package com.adpmp.universityApp.microservices.university.components.dto;

import com.adpmp.universityApp.microservices.director.components.model.StudyFields;
import com.sun.istack.NotNull;

public class AssignmentCreateDto {
    @NotNull
    private String subject;

    @NotNull
    private Integer credit;

    @NotNull
    private StudyFields study_filed;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public StudyFields getStudy_filed() {
        return study_filed;
    }

    public void setStudy_filed(StudyFields study_filed) {
        this.study_filed = study_filed;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
