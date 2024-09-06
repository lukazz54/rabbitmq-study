package br.com.rabbitmq.producer.exceptions;

public class UserFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserFoundException() { super("Usuario já se encontra em nosso banco de dados !"); }
	
	public UserFoundException(String message) { super(message); }

}
