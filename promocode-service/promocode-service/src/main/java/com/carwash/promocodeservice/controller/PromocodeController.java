package com.carwash.promocodeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.promocodeservice.entity.Promocode;
import com.carwash.promocodeservice.service.PromocodeService;
import com.carwash.promocodeservice.service.PromocodeServiceImpl;


@RestController
@RequestMapping("/promocode")
public class PromocodeController {

	@Autowired
	PromocodeService promocodeService;

	@PostMapping
	public ResponseEntity<String> addPromocode(@RequestBody Promocode promocode) {
		int promocodeId = promocodeService.addPromocode(promocode);
		return new ResponseEntity<String>("Promocode added ID: " + promocodeId, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updatePromocode(@RequestBody Promocode promocode) {
		promocodeService.updatePromocode(promocode);
		return new ResponseEntity<String>("Promocode updated", HttpStatus.OK);
	}

	@GetMapping("/id/{promocodeId}")
	public ResponseEntity<Optional<Promocode>> getPromocodeByPromocodeId(@PathVariable int promocodeId) {
		Optional<Promocode> promocode = promocodeService.getPromocodeByPromocodeId(promocodeId);
		return new ResponseEntity<Optional<Promocode>>(promocode, HttpStatus.OK);
	}

	@GetMapping("/{promocode}")
	public ResponseEntity<Promocode> getByPromocode(@PathVariable String promocode) {
		Promocode promocodeDetails = promocodeService.getByPromocode(promocode);
		return new ResponseEntity<Promocode>(promocodeDetails, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Promocode>> getAllPromocodes() {
		List<Promocode> promocode = promocodeService.getAllPromocodes();
		return new ResponseEntity<List<Promocode>>(promocode, HttpStatus.OK);
	}

	@DeleteMapping("/{promocodeId}")
	public ResponseEntity<String> deletePromocode(@PathVariable int promocodeId) {
		promocodeService.deletePromocode(promocodeId);
		return new ResponseEntity<String>("Promocode deleted", HttpStatus.OK);
	}

	@GetMapping("/promo/{promocodeId}")
	public ResponseEntity<Boolean> checkUserExist(@PathVariable int promocodeId) {
		Boolean promo = promocodeService.existById(promocodeId);
		return new ResponseEntity<Boolean>(promo, HttpStatus.OK);
	}
}
