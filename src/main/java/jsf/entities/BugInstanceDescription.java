package jsf.entities;

import java.math.BigInteger;

public class BugInstanceDescription {
    private BigInteger bugInstanceId;
    private String type;
    private byte priority;
    private int rank;
    private String abbrev;
    private String category;

    public BigInteger getBugInstanceId() {
        return bugInstanceId;
    }

    public void setBugInstanceId(BigInteger bugInstanceId) {
        this.bugInstanceId = bugInstanceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
