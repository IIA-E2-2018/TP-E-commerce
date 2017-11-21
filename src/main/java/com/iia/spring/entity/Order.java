package com.iia.spring.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class @see Order from database
 * @author Antonio Maxime
 *
 */
@Entity
@Table(name = "Order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String date;
	private OrderState state;
	private float totalPrice;
	
	/**
	 * Empty constructor class @see Order
	 */
	protected Order() {}
	
	/**
	 * Constructor class @see Order
	 * @param date			@see String			date of this @see Order
	 * @param state			@see OrderState		State of this Order
	 * @param totalPrice	@see Float			totalPrice of this @see Order
	 */
	public Order(String date, OrderState state, float totalPrice) {
		this.setDate(date)
			.setState(state)
			.setTotalPrice(totalPrice);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Order
	 */
	@Override
	public String toString() {
		return "\nDate : " + this.date
			+ "\nState : " + this.state
			+ "\nTotalPrice : " + this.totalPrice
			+ "\n";
		
	}
	
	/**
	 * References OneToMany to @see Customer 
	 */
	@OneToMany(mappedBy="Order")
	private List<Customer> customers;
	
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 * @return this @see Order
	 */
	public Order setCustomers(List<Customer> customers) {
		this.customers = customers;
		return this;
	}

	/**
	 * References ManyToMany to @see Product
	 */
	@ManyToMany(targetEntity = Product.class, cascade=CascadeType.MERGE)
	/**
	 * References Table "product_Order" in database
	 */
	@JoinTable(
			name = "product_Order",
			joinColumns = {@JoinColumn(name = "product_id")},
			inverseJoinColumns = {@JoinColumn(name = "Order_id")})
	private Set<Product> products = new HashSet<>();

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the new product
	 * @return this @see Order
	 */
	public Order setProducts(Set<Product> products) {
		this.products = products;
		return this;
	}
	
	/**
	 * Add a @see Product to @see Order products
	 * @param product	@see Product product to add
	 */
	public void ProductAdd(Product product) {
		this.products.add(product);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the new id, In protected only for security
	 * @return this @see Order
	 */
	protected Order setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @param date the new date
	 * @return this @see Order
	 */
	public Order setDate(String date) {
		this.date = date;
		return this;
	}
	
	/**
	 * @return the state
	 */
	public OrderState getState() {
		return state;
	}
	
	/**
	 * @param state the new state
	 * @return this @see Order
	 */
	public Order setState(OrderState state) {
		this.state = state;
		return this;
	}
	
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * @param totalPrice the new totalPrice
	 * @return this @see Order
	 */
	public Order setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	
}
