package RestEasyPackage;

public class BugInstanceDescription {
    private String type;
    private byte priority;
    private int rank;
    private String abbrev;
    private String category;

    public BugInstanceDescription() {

    }

    public BugInstanceDescription(String type, byte priority, int rank, String abbrev, String category) {
        this.type = type;
        this.priority = priority;
        this.rank = rank;
        this.abbrev = abbrev;
        this.category = category;
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

    @Override
    public String toString() {
        return "type: " + type + ", priority: " + priority + ", rank: " + rank
                + ", abbrev: " + abbrev + ", category: " + category;
    }
}
