package br.com.rabbitmq.producer.services;

import org.springframework.stereotype.Service;

import br.com.rabbitmq.producer.configs.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class RabbitMQService {
	
	private final RabbitMQConfig rabbitMqConfig;
	
	public void setRabbitMq(String queueName, String exchangeName, String routingKey) {
		try {
			log.info("Start configuring RabbitMQ by QUEUE: {}", queueName);
			rabbitMqConfig.configureRabbitMQ(queueName, exchangeName, routingKey);
		}catch (Exception e) {
			log.error("Error to set RabbitMQ: ", e);
		}
	}
	
	public <T> void sendMessage(T message) {
		log.info("Sending message");
		rabbitMqConfig.sendObjectMessage(message);
	}
	
}
