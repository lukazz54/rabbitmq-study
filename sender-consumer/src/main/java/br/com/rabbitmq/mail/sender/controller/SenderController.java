package br.com.rabbitmq.mail.sender.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitmq.mail.sender.service.EmailService;
import lib.dtos.SenderEmailDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/send")
@AllArgsConstructor
public class SenderController {
	
	private final EmailService emailService;
	
	@PostMapping("/email")
	public void sendEmail(@RequestBody SenderEmailDTO senderDTO) {
		//emailService.sendEmail(senderDTO);
		
	}

}
