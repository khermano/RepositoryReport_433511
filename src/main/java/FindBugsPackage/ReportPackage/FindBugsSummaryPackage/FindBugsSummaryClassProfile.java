package FindBugsPackage.ReportPackage.FindBugsSummaryPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ClassProfile")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsSummaryClassProfile {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "totalMilliseconds")
    private short totalMilliseconds;

    @XmlAttribute(name = "invocations")
    private int invocations;

    @XmlAttribute(name = "avgMicrosecondsPerInvocation")
    private short avgMicrosecondsPerInvocation;

    @XmlAttribute(name = "maxMicrosecondsPerInvocation")
    private int maxMicrosecondsPerInvocation;

    @XmlAttribute(name = "standardDeviationMircosecondsPerInvocation")
    private short standardDeviationMircosecondsPerInvocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getTotalMilliseconds() {
        return totalMilliseconds;
    }

    public void setTotalMilliseconds(short totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
    }

    public int getInvocations() {
        return invocations;
    }

    public void setInvocations(int invocations) {
        this.invocations = invocations;
    }

    public short getAvgMicrosecondsPerInvocation() {
        return avgMicrosecondsPerInvocation;
    }

    public void setAvgMicrosecondsPerInvocation(short avgMicrosecondsPerInvocation) {
        this.avgMicrosecondsPerInvocation = avgMicrosecondsPerInvocation;
    }

    public int getMaxMicrosecondsPerInvocation() {
        return maxMicrosecondsPerInvocation;
    }

    public void setMaxMicrosecondsPerInvocation(int maxMicrosecondsPerInvocation) {
        this.maxMicrosecondsPerInvocation = maxMicrosecondsPerInvocation;
    }

    public short getStandardDeviationMircosecondsPerInvocation() {
        return standardDeviationMircosecondsPerInvocation;
    }

    public void setStandardDeviationMircosecondsPerInvocation(short standardDeviationMircosecondsPerInvocation) {
        this.standardDeviationMircosecondsPerInvocation = standardDeviationMircosecondsPerInvocation;
    }
}
