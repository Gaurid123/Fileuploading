package com.cjc.main.serviceIMPL;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Student11;
import com.cjc.main.repository.StudentRepository;
import com.cjc.main.serviceI.StudentserviceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class StudentserviceIMPL implements StudentserviceI
{
	private static final Logger Log=LoggerFactory.getLogger(StudentserviceIMPL.class);
	@Autowired
	private ObjectMapper objmapper;
	@Autowired
	StudentRepository sr;

	@Override
	public Student11 onsavestudentdata(String stu, MultipartFile sImage, MultipartFile sSign, MultipartFile sIdcard)
	{
		Student11 stdata=null;
		
		
			try {
				stdata=objmapper.readValue(stu, Student11.class);
				Log.info(stdata.toString());
				if(!sImage.isEmpty())stdata.setStudentImage(sImage.getBytes());
				
				if(!sSign.isEmpty())stdata.setStudentSign(sSign.getBytes());
				if(!sIdcard.isEmpty())stdata.setStudentIdCard(sIdcard.getBytes());
				
				sr.save(stdata);
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			Log.info("hi");
		return stdata;
	}

}
