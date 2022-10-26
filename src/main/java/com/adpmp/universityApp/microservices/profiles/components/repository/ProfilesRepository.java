package com.adpmp.universityApp.microservices.profiles.components.repository;

import com.adpmp.universityApp.microservices.profiles.components.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfilesRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByProcess(String process);
}
