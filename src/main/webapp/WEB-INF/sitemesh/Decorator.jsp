<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html  lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
    

<head>
    <sitemesh:write property="head" />
    <%@ include file="/WEB-INF/includes/header.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
</head>
<body>
         <%@ include file="/WEB-INF/includes/menu.jsp" %>
          <sitemesh:write property="body" />
           <jsp:include page="/WEB-INF/includes/footer.jsp"/>
     </body>
</html>