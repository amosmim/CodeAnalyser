package parsers;

import parsers.CodeUnits.CodeUnit;

import java.util.List;

public interface ISyntax {
    List<CodeUnit> parseToUnits(String path);
    List<String> getCalls(CodeUnit unit);
}

