package parsers;

import dataStructures.ISearchable;
import parsers.CodeUnits.CodeUnit;

import java.util.List;

public class MainParser {
    private ISearchable db;
    private ISyntax syntax;

    public MainParser(ISearchable searchable, ISyntax syn) {
        this.db = searchable;
        this.syntax = syn;
    }

    public void parseFile(String pathToFile) {
        List<CodeUnit> codeUniteList = this.syntax.parseToUnits(pathToFile);
        try {
            for (CodeUnit unit : codeUniteList) {
                this.db.addNode(unit);
                for (String l : this.syntax.getCalls(unit)) {
                    this.db.addLink(unit.getLabel(), l);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
