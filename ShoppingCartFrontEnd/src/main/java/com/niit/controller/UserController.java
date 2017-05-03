package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {

	// Logger Statements
	// SLF4J - Simple Logging Facade for Java
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	// To connect to user in backend
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	// Get the user id and password from login page
	// Send these values to userDao.validate
	// based on response, you can navigate to either login.jsp or home.jsp

	// Whenever we configure spring security - we can remove this method

	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("userName") String id, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView("/Home");
		log.debug("Starting of the method login");
		
		log.info("You are login with id : "+id);
		if (userDAO.validate(id, password) == true) {
			log.debug("Valid credentials");
			user = userDAO.get(id);
			mv.addObject("message", "Welcome " + user.getName() + "!");

			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", categoryDAO);

			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("supplier", supplierDAO);

			// check whether user role is admin or user

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("You are admin");
				mv.addObject("isAdmin", "true");
			} else {
				log.debug("You are a customer");
				mv.addObject("isAdmin", "false");
			}
		} else {
			log.debug("Invalid user");
			mv.addObject("message", "invalid credentials");
		}
		log.debug("Ending of the method login");
		return mv;

	}

}
