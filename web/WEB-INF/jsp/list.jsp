<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <table align="center" style="width:50%">
        <tr>
            <th>Наименование</th>
            <th>Электронный адрес</th>
            <th>Просмотреть резюме</th>
            <th>Добавить информацию в резюме</th>
            <th>Удалить резюме</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="com.urise.webapp.model.Resume"/>
            <tr>
                <td>${resume.fullName}</td>
                <td><%=ContactType.MAIL.toHtml(resume.getContact(ContactType.MAIL))%></td>
                <td><a href="resume?uuid=${resume.uuid}&action=view">View</a></td>
                <td><a href="resume?uuid=${resume.uuid}&action=edit">Edit</a></td>
                <td><a href="resume?uuid=${resume.uuid}&action=delete">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <p align="center">
        <input action="action" onclick="location.href='resume?action=save'" type="button" value="Создать новое резюме"/>
    </p>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
