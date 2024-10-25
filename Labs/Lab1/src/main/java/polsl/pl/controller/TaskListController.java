package polsl.pl.controller;

import polsl.pl.model.OutOfRangePriority;
import polsl.pl.model.Task;
import polsl.pl.model.TaskListManager;
import polsl.pl.view.TaskListView;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Representing Task List Controller
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListController {

    /**
     * Representing a Task List Manager
     */
    private TaskListManager taskListManager;
    /**
     * Representing a Task List View
     */
    private TaskListView taskListView;
    /**
     * Scanner used for User - TaskList communication
     */
    private Scanner sc;
    /**
     * value if the TaskListLoop should end
     */
    private boolean end = false;

    /** Creates a TaskListController object
     * @param taskListManager Representing Task List Manager
     * @param taskListView Representing Task List View
     */
    public TaskListController(TaskListManager taskListManager, TaskListView taskListView) {
        this.taskListManager = taskListManager;
        this.taskListView = taskListView;
        sc = new Scanner(System.in);
    }

    /**
     * Loop for Task List app
     * User type on keyboard choices of the menu
     * 1 - Display Task
     * 2 - Delete Task
     * 3 - Add Task
     * 4 - Set Task isDone value
     * 5 - end loop(set end boolean value to false)
     */
    public void TaskListLoop() {
        while (!end) {
            taskListView.menu();
            try {
                int i = sc.nextInt();
                switch (i) {
                    case 1: {
                        taskListView.displayTaskList(taskListManager.getTaskList());
                        break;
                    }
                    case 2: {
                        deleteTask();
                        break;
                    }
                    case 3: {
                        // add new task
                        taskListManager.addTask(getTask());
                        break;
                    }
                    case 4: {
                        // set task Done
                        setTaskDone();
                        break;
                    }
                    case 5: {
                        end = true;
                        break;
                    }
                    default: {
                        System.out.println("Invalid option. Please select a valid number.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
        System.out.println("Program Exit");
    }

    /**Gets Task that user want to create
     * User is asked to provide data:
     * 1 - Task name
     * 2 - Task description
     * 3 - Task priority - with int between and including 1 and 3
     * Data is provided by keyboard in console
     * @return Task representation of task that user created
     */
    public Task getTask() {
        Task newTask = new Task();
        System.out.print("New Task [" + newTask.getId() + "]");
        System.out.print("Enter Task Name: ");
        newTask.setName(sc.next());
        System.out.print("Enter Task Description: ");
        newTask.setDescription(sc.next());

        while (true) {
            try {
                System.out.print("Enter Task Priority 1-3: ");
                int priority = sc.nextInt();
                if (priority < 1 || priority > 3) {
                    throw new OutOfRangePriority("Out of range priority.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value that's not a number.");
                sc.nextLine();
            } catch (OutOfRangePriority e) {
                System.out.println(e.getMessage());
            }
        }
        newTask.setDone(false);
        return newTask;
    }

    /**
     * Delete the Task from TaskLIst that user want to delete by his number in TaskList
     * User is asked to provide data of the task number
     * data is provided by the keyboard in console
     */
    private void deleteTask() {
        System.out.print("Delete Task\n");
        while (true) {
            try {
                System.out.print("Enter Task number: ");
                int idToRemove = sc.nextInt();
                taskListManager.removeTask(idToRemove);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid task number.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid value that's not a number.");
                sc.nextLine();
            }
        }
    }

    /**Sets Task isDone value that user want
     * User is asked to provide data:
     * 1 - Task number in TaskList
     * 2 - boolean value of isDone true / false
     * Data is provided by keyboard in console
     */
    private void setTaskDone() {
        int idIsDone;
        while (true) {
            try {
                System.out.print("Enter Task number in Task List: ");
                idIsDone = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value that's not a number.");
                sc.nextLine();
            }
        }

        boolean isDone;
        while (true) {
            try {
                System.out.print("Enter is done (true/false): ");
                String input = sc.nextLine().trim().toLowerCase();
                if (input.equals("true")) {
                    isDone = true;
                    break;
                } else if (input.equals("false")) {
                    isDone = false;
                    break;
                } else {
                    System.out.println("Invalid value. Please enter true or false.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Please enter true or false.");
                sc.nextLine();
            }
        }
        taskListManager.setTaskIsDone(idIsDone, isDone);
    }
}
