package com.qspiders.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspiders.springboot.entity.Aadhar;
import com.qspiders.springboot.repo.Aadhar_repo;

@Repository
public class Aadhardao {
	@Autowired
	Aadhar_repo repo;
	
	public Aadhar saveAadhar(Aadhar adhar) {
		return repo.save(adhar);
	}
	
	public Aadhar findAdharbyId(int id) {
		Optional<Aadhar> optionalAadhar= repo.findById(id);
		if(optionalAadhar.isPresent()) {
			return optionalAadhar.get();
		}
		return null;
	}
	
	public Aadhar deletebyId(int id) {
		Aadhar aadhar=findAdharbyId(id);
		if(aadhar!=null) {
			repo.delete(aadhar);
			return aadhar;
		}
		return null;
	}
	public Aadhar updatebyId(Aadhar adhar,int id) {
		Aadhar dbadhar=findAdharbyId(id);
		if(dbadhar!=null) {
			adhar.setId(id);
			repo.save(adhar);
			return adhar;
		}
		return null;
	}
	public List<Aadhar> findall(){
		return repo.findAll();
	}

}
