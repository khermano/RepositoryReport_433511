package FindBugs;

import java.sql.Timestamp;
import java.util.List;

public class FindBugsReport {
    private Timestamp analysisTimeStamp;
    private String release;
    private int sequence;
    private Timestamp timeStamp;
    private String version;
    private FindBugsProject project;
    private List<FindBugsBugInstance> findBugsBugInstanceList;
}
