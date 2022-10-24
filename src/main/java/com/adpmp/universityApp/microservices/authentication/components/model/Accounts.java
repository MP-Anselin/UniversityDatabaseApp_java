package com.adpmp.universityApp.microservices.authentication.components.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "DNIE", nullable = false)
    private String dnie;
    @Column(name = "USER_ROLE_ID", nullable = false)
    private Integer userRoleId;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    private Boolean is_log = false;

    public Boolean getIs_log() {
        return is_log;
    }

    public void setIs_log(Boolean is_log) {
        this.is_log = is_log;
    }

    public String getDnie() {
        return dnie;
    }

    public void setDnie(String dnie) {
        this.dnie = dnie;
    }

    public Integer getUser_role_id() {
        return userRoleId;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.userRoleId = user_role_id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
