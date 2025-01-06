/**
 * Handles displaying the action history of the task list.
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

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    /**
     * Processes the HTTP GET request to display the action history.
     *
     * @param req the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");

        if (taskList != null) {
            req.setAttribute("history", taskList.getActionHistory());
        }
        req.getRequestDispatcher("history.jsp").forward(req, resp);
    }
}