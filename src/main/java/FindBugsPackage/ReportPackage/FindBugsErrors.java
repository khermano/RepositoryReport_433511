package FindBugsPackage.ReportPackage;

import FindBugsPackage.ReportPackage.ErrorsPackage.FindBugsErrorsError;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ErrorsPackage")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsErrors {

    @XmlAttribute(name = "errors")
    private byte errors;

    @XmlAttribute(name = "missingClasses")
    private byte missingClasses;

    @XmlElement(name = "Error")
    private FindBugsErrorsError findBugsErrorsError;

    @XmlElement(name = "MissingClass")
    private List<String> missingClassList;

    public byte getErrors() {
        return errors;
    }

    public void setErrors(byte errors) {
        this.errors = errors;
    }

    public byte getMissingClasses() {
        return missingClasses;
    }

    public void setMissingClasses(byte missingClasses) {
        this.missingClasses = missingClasses;
    }

    public FindBugsErrorsError getFindBugsErrorsError() {
        return findBugsErrorsError;
    }

    public void setFindBugsErrorsError(FindBugsErrorsError findBugsErrorsError) {
        this.findBugsErrorsError = findBugsErrorsError;
    }

    public List<String> getMissingClassList() {
        return missingClassList;
    }

    public void setMissingClassList(List<String> missingClassList) {
        this.missingClassList = missingClassList;
    }
}
