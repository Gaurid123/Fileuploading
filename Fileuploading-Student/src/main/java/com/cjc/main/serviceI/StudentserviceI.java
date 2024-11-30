package com.cjc.main.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Student11;

public interface StudentserviceI {

	public Student11 onsavestudentdata(String stu, MultipartFile sImage, MultipartFile sSign, MultipartFile sIdcard);

}
