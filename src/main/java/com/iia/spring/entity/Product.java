package com.iia.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Class @see Product from database
 * @author Antonio Maxime
 *
 */
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private int quantity;
	private Boolean dead;
	private float price;
	 
	/**
	 * Empty constructor class @see Product
	 */
	protected Product() {}
	 
	/**
	 * Constructor class @see Product
	 * @param name			@see String			name of this @see Product
	 * @param description	@see String			description of this @see Product
	 * @param quantity		@see Integer		quantity of this @see Product
	 * @param dead			@see Boolean		dead of this @see Product
	 * @param price			@see Float			price of this @see Product 
	 */
	public Product(String name, String description, int quantity, boolean dead, float price) {
		this.setName(name)
			.setDescription(description)
			.setQuantity(quantity)
			.setDead(dead)
			.setPrice(price);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Product
	 */
	@Override
	public String toString() {
		return "\nName : " + this.name
			+ "\nDescription : " + this.description
			+ "\nQuantity : " + this.quantity 
			+ "\nDead : " + this.dead
			+ "\nPrice : " + this.price
			+ "\n";
		
	}
	
	/**
	 * References ManyToMany to @see Order
	 */
	@ManyToMany(targetEntity = Order.class, mappedBy = "products")
	private Set<Order> Orders = new HashSet<>();
	
	/**
	 * @return the @see List<Order> Orders
	 */
	public Set<Order> getOrders() {
		return Orders;
	}

	/**
	 * @param Orders the new @see List<Order> Orders
	 * @return this @see Product
	 */
	public Product setOrders(Set<Order> Orders) {
		this.Orders = Orders;
		return this;
	}

	/**
	 * Add a @see Order to @see Product products
	 * @param Order		@see Order Order to add
	 */
	public void OrderAdd(Order Order) {
		this.Orders.add(Order);
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the new id. In protected only for security
	 * @return this @see Product
	 */
	protected Product setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the new name
	 * @return this @see Product
	 */
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the new description
	 * @return this @see Product
	 */
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the new quantity
	 * @return this @see Product
	 */
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	/**
	 * @return the dead
	 */
	public Boolean getDead() {
		return dead;
	}
	
	/**
	 * @param dead the new dead value
	 * @return this @see Product
	 */
	public Product setDead(Boolean dead) {
		this.dead = dead;
		return this;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the new price
	 * @return this @see Product
	 */
	public Product setPrice(float price) {
		this.price = price;
		return this;
	}
	 	 
}
