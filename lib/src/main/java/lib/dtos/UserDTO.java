package lib.dtos;

import java.io.Serializable;

public record UserDTO(String name, String email) implements Serializable {

}
