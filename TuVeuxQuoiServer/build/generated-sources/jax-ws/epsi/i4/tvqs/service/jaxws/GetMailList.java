
package epsi.i4.tvqs.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMailList", namespace = "http://service.tvqs.i4.epsi/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMailList", namespace = "http://service.tvqs.i4.epsi/")
public class GetMailList {

    @XmlElement(name = "searchParam", namespace = "")
    private String searchParam;

    /**
     * 
     * @return
     *     returns String
     */
    public String getSearchParam() {
        return this.searchParam;
    }

    /**
     * 
     * @param searchParam
     *     the value for the searchParam property
     */
    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

}
