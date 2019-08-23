package com.example.Foody.Domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Mahesvaran Ashokan
 *
 */
@Entity
@Table(name = "resturant")
public class Resturant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resturant")
	private Set<Food> food = new HashSet<>();

	@Column()
	private double rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Food> getFoods() {
		return food;
	}

	public void setFood(Set<Food> foods) {
		this.food = foods;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = (getRating() + rating) / 2.0;
	}

}
