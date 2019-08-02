package parsers.CodeUnits;

public class CodeBlock {
    private final Number start;
    private final Number end;
    private String[] lines;

    public CodeBlock(Number start, Number end, String[] lines) {
        this.start = start;
        this.end = end;
        this.lines = lines;
    }

    public String[] getLines() {
        return lines;
    }

    public Number getStart() {
        return start;
    }

    public Number getEnd() {
        return end;
    }

}
