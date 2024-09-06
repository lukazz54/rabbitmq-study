package lib.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {

	@Id
	private String id;
	private String name;
	private String email;
	
	//Custom Constructor
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
}
