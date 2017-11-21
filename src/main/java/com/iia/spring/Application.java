package com.iia.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.Style;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.spring.entity.Order;
import com.iia.spring.entity.OrderState;
import com.iia.spring.entity.Customer;
import com.iia.spring.entity.Product;
import com.iia.spring.repository.OrderRepository;
import com.iia.spring.repository.CustomerRepository;
import com.iia.spring.repository.ProductRepository;

/**
 * Main application
 * @author Antonio Maxime
 *
 */
@SpringBootApplication
public class Application {
	
	final static Log logger = LogFactory.getLog(Style.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository) {
		return (args) -> {
			//Clean databases for tests
			productRepository.deleteAll();
			orderRepository.deleteAll();
			customerRepository.deleteAll();
			
			//Create lists which contains datas to save them after in a for
			List<Customer> customers = new ArrayList<Customer>();
			List<Product> products = new ArrayList<Product>();
			List<Order> orders = new ArrayList<Order>();
			
			//Creation of products
			Product product1 = new Product("Jouet", "Tres utile pour les enfants", 666, true, 1299.99f);
			Product product2 = new Product("Gateau", "Manger", 666, true, 1299.99f);
			Product product3 = new Product("Joris", "Inutle", 0, false, 0.01f);
			products.add(product1);
			products.add(product2);
			products.add(product3);
			
			//Prepare a DateFormat
			Date date = new Date();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT);
			String formattedDate = shortDateFormat.format(date);
			
			
			//Creation of multiple orders
			Order order1 = new Order(formattedDate, OrderState.Brouillon, 89478.82f);
			Order order2 = new Order(formattedDate, OrderState.EnCours, 89478.82f);
			Order order3 = new Order(formattedDate, OrderState.Finie, 89478.82f);
			orders.add(order1);
			orders.add(order2);
			orders.add(order3);
			
			//Creation of multiple customers and add them to list
			Customer customer1 = new Customer("Antonio", "Maxime", "0649381612", "Le Haut Aunay", 53100, "Contest", order1);
			Customer customer2 = new Customer("Deffay", "Pierre", "0606060606", "Rue de l'oeil de perdrix", 53000, "Laval", order2);
			Customer customer3 = new Customer("Soutif", "Gabin", "0606060606", "UNKNOW", 53000, "Laval", order3);
			customers.add(customer1);
			customers.add(customer2);
			customers.add(customer3);
			
			//add customer's list to orders
			order1.setCustomers(customers);
			order2.setCustomers(customers);
			order3.setCustomers(customers);
			
			//add orders to products
			product1.OrderAdd(order1);
			product1.OrderAdd(order3);
			product2.OrderAdd(order2);
			product3.OrderAdd(order3);

			//add product to orders
			order1.ProductAdd(product1);
			order2.ProductAdd(product2);
			order3.ProductAdd(product1);
			order3.ProductAdd(product3);
			
			//save all in database
			logger.info(System.lineSeparator() + "-------------------------------------------------------------------------------------");
			for(int i = 0;i < products.size();i++) {
				productRepository.save(products.get(i));
				logger.info("\nProduct added : " + products.get(i).toString());
			}
			logger.info(System.lineSeparator());
			

			logger.info(System.lineSeparator());
			for(int i = 0;i < orders.size();i++) {
				orderRepository.save(orders.get(i));
				logger.info("\nOrder added : " + orders.get(i).toString());
			}
			logger.info(System.lineSeparator());
			
			
			logger.info(System.lineSeparator());
			for(int i = 0;i < customers.size();i++) {
				customerRepository.save(customers.get(i));
				logger.info("\nCustomer added : " + customers.get(i));
			}
			logger.info(System.lineSeparator() + "-------------------------------------------------------------------------------------");
			
		};
	}
	
}
