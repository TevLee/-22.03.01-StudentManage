<%@ page import="dto.Student" %>
<%@ page import="dao.StudentRepository" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    // Q01. index에서 빈칸이 입력된경우.... ? --> try~catch문으로 하면 밖에서 각 변수 먼저 선언? 지저분한 코드가 될 것 같은데..
    // 입력 : 이름, 국어,영어,수학,주소
    String studentName = request.getParameter("name"); // 2. 이름
    String kor = request.getParameter("kor_score");
    String eng = request.getParameter("eng_score");
    String mat = request.getParameter("mat_score");
    Integer[] scores = {Integer.valueOf(kor),Integer.valueOf(eng),Integer.valueOf(mat)}; // 3. 성적
    String addr = request.getParameter("addr");        // 7. 주소

    /* 잘못된 입력 체크*/
    StudentRepository dao = StudentRepository.getInstance();
    boolean isCorrectInput = true; //
    if(!dao.checkName(studentName)){                         // Q02. alert하고 다시 index.jsp로 돌아가려면....?
        isCorrectInput = false;
%>
<script>
    var msg = "올바르지 않은 성적입력";
</script>
<%
    }
    else if(!dao.checkScores(scores)){
        isCorrectInput = false;
%>
    <script>
        alert("올바르지 않은 성적입력");
    </script>
<%
    }
    else if(!dao.checkAddress(addr)){
        isCorrectInput = false;
%>
<script>alert("올바르지 않은 주소!");</script>
<%
    }
    else{
        // total, avg, rank
        Integer total = dao.scoreToTotal(scores);// 4.합계
        Double avg = dao.totalToAvg(total,scores.length); // 5. 평균
        Integer rank = 1; // 등수


        Student student = new Student();
        student.setStudentId(dao.getStudentCnt()+1); // 1. 학번
        student.setName(studentName);
        student.setScores(scores);
        student.setTotal(total);
        student.setAvg(avg);
        student.setRank(rank);
        student.setAddr(addr);

        dao.addStudent(student);
        //    dao.printInfo();
        %>
        <%
        response.sendRedirect("Students.jsp");
    }
    if (isCorrectInput == false) {
        response.sendRedirect("index.jsp");
    }
        %>

</body>
</html>
