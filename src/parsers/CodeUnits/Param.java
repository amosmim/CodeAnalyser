package parsers.CodeUnits;

public class Param {
    private final String type;
    private final String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Param(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
