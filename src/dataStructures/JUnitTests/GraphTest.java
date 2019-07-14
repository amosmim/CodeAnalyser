package dataStructures.JUnitTests;

import dataStructures.Graph;
import dataStructures.SimpleData;
import dataStructures.exceptions.AlreadyExistLabelException;
import dataStructures.exceptions.AlreadyExistLinkException;
import dataStructures.exceptions.DoesNotExistLabelException;
import dataStructures.exceptions.DoesNotExistLinkException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {
    Graph<String> graph;

    @BeforeEach
    void setUp() {
        this.graph = new Graph<>();
        try {

            this.graph.addNode(new SimpleData("a"));
            this.graph.addNode(new SimpleData("b"));
            this.graph.addNode(new SimpleData("c"));
            this.graph.addLink("a" , "c");
            this.graph.addLink("a" , "b");
            this.graph.addLink("b" , "c");

            this.graph.getNode("a");

        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    void addNode() {
        try {
            this.graph.addNode(new SimpleData("d"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void deleteNode() {
        try {
            this.graph.deleteNode("b");
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void deleteNodeShouldThrow() {
        Throwable exception = assertThrows(
                DoesNotExistLabelException.class,
                () -> this.graph.deleteNode("d")
        );
        assertEquals(exception.getMessage(), "d doesn't exist in the graph!");
    }

    @Test
    void addNodeShouldThrow() {
        Throwable exception = assertThrows(
                AlreadyExistLabelException.class,
                () -> this.graph.addNode(new SimpleData("b"))
        );
        assertEquals(exception.getMessage(), "b already exist in the graph!");
    }

    @Test
    void addLink() {
        try {
            this.graph.addLink("b", "a");
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    void deleteLink() {
        try {
            this.graph.deleteLink("a", "b");
        } catch (Exception e) {
            assertTrue(false);
        }
    }


    @Test
    void addLinkShouldThrowUnExist() {
        Throwable exception = assertThrows(
                DoesNotExistLabelException.class,
                () -> this.graph.addLink("e", "a")
        );

        assertEquals(exception.getMessage(), "e doesn't exist in the graph!");

    }

    @Test
    void addLinkShouldThrowExist() {
        Throwable exception = assertThrows(
                AlreadyExistLinkException.class,
                () -> this.graph.addLink("a", "b")
        );

        assertEquals(exception.getMessage(), "link a->b already exist in the graph!");

    }

    @Test
    void deleteLinkShouldThrowUnExist() {
        Throwable exception = assertThrows(
                DoesNotExistLabelException.class,
                () -> this.graph.deleteLink("e", "a")
        );

        assertEquals(exception.getMessage(), "e doesn't exist in the graph!");

    }

    @Test
    void deleteLinkShouldThrowExist() {
        Throwable exception = assertThrows(
                DoesNotExistLinkException.class,
                () -> this.graph.deleteLink("a", "a")
        );

        assertEquals(exception.getMessage(), "link a->a doesn't exist in the graph!");

    }

    @Test
    void isLinked() {
        assertTrue(this.graph.IsLinked("a", "b"));
    }

    @Test
    void getNode() {
        try {
            assertEquals(this.graph.getNode("a").getLabel(), "a");
        } catch (Exception e) {
            assertTrue(false);
        }
    }
    @Test
    void getNodeShouldThrowUnExist() {
        Throwable exception = assertThrows(
                DoesNotExistLabelException.class,
                () -> this.graph.getNode("r")
        );

        assertEquals(exception.getMessage(), "r doesn't exist in the graph!");
    }

    @Test
    void getNextNodesOf() {
        Set<String> set =  new HashSet<>();

        try {
            assertEquals(this.graph.getNextNodesOf("c"), set);
            set.add("c");
            assertEquals(this.graph.getNextNodesOf("b"), set);
            set.add("b");
            assertEquals(this.graph.getNextNodesOf("a"), set);
        } catch (DoesNotExistLabelException e) {
            assertTrue(false);
        }
    }


    @Test
    void getNextNodesOfShouldThrowUnExist() {
        Throwable exception = assertThrows(
                DoesNotExistLabelException.class,
                () -> this.graph.getNextNodesOf("r")
        );

        assertEquals(exception.getMessage(), "r doesn't exist in the graph!");
    }

    @Test
    void nodeExist(){
        assertTrue(this.graph.nodeExist("a"));
        assertTrue(this.graph.nodeExist("b"));
        assertTrue(this.graph.nodeExist("c"));
        assertFalse(this.graph.nodeExist("d"));
    }

}