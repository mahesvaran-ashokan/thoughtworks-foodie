package com.example.Foody.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Foody.Domain.Resturant;

/**
 * @author Mahesvaran Ashokan
 *
 */
@Repository
@Transactional
public interface ResturantRepository extends JpaRepository<Resturant, Long> {

	@Query(nativeQuery = true, value = "SELECT re.id, re.name, fo.food_name, fo.food_type ,re.rating "
			+ "FROM resturant re join food fo ON re.id=fo.resturant_id WHERE "
			+ " fo.food_name LIKE %:searchTerm% or fo.food_type LIKE %:searchTerm% GROUP BY re.id")
	public List<Resturant> findBySearchTerm(String searchTerm);
}
