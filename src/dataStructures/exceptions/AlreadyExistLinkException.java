package dataStructures.exceptions;

public class AlreadyExistLinkException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param links exist link.
     */
    public AlreadyExistLinkException(String links) {
        super("link " + links + " already exist in the graph!");
    }
}
