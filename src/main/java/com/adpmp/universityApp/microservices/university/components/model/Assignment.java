package com.adpmp.universityApp.microservices.university.components.model;

import com.adpmp.universityApp.microservices.director.components.model.StudyFields;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assignments")
public class Assignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    @Column(name = "CREDIT", nullable = false)
    private Integer credit;

    @JoinColumn(name = "STUDY_FIELD", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
