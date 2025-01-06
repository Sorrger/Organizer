<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Task History</title>
</head>
<body>
<h1>Action History</h1>

<table border="1">
  <thead>
  <tr>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <%
    java.util.List<String> history = (java.util.List<String>) request.getAttribute("history");
    if (history != null && !history.isEmpty()) {
      for (String action : history) {
  %>
  <tr>
    <td><%= action %></td>
  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td>No actions recorded yet.</td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>

<a href="tasks">Back to Task List</a>

</body>
</html>
