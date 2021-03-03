import java.util.List;

public class FSA {
    private String name;
    private String identifier;
    private List<String> alphabet;
    private List<List<String>> transitionTable;

    public FSA(String n, String i, List<String> a, List<List<String>> t) {
        name = n;
        identifier = i;
        alphabet = a;
        transitionTable = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public List<List<String>> getTransitionTable() {
        return transitionTable;
    }

    public void setTransitionTable(List<List<String>> transitionTable) {
        this.transitionTable = transitionTable;
    }

    public String printFSA() {
        StringBuilder result = new StringBuilder();
        result.append(this.identifier).append("\n");
        for (String s : this.alphabet) {
            result.append(s).append(" ");
        }
        result.append("\n");
        for (List<String> strings : this.transitionTable) {
            for (String string : strings) {
                result.append(string).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public void addToAlphabet(String s) {
        this.alphabet.add(s);
    }

    public void addTableRow(List<String> input) {
        this.transitionTable.add(input);
    }
}
