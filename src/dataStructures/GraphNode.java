package dataStructures;

public class GraphNode <T> {
    private String label;
    private T data;

    public GraphNode(String label) {
        this.label = label;
        data = null;
    }

    public String getLabel() {
        return this.label;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
