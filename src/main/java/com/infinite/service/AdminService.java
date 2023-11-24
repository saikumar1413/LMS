package com.infinite.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.infinite.model.AdminPojo;

@Service //Contains business logic
public interface AdminService extends JpaRepository<AdminPojo, Long> {
	AdminPojo findByAdminname(String adminname);

	AdminPojo findByAdminpassword(String adminpassword);

	AdminPojo findByAdminnameAndAdminpassword(String adminname, String adminpassword);

}
