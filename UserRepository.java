package com.example.mediapp.user;

import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.MedicalHistory.MedicalHistory;
import com.example.mediapp.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailAndRoles(String email, Role role);

	public User findByName(String name);

	public User findByUid(Long uid);

	public List<User> findByGradeAndClzAndRoles(Integer grade, String clz, Role role);

	User findByIndexNo(String indexNo);

	User getUserByRoles(List<Role> roles);

	List<User> findByRoles(List<Role> roles);

	User findByEmail(String email);

	@Query(value = "select distinct u.medicines from User u where u.uid = :uid")
	List<Medicine> getByUid(@Param("uid") long uid);

	@Query(value = "select u.parent from User u where u.uid = :uid")
	User findParent(@Param("uid") long uid);

	@Query(value = "select u.medicalHistories from User u where u.uid = :uid and u.email = :em ")
	List<MedicalHistory> findByUidAndEmail(@Param("uid") long uid, @Param("em") String em);

}


