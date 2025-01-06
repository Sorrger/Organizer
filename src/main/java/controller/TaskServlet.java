/**
 * Handles displaying the list of tasks.
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

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    /**
     * Initializes the task list and stores it in the application context.
     *
     * @throws ServletException if a servlet-specific error occurs.
     */
    @Override
    public void init() throws ServletException {
        TaskList taskList = new TaskList();
        getServletContext().setAttribute("taskList", taskList);
    }

    /**
     * Processes the HTTP GET request to display the list of tasks.
     *
     * @param req the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");

        if (taskList == null) {
            taskList = new TaskList();
            getServletContext().setAttribute("taskList", taskList);
        }

        req.setAttribute("tasks", taskList.getTaskList());

        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }
}