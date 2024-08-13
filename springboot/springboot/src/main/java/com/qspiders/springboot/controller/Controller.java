package com.qspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.springboot.entity.Aadhar;
import com.qspiders.springboot.service.Aadharservice;
import com.qspiders.springboot.util.ResponseStructure;

@RestController
@RequestMapping("adhar")
public class Controller {
	
	@Autowired
	Aadharservice service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Aadhar>> saveadhar(@RequestBody Aadhar adhar) {
		return service.saveAdhar(adhar);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Aadhar>> find(@RequestParam int id) {
		return service.find(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Aadhar>> deleteadhar(@RequestParam int id) {
		return service.deleteById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Aadhar>> updateadhar(@RequestBody Aadhar adhar,@RequestParam int id) {
		return service.updateAdhar(adhar, id);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<Aadhar>>> findall(){
		return service.findall();
	}
	
	

}
