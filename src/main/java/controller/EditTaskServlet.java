package controller;

import model.Priority;
import model.Task;
import model.TaskList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editTask")
public class EditTaskServlet extends HttpServlet {

    /**
     * Processes the HTTP GET request to display the edit task page.
     *
     * @param req  the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");

        if (taskList != null) {
            String idParam = req.getParameter("id");
            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                Task task = taskList.getTaskById(id);
                if (task != null) {
                    req.setAttribute("task", task);
                    req.getRequestDispatcher("editTask.jsp").forward(req, resp);
                    return;
                }
            }
        }

        resp.sendRedirect("tasks");
    }

    /**
     * Processes the HTTP POST request to update a task.
     *
     * @param req  the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException      if an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");

        if (taskList != null) {
            String idParam = req.getParameter("id");
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String priorityParam = req.getParameter("priority");

            if (idParam != null && name != null && description != null && priorityParam != null) {
                int id = Integer.parseInt(idParam);
                Priority priority = Priority.valueOf(priorityParam);

                Task task = taskList.getTaskById(id);
                if (task != null) {
                    task.setName(name);
                    task.setDescription(description);
                    task.setPriority(priority);

                    resp.sendRedirect("tasks");
                    return;
                }
            }
        }

        resp.sendRedirect("tasks");
    }
}
