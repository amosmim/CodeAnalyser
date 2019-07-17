package dataStructures;

import dataStructures.exceptions.AlreadyExistLabelException;
import dataStructures.exceptions.AlreadyExistLinkException;
import dataStructures.exceptions.DoesNotExistLabelException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Searcher {

    /**
     * return sub-graph, from the given node.
     * @param graph graph to reference.
     * @param label given node to root from.
     * @return ISearchable sub-graph from label with all the original links.
     */
    public static ISearchable getOffspringOf(ISearchable graph, String label) {
        ISearchable offspringMap = new Graph<>();
        Queue<String> queue =  new LinkedList<>();
        Set<String> checked = new HashSet<>();

        if (graph.nodeExist(label)) {
            try {
                // push the given node
                queue.add(label);
                offspringMap.addNode(graph.getNode(label));

                // build the graph in BDS algorithm
                while (!queue.isEmpty()) {
                    String nexted_label = queue.poll();

                    if (!checked.contains(nexted_label)) {
                        checked.add(nexted_label);

                        for (String o : graph.getNextNodesOf(nexted_label)) {
                            queue.add(o);
                            if (!offspringMap.nodeExist(o)) {
                                offspringMap.addNode(graph.getNode(o));
                            }
                            offspringMap.addLink(nexted_label, o);
                        }

                    }
                }

            } catch (DoesNotExistLabelException | AlreadyExistLabelException | AlreadyExistLinkException e) {
                e.printStackTrace();
            }
        }
        return offspringMap;
    }

    /**
     * Returns all the roots in the graph
     * @param graph graph to search on.
     * @return list of labels of all node that no other link to.
     */
    public static Set<String> getRoots(ISearchable graph){
        Set<String> nodes = graph.getAllLabels();
        Set<String> roots = new HashSet<>(nodes);
        for (String node : nodes) {
            try {
                for (String offspring : graph.getNextNodesOf(node)) {
                    if (roots.contains(offspring)) {
                        roots.remove(offspring);
                    }
                }
            } catch (DoesNotExistLabelException e) {
                e.printStackTrace();
            }
        }
        return roots;
    }


}
