<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Memes Page</title>

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
<a href="login.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Meme List</h1>

<c:if test="${!empty listMemes}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listMemes}" var="meme">
            <tr>
                <td>${meme.id}</td>
                <td><a href="/memedata/${meme.id}" target="_blank">${meme.memeTitle}</a></td>
                <td>${meme.memeAuthor}</td>
                <td>${meme.memePrice}</td>
                <td><a href="<c:url value='/edit/${meme.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${meme.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Meme</h1>

<c:url var="addAction" value="/memes/add"/>

<form:form action="${addAction}" commandName="meme">
    <table>
        <c:if test="${!empty meme.memeTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="memeTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="memeTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="memeAuthor">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="memeAuthor"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="memePrice">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="memePrice"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty meme.memeTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit Meme"/>"/>
                </c:if>
                <c:if test="${empty meme.memeTitle}">
                    <input type="submit"
                           value="<spring:message text="Add Meme"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
