
<% 
//total questions and array to hold numbers
  int numQuestions = 10;
  int[] num1 = new int[numQuestions];
  int[] num2 = new int[numQuestions];
%>

<html>
<head><title>Quiz</title></head>
<body>
  <h3>Answer the following questions:</h3>
   <!-- form that sends answers to CheckAnswers.jsp -->
  <form method="post" action="CheckAnswers.jsp">
    <%
    //loop to create 10 random questions
      for (int i = 0; i < numQuestions; i++) {
        num1[i] = (int)(Math.random() * 30);
        num2[i] = (int)(Math.random() * 30);
    %>
      <!-- display question -->
      <%= num1[i] %> + <%= num2[i] %> = 
      <input type="text" name="userAnswer<%=i%>" /><br/>

      <!-- store hidden numbers-->
      <input type="hidden" name="num1<%=i%>" value="<%= num1[i] %>" />
      <input type="hidden" name="num2<%=i%>" value="<%= num2[i] %>" />
    <%
      }
    %>
    <br/><input type="submit" value="Submit Answers" />
  </form>
</body>
</html>
