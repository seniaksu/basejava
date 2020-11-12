<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ page import="com.urise.webapp.model.SectionType" %>
<%@ page import="com.urise.webapp.model.ListSection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.urise.webapp.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><input type="text" name="fullName" size=50 value="${resume.fullName}"></dd>
        </dl>
        <h2>Контакты:</h2>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>
        <hr>
        <h2>Секции:</h2>
        <c:forEach var="type"
                   items="<%=new SectionType[]{SectionType.PERSONAL, SectionType.OBJECTIVE, SectionType.QUALIFICATIONS, SectionType.ACHIEVEMENT}%>">
            <c:set var="section" value="${resume.getSection(type)}"/>
            <jsp:useBean id="section" type="com.urise.webapp.model.AbstractSection"/>
            <h3>${type.title}</h3>
            <c:choose>
                <c:when test="${type.equals(SectionType.PERSONAL) || type.equals(SectionType.OBJECTIVE)}">
                    <textarea style="width:100%; height:80px;" name="${type.name()}"><%=section%></textarea>
                </c:when>
                <c:when test="${type.equals(SectionType.QUALIFICATIONS) || type.equals(SectionType.ACHIEVEMENT)}">
                    <textarea style="width:100%; height:80px;"
                              name='${type}'><%=String.join("\n", ((ListSection) section).getContent())%></textarea>
                </c:when>
            </c:choose>
        </c:forEach>
        <hr>
        <p align="center">
            <button type="submit">Сохранить</button>
            <input action="action" onclick="window.history.go(-1); return false;" type="submit" value="Отменить"/>
        </p>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
