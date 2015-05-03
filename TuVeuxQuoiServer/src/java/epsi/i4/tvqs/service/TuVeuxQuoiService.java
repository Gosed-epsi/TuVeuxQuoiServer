/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.service;

import epsi.i4.tvqs.database.entities.Client;
import epsi.i4.tvqs.database.implement.ClientImpl;
import epsi.i4.tvqs.database.implement.RechercheImpl;
import epsi.i4.tvqs.database.implement.ResultatImpl;
import epsi.i4.tvqs.search.bean.Scraping;
import epsi.i4.tvqs.search.bean.Search;
import epsi.i4.tvqs.search.bean.Site;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Edgar
 */
@WebService(serviceName = "TuVeuxQuoiService")
@Stateless()
public class TuVeuxQuoiService {

    /**
     *
     */
    @PersistenceContext(unitName = "TuVeuxQuoiServerPU")
    protected EntityManager em;

    private ClientImpl clientImpl;
    private RechercheImpl rechercheImpl;
    private ResultatImpl ResultatImpl;

    /**
     *
     */
    protected Search search = new Search();

    /**
     *
     */
    protected Scraping scraping = new Scraping();

    /**
     *
     */
    protected List<Site> sites;

    /**
     *
     * @param cl : nouveau client
     * @return client enregistr�
     */
    public Client creationCompteClient(Client cl) {
        return (Client) clientImpl.addElement(cl);
    }

    /**
     *
     * @param cl : modification des informations client
     * @return client modifi�
     */
    public Client modificationCompteClient(Client cl) {
        return (Client) clientImpl.modifyElement(cl);
    }

    /**
     *
     * @param cl : client � supprimer
     */
    public void suppressionCompteClient(Client cl) {
        clientImpl.deleteElement(cl);
    }

    /**
     *
     * @param cl : objet client avec mail et password
     * @return true si trouv� | false si non pr�sent en base
     */
    public boolean connection(Client cl) {
        return clientImpl.connection(cl);
    }

    /**
     * Web service operation
     *
     * @param searchParam
     * @return resultTab
     */
    @WebMethod(operationName = "getMailList")
    public boolean getMailList(@WebParam(name = "searchParam") final String searchParam) {
        List<String> mails = new ArrayList<>();
        sites = null;
        sites = search.doSearch(searchParam.toString(), 20);

        System.out.println("********************************************************");
        for (Site site : sites) {
            System.out.println(site.getUrl());
            for (String page : site.getPagesList()) {
                System.out.println(page);
                System.out.println(scraping.doScrapping(page));
                mails.add(scraping.doScrapping(page));
            }
        }

        return true;
    }
}
