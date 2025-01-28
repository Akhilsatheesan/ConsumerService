package com.shopping.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.consumer.model.ConsumerCredEntity;

public interface ConsumerCredRepo extends JpaRepository<ConsumerCredEntity, String> {

	@Modifying
	@Transactional
	@Query("UPDATE ConsumerCredEntity c SET c.password = :password where c.userName = :username")
	int updatePassword(@Param("username") String username, @Param("password") String password);
}
