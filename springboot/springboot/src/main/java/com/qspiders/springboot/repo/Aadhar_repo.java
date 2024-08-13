package com.qspiders.springboot.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.springboot.entity.Aadhar;

public interface Aadhar_repo extends JpaRepository<Aadhar, Integer>{
	
	

}
