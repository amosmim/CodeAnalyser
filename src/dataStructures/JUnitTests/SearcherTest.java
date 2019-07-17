package dataStructures.JUnitTests;

import dataStructures.Graph;
import dataStructures.Searcher;
import dataStructures.SimpleData;
import dataStructures.exceptions.AlreadyExistLabelException;
import dataStructures.exceptions.AlreadyExistLinkException;
import dataStructures.exceptions.DoesNotExistLabelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {
    Graph<String> graph;

    @BeforeEach
    void setUp() {
        this.graph = new Graph<>();
        try {

            this.graph.addNode(new SimpleData("a"));
            this.graph.addNode(new SimpleData("b"));
            this.graph.addNode(new SimpleData("c"));


            this.graph.addLink("a" , "b");
            this.graph.addLink("b" , "c");

        } catch (Exception e) {
            assertTrue(false);
        }

    }
    @Test
    void getOffspringOf() {
        Set<String> set =  new HashSet<>();
        set.add("c");
        assertEquals(Searcher.getOffspringOf(this.graph, "c").getAllLabels(), set);
        set.add("b");
        assertEquals(Searcher.getOffspringOf(this.graph, "b").getAllLabels(), set);
        set.add("a");
        assertEquals(Searcher.getOffspringOf(this.graph, "a").getAllLabels(), set);
    }

    @Test
    void getRoots() {
        Set<String> set =  new HashSet<>();
        set.add("a");
        assertEquals(Searcher.getRoots(this.graph), set);
        try {
            this.graph.addNode(new SimpleData("d"));
            set.add("d");
            assertEquals(Searcher.getRoots(this.graph), set);
            this.graph.addLink("d","c");
            assertEquals(Searcher.getRoots(this.graph), set);
        } catch (AlreadyExistLabelException | DoesNotExistLabelException | AlreadyExistLinkException e) {
            e.printStackTrace();
        }

    }

}