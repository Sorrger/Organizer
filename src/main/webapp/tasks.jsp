<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task List</title>
    <style>
        .error {
            border: 2px solid red;
        }
        .error-message {
            color: red;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Task List</h1>

<%-- Wyświetlanie komunikatu o błędzie, jeśli jest ustawiony --%>
<% if (request.getAttribute("errorMessage") != null) { %>
<div class="error-message"><%= request.getAttribute("errorMessage") %></div>
<% } %>

<form action="addTask" method="POST">
    <label>
        Name:
        <input type="text"
               name="name"
               class="<%= request.getAttribute("errorFields") != null && ((List<String>) request.getAttribute("errorFields")).contains("name") ? "error" : "" %>"
               value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>">
    </label>
    <label>
        Description:
        <input type="text"
               name="description"
               class="<%= request.getAttribute("errorFields") != null && ((List<String>) request.getAttribute("errorFields")).contains("description") ? "error" : "" %>"
               value="<%= request.getParameter("description") != null ? request.getParameter("description") : "" %>">
    </label>
    <label>
        Priority:
        <select name="priority"
                class="<%= request.getAttribute("errorFields") != null && ((List<String>) request.getAttribute("errorFields")).contains("priority") ? "error" : "" %>">
            <option value="LOW" <%= "LOW".equals(request.getParameter("priority")) ? "selected" : "" %>>LOW</option>
            <option value="MEDIUM" <%= "MEDIUM".equals(request.getParameter("priority")) ? "selected" : "" %>>MEDIUM</option>
            <option value="HIGH" <%= "HIGH".equals(request.getParameter("priority")) ? "selected" : "" %>>HIGH</option>
        </select>
    </label>
    <button type="submit">Add Task</button>
</form>

<a href="history">View Action History</a>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Priority</th>
        <th>Is Done</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%-- Wyświetlanie listy zadań --%>
    <%
        java.util.List<model.Task> tasks = (java.util.List<model.Task>) request.getAttribute("tasks");
        if (tasks != null) {
            for (model.Task task : tasks) {
    %>
    <tr>
        <td><%= task.getId() %></td>
        <td><%= task.getName() %></td>
        <td><%= task.getDescription() %></td>
        <td><%= task.getPriority() %></td>
        <td>
            <form action="markTaskDone" method="POST">
                <input type="hidden" name="id" value="<%= task.getId() %>">
                <input type="hidden" name="isDone" value="<%= !task.isDone() %>">
                <input type="checkbox" <%= task.isDone() ? "checked" : "" %> onchange="this.form.submit()">
            </form>
        </td>
        <td>
            <form action="deleteTask" method="POST">
                <input type="hidden" name="id" value="<%= task.getId() %>">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>