package com.example.Foody.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Foody.Domain.Resturant;
import com.example.Foody.Repositories.ResturantRepository;

/**
 * @author Mahesvaran Ashokan
 *
 */
@Service
public class ResturantServiceImpl implements ResturantService {

	@Autowired
	private ResturantRepository resturantRepository;

	@Override
	public List<Resturant> searchResturants(String searchTerm) {
		return resturantRepository.findBySearchTerm(searchTerm);
	}

	@Override
	public void addResturant(Resturant resturant) {
		resturantRepository.save(resturant);
	}

	@Override
	public String saveRating(Long resturantId, double rating) {
		Optional<Resturant> resturant = resturantRepository.findById(resturantId);
		if (resturant.isPresent()) {
			Resturant resturantToUpdate = resturant.get();
			resturantToUpdate.setRating(rating);
			resturantRepository.save(resturantToUpdate);
		}
		return "Thanks for rating us";

	}

	@Override
	public List<Resturant> getAllResturants() {

		return resturantRepository.findAll();
	}

}
