package com.adpmp.universityApp.microservices.profiles.components.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "assignments")
public class Assignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PROFILES_ASSIGNMENTS",
            joinColumns = @JoinColumn(name = "ASSIGNMENTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROFILE_ID"))
    private List<Profile> profiles;

    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    @Column(name = "CREDITS", nullable = false)
    private Integer credits;

    @Column(name = "STUDY_FIELD", nullable = false)
    private Integer study_filed;

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getStudy_filed() {
        return study_filed;
    }

    public void setStudy_filed(Integer study_filed) {
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
