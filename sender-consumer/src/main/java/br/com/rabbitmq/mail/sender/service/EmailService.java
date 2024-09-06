package br.com.rabbitmq.mail.sender.service;

import static lib.rabbitmq.config.RabbitContants.QUEUE_SEND_EMAIL;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lib.dtos.UserDTO;

@Component
public class EmailService {

	@RabbitListener(queues = QUEUE_SEND_EMAIL)
	public void sendEmail(UserDTO userDTO) {
		
		System.out.println("NO CONSUMER " + userDTO.toString());
		
	}
}
