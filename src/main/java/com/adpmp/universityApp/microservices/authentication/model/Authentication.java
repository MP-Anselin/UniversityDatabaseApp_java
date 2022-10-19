package com.adpmp.universityApp.microservices.authentication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Authentication implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "DNIE", nullable = false)
    private String dnie;
    @Column(name = "USER_ROLE_ID", nullable = false)
    private Integer user_role_id;
    @Column(name = "FIRST_NAME", nullable = false)
    private String first_name;

    private Boolean is_log;

    public Boolean getIs_log() {
        return is_log;
    }

    public void setIs_log(Boolean is_log) {
        this.is_log = is_log;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getDnie() {
        return dnie;
    }

    public void setDnie(String dnie) {
        this.dnie = dnie;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    private String last_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
