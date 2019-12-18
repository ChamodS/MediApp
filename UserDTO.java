package com.example.mediapp.user;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.mediapp.MedicalHistory.MedicalHistory;
import com.example.mediapp.Role.Role;

public class UserDTO {

	long uid;
	String name;
	String indexNo;
	String gender;
	Date dob;
	String email;
	String contactNo;
	Integer grade;
	String clz;
	Long height;
	Long weight;
	String roleName;
	long roleID;
	String teacherName;
	long teacherID;
	long parentID;
	String parentImage;
	String teacherImage;
	List<String> diseases;
	List<String> allergicDrugs;
	String bloodGroup;
	List<String> roles;
	String parentName;
	String parentNIC;
	String address;
	String parentEmail;
	String imageurl;
	String bloodgroup;
	List<User> children;
	List<String> medicineName;

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getAllergicDrugs() {
		return allergicDrugs;
	}

	public void setAllergicDrugs(List<String> allergicDrugs) {
		this.allergicDrugs = allergicDrugs;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<String> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<String> diseases) {
		this.diseases = diseases;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public String getParentImage() {
		return parentImage;
	}

	public void setParentImage(String parentImage) {
		this.parentImage = parentImage;
	}

	public String getTeacherImage() {
		return teacherImage;
	}

	public void setTeacherImage(String teacherImage) {
		this.teacherImage = teacherImage;
	}

	public List<User> getChildren() {
		return children;
	}

	public void setChildren(List<User> children) {
		this.children = children;
	}

    public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Override
    public String toString() {
        return (" uid: " +uid+
        " /n name: " +name+
        "/n  indexNo: "+indexNo+
        "/n  gender: "+gender+
        " /n dob: "+dob+
        "/n  email: "+email+
        "/n contactNo:" +contactNo+
        "/n grade:"+grade+
        " /n clz: "+clz+
        "/n  height: "+height+
        "/n weight:" +weight+
        "/n roleName:"+roleName+
        "/n roleID:"+roleID+
        "/n imageurl:"+imageurl+
        "/n bloodgroup:"+bloodgroup+
         "/n children:"+children+
        "/n medicineName:"+medicineName);
    }

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentNIC() {
		return parentNIC;
	}

	public void setParentNIC(String parentNIC) {
		this.parentNIC = parentNIC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public long getUid() {
		return uid;
	}


	public void setUid(long uid) {
		this.uid = uid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIndexNo() {
		return indexNo;
	}


	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public String getClz() {
		return clz;
	}


	public void setClz(String clz) {
		this.clz = clz;
	}


	public Long getHeight() {
		return height;
	}


	public void setHeight(Long height) {
		this.height = height;
	}


	public Long getWeight() {
		return weight;
	}


	public void setWeight(Long weight) {
		this.weight = weight;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public long getRoleID() {
		return roleID;
	}


	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public List<String> getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(List<String> medicineName) {
		this.medicineName = medicineName;
	}


}
