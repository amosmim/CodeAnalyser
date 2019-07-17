package dataStructures;

import dataStructures.exceptions.AlreadyExistLabelException;
import dataStructures.exceptions.AlreadyExistLinkException;
import dataStructures.exceptions.DoesNotExistLabelException;
import dataStructures.exceptions.DoesNotExistLinkException;

import java.util.*;

public class Graph <T> implements ISearchable{
    private HashMap<String, Set<String>> links;
    private LinkedHashMap<String, ILabeledData> nodes;

    public Graph() {
        this.links = new HashMap<String, Set<String>>();
        this.nodes = new LinkedHashMap<String, ILabeledData>();
    }

    public void addNode(ILabeledData data) throws AlreadyExistLabelException {
        if (this.nodes.containsKey(data.getLabel())) {
            throw new AlreadyExistLabelException(data.getLabel());
        }
        this.nodes.put(data.getLabel(), data);
        this.links.put(data.getLabel(), new HashSet<>());
    }

    public void deleteNode(String label) throws DoesNotExistLabelException {
        if (!this.nodes.containsKey(label)){
            throw new DoesNotExistLabelException(label);
        }
        // delete the entry from nodes list
        this.nodes.remove(label);

        // delete links from the deleted entry
        this.links.remove(label);

        // delete all the links to the deleted entry
        for (Map.Entry<String, Set<String>> entry : this.links.entrySet()) {
            entry.getValue().remove(label);
        }
    }

    public void addLink(String label, String to) throws DoesNotExistLabelException, AlreadyExistLinkException {
        if ( (!this.nodes.containsKey(label)) ){
            throw new DoesNotExistLabelException(label);
        } else if (!this.nodes.containsKey(to)) {
            throw new DoesNotExistLabelException(to);
        }

        if (this.links.get(label).contains(to)) {
            throw new AlreadyExistLinkException(label + "->" + to);
        }

        this.links.get(label).add(to);
    }

    public void deleteLink(String from, String to) throws DoesNotExistLabelException, DoesNotExistLinkException {
        if ( (!this.nodes.containsKey(from)) ){
            throw new DoesNotExistLabelException(from);
        } else if (!this.nodes.containsKey(to)) {
            throw new DoesNotExistLabelException(to);
        }

        Set<String> list = this.links.get(from);

        if (!list.contains(to)) {
            throw new DoesNotExistLinkException(from + "->" + to);
        }

        list.remove(to);
    }

    public boolean IsLinked (String from, String to) {
        return ( (this.nodes.containsKey(from)) && (this.nodes.containsKey(to)) && (this.links.get(from).contains(to)) );
    }

    public boolean nodeExist(String label){
        return this.nodes.containsKey(label);
    }

    public ILabeledData getNode(String label) throws DoesNotExistLabelException {
        if (this.nodes.containsKey(label)) {
            return this.nodes.get(label);
        } else {
            throw new DoesNotExistLabelException(label);
        }
    }

    public Set<String> getNextNodesOf(String label) throws DoesNotExistLabelException  {
        if (this.nodes.containsKey(label)) {
            return this.links.get(label);
        } else {
            throw new DoesNotExistLabelException(label);
        }
    }

    public Set<String> getAllLabels() {
        return this.nodes.keySet();
    }
}
