package com.cjc.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Student11;
import com.cjc.main.serviceI.StudentserviceI;

@RestController
public class Studentcontroller 
{
	private static final Logger Log=LoggerFactory.getLogger(Studentcontroller.class);
	@Autowired
	StudentserviceI si;
	@PostMapping("/savestudentdata")
	public ResponseEntity<Student11>onsaveStudent(@RequestPart("data")String stu,
			@RequestPart("sImage") MultipartFile sImage,
			@RequestPart("sSign") MultipartFile sSign,
			@RequestPart("sIdcard") MultipartFile sIdcard)
	{
		Student11 std =si.onsavestudentdata(stu,sImage,sSign,sIdcard);
		return new ResponseEntity<Student11>(std,HttpStatus.CREATED);
	

}
}
