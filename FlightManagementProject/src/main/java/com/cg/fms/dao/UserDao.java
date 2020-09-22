package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.fms.dto.Users;

public interface UserDao extends JpaRepository<Users, String> {

	@Query("select r from Users r where r.username=?1 and r.password=?2")
	Users loginCheck(String username, String password);

}
