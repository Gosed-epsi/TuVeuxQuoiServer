/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.database.implement;

import epsi.i4.tvqs.database.entities.Client;
import epsi.i4.tvqs.database.interfaces.DatabaseManager;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class ClientImpl implements DatabaseManager {

    /**
     *
     */
    @PersistenceContext(unitName = "TuVeuxQuoiServerPU")
    protected EntityManager em;

    @Override
    public List<Object> getAllElements() {
        Query query = em.createNamedQuery("Client.findAll");
        return query.getResultList();
    }

    @Override
    public Object getElement(BigDecimal id) {
        return em.find(Client.class, id);
    }

    @Override
    public Object addElement(Object obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Object modifyElement(Object obj) {
        return em.merge(obj);
    }

    @Override
    public void deleteElement(Object obj) {
        em.remove(obj);
    }

    public Client connection(Client cl) {
        Query query = em.createNamedQuery("Client.findByMailclient");
        query.setParameter("mailclient", cl.getMailclient());
        List<Client> clientTrouve = query.getResultList();
        if (cl.getPasswordclient().equals(clientTrouve.get(0).getPasswordclient())) {
            return clientTrouve.get(0);
        } else {
            return new Client();
        }
    }

    public boolean findMail(Client cl) {
        Query query = em.createNamedQuery("Client.findByMailclient");
        query.setParameter("mailclient", cl.getMailclient());
        List<Client> clientTrouve = query.getResultList();
        return !clientTrouve.isEmpty();
    }

}
