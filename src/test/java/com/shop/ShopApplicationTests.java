package com.shop;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.entity.UserDataEntity;
import com.shop.repository.UserDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {
	
	@Autowired
	UserDataRepository userDataRepository;

	@Test
	public void contextLoads() {
		UserDataEntity savedEntity = userDataRepository.save(prepareUserDataEntity());
		assertNotNull(savedEntity.getId());
		System.out.println("saved entity "+savedEntity.getId());
	}
	
	private UserDataEntity prepareUserDataEntity() {
		UserDataEntity entity = new UserDataEntity();
		entity.setAadharNo(5);
		entity.setCardHolderName("Roushan");
		entity.setCashMemoNo("12121");
		entity.setHouseNo("abcd");
		entity.setKerosene("2Litre");
		entity.setRice("1KG");
		entity.setPrice(BigDecimal.valueOf(210.56));
		return entity;
	}

}
