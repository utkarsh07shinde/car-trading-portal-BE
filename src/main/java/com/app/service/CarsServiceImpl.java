package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Brands;
import com.app.entity.CarService;
import com.app.entity.Cars;
import com.app.dao.CarsRepository;

@Service
public class CarsServiceImpl implements CarsService {
	
	private CarsRepository carsRepository ;
	
	@Autowired
	public CarsServiceImpl(CarsRepository carsRepository) {
		super();
		this.carsRepository = carsRepository;
	}

	@Override
	public List<Cars> findAllCars() {
		// TODO Auto-generated method stub
		return carsRepository.findAll();
	}

	@Override
	public Cars findCarById(int theId) {
		// TODO Auto-generated method stub
		Optional<Cars> c= carsRepository.findById(theId)  ;
		Cars theCars=c.get();
		return theCars;
	}

	@Override
	public void saveCar(Cars theCars) {
		// TODO Auto-generated method stub
		carsRepository.save(theCars);

		
	}

	@Override
	public void deleteCarById(int theId) {
		// TODO Auto-generated method stub
		carsRepository.deleteById(theId);

		
	}

	@Override
	public List<Cars> findCarsByCity(String city) {
		// TODO Auto-generated method stub
		return carsRepository.getCarsByCity(city);
	}

	@Override
	public List<Cars> findCarsByBrandId(Brands theBrands) {
		// TODO Auto-generated method stub
		return carsRepository.getCarsBybrandId(theBrands);
	}

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String name=file.getOriginalFilename();
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name).substring(name.lastIndexOf("."));
		String filePath=path+File.separator+fileName1;
		File f= new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return fileName1;
	}

}
