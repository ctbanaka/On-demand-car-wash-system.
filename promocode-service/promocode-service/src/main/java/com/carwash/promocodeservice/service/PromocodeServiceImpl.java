package com.carwash.promocodeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.promocodeservice.entity.Promocode;
import com.carwash.promocodeservice.exception.PromocodeAlreadyExistsException;
import com.carwash.promocodeservice.exception.PromocodeNotFoundException;
import com.carwash.promocodeservice.repository.PromocodeRepository;

@Service
public class PromocodeServiceImpl implements PromocodeService {

	@Autowired
	PromocodeRepository promocodeRepository;
	
	@Override
	public int addPromocode(Promocode promocode) {
		if(promocodeRepository.existsById(promocode.getPromocodeId()))
			throw new PromocodeAlreadyExistsException("promocode already exists");
		promocodeRepository.save(promocode);
		return promocode.getPromocodeId();
	}

	@Override
	public void updatePromocode(Promocode promocode) {
		if(promocodeRepository.existsById(promocode.getPromocodeId()))
			promocodeRepository.save(promocode);
		else
			throwNotFoundException();

	}

	@Override
	public Optional<Promocode> getPromocodeByPromocodeId(int promocodeId) {
		Optional<Promocode> promocode=null;
		if(promocodeRepository.existsById(promocodeId))
			promocode=promocodeRepository.findById(promocodeId);
		else
			throwNotFoundException();
//			throw new PromocodeNotFoundException("Promocode doesnot exists...");
		return promocode;
	}
	@Override
	public Promocode getByPromocode(String promocode) {
		Promocode promocodeDetails=promocodeRepository.getByPromocode(promocode);
		if(promocode==null)
			throwNotFoundException();
//			throw new PromocodeNotFoundException("Promocode doesnot exists...");
		return promocodeDetails;
	}

	@Override
	public Boolean existById(int promocodeId) {
	return promocodeRepository.existsById(promocodeId);
	}

	@Override
	public List<Promocode> getAllPromocodes() {
		return promocodeRepository.findAll();
	}

	@Override
	public void deletePromocode(int promocodeId) {
		if(promocodeRepository.existsById(promocodeId))
			promocodeRepository.deleteById(promocodeId);
		else
			throwNotFoundException();

	}



	public void throwNotFoundException() {
		throw new PromocodeNotFoundException("Promocode doesnot exists...");
	}
}
