package br.com.rabbitmq.producer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import lib.documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByName(String name);

}
