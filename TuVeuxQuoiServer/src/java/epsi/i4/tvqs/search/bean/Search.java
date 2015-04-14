/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.search.bean;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Edgar
 */
public class Search {

    List<Site> sites = new ArrayList<>();

    /**
     *
     * @param search
     * @param profondeur
     * @return liste d'url correspondant à la recherche
     */
    public List<Site> doSearch(String search, Integer profondeur) {
        System.out.println(search);
        sites = null;
        //List<List<String>> resultList = new ArrayList<>();
        for (int i = 0; i < profondeur.intValue(); i++) {
            try {
                String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start=" + i + "&q=";

                String query = search;
                String charset = "ISO-8859-1";

                URL url = new URL(address + URLEncoder.encode(query, charset));
                Reader reader = new InputStreamReader(url.openStream(), charset);
                GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

                // Show title and URL of each results
                //for (int m = 0; m <= 0; m++) {
                try {
                    //System.out.println("Title " + m + ": " + results.getResponseData().getResults().get(m).getTitle());
                    System.out.println("URL: " + results.getResponseData().getResults().get(0).getUrl() + "\n");
                    Site site = new Site(results.getResponseData().getResults().get(0).getUrl());
                    site.setPagesList(siteExtract(site.getUrl()));
                    sites.add(site);
                    //resultList.add(results.getResponseData().getResults().get(0).getUrl());
                } catch (Exception e) {
                    //Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, e);
                    System.out.println(e.getMessage());
                }
                //}

            } catch (MalformedURLException ex) {
                //Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            } catch (UnsupportedEncodingException ex) {
                //Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                //Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
        return sites;
    }

    public List<String> siteExtract(String site) {
        List<String> pages = new ArrayList<>();
        try {
            //Charger la page
            URL url = new URL(site);
            URLConnection uconnection = url.openConnection();
            Reader rd = new InputStreamReader(uconnection.getInputStream());
            //lire le document HTML
            EditorKit kit = new HTMLEditorKit();
            HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
            doc.putProperty("IgnoreCharsetDirective", true);
            kit.read(rd, doc, 0);
            //Parcourir la balise lien
            HTMLDocument.Iterator it = doc.getIterator(HTML.Tag.A);
            while (it.isValid()) {
                SimpleAttributeSet s = (SimpleAttributeSet) it.getAttributes();
                String link = (String) s.getAttribute(HTML.Attribute.HREF);
                if (link != null && !link.equals("#") && link.startsWith(site)) {
                    //Afficher le lien trouve
                    System.out.println(link);
                    pages.add(link);
                }
                it.next();
            }
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pages;
    }

    /**
     * lister les pages d'un site web
     */
    public void linkExtractTest() {
        try {
            //Charger la page
            URL url = new URL("http://www.fobec.com");
            URLConnection uconnection = url.openConnection();
            Reader rd = new InputStreamReader(uconnection.getInputStream());
            //lire le document HTML
            EditorKit kit = new HTMLEditorKit();
            HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
            doc.putProperty("IgnoreCharsetDirective", true);
            kit.read(rd, doc, 0);
            //Parcourir la balise lien
            HTMLDocument.Iterator it = doc.getIterator(HTML.Tag.A);
            while (it.isValid()) {
                SimpleAttributeSet s = (SimpleAttributeSet) it.getAttributes();
                String link = (String) s.getAttribute(HTML.Attribute.HREF);
                if (link != null && !link.equals("#") && link.startsWith("http://www.fobec.com")) {
                    //Afficher le lien trouvé
                    System.out.println(link);
                }
                it.next();
            }
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
