package com.qspiders.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspiders.springboot.dao.Aadhardao;
import com.qspiders.springboot.entity.Aadhar;
import com.qspiders.springboot.util.ResponseStructure;

@Service
public class Aadharservice {
	@Autowired
	Aadhardao dao;
	
	public ResponseEntity<ResponseStructure<Aadhar>> saveAdhar(Aadhar adhar) {
		Aadhar saveadhar=dao.saveAadhar(adhar);
		if(saveadhar!=null) {
			ResponseStructure structure=new ResponseStructure<>();
			structure.setData(saveadhar);
			structure.setMessage("Aadhar saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.CREATED);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Aadhar>> find(int id) {
		Aadhar findadhar=dao.findAdharbyId(id);
		if(findadhar!=null) {
			ResponseStructure structure=new ResponseStructure<>();
			structure.setData(findadhar);
			structure.setMessage("Aadhar found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.FOUND);
		}
		return  null;
	}
	public  ResponseEntity<ResponseStructure<Aadhar>> deleteById(int id) {
		Aadhar adhar=dao.findAdharbyId(id);
		if(adhar!=null) {
			dao.deletebyId(id);
			ResponseStructure structure=new ResponseStructure<>();
			structure.setData(adhar);
			structure.setMessage("Aadhar deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.OK);
			
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Aadhar>> updateAdhar(Aadhar adhar,int id) {
		Aadhar dbadhar=dao.updatebyId(adhar, id);
		if(dbadhar!=null) {
			ResponseStructure structure=new ResponseStructure<>();
			structure.setData(dbadhar);
			structure.setMessage("Aadhar updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Aadhar>>>  findall(){
		ResponseStructure structure=new ResponseStructure<>();
		structure.setData(dao.findall());
		structure.setMessage("Aadhar details found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Aadhar>>>(structure,HttpStatus.FOUND);
	}
	
	
	

}
