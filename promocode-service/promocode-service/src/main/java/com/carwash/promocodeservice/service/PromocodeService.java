package com.carwash.promocodeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carwash.promocodeservice.entity.Promocode;

public interface PromocodeService {

	int addPromocode(Promocode promocode);
	void updatePromocode(Promocode promocode);
	Optional<Promocode> getPromocodeByPromocodeId(int promocodeId);
	List<Promocode> getAllPromocodes();
	void deletePromocode(int promocodeId);
	Promocode getByPromocode(String promocode);
	Boolean existById(int promocodeId);
}

