package br.com.rabbitmq.producer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {

	private ConnectionFactory connectionFactory;
	private RabbitTemplate rabbitTemplate; 
	
	
	public void configureRabbitMQ(String queueName, String exchangeName, String routingKey) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		
		Queue queue = factorySimpleQueue(queueName);
		rabbitAdmin.declareQueue(queue);
		
		DirectExchange directExchange = factorySimpleDirectExchange(exchangeName);
		rabbitAdmin.declareExchange(directExchange);
		
		Binding binding = BindingBuilder.bind(queue).to(directExchange).with(routingKey);
		rabbitAdmin.declareBinding(binding);
		
		rabbitTemplate.setExchange(exchangeName);
		rabbitTemplate.setRoutingKey(routingKey);
		
	}
	
	public Queue factorySimpleQueue(String queueName) {
		return new Queue(queueName, false, false, false);
	}
	
	public DirectExchange factorySimpleDirectExchange(String exchangeName) {
		return new DirectExchange(exchangeName, false, false);
	}
	
	public void sendStringMessage(String message) {
		rabbitTemplate.convertAndSend(message);
	}
	
	public <T> void sendObjectMessage(T objectMessage) {
		rabbitTemplate.convertAndSend(objectMessage);
	}
	
	
}
