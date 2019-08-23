package com.example.Foody.Repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Foody.Domain.Food;

/**
 * @author Mahesvaran Ashokan
 *
 */
@Repository
@Transactional
public interface FoodRepository extends JpaRepository<Food, Long> {

	
}
