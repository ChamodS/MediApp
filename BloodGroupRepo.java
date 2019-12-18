package com.example.mediapp.BloodGroup;

import org.springframework.data.repository.CrudRepository;

public interface BloodGroupRepo extends CrudRepository<BloodGroup, Long> {
    BloodGroup getBloodGroupByBloodGroup(String bloodGroupName);
}
