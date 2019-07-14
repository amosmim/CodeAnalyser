package dataStructures;

public class SimpleData implements ILabeledData {
    private String label;
    public SimpleData(String label) {
        this.label = label;
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
