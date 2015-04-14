/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.mailing.service;

import static com.sun.xml.ws.api.message.Packet.State.ClientResponse;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.mail.internet.*;
import javax.mail.*;
import java.util.*;
import epsi.i4.tvqs.mailing.bean.Mailing;

/**
 *
 * @author Edgar
 */
@WebService(serviceName = "MailingService")
@Stateless()
public class MailingService {

    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "hello")
    public boolean SendSimpleMessage() {
        return Mailing.SendSimpleMessage();
    }
}
