/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epsi.i4.tvqs.database.manager;

import epsi.i4.tvqs.database.bean.Client;
import epsi.i4.tvqs.database.bean.Recherche;
import epsi.i4.tvqs.database.bean.Resultat;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edgar
 */
public class RechercheManager {
    
    /**
     *
     */
    @PersistenceContext(unitName = "TuVeuxQuoiServerPU")
    protected EntityManager em;

    /**
     *
     * @return liste de toutes les recherches
     */
    public List<Recherche> getAllRecherches() {
        Query query = em.createNamedQuery("Recherche.findAll");
        return query.getResultList();
    }
    
    /**
     *
     * @param libelle
     * @return
     */
    public List<Recherche> getRechercheByLibelle (String libelle) {
        Query query = em.createNamedQuery("Recherche.findByLibellerecherche");
        query.setParameter("libellerecherche", libelle);
        return query.getResultList();
    }
    
    /**
     *
     * @param client
     * @return
     */
    public List<Recherche> getRechercheByClient (Client client) {
        return null;
    }

    /**
     *
     * @param id
     * @param libelle
     * @param profondeur
     * @param date
     * @param client
     * @return recherche inséré
     */
//    public Recherche addRecherche(String id, String libelle, BigInteger profondeur, String date, Client client) {
//        Recherche r = new Recherche(id, libelle, profondeur, date, client);
//        em.persist(r);
//        return r;
//    }
    
    /**
     *
     * @param id
     * @param resultat
     */
    public void addResultat(String id, Resultat resultat) {
        Recherche r = em.find(Recherche.class, id);
        List<Resultat> resultatsRecherche = r.getResultatList();
        resultatsRecherche.add(resultat);
        r.setResultatList(resultatsRecherche);
        em.merge(r);
    }
    
}
