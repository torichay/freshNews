<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>FRESH NEWS</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/FreshNewsV2" method="post">
    <%
      if(request.getAttribute("header") != null){
        out.println("<h2 align=\"center\">" + request.getAttribute("header") + "</h2>");
      } else {
        out.println("<h2 align=\"center\"></h2>");
      }
    %>

 <%-- <p align="center">--%>
  <center>
    <%--<textarea rows="7" cols="75" name="text">--%>
      <%
        if(request.getAttribute("body") != null) {
          out.println("<textarea rows=\"7\" cols=\"75\" name=\"text\">" + request.getAttribute("body") + "</textarea>");
        } else {
          out.println("<textarea rows=\"7\" cols=\"75\" name=\"text\"></textarea>");
        }
      %>
  </center>
    <%--  </textarea>--%>
  <%--</p>--%>

  <%
    Random r = new Random();
    int rndnum = 1 + r.nextInt(24);
  %>

  <p align="center"><select name="number" >
    <option value=<%=rndnum%> selected value=<%= rndnum%>><%= rndnum%></option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
    <option value="19">19</option>
    <option value="20">20</option>
    <option value="21">21</option>
    <option value="22">22</option>
    <option value="23">23</option>
    <option value="24">24</option>
    <option value="25">25</option>


  </select>

    <%--<button>NEXT</button>--%>
    <input type="submit" value="NEXT">
  </p>


</form>
</body>
</html>
