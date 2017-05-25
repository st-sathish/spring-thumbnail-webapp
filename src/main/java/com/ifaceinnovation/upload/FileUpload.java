package com.ifaceinnovation.upload;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload implements Serializable {

	private static final long serialVersionUID = 74458L;
	
	private List<MultipartFile> images;
	
	public List<MultipartFile> getImages() {
        return images;
    }
    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
