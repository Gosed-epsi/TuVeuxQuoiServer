/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package epsi.i4.tvqs.search.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class Site {
    
    protected String url;
    protected List<String> pagesList = new ArrayList<>();
    protected List<String> mailList = new ArrayList<>();

    public Site(String url) {
        this.url = url;
        this.pagesList = null;
        this.mailList = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPagesList() {
        return pagesList;
    }

    public void setPagesList(List<String> pagesList) {
        this.pagesList = pagesList;
    }

    public List<String> getMailList() {
        return mailList;
    }

    public void setMailList(List<String> mailList) {
        this.mailList = mailList;
    }
     
}
