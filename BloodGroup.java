package com.example.mediapp.BloodGroup;

import com.example.mediapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bloodGroupID;
    String bloodGroup;

    @JsonIgnore
    @OneToMany(mappedBy = "bloodGroup",cascade = CascadeType.ALL)
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getBloodGroupID() {
        return bloodGroupID;
    }

    public void setBloodGroupID(Long bloodGroupID) {
        this.bloodGroupID = bloodGroupID;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
