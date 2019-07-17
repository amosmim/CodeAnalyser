package dataStructures;

import dataStructures.exceptions.*;

import java.util.Set;

public interface ISearchable {
    void addNode(ILabeledData data) throws AlreadyExistLabelException;
    void deleteNode(String label) throws DoesNotExistLabelException;
    void addLink(String label, String to) throws DoesNotExistLabelException, AlreadyExistLinkException;
    void deleteLink(String from, String to) throws DoesNotExistLabelException, DoesNotExistLinkException;
    boolean IsLinked (String from, String to);
    boolean nodeExist(String label);
    ILabeledData getNode(String label) throws DoesNotExistLabelException;
    Set<String> getNextNodesOf(String label) throws DoesNotExistLabelException;
    Set<String> getAllLabels();

}
