package com.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.UserDataEntity;
import com.shop.repository.UserDataRepository;

@Controller
@RequestMapping("/userdata")
@CrossOrigin(origins = "*")
public class UserDataController {

	@Autowired
	UserDataRepository repo;

	@GetMapping
	ResponseEntity<List<UserDataEntity>> getUserData(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		List<UserDataEntity> userData = repo.findAllByDateRange(startDate, endDate);
		return new ResponseEntity<List<UserDataEntity>>(userData, HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity<UserDataEntity> saveData(@RequestBody UserDataEntity userData) {
		List<UserDataEntity> users = repo.findByCardHolderNameAndHouseNoAndBillMonthIgnoreCase(
				userData.getCardHolderName(), userData.getHouseNo(), userData.getBillMonth());
		if (!users.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		else {
			UserDataEntity savedData = repo.save(userData);
			return new ResponseEntity<>(savedData, HttpStatus.OK);
		}
	}

	@PutMapping
	ResponseEntity<UserDataEntity> updateData(@RequestBody UserDataEntity userData) {
		UserDataEntity savedData = repo.save(userData);
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteData(@PathVariable("id") Long id) {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
