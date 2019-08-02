package parsers.CodeUnits;

import dataStructures.ILabeledData;

public class CodeUnit implements ILabeledData {
    private final CodeBlock definition;
    private final UnitTypes type;
    private final Signature sign;
    private final String name;

    public CodeUnit(String name, CodeBlock definition, UnitTypes type, Signature sign) {
        this.name = name;
        this.definition = definition;
        this.type = type;
        this.sign = sign;

    }

    public CodeBlock getDefinition() {
        return this.definition;
    }
    public UnitTypes getUnitType() {
        return  this.type;
    }
    public Signature getSignature() {
        return this.sign;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        return this.name;
    }
}
