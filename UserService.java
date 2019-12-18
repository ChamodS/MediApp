package com.example.mediapp.user;

import com.example.mediapp.BloodGroup.BloodGroupRepo;
import com.example.mediapp.Disease.Disease;
import com.example.mediapp.Disease.DiseaseRepo;
import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.Medi.MedicineRepo;
import com.example.mediapp.MedicalHistory.MedicalHistory;
import com.example.mediapp.MedicalHistory.MedicalHistoryDTO;
import com.example.mediapp.MedicalHistory.MedicalHistoryRepo;
import com.example.mediapp.Role.Role;
import com.example.mediapp.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MedicalHistoryRepo mediHisRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MedicineRepo medicineRepo;
	
	@Autowired
	DiseaseRepo diseaseRepo;

	@Autowired
	BloodGroupRepo bloodGroupRepo;


	public Response login(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Role rolI = roleRepository.findByRoleName(userDTO.roleName);
		List<User> childrenListNew = new ArrayList<>();
		if(rolI!=null) {
			User u = userRepository.findByEmailAndRoles(userDTO.email,rolI);
			if(u==null)
				
				return new Response("failed","no user with email",null);
			else
			{UserDTO userD=new UserDTO();
			
			u.children.toString();
			if(u.children!=null) {
		        for(User childrenList:u.children){
		        	System.out.println("hriyooo");
		            System.out.println(childrenList.getName());
		            childrenListNew.add(childrenList);
		           
		            System.out.println("ekath weda bn");
		          
		        }}
			userD.children=childrenListNew;
			userD.uid = u.uid;
            System.out.println(userD.uid);
        	userD.name = u.name;
        	userD.indexNo = u.indexNo;
        	userD.gender = u.gender;
        	userD.dob = u.dob;
        	userD.email = u.email;
        	userD.contactNo = u.contactNo;
        	userD.grade = u.grade;
        	userD.clz = u.clz;
        	userD.height = u.height;
        	userD.weight = u.weight;
				
				return new Response("success","user found",userD);
			}
		}
		else
			return new Response("failed","no user with roleId",null);
	}
	
	public List<UserDTO> findStudents(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Role rolI = roleRepository.findByRoleName(userDTO.roleName);
		List<UserDTO> userDTOlist = new ArrayList<>();
		List<User> userList = userRepository.findByGradeAndClzAndRoles(userDTO.grade,userDTO.clz,rolI);

		//List<String> diseaseNames = new ArrayList<>();
		//List<String> childrenNames = new ArrayList<>();
		
		
		for(User u:userList){
            UserDTO userD=new UserDTO();
            userD.uid = u.uid;
            System.out.println(userD.uid);
        	userD.name = u.name;
        	userD.indexNo = u.indexNo;
        	userD.gender = u.gender;
        	userD.dob = u.dob;
        	userD.email = u.email;
        	userD.contactNo = u.contactNo;
        	userD.grade = u.grade;
        	userD.clz = u.clz;
        	userD.height = u.height;
        	userD.weight = u.weight;
        
        	System.out.println(userDTO.roleName);
        	Role role = roleRepository.findByRoleName(userDTO.roleName);
        	//MedicalHistory medihis = mediHisRepository.findByStudentId(userD.uid);
        	
        	userD.roleName = role.getRoleName();
        	userD.roleID = role.getRoleID();
        	userD.teacherName = u.teacher.getName();
        	userD.teacherID = u.teacher.getUid();
        	userD.teacherImage = u.teacher.getImageurl();
        	System.out.println(userD.teacherName);
        	userD.parentName = u.parent.getName();
        	userD.parentID = u.parent.getUid();
        	userD.parentImage = u.parent.getImageurl();
        	userD.parentNIC = u.parent.getNIC();
        	userD.address = u.parent.getAddress();
        	userD.parentEmail = u.parent.getEmail();
        	userD.bloodgroup = u.bloodGroup.getBloodGroup();
        	userD.imageurl = u.imageurl;
        	MedicalHistoryDTO medidie = new MedicalHistoryDTO();
        	
        			u.medicines.toString();

        			System.out.println(u.medicines.toString());
        			if(u.medicines!=null) {
        				List<String> mediNames = new ArrayList<>();
        		        for(Medicine medicinesList:u.medicines){
        		        	System.out.println("hi3");
        		            System.out.println(medicinesList.getGenericName());
        		            mediNames.add(medicinesList.getGenericName());

        		            System.out.println("hi4");

        		        }userD.medicineName=mediNames;
        		        System.out.println(mediNames);}

        			userDTOlist.add(userD);

        }
			return userDTOlist;
	}// get user in a class mot sutudents

	public List<UserDTO> findChildren(UserDTO userDTO) {
		// TODO Auto-generated method stub

		List<UserDTO> userDTOlist = new ArrayList<>();
		User userList = userRepository.findByUid(userDTO.uid);
		List<String> mediNames = new ArrayList<>();
		System.out.println(userDTO.uid);


		for(User u:userList.children){
            UserDTO userD=new UserDTO();
            userD.uid = u.getUid();
            System.out.println(userD.uid);
        	userD.name = u.getName();
        	userD.indexNo = u.getIndexNo();
        	userD.gender = u.getGender();
        	userD.dob = u.getDob();
        	userD.email = u.getEmail();
        	userD.contactNo = u.getContactNo();
        	userD.grade = u.getGrade();
        	userD.clz = u.getClz();
        	userD.height = u.getHeight();
        	userD.weight = u.getWeight();
        	userD.teacherName = u.getTeacher().getName();
        	userD.teacherID = u.getTeacher().getUid();
        	userD.teacherImage = u.getTeacher().getImageurl();
        	System.out.println(userD.teacherName);
        	userD.parentName = u.getParent().getName();
        	userD.parentID = u.getParent().getUid();
        	userD.parentNIC = u.getParent().getNIC();
        	userD.address = u.getParent().getAddress();
        	userD.parentEmail = u.getParent().getEmail();
        	userD.bloodgroup = u.getBloodGroup().getBloodGroup();
        	userD.imageurl = u.getImageurl();

        			u.getMedicines().toString();
        			System.out.println(u.medicines.toString());
        			if(u.getMedicines()!=null) {
        		        for(Medicine medicinesList:u.getMedicines()){
        		        	System.out.println("hi3");
        		            System.out.println(medicinesList.getGenericName());
        		            mediNames.add(medicinesList.getGenericName());
        		           
        		            System.out.println("hi4");
        		          
        		        }}
        			userD.medicineName=mediNames;
        			userDTOlist.add(userD);
        	
        }
			return userDTOlist;
	}

	public Response contactNo(String name) {
		// TODO Auto-generated method stub
		User u = userRepository.findByName(name);
		if(u == null)
			return new Response("Failed", "user not found", null);
		else 
			return new Response("Done", "user found", u);
	}

	public Response addUser(UserDTO userDTO) {


			List<Role> roles = new ArrayList<>();
			User user = new User();

			List<Medicine> allergicDrugs = new ArrayList<>();
			List<MedicalHistory> medicalHistories = new ArrayList<>();


			user.name = userDTO.name;
			user.indexNo = userDTO.indexNo;
			user.gender = userDTO.gender;
			user.dob = userDTO.dob;
			user.email = userDTO.email;
			user.grade = userDTO.grade;
			user.clz = userDTO.clz;
			user.height = userDTO.height;
			user.weight = userDTO.weight;
			user.contactNo = userDTO.contactNo;


			Role userRole = roleRepository.findByRoleName(userDTO.roleName);
			roles.add(userRole);
			user.setRoles(roles);

			if (userDTO.roleName.equals("teacher")){
				user.NIC=userDTO.parentNIC;
			}

			if (userDTO.roleName.equals("student")){
				User parent = new User();
				parent.name = userDTO.parentName;
				parent.NIC = userDTO.parentNIC;
				parent.address = userDTO.address;
				parent.contactNo = userDTO.contactNo;
				parent.email = userDTO.parentEmail;

				List<Role> ListRoles = new ArrayList<>();
				Role parentRole = roleRepository.findByRoleName("parent");
				ListRoles.add(parentRole);
				parent.setRoles(ListRoles);

				user.setBloodGroup(bloodGroupRepo.getBloodGroupByBloodGroup(userDTO.bloodgroup));
				user.setParent(parent);
				System.out.println("Parent Added ");

				if (userDTO.allergicDrugs != null) {
					for (String genericName : userDTO.allergicDrugs) {
						List<Medicine> medicine = medicineRepo.getMedicinesByGenericName(genericName);
						allergicDrugs.addAll(medicine);
					}
					user.setMedicines(allergicDrugs);
				}
			}




			List<Role> ListOfRoles = new ArrayList<>();
			Role adminRole = roleRepository.findByRoleName("Admin");
			ListOfRoles.add(adminRole);
			User admin = userRepository.getUserByRoles(ListOfRoles);
			System.out.println(admin.name);

			try {
				userRepository.save(user);//save user
				if (userDTO.diseases != null){
					System.out.println("mekata en na ne");
					for (String diseaseHad : userDTO.diseases) {
						System.out.println(diseaseHad);
						MedicalHistory medicalHistory = new MedicalHistory();
						Disease disease = diseaseRepo.findDiseaseByName(diseaseHad);
						medicalHistory.setDisease(disease);
						medicalHistory.setUser(admin);
						medicalHistory.setOccurredAt("Pre-school");
						medicalHistory.setStudent(user);
						try {
							mediHisRepository.save(medicalHistory);
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}

				return new Response("success", "User Added Successfully", null);
			} catch (Exception e) {
				System.out.println(e);
				return new Response("Failed", "Server Error", null);
			}

		}
	
	public List<User> getAllStudents( String userType){
	    System.out.println("hi"+ userType);
        System.out.println("hi ai oi meka wada naththe");
	    Role userRole=roleRepository.findByRoleName(userType);
	    System.out.println(userRole);

	    List<Role> userRoles=new ArrayList<>();
	    userRoles.add(userRole);
        System.out.println(userRoles);

	    List<User> studentList=userRepository.findByRoles(userRoles);
	    System.out.println(studentList);

	    return studentList;
    }

    public UserDTO getDataByEmail(UserDTO userDTO){
		UserDTO ud=new UserDTO();
		System.out.println(userDTO.email);
		User u=userRepository.findByEmail(userDTO.email);
		System.out.println(u);
		ud.contactNo=u.contactNo;
		ud.email=u.email;
		ud.name=u.name;
		ud.indexNo=u.indexNo;
		ud.gender=u.gender;
		ud.dob=u.dob;
		ud.grade=u.grade;
		ud.clz=u.clz;
		ud.height=u.height;
		ud.weight=u.weight;
		ud.imageurl=u.imageurl;
		ud.parentNIC=u.NIC;
		ud.address=u.address;
		//User parent=userRepository.findParent(u.uid);
		System.out.println("Check Point 02");

		System.out.println("Check Point 03");

		System.out.println("Check Point 03");
		if(u.getRoles()!=null){
			List<Role> rL=u.getRoles();
			List<String> roles= new ArrayList<>();
			if(rL!=null){
				for(Role r: rL){
					roles.add(r.getRoleName());
				}
			}
			ud.roles=roles;
			for(String ro: roles){
				if(ro.equals("student")){
					System.out.println("t01");
					List<Medicine> medi = userRepository.getByUid(u.uid);
					List<String> alDrugs= new ArrayList<>();
					if (medi!=null){
						for (Medicine m:medi){
							//System.out.println(m.getBrandName());
							String mName=m.getBrandName();
							alDrugs.add(mName);
						}
					}
					System.out.println("Check Point 01");
					ud.allergicDrugs=alDrugs;
					List<MedicalHistory> mH=userRepository.findByUidAndEmail(u.uid,u.email);
					List<String> dL=new ArrayList<>();//disease list
					if(mH!=null){
						for (MedicalHistory m: mH){
							dL.add(m.getDisease().getName());
						}
					}
					List<User> teacher= userRepository.findByGradeAndClzAndRoles(u.grade,u.clz,roleRepository.findByRoleName("teacher"));
					String tN = null;
					if(teacher!=null){
						for(User t: teacher){
							tN=t.getName();
						}
					}
					ud.teacherName=tN;
					ud.parentName=u.parent.getName();
					ud.bloodGroup=u.bloodGroup.getBloodGroup();
					ud.diseases=dL;
					System.out.println(dL);
					break;
				}
			}
		}

		System.out.println("Check Point 04");

		return ud;
	}
}
