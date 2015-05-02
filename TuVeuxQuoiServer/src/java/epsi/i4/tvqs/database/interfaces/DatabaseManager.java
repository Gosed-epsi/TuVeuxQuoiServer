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
     * @return liste d'objets de tous les �l�ments de la table.
     */
    public List<Object> getAllElements();

    /**
     *
     * @param id : clef primaire de l'�l�ment � rechercher
     * @return l'�l�ment recherch�
     */
    public Object getElement(BigDecimal id);

    /**
     *
     * @param obj : �l�ment � ajouter
     * @return l'�l�ment ajout�
     */
    public Object addElement(Object obj);

    /**
     *
     * @param obj : �l�ment modifi�
     * @return �l�ment modifi�
     */
    public Object modifyElement(Object obj);

    /**
     *
     * @param obj : �l�ment � supprimer
     */
    public void deleteElement(Object obj);

}
