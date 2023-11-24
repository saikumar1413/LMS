package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.exceptions.UserNotFoundException;
import com.infinite.model.AdminPojo;
import com.infinite.model.LoginFront;
import com.infinite.model.LoginMessage;
import com.infinite.model.User;
import com.infinite.repository.ScoreRepository;
import com.infinite.repository.UserRepository;
import com.infinite.service.AdminService;
import com.infinite.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")//specify the allowed origin for connection
@RequestMapping("api/a1")
public class UserController {
	//constructor injection for automatic dependency injection
	@Autowired
	private UserService service;

	@Autowired
	private AdminService sadmin;

	@Autowired
	private ScoreRepository scorerepo;
	
	@Autowired
	private UserRepository repo;

	/*
	 * @Autowired private UserService serv;
	 */
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return service.save(newUser);
	}

	/*
	 * @PostMapping("/score") Score newUser(@RequestBody Score newUser) { return
	 * scorerepo.save(newUser); }
	 */
	//Handles the POST request and returns a response
	@PostMapping(path = "/users/login")
	public LoginMessage loginuser(@RequestBody LoginFront loginFront) {
		User username = service.findByUsername(loginFront.getUsername());
		if (username != null) {
			String password = loginFront.getPassword();
			String userpass = username.getPassword();
			if (password.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else {
				return new LoginMessage("Incorrect emailId or Password", false);
			}
		} else {
			return new LoginMessage("emailId not exist", false);
		}
	}

	@PostMapping(path = "/admin/login")
	public LoginMessage loginadmin(@RequestBody AdminPojo admin) {
		AdminPojo adminname = sadmin.findByAdminname(admin.getAdminname());
		if (adminname != null) {
			String adminpassword = admin.getAdminpassword();
			String userpass = adminname.getAdminpassword();
			if (adminpassword.matches(userpass)) {
				return new LoginMessage("Login Success", true);
			} else {
				return new LoginMessage("Incorrect adminname or Password", false);
			}
		} else {
			return new LoginMessage("adminname not exist", false);
		}
	}

	@GetMapping("/users")
	List<User> getAllUsers() {
		return service.findAll();
	}
	 //Handles HTTP GET requests
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	//Handles PUT requests for updating an item
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return service.findById(id).map(user -> {
			user.setFullname(newUser.getFullname());
			user.setEmail(newUser.getEmail());
			user.setMobile(newUser.getMobile());
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			return service.save(user);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}
	//Handles DELETE requests for updating an item
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		service.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}
}
