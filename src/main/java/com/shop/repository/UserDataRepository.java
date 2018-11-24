package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, Long>{
	
	@Query("select user from UserDataEntity user where user.billMonth >= :endDate and user.billMonth <= :startDate order by user.id desc")
	public List<UserDataEntity> findAllByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

	public List<UserDataEntity> findByCardHolderNameAndHouseNoAndBillMonthIgnoreCase(String cardHolderName, String houseNo, String billMonth);
	
}
