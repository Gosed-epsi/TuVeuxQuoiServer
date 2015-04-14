/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.search.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJBException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Edgar
 */
public class Scraping {

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    /**
     *
     * @param url
     * @return liste d'adresses mail
     */
    public String doScrapping(String url) {
        String mail = null;
        Document doc;
        try {
            // need http protocol
            doc = Jsoup.connect(url).get();
            // get page title
            String title = doc.title();
            //System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                // get the value from href attribute
                //System.out.println("\nlink : " + link.attr("href"));
                //System.out.println("text : " + link.text());

                if (!link.text().isEmpty()) {
                    matcher = pattern.matcher(link.text());
                    if (matcher.matches()) {
                        //System.out.println("text : " + link.text());
                        mail = link.text();
                    }
                }

            }
        } catch (IOException | EJBException e) {
            System.out.println(e.getMessage());
        }
        return mail;
    }

}
