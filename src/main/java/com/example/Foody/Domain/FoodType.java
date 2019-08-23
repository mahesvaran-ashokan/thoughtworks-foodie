//package com.example.Foody.Domain;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "food_type")
//public class FoodType {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotNull
//	@Lob
//	private String foodType;
//
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "resturant_id", nullable = false)
//	private Resturant resturant;
//	
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "foodType")
//	private Set<Food> food = new HashSet<>();
//
//	public String getFoodType() {
//		return foodType;
//	}
//
//	public void setFoodType(String foodType) {
//		this.foodType = foodType;
//	}
//
//	public Resturant getResturant() {
//		return resturant;
//	}
//
//	public void setResturant(Resturant resturant) {
//		this.resturant = resturant;
//	}
//
//}
