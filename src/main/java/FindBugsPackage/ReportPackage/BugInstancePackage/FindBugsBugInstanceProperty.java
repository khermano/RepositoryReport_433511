package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Property")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceProperty {

    @XmlAttribute(name = "value")
    private byte value;

    @XmlAttribute(name = "role")
    private String role;

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
