/**
 * Handles marking a task as done or not done.
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

@WebServlet("/markTaskDone")
public class MarkTaskAsDoneServlet extends HttpServlet {
    /**
     * Processes the HTTP POST request to update the completion status of a task.
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
            String isDoneParam = req.getParameter("isDone");

            if (idParam != null && isDoneParam != null) {
                int id = Integer.parseInt(idParam);
                boolean isDone = Boolean.parseBoolean(isDoneParam);
                taskList.setTaskIsDone(id, isDone);
            }
        }

        resp.sendRedirect("tasks");
    }
}