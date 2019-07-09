package dataStructures.exceptions;

public class DoesNotExistLabelException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param label the label which doesn't exist.
     */
    public DoesNotExistLabelException(String label) {
        super(label + " doesn't exist in the graph!");
    }
}
