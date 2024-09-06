package br.com.rabbitmq.producer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitmq.producer.services.UserService;
import lib.documents.User;
import lib.dtos.UserDTO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	@PostMapping
	public ResponseEntity<Void> insertNewUser(@RequestBody UserDTO userDTO) {
		
		System.out.println(userDTO.toString());
		userService.insertNewUser(userDTO);
		
		return ResponseEntity.ok().build();
	}
}
