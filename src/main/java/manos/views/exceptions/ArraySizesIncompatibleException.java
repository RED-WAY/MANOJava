package manos.views.exceptions;

public class ArraySizesIncompatibleException extends Exception {
    private static final long uuid = 1000L;
    
    public ArraySizesIncompatibleException(String message) {
        super(message);
    }
}
