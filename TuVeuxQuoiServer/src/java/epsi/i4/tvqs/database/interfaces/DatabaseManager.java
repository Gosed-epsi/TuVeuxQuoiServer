/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.database.interfaces;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Edgar
 */
public interface DatabaseManager {

    /**
     *
     * @return liste d'objets de tous les éléments de la table.
     */
    public List<Object> getAllElements();

    /**
     *
     * @param id : clef primaire de l'élément à rechercher
     * @return l'élément recherché
     */
    public Object getElement(BigDecimal id);

    /**
     *
     * @param obj : élément à ajouter
     * @return l'élément ajouté
     */
    public Object addElement(Object obj);

    /**
     *
     * @param obj : élément modifié
     * @return élément modifié
     */
    public Object modifyElement(Object obj);

    /**
     *
     * @param obj : élément à supprimer
     */
    public void deleteElement(Object obj);

}
