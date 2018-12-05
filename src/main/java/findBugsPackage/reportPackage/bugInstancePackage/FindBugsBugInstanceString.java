package findBugsPackage.reportPackage.bugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "BUG_INSTANCE_STRING")
@XmlRootElement(name = "String")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceString {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceStringId;

    @Column
    @XmlAttribute(name = "value")
    private String stringValue;

    @Column
    @XmlAttribute(name = "role")
    private String stringRole;

    public Long getBugInstanceStringId() {
        return bugInstanceStringId;
    }

    public void setBugInstanceStringId(Long bugInstanceStringId) {
        this.bugInstanceStringId = bugInstanceStringId;
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
