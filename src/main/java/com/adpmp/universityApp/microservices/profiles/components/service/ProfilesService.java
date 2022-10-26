package com.adpmp.universityApp.microservices.profiles.components.service;

import com.adpmp.universityApp.microservices.profiles.components.dao.ProfilesDao;
import com.adpmp.universityApp.microservices.profiles.components.dto.ProfileCreateDto;
import com.adpmp.universityApp.microservices.profiles.components.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesService {
    @Autowired
    private ProfilesDao profilesDao;

    public Profile addNewStudent(ProfileCreateDto profileCreateDto) {
        Profile newProfile = new Profile();
        newProfile.setAccount(profileCreateDto.getAccount());
        newProfile.setProcess(profileCreateDto.getProcess());
        return profilesDao.save(newProfile);
    }

    public List<Profile> getStudentsToCheck() {
        return profilesDao.getStudentsToCheck();
    }

    public List<Profile> getAllProfile() {
        return profilesDao.getFindAll();
    }
}
