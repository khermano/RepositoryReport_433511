package jsf.entities;

public class BugInstanceStringDescription {
    private String stringValue;
    private String stringRole;

    public BugInstanceStringDescription() {
    }

    public BugInstanceStringDescription(String stringValue, String stringRole) {
        this.stringValue = stringValue;
        this.stringRole = stringRole;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringRole() {
        return stringRole;
    }

    public void setStringRole(String stringRole) {
        this.stringRole = stringRole;
    }
}
