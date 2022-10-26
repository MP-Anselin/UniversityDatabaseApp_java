package com.adpmp.universityApp.microservices.profiles.components.dao;

import com.adpmp.universityApp.microservices.profiles.components.model.Profile;
import com.adpmp.universityApp.microservices.profiles.components.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfilesDao {
    @Autowired
    private ProfilesRepository profilesRepository;

    public Profile save(Profile newProfile) {
        return profilesRepository.save(newProfile);
    }

    public List<Profile> getStudentsToCheck() {
        return profilesRepository.findByProcess("NO_START");
    }

    public List<Profile> getFindAll() {
        return profilesRepository.findAll();
    }
}
