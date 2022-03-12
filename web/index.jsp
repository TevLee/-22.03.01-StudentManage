<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  학생정보를 입력하세요.<br>
  <div class="container">
    <div class="text-center">
      <form action="inputInfo.jsp" method="post">
        <p>이름 : <input type="text" name="name" ></p>
        <p>국어 점수 : <input type="text" name="kor_score" ></p>
        <p>영어 점수 : <input type="text" name="eng_score" ></p>
        <p>수학 점수 : <input type="text" name="mat_score" ></p>
        <p>주소 : <input type="text" name="addr" ></p>
        <p><input type="submit" value="입력"></p>
      </form>
    </div>
  </div>
  </body>
</html>
