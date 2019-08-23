package com.example.Foody.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Foody.Domain.Resturant;
import com.example.Foody.Service.ResturantService;

/**
 * Controller class for resturant
 * 
 * @author Mahesvaran Ashokan
 *
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private ResturantService resturantService;

	@GetMapping(value = "/search")
	public List<Resturant> searchResturants(@RequestParam("searchTerm") String searchTerm) {
		return resturantService.searchResturants(searchTerm);
	}

	@PostMapping(value = "/rate")
	public ResponseEntity<String> saveRating(@RequestParam("resturantId") Long resturantId,
			@RequestParam("rating") double rating) {
		if (rating > 0 && rating <= 5) {
			resturantService.saveRating(resturantId, rating);
			return new ResponseEntity<String>("Thanks rating for us!!", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Please rate between 1 To 5", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PostMapping(value = "/addResturant")
	public void addResturant(Resturant resturant) {
		resturantService.addResturant(resturant);
	}

	@GetMapping(value = "")
	public List<Resturant> getResturant() {
		return resturantService.getAllResturants();
	}

}
