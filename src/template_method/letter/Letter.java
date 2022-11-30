package template_method.letter;

public class Letter {

    private final String text;
    private final String header;
    private final String address;

    public Letter(String setAdress, String setHeader, String setText) {
        this.address = setAdress;
        this.header = setHeader;
        this.text = setText;
    }

    public String beautify() {
        return address + "\n\n" + header + "\n\n" + text;
    }
}
