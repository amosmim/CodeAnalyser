package parsers.CodeUnits;

import java.util.Set;

public class Signature {
    private final Set<Param> params;
    private final Param return_value;
    private final String[] properties;

    public Signature(Set<Param> params, Param return_value, String[] properties) {
        this.params = params;
        this.return_value = return_value;
        this.properties = properties;
    }

    public Set<Param> getParams() {
        return params;
    }

    public Param getReturn_value() {
        return return_value;
    }

    public String[] getProperties() {
        return properties;
    }
}
