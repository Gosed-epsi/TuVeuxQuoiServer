/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epsi.i4.tvqs.database.manager;

import epsi.i4.tvqs.database.bean.Client;
import epsi.i4.tvqs.database.bean.Recherche;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edgar
 */
public class ClientManager {

    /**
     *
     */
    @PersistenceContext(unitName = "TuVeuxQuoiServerPU")
    protected EntityManager em;

    /**
     *
     * @return liste de tous les clients
     */
    public List<Client> getAllClients() {
        Query query = em.createNamedQuery("Client.findAll");
        return query.getResultList();
    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @param mail
     * @param password
     * @return client inséré
     */
//    public Client addClient(String id, String nom, String prenom, String mail, String password) {
//        Client c = new Client(id, nom, prenom, mail, password);
//        em.persist(c);
//        return c;
//    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @param mail
     * @param password
     * @return client modifié
     */
    public Client updateCLient(String id, String nom, String prenom, String mail, String password) {
        Client c = em.find(Client.class, id);
        c.setNomclient(nom);
        c.setPrenomclient(prenom);
        c.setMailclient(mail);
        c.setPasswordclient(password);
        em.merge(c);
        return c;
    }

    /**
     *
     * @param id
     */
    public void deleteCLient(String id) {
        Client c = em.find(Client.class, id);
        em.remove(c);
    }
    
    /**
     *
     * @param id
     * @param recherche
     */
    public void addRecherche(String id, Recherche recherche) {
        Client c = em.find(Client.class, id);
        List<Recherche> recherchesClient = c.getRechercheList();
        recherchesClient.add(recherche);
        c.setRechercheList(recherchesClient);
        em.merge(c);
    }
    
}
