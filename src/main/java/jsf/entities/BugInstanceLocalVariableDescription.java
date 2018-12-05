package jsf.entities;

public class BugInstanceLocalVariableDescription {
    private String localVariableName;
    private short register;
    private int pc;
    private String localVariableRole;

    public BugInstanceLocalVariableDescription() {
    }

    public BugInstanceLocalVariableDescription(String localVariableName, short register, int pc, String localVariableRole) {
        this.localVariableName = localVariableName;
        this.register = register;
        this.pc = pc;
        this.localVariableRole = localVariableRole;
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
