package input.findbugs.report.bugInstance;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "BUG_INSTANCE_INT")
@XmlRootElement(name = "Int")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceInt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceIntId;

    @Column
    @XmlAttribute(name = "value")
    private Long intValue;

    @Column
    @XmlAttribute(name = "role")
    private String intRole;

    public Long getBugInstanceIntId() {
        return bugInstanceIntId;
    }

    public void setBugInstanceIntId(Long bugInstanceIntId) {
        this.bugInstanceIntId = bugInstanceIntId;
    }

    public Long getIntValue() {
        return intValue;
    }

    public void setIntValue(Long intValue) {
        this.intValue = intValue;
    }

    public String getIntRole() {
        return intRole;
    }

    public void setIntRole(String intRole) {
        this.intRole = intRole;
    }
}
