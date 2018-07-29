/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coalindiaprojectwebcrawler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RIDDHI DUTTA
 */
@WebServlet(name = "SearchAction", urlPatterns = {"/search.do"})
public class SearchAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String key = request.getParameter("key");
//        String statesmanURL = "https://www.thestatesman.com/?s=" + key+"&order=DESC&sort=publishdate";
//        String hinduURL = "https://www.thehindu.com/search/?q="+key+"&order=DESC&sort=publishdate";
//        String cnbcURL = "https://search.cnbc.com/rs/search/view.html?source=CNBC.com&categories=exclude&partnerId=2000&keywords="+key+"&order=DESC&sort=publishdate";
//        String cnnURL = "https://edition.cnn.com/search/?q="+key+"&order=DESC&sort=publishdate";
//        String bloombergURL = "https://www.bloomberg.com/search?query="+key+"&order=DESC&sort=publishdate";
//        
//        HashSet<String> statesmanLink = WebCrawler.crawl(statesmanURL,key);
//        request.setAttribute("statesman",statesmanLink);
//        
//        HashSet<String> hinduLink = WebCrawler.crawl(hinduURL,key);
//        request.setAttribute("hindu",hinduLink);
//        
//        HashSet<String> cnbcLink = WebCrawler.crawl(cnbcURL,key);
//        request.setAttribute("cnbc",cnbcLink);
//
//        HashSet<String> cnnLink = WebCrawler.crawl(cnnURL,key);
//        request.setAttribute("cnn",cnnLink);
//
//        HashSet<String> bloombergLink = WebCrawler.crawl(bloombergURL,key);
//        request.setAttribute("bloomberg",bloombergLink);
        
        String url = "https://in.search.yahoo.com/search?p="+key+"news";
        HashSet<String> link = WebCrawler.crawl(url,key);
        request.setAttribute("link",link);
        
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
