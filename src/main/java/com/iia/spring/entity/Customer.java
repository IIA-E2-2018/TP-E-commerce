package com.iia.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class @see Customer from database
 * @author Antonio Maxime
 *
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String lastName;
	private String name;
	private String phone;
	private int cp;
	private String city;
	private String address;
	
	/**
	 * Empty constructor class @see Customer
	 */
	protected Customer() {}
	
	/**
	 * Constructor class @see Customer
	 * @param lastName		@see String		lastName of this @see Customer
	 * @param name		 	@see String		name of this @see Customer
	 * @param phone			@see String		phone of this @see Customer
	 * @param address		@see String		address of this @see Customer
	 * @param cp			@see Integer	cp of this @see Customer
	 * @param city 			@see String		city of this @see Customer
	 * @param order			@see order 		order of this @see Customer
	 */	
	public Customer(String lastName, String name, String phone, String address, int cp, String city, Order order) {
		this.setLastName(lastName)
			.setName(name)
			.setPhone(phone)
			.setCity(city)
			.setAddress(address)
			.setCp(cp)
			.setOrder(order);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Customer
	 */
	@Override
	public String toString() {
		return "\nLastName : " + this.lastName
			+ "\nName : " + this.name
			+ "\nPhone : " + this.phone
			+ "\nAddress : " + this.address
			+ "\nCp : " + this.cp
			+ "\nCity : " + this.city
			+ "\norder : " + this.order
			+ "\n";
		
	}

	/**
	 * References ManyToOne to @see order
	 */
	@ManyToOne
	private Order order;
	
	/**
	 * @return the @see Order order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the new @see Order
	 * @return this @see Customer
	 */
	public Customer setOrder(Order order) {
		this.order = order;
		return this;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the new id. In protected access for security
	 * @return this @see Customer
	 */
	protected Customer setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the new lastname
	 * @return this @see Customer
	 */
	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * @return the firstName
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param firstName the new name
	 * @return this @see Customer
	 */
	public Customer setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the new phone number
	 * @return this @see Customer
	 */
	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the new address
	 * @return this @see Customer
	 */
	public Customer setAddress(String address) {
		this.address = address;
		return this;
	}
	
	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}
	
	/**
	 * @param cp the new Postal Code
	 * @return this @see Customer
	 */
	public Customer setCp(int cp) {
		this.cp = cp;
		return this;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the new city of customer
	 * @return this @see Customer
	 */
	public Customer setCity(String city) {
		this.city = city;
		return this;
	}

}
