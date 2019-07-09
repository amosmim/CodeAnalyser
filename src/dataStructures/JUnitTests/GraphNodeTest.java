package dataStructures.JUnitTests;

import dataStructures.GraphNode;

import static org.junit.jupiter.api.Assertions.*;

class GraphNodeTest {
    @org.junit.jupiter.api.Test
    void getLabel() {
        String pattern = "func_name";
        GraphNode<String> test= new GraphNode<>(pattern);
        assertTrue( test.getLabel().equals(pattern) );
    }

    @org.junit.jupiter.api.Test
    void setData() {
        String pattern = "func_name";
        String pattern2 = "data for node";
        GraphNode<String> test = new GraphNode<>(pattern);
        test.setData(pattern2);
        assertTrue( test.getData().equals(pattern2) );
    }

    @org.junit.jupiter.api.Test
    void toStringIsLabel() {
        String pattern = "func_name";
        GraphNode<String> test= new GraphNode<>(pattern);
        assertTrue( test.getLabel().equals(test.toString()) );
    }


}