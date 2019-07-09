package dataStructures.exceptions;

public class AlreadyExistLabelException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param label the label which already exist.
     */
    public AlreadyExistLabelException(String label) {
        super(label + " already exist in the graph!");
    }
}
