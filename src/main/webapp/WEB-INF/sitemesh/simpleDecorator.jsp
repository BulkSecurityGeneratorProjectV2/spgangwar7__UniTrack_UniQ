<!DOCTYPE html>
<html  lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    < sitemesh:write property="head" />
   <%--  <%@ include file="/WEB-INF/includes/header.jsp" %> --%>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
</head>
<body>
   <%--  <%@ include file="/WEB-INF/includes/menu.jsp" %> --%>
        <!-- <main id="page-wrapper5">
                <div class="container-fluid"> -->
                        <sitemesh:write property="body" />
                <!-- </div>
        </main> -->
</body>
</html>