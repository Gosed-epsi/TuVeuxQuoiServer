
package epsi.i4.tvqs.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "connection", namespace = "http://service.tvqs.i4.epsi/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connection", namespace = "http://service.tvqs.i4.epsi/")
public class Connection {

    @XmlElement(name = "arg0", namespace = "")
    private epsi.i4.tvqs.database.entities.Client arg0;

    /**
     * 
     * @return
     *     returns Client
     */
    public epsi.i4.tvqs.database.entities.Client getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(epsi.i4.tvqs.database.entities.Client arg0) {
        this.arg0 = arg0;
    }

}
