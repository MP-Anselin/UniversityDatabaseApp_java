package com.adpmp.universityApp.microservices.authentication.components.dto;

import com.sun.istack.NotNull;

public class RegistrationDto {
    @NotNull
    private String dnie;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer userRoleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getDnie() {
        return dnie;
    }

    public void setDnie(String dnie) {
        this.dnie = dnie;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }
}
