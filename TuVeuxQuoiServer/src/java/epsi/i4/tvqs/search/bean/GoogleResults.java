/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.i4.tvqs.search.bean;

import java.util.List;

/**
 *
 * @author Edgar
 */
public class GoogleResults {

    private ResponseData responseData;

    /**
     *
     * @return
     */
    public ResponseData getResponseData() { return responseData; }

    /**
     *
     * @param responseData
     */
    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }

    /**
     *
     * @return
     */
    public String toString() { return "ResponseData[" + responseData + "]"; }

    static class ResponseData {
        private List<Result> results;
        public List<Result> getResults() { return results; }
        public void setResults(List<Result> results) { this.results = results; }
        public String toString() { return "Results[" + results + "]"; }
    }

    static class Result {
        private String url;
        private String title;
        public String getUrl() { return url; }
        public String getTitle() { return title; }
        public void setUrl(String url) { this.url = url; }
        public void setTitle(String title) { this.title = title; }
        public String toString() { return "Result[url:" + url +",title:" + title + "]"; }
    }

}