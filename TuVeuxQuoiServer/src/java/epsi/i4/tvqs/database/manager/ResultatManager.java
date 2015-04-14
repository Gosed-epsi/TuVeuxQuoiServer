/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epsi.i4.tvqs.database.manager;

import epsi.i4.tvqs.database.bean.Resultat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edgar
 */
public class ResultatManager {
    
    /**
     *
     */
    @PersistenceContext(unitName = "TuVeuxQuoiServerPU")
    protected EntityManager em;

    /**
     *
     * @return liste de tous les resultats
     */
    public List<Resultat> getAllResultats() {
        Query query = em.createNamedQuery("Resultat.findAll");
        return query.getResultList();
    }
    
}
