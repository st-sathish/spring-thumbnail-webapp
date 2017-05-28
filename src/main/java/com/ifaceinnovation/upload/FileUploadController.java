package com.ifaceinnovation.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ifaceinnovation.GenericUtils;
import com.ifaceinnovation.ImageUtils;

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
    public String uploadResources(HttpServletRequest servletRequest, 
                                 @ModelAttribute FileUpload fileUpload,
                                 Model model) {
        //Get the uploaded files and store them
        List<MultipartFile> files = fileUpload.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) {
        	File imageDir = new File("F:\\storage\\images\\");
        	if(!imageDir.exists()) {
        		imageDir.mkdir();
        	}
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                File imageFile = new File(imageDir+File.separator+fileName);
                System.out.println(imageFile.getAbsolutePath());
                try {
                    multipartFile.transferTo(imageFile);
                    String path = ImageUtils.createThumbnail(imageFile, 50, 50);
                    System.out.println(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // Here, you can save the product details in database
        String url = GenericUtils.getBaseUrl(servletRequest)+File.separator+"images";
        System.out.println(url);
        model.addAttribute("url", url);
        model.addAttribute("fileUpload", fileUpload);
        return "uploadSuccess";
    }
	
	@RequestMapping(value = "/upload-form")
    public String inputProduct(HttpServletRequest servletRequest, Model model) {
		System.out.println(GenericUtils.getBaseUrl(servletRequest));
        model.addAttribute("fileUpload", new FileUpload());
        return "fileUpload";
    }
}
