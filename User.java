package com.example.mediapp.user;

import com.example.mediapp.BloodGroup.BloodGroup;
import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.MedicalHistory.MedicalHistory;
import com.example.mediapp.Role.Role;
import com.example.mediapp.clinicalEvent.ClinicalEvent;
import com.example.mediapp.sos.Sos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

//import com.example.mediapp.Medi.Medicine;
//import java.util.Set;

@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long uid;
	@NotNull
	@Size(min = 2, max = 20)
	String name;
	String indexNo;
	String gender;
	Date dob;
	@NotNull
	@Size(min = 2, max = 30)
	String email;
	@NotNull
	@Size(min = 0,max = 10)
	String contactNo;
	Integer grade;
	String clz;
	Long height;
	Long weight;
	String imageurl;
	String NIC;
	String address;

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "user_role",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	@JsonIgnore
	List<Role> roles;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "user_clinicalEvents",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "clinical_id")
	    )
	@JsonIgnore
	List<ClinicalEvent> clinicalEvents;

	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="student_allergicDrugs",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name ="allergic_drug_id"))
	@JsonIgnore
	List<Medicine> medicines;

	@JsonIgnore
	@OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
	List<User> children;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	List<User> students;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "teacher_id")
	@Fetch(FetchMode.JOIN)
	User teacher;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id")
	User parent;

	@JsonIgnore
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	List<MedicalHistory> medicalHistories;

	@JsonIgnore
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
	Set<Sos> sos;

	public void setUid(long uid) {
		this.uid = uid;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodGroupId")
	BloodGroup bloodGroup;

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public List<ClinicalEvent> getClinicalEvents() {
		return clinicalEvents;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Set<Sos> getSos() {
		return sos;
	}

	public void setSos(Set<Sos> sos) {
		this.sos = sos;
	}

	
	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public List<MedicalHistory> getMedicalHistories() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public User getTeacher() {
		return teacher;
	}



	public User getParent() {
		return parent;
	}


	//@JsonProperty(access= Access.READ_WRITE)
	public List<Role> getRoles() {
        return roles;
    }
	
    public void setRole(List<Role> roles) {
        this.roles = roles;
    }
    public List<ClinicalEvent> getEvents() {
        return clinicalEvents;
    }
	
    public void setClinicalEvents(List<ClinicalEvent> clinicalEvents) {
        this.clinicalEvents = clinicalEvents;
    }
	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", name=" + name + ",roles="+roles+", gender=" + gender + ",height=" + height + ", weight=" + weight + ", dob=" + dob + ", contactNo=" + contactNo + ", grade=" + grade + ", clz=" + clz + ", imageurl=" + imageurl + ",NIC="+NIC+",address="+address+"]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<User> getChildren() {
		return children;
	}

	public void setChildren(List<User> children) {
		this.children = children;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}
	
}
