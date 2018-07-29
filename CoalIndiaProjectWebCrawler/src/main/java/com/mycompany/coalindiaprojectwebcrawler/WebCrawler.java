/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coalindiaprojectwebcrawler;

/**
 *
 * @author RIDDHI DUTTA
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
public class WebCrawler {
    
 

    private static final int MAX_DEPTH = 2;
    private HashSet<String> links;

    public WebCrawler()
    {
        links = new HashSet<>();
    }

    public HashSet<String> getLinks() {
        return links;
    }

    public void getPageLinks(String URL, int depth,String key) {
        
        if ((!links.contains(URL) && (depth < MAX_DEPTH) )) {
                try{
                    Document document = Jsoup.connect(URL).get();
                    if(true)
                    {
                        links.add(URL);
                        System.out.println("["+URL+"]");
                        Elements linksOnPage = document.select("a[href]");

                        depth++;
                        for (Element page : linksOnPage) {
                            getPageLinks(page.absUrl("href"), depth,key);
                        }
                    }
                }
                catch(Exception e){
                    System.out.println(URL+e);
                }
            } 
        }

    public static HashSet<String> crawl(String url,String key) {
        WebCrawler wc = new WebCrawler();
        wc.getPageLinks(url, 0,key);
        return wc.getLinks();
    }
}
    
    