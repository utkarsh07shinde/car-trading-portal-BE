package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Cars;
import com.app.entity.Carts;
import com.app.dao.CartsRepository;

@Service
public class CartsServiceImpl implements CartsService {
	
	private CartsRepository cartsRepository;

	@Autowired
	public CartsServiceImpl(CartsRepository cartsRepository) {
		super();
		this.cartsRepository = cartsRepository;
	}

	@Override
	public List<Carts> findAllCarts() {
		// TODO Auto-generated method stub
		return cartsRepository.findAll()  ;
	}

	@Override
	public Carts findCartsById(int theId) {
		// TODO Auto-generated method stub
		Optional<Carts> cr= cartsRepository.findById(theId)  ;
		Carts theCarts=cr.get();
		return theCarts;
	}

	@Override
	public void saveCarts(Carts theCarts) {
		// TODO Auto-generated method stub
		cartsRepository.save(theCarts);

		
	}

	@Override
	public void deleteCartsById(int theId) {
		// TODO Auto-generated method stub
		cartsRepository.deleteById(theId);

		
	}

}
