/**
 * Handles deleting a task from the task list.
 *
 * @author Dawid Polczyk
 * @version 1.0
 */
package controller;

import model.TaskList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
    /**
     * Processes the HTTP POST request to delete a task from the task list.
     *
     * @param req the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");

        if (taskList != null) {
            String idParam = req.getParameter("id");
            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                taskList.removeTask(id);
            }
        }

        resp.sendRedirect("tasks");
    }
}