/**
 * Handles adding a new task to the task list.
 *
 * @author Dawid Polczyk
 * @version 1.0
 */
package controller;

import model.Exceptions.TaskValueCannotBeEmptyException;
import model.Priority;
import model.Task;
import model.TaskList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    /**
     * Processes the HTTP POST request to add a new task to the task list.
     *
     * @param req the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskList taskList = (TaskList) getServletContext().getAttribute("taskList");
        List<String> errorFields = new ArrayList<>();

        if (taskList != null) {
            try {
                String name = req.getParameter("name");
                String description = req.getParameter("description");
                String priority = req.getParameter("priority");

                if (name == null || name.isEmpty()) {
                    errorFields.add("name");
                }
                if (description == null || description.isEmpty()) {
                    errorFields.add("description");
                }
                if (priority == null || priority.isEmpty()) {
                    errorFields.add("priority");
                }

                if (!errorFields.isEmpty()) {
                    req.setAttribute("errorMessage", "Please fill out all required fields.");
                    req.setAttribute("errorFields", errorFields);
                    forwardWithError(req, resp, taskList);
                    return;
                }
                Task task = new Task(name, description, Priority.valueOf(priority), false);

                taskList.addTask(task);

                resp.sendRedirect("tasks");

            } catch (TaskValueCannotBeEmptyException e) {
                errorFields.add(e.getField());
                req.setAttribute("errorMessage", e.getMessage());
                req.setAttribute("errorFields", errorFields);
                forwardWithError(req, resp, taskList);

            } catch (IllegalArgumentException e) {
                errorFields.add("priority");
                req.setAttribute("errorMessage", "Invalid priority value.");
                req.setAttribute("errorFields", errorFields);
                forwardWithError(req, resp, taskList);
            }
        } else {
            req.setAttribute("errorMessage", "Task list is not initialized.");
            forwardWithError(req, resp, taskList);
        }
    }

    /**
     * Forwards the request with error messages and task list data.
     *
     * @param req the HttpServletRequest object containing the request details.
     * @param resp the HttpServletResponse object to send the response.
     * @param taskList the TaskList object containing the list of tasks.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    private void forwardWithError(HttpServletRequest req, HttpServletResponse resp, TaskList taskList) throws ServletException, IOException {
        req.setAttribute("formData", req.getParameterMap());

        if (taskList != null) {
            req.setAttribute("tasks", taskList.getTaskList());
        }

        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }
}