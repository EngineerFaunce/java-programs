// Basically a String variable
public class Doodad {
    private String name;
    private String value;

    public Doodad(String n, String v) {
        name = n;
        value = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
