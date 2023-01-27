package Drivers;

public class CheckLicenceException extends Exception{
    public CheckLicenceException(String message) {
        super(message);
    }

    public CheckLicenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
