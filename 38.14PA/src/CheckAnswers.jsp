<%@ page language="java" %>
<html>
<head><title>Results</title></head>
<body>
  <h3>Your Results:</h3>
  <%
  int totalCorrect = 0;
    for (int i = 0; i < 10; i++) {
      int num1 = Integer.parseInt(request.getParameter("num1" + i));
      int num2 = Integer.parseInt(request.getParameter("num2" + i));
      int userAnswer = Integer.parseInt(request.getParameter("userAnswer" + i));
      int correctAnswer = num1 + num2;
  %>
      <%= num1 %> + <%= num2 %> = <%= correctAnswer %>,
  
      <%
        if (userAnswer == correctAnswer) {
            totalCorrect++;
      %>
         Correct
         
      <%
        } else {
      %>
         Wrong
      <%
        }
      %>
      <br/>
  <%
    }
  %>
  <br/><strong>You got <%= totalCorrect %> out of 10 correct.</strong>
</body>
</html>

