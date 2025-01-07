<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
</head>
<body>
<h1>Edit Task</h1>
<form action="editTask" method="post">
    <input type="hidden" name="id" value="${task.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${task.name}" required><br><br>

    <label for="description">Description:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required>${task.description}</textarea><br><br>

    <label for="priority">Priority:</label>
    <select id="priority" name="priority">
        <option value="LOW" ${task.priority == 'LOW' ? 'selected' : ''}>Low</option>
        <option value="MEDIUM" ${task.priority == 'MEDIUM' ? 'selected' : ''}>Medium</option>
        <option value="HIGH" ${task.priority == 'HIGH' ? 'selected' : ''}>High</option>
    </select><br><br>

    <button type="submit">Save</button>
    <a href="tasks">Cancel</a>
</form>
</body>
</html>
