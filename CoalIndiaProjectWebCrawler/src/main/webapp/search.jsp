<%-- 
    Document   : search
    Created on : 28 Jul, 2018, 1:22:13 AM
    Author     : RIDDHI DUTTA
--%>

<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="java.util.HashSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=request.getParameter("key")%></title>
        <style>
            p{
                font-family: sans-serif;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
        <%-- <%
            HashSet<String> statesman = (HashSet<String>)(request.getAttribute("statesman"));
            HashSet<String> hindu = (HashSet<String>)(request.getAttribute("hindu"));      
            HashSet<String> cnn = (HashSet<String>)(request.getAttribute("cnn"));      
            HashSet<String> bloomberg = (HashSet<String>)(request.getAttribute("bloomberg"));      
            HashSet<String> cnbc = (HashSet<String>)(request.getAttribute("cnbc"));      
        %> --%>
        
        <center><h1>Search Results for <%=request.getParameter("key")%> </h1></center>
        
      <%--  <h2>News From THE STATESMAN</h2>
        <div>
            <% for(String url:statesman)
                {
            %>
                    <p> <%=url%> </p> <br>
            <%  } %>
        </div>
        
        <h2>News From THE HINDU</h2>
        <div>
            <% for(String url:hindu)
                {
            %>
                    <p> <%=url%> </p> <br>
            <%  } %>
        </div>
        
        <h2>News From CNBC</h2>
        <% for(String url:cnbc)
                {
            %>
                    <p> <%=url%> </p> <br>
            <%  } %>
            
        <h2>News From CNN</h2>
        <% for(String url:cnn)
                {
            %>
                    <p> <%=url%> </p> <br>
            <%  } %>
            
        <h2>News From BLOOMBERG</h2>
        <% for(String url:bloomberg)
                {
            %>
                    <p> <%=url%> </p> <br>
            <%  } %> --%>
       <div class="row">
      <% HashSet<String> link = (HashSet<String>)(request.getAttribute("link"));
        HashSet<String> titleSet = new HashSet<String>();
        String key = request.getParameter("key");
              for(String url:link)
                {
                    Document document;
                   try{ document = Jsoup.connect(url).get();}
                   catch(Exception e){ continue;}
                    String title = document.title();
                    if(titleSet.contains(title)) continue;
                    titleSet.add(title);
                    String description="No description";
                    try{description = document.select("meta[name=description]").get(0).attr("content"); }
                    catch(Exception e){ }
                    if(url.contains("yahoo") || title.contains("yahoo") ||description.contains("yahoo"))
                        continue;
            %>
           <div class="col-lg-12"> <h2><a href="<%=url%>"><%=title%></a></h2><p><%=description%></p></div>
            <%  } %>    
        </div>
    </div>
     </body>
</html>
