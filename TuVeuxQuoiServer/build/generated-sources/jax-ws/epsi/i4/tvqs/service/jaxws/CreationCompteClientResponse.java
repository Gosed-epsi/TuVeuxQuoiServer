
package epsi.i4.tvqs.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "creationCompteClientResponse", namespace = "http://service.tvqs.i4.epsi/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creationCompteClientResponse", namespace = "http://service.tvqs.i4.epsi/")
public class CreationCompteClientResponse {

    @XmlElement(name = "return", namespace = "")
    private epsi.i4.tvqs.database.entities.Client _return;

    /**
     * 
     * @return
     *     returns Client
     */
    public epsi.i4.tvqs.database.entities.Client getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(epsi.i4.tvqs.database.entities.Client _return) {
        this._return = _return;
    }

}
