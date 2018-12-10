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
@Table(name = "BUG_INSTANCE_PROPERTY")
@XmlRootElement(name = "Property")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstancePropertyId;

    @Column
    @XmlAttribute(name = "name")
    private String propertyName;

    @Column
    @XmlAttribute(name = "value")
    private String propertyValue;

    public Long getBugInstancePropertyId() {
        return bugInstancePropertyId;
    }

    public void setBugInstancePropertyId(Long bugInstancePropertyId) {
        this.bugInstancePropertyId = bugInstancePropertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
