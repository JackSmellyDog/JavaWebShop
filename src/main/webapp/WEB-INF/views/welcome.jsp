<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">


    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9

        }
    </style>
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                | <a href="/admin">Admin</a>
            </security:authorize>
        </h2>



    </c:if>

</div>


<c:if test="${!empty listMemes}">
    <table class="tg" align="center">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Img</th>
            <th width="240">Description</th>
            <th width="120">Price</th>
            <th width="60">Buy</th>

        </tr>
        <c:forEach items="${listMemes}" var="meme">
            <tr>
                <td>${meme.id}</td>
                <td><a href="/memedata/${meme.id}" target="_blank">${meme.memeTitle}</a></td>
                <td><img src="../../resources/img/${meme.memeImgLink}"></td>
                <td>${meme.memeDescription}</td>
                <td>${meme.memePrice} xbt</td>
                <td><a href="<c:url value='/buy/${meme.id}'/>">Buy</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>