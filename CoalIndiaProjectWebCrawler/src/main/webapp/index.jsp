<%-- 
    Document   : index.jsp
    Created on : 28 Jul, 2018, 12:30:35 AM
    Author     : RIDDHI DUTTA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Crawler</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
       
        body{
          background: #f2f2f2;
          background-image: url("Search-engines.png");
          font-family: 'Open Sans', sans-serif;
        }
        
        .search {
          width: 100%;
          position: relative
        }

        .searchTerm {
          float: left;
          width: 100%;
          border: 3px solid red;
          padding: 5px;
          height: 20px;
          border-radius: 5px;
          outline: none;
          color: #9DBFAF;
        }

        .searchTerm:focus{
          color: red;
        }

        .searchButton {
          position: absolute;  
          right: -50px;
          width: 40px;
          height: 36px;
          border: 1px solid #00B4CC;
          background: red;
          text-align: center;
          color: #fff;
          border-radius: 5px;
          cursor: pointer;
          font-size: 20px;
        }
        /*Resize the wrap to see the search bar change!*/
        .wrap{
          width: 30%;
          position: absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
        }
    </style>
</head>
    <body>
        <div class="wrap">
    <form class="search" action="search.do">
         <input type="text" class="searchTerm" placeholder="What are you looking for?" name="key">
         <button type="submit" class="searchButton">
           <i class="fa fa-search"></i>
        </button>
    </form>
    </div>
    </body>
</html>
