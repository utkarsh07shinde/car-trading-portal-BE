package com.app.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.CarImage;
import com.app.service.CarImageService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class CarImageController {

	private CarImageService carImageService;
	
	@Value("${project.image}")
	private String path;

	public CarImageController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	@GetMapping(value = "/cars/images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public String downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException
	{
		InputStream resource= this.carImageService.getResouce(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		return "Image Display Succesfully";
	}
	
	@PostMapping("/cars/uploadImage")
	public String uploadImage(@RequestParam("carImage") MultipartFile carImage) throws IOException
	{
		String fileName=this.carImageService.uploadImage(path, carImage);
		CarImage image=new CarImage();
		image.setImageUrl(fileName);
		carImageService.saveCarImage(image);
		return fileName;
	}
	
}
