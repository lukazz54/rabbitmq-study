package br.com.rabbitmq.producer.services;

import static lib.rabbitmq.config.RabbitContants.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rabbitmq.producer.exceptions.UserFoundException;
import br.com.rabbitmq.producer.repository.UserRepository;
import lib.documents.User;
import lib.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final RabbitMQService rabbitService;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void insertNewUser(UserDTO userDTO) {
		
		try {
			System.out.println("UE " + userDTO.toString());
			Optional<User> user = Optional.ofNullable(userRepository.findByName(userDTO.name()));
			
			if(user.isPresent())
				throw new UserFoundException();
			
			user = Optional.ofNullable(new User(userDTO.name(), userDTO.email()));
			
			userRepository.save(user.get());
			
			rabbitService.setRabbitMq(QUEUE_SEND_EMAIL, EXG_SEND_EMAIL, RK_SEND_EMAIL);
			rabbitService.sendMessage(userDTO);
		}catch(Exception e) {
			log.info("Sending to DQL" );
			log.error("Error ", e);
		}
		
	}
}
