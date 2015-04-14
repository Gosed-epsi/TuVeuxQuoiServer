/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.search.service;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;

/**
 *
 * @author Edgar
 */
@WebService(serviceName = "SearchService")
@Stateless()
public class SearchService {

    /**
     * This is a sample web service operation
     *
     * @return
     * @throws java.net.MalformedURLException
     * @throws java.io.UnsupportedEncodingException
     */
    @WebMethod(operationName = "hello")
    public boolean hello() throws MalformedURLException, UnsupportedEncodingException, IOException {

        /* Recherche pour non abandonnés */
        /*String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
         String query = "java";
         String charset = "UTF-8";

         URL url = new URL(address + URLEncoder.encode(query, charset));
         Reader reader = new InputStreamReader(url.openStream(), charset);
         GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

         int total = results.getResponseData().getResults().size();
         System.out.println("total: " + total);

         // Show title and URL of each results
         for (int i = 0; i <= total - 1; i++) {
         System.out.println("Title: " + results.getResponseData().getResults().get(i).getTitle());
         System.out.println("URL: " + results.getResponseData().getResults().get(i).getUrl() + "\n");

         }*/
        for (int i = 0; i < 20; i++) {
            String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start=" + i + "&q=";

            String query = "Programcreek";
            String charset = "UTF-8";

            URL url = new URL(address + URLEncoder.encode(query, charset));
            Reader reader = new InputStreamReader(url.openStream(), charset);
            GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

            // Show title and URL of each results
            for (int m = 0; m <= 3; m++) {
                System.out.println("Résultat " + i);
                System.out.println("Title " + m + ": " + results.getResponseData().getResults().get(m).getTitle());
                System.out.println("URL: " + results.getResponseData().getResults().get(m).getUrl() + "\n");
            }
        }

        return true;
    }
}

class GoogleResults {

    private ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public String toString() {
        return "ResponseData[" + responseData + "]";
    }

    static class ResponseData {

        private List<Result> results;

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public String toString() {
            return "Results[" + results + "]";
        }
    }

    static class Result {

        private String url;
        private String title;

        public String getUrl() {
            return url;
        }

        public String getTitle() {
            return title;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String toString() {
            return "Result[url:" + url + ",title:" + title + "]";
        }
    }
}
