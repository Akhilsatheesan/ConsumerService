package com.shopping.consumer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.consumer.model.ConsumerEntity;

public interface ConsumerRepo extends JpaRepository<ConsumerEntity, Integer> {

	List<ConsumerEntity> findByEmail(String email);

	List<ConsumerEntity> findByMobNumber(String mobNumber);

	boolean existsByEmail(String email);

	boolean existsByMobNumber(String mobNumber);

}
