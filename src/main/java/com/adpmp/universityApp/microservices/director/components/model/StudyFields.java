package com.adpmp.universityApp.microservices.director.components.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "study_fields")
public class StudyFields implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "STUDY_TYPE", nullable = false)
    private String study_type;

    public String getStudy_type() {
        return study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
