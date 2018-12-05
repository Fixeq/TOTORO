<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String context = request.getContextPath(); %>

<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="<%=context%>/resources/css/base.css">
    <link rel="stylesheet" href="<%=context%>/resources/css/vendor.css">
    <link rel="stylesheet" href="<%=context%>/resources/css/main.css">

    <!-- script
    ================================================== -->
    <script src="<%=context%>/resources/js/modernizr.js"></script>
    <script src="<%=context%>/resources/js/pace.min.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
                <tiles:insertAttribute name="header" />
                <tiles:insertAttribute name="body"  />
                <tiles:insertAttribute name="footer"  />            
</body>
</html>