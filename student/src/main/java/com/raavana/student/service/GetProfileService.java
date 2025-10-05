package com.raavana.student.service;

import com.raavana.student.entity.*;
import com.raavana.student.model.*;
import com.raavana.student.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProfileService {

    private final PersonalRepository personalRepo;
    private final EducationRepository educationRepo;
    private final SkillsRepository skillsRepo;
    private final ExperiencesRepository experiencesRepo;
    private final ProjectsRepository projectsRepo;
    private final AchievementsRepository achievementsRepo;

    public StudentProfileDTO getById(String id) {
        PersonalEntity personal = personalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
        List<EducationEntity> education = educationRepo.findByStudentId(id);
        List<SkillsEntity> skills = skillsRepo.findByStudentId(id);
        List<ExperiencesEntity> experiences = experiencesRepo.findByStudentId(id);
        List<ProjectsEntity> projects = projectsRepo.findByStudentId(id);
        List<AchievementsEntity> achievements = achievementsRepo.findByStudentId(id);

        StudentProfileDTOPersonalInfo personalDto = StudentProfileDTOPersonalInfo.builder()
                .id(personal.getId())
                .studentImage(personal.getStudentImage())
                .fullName(personal.getFullName())
                .registerNo(personal.getRegisterNo())
                .degree(personal.getDegree())
                .fieldOfStudy(personal.getFieldOfStudy())
                .phone(personal.getPhone())
                .gender(personal.getGender())
                .domain(personal.getDomain())
                .about(personal.getAbout())
                .build();
        List<StudentProfileDTOEducation> eduDto = new ArrayList<>();
        for (EducationEntity edu : education) {
            eduDto.add(StudentProfileDTOEducation.builder()
                    .degree(edu.getDegree())
                    .specialization(edu.getSpecialization())
                    .institution(edu.getInstitution())
                    .cgpa(edu.getCgpa())
                    .year(edu.getYear())
                    .location(edu.getLocation())
                    .build());
        }
        List<StudentProfileDTOSkills> skillDto = new ArrayList<>();
        for (SkillsEntity skill : skills) {
            skillDto.add(StudentProfileDTOSkills.builder()
                    .technicalSkills(skill.getTechnicalSkills())
                    .softSkills(skill.getSoftSkills())
                    .hobbies(skill.getHobbies())
                    .build());
        }
        List<StudentProfileDTOExperiences> experienceDto = new ArrayList<>();
        for (ExperiencesEntity exp : experiences) {
            experienceDto.add(StudentProfileDTOExperiences.builder()
                    .role(exp.getRole())
                    .companyName(exp.getCompanyName())
                    .startDate(exp.getStartDate())
                    .endDate(exp.getEndDate())
                    .mode(exp.getMode())
                    .location(exp.getLocation())
                    .description(exp.getDescription())
                    .build());
        }
        List<StudentProfileDTOProjects> projectDto = new ArrayList<>();
        for (ProjectsEntity proj : projects) {
            projectDto.add(StudentProfileDTOProjects.builder()
                    .projectName(proj.getProjectName())
                    .description(proj.getDescription())
                    .technologiesOrToolsUsed(proj.getTechnologiesOrToolsUsed())
                    .startDate(proj.getStartDate())
                    .endDate(proj.getEndDate())
                    .build());
        }
        List<StudentProfileDTOAchievements> achievementDto = new ArrayList<>();
        for (AchievementsEntity ach : achievements) {
            achievementDto.add(StudentProfileDTOAchievements.builder()
                    .certificationAward(ach.getCertification())
                    .awardedBy(ach.getAwardedBy())
                    .description(ach.getDescription())
                    .date(ach.getDate())
                    .uploadedCertificate(ach.getUploadedCertificate())
                    .build());
        }
        return StudentProfileDTO.builder()
                .personalInfo(personalDto)
                .education(eduDto)
                .skills(skillDto)
                .experiences(experienceDto)
                .projects(projectDto)
                .achievements(achievementDto)
                .build();
    }

    public List<StudentProfileDTO> getAll() {
        List<PersonalEntity> personalInfos = personalRepo.findAll();
        List<StudentProfileDTO> studentProfiles = new ArrayList<>();

        for (PersonalEntity personal : personalInfos) {
            String id = personal.getId();
            List<EducationEntity> education = educationRepo.findByStudentId(id);
            List<SkillsEntity> skills = skillsRepo.findByStudentId(id);
            List<ExperiencesEntity> experiences = experiencesRepo.findByStudentId(id);
            List<ProjectsEntity> projects = projectsRepo.findByStudentId(id);
            List<AchievementsEntity> achievements = achievementsRepo.findByStudentId(id);

            StudentProfileDTOPersonalInfo personalDto = StudentProfileDTOPersonalInfo.builder()
                    .id(personal.getId())
                    .studentImage(personal.getStudentImage())
                    .fullName(personal.getFullName())
                    .registerNo(personal.getRegisterNo())
                    .degree(personal.getDegree())
                    .fieldOfStudy(personal.getFieldOfStudy())
                    .phone(personal.getPhone())
                    .gender(personal.getGender())
                    .domain(personal.getDomain())
                    .about(personal.getAbout())
                    .build();
            List<StudentProfileDTOEducation> eduDto = new ArrayList<>();
            for (EducationEntity edu : education) {
                eduDto.add(StudentProfileDTOEducation.builder()
                        .degree(edu.getDegree())
                        .specialization(edu.getSpecialization())
                        .institution(edu.getInstitution())
                        .cgpa(edu.getCgpa())
                        .year(edu.getYear())
                        .location(edu.getLocation())
                        .build());
            }
            List<StudentProfileDTOSkills> skillDto = new ArrayList<>();
            for (SkillsEntity skill : skills) {
                skillDto.add(StudentProfileDTOSkills.builder()
                        .technicalSkills(skill.getTechnicalSkills())
                        .softSkills(skill.getSoftSkills())
                        .hobbies(skill.getHobbies())
                        .build());
            }
            List<StudentProfileDTOExperiences> experienceDto = new ArrayList<>();
            for (ExperiencesEntity exp : experiences) {
                experienceDto.add(StudentProfileDTOExperiences.builder()
                        .role(exp.getRole())
                        .companyName(exp.getCompanyName())
                        .startDate(exp.getStartDate())
                        .endDate(exp.getEndDate())
                        .mode(exp.getMode())
                        .location(exp.getLocation())
                        .description(exp.getDescription())
                        .build());
            }
            List<StudentProfileDTOProjects> projectDto = new ArrayList<>();
            for (ProjectsEntity proj : projects) {
                projectDto.add(StudentProfileDTOProjects.builder()
                        .projectName(proj.getProjectName())
                        .description(proj.getDescription())
                        .technologiesOrToolsUsed(proj.getTechnologiesOrToolsUsed())
                        .startDate(proj.getStartDate())
                        .endDate(proj.getEndDate())
                        .build());
            }
            List<StudentProfileDTOAchievements> achievementDto = new ArrayList<>();
            for (AchievementsEntity ach : achievements) {
                achievementDto.add(StudentProfileDTOAchievements.builder()
                        .certificationAward(ach.getCertification())
                        .awardedBy(ach.getAwardedBy())
                        .description(ach.getDescription())
                        .date(ach.getDate())
                        .uploadedCertificate(ach.getUploadedCertificate())
                        .build());
            }
            StudentProfileDTO dto = StudentProfileDTO.builder()
                    .personalInfo(personalDto)
                    .education(eduDto)
                    .skills(skillDto)
                    .experiences(experienceDto)
                    .projects(projectDto)
                    .achievements(achievementDto)
                    .build();

            studentProfiles.add(dto);
        }
        return studentProfiles;
    }

}
