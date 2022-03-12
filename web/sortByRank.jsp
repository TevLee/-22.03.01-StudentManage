<%@ page import="dto.Student" %>
<%@ page import="dao.StudentRepository" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    StudentRepository dao = StudentRepository.getInstance();
%>

<%
    /*석차구하는 메서드*/
    dao.getRank();
    /*석차별로 정렬하는 메서드*/
    dao.sortByScore();

    /* 학생정보 출력하는 페이지로 이동*/
    response.sendRedirect("Students.jsp");
%>
</body>
</html>
