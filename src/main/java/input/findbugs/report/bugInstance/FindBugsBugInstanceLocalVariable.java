package input.findbugs.report.bugInstance;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "BUG_INSTANCE_LOCAL_VARIABLE")
@XmlRootElement(name = "LocalVariable")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceLocalVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceLocalVariableId;

    @Column
    @XmlAttribute(name = "name")
    private String localVariableName;

    @Column
    @XmlAttribute(name = "register")
    private short register;

    @Column
    @XmlAttribute(name = "pc")
    private int pc;

    @Column
    @XmlAttribute(name = "role")
    private String localVariableRole;

    public Long getBugInstanceLocalVariableId() {
        return bugInstanceLocalVariableId;
    }

    public void setBugInstanceLocalVariableId(Long bugInstanceLocalVariableId) {
        this.bugInstanceLocalVariableId = bugInstanceLocalVariableId;
    }

    public String getLocalVariableName() {
        return localVariableName;
    }

    public void setLocalVariableName(String localVariableName) {
        this.localVariableName = localVariableName;
    }

    public short getRegister() {
        return register;
    }

    public void setRegister(short register) {
        this.register = register;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getLocalVariableRole() {
        return localVariableRole;
    }

    public void setLocalVariableRole(String localVariableRole) {
        this.localVariableRole = localVariableRole;
    }
}
