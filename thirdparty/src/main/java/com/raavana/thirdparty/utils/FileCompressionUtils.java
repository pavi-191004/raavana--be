package com.raavana.thirdparty.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDResources;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

public class FileCompressionUtils {

        public static String compressBase64PDF(String base64Pdf) throws PdfCompressionException {
            if (base64Pdf == null || base64Pdf.trim().isEmpty()) {
                throw new PdfCompressionException("Input Base64 string is null or empty");
            }

            try {
                if (base64Pdf.startsWith("data:")) {
                    int commaIndex = base64Pdf.indexOf(',');
                    base64Pdf = base64Pdf.substring(commaIndex + 1);
                }
                byte[] pdfBytes;
                try {
                    pdfBytes = Base64.getDecoder().decode(base64Pdf);
                } catch (IllegalArgumentException e) {
                    throw new PdfCompressionException("Invalid Base64 input", e);
                }

                PDDocument document;
                try {
                    document = PDDocument.load(pdfBytes);
                } catch (IOException e) {
                    throw new PdfCompressionException("Failed to load PDF document — possibly corrupted.", e);
                }

                try {
                    for (PDPage page : document.getPages()) {
                        PDResources resources = page.getResources();
                        if (resources == null) continue;

                        for (COSName xObjectName : resources.getXObjectNames()) {
                            if (resources.isImageXObject(xObjectName)) {
                                PDImageXObject imageObject = (PDImageXObject) resources.getXObject(xObjectName);
                                BufferedImage image = imageObject.getImage();

                                if (image != null) {
                                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
                                    if (writers.hasNext()) {
                                        ImageWriter writer = writers.next();
                                        ImageWriteParam param = writer.getDefaultWriteParam();
                                        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                                        param.setCompressionQuality(0.75f);

                                        writer.setOutput(new MemoryCacheImageOutputStream(baos));
                                        writer.write(null, new IIOImage(image, null, null), param);
                                        writer.dispose();

                                        PDImageXObject compressedImage = PDImageXObject.createFromByteArray(
                                                document, baos.toByteArray(), "compressed");
                                        resources.put(xObjectName, compressedImage);
                                    }
                                }
                            }
                        }
                    }

                    document.getDocumentCatalog().getCOSObject().removeItem(COSName.METADATA);

                    ByteArrayOutputStream compressedOutput = new ByteArrayOutputStream();
                    document.save(compressedOutput);

                    return Base64.getEncoder().encodeToString(compressedOutput.toByteArray());

                } finally {
                    document.close();
                }

            } catch (IOException e) {
                throw new PdfCompressionException("I/O error during PDF compression", e);
            } catch (Exception e) {
                throw new PdfCompressionException("Unexpected error during compression", e);
            }
        }
    }




