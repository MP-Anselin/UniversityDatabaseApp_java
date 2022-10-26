package com.adpmp.universityApp.microservices.profiles.components.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PROFILES_ASSIGNMENTS",
            joinColumns = @JoinColumn(name = "PROFILE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ASSIGNMENTS_ID"))
    private List<Assignment> assignments;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT", nullable = false)
    private Account account;

    @Column(name = "PROCESS", nullable = false)
    private String process = "NO_START";

    public String getProcess() {
        return process;
    }

    public void setProcess(String process_apply) {
        this.process = process_apply;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account_id) {
        this.account = account_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
