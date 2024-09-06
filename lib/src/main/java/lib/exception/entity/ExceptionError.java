package lib.exception.entity;

public record ExceptionError(boolean success, int statusCode, String message ) {

}
