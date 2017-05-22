package com.ifaceinnovation.upload;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	String message = "Welcome to Spring MVC!";
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)  
	public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){  
        String path=session.getServletContext().getRealPath("/");  
        String filename=file.getOriginalFilename();
        System.out.println(path+" "+filename);  
        try{  
	        byte barr[]=file.getBytes();   
	        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
        }catch(Exception e){
        	System.out.println(e);
        }  
        return new ModelAndView("uploadSuccess", "filename", path+"/"+filename);  
	}
}
