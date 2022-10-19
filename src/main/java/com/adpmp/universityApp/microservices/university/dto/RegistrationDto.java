package com.adpmp.universityApp.microservices.university.dto;

import javax.validation.constraints.NotNull;

public class RegistrationDto {
    @NotNull
    private String dnie;
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDnie() {
        return dnie;
    }

    public void setDnie(String dnie) {
        this.dnie = dnie;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
