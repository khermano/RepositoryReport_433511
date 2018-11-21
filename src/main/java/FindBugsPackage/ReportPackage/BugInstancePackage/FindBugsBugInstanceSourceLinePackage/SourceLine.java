package FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SourceLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class SourceLine {

    @XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "start")
    private short start;

    @XmlAttribute(name = "end")
    private short end;

    @XmlAttribute(name = "sourcefile")
    private String sourcefile;

    @XmlAttribute(name = "sourcepath")
    private String sourcepath;

    @XmlAttribute(name = "startBytecode")
    private byte startBytecode;

    @XmlAttribute(name = "endBytecode")
    private byte endBytecode;
}
