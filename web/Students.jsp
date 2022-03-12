<%@ page import="dao.StudentRepository" %>
<%@ page import="dto.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    StudentRepository dao = StudentRepository.getInstance();
    List<Student> listofstudents = dao.getAllStudents();
%>
<div class="container">
    <div class="row" align="center">
        <%
            for(int i=0;i<listofstudents.size();i++){
                Student student = listofstudents.get(i);
        %>
        <div class="col-md-4">
            <p> 학번 : <%=student.getStudentId()+" "%>
                석차 : <%=student.getRank()+" "%>
                이름 : <%=student.getName()+" "%>
                평균점수 : <%=student.getAvg()+" "%>
            </p>
        <%
            }
        %>
            <form action="index.jsp">
                <input type="submit" value="등록페이지로">
            </form>
            <form action="sortByRank.jsp">
                <input type="submit" value="석차별 정렬">
            </form>
        </div>
    </div>
</div>

</body>
</html>
