package polsl.pl.controller;

import polsl.pl.model.OutOfRangePriority;
import polsl.pl.model.Task;
import polsl.pl.model.TaskManager;
import polsl.pl.view.TaskListView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskListController {

    private TaskManager taskManager;
    private TaskListView taskListView;
    private Scanner sc;
    private boolean end = false;

    public TaskListController(TaskManager taskManager, TaskListView taskListView) {
        this.taskManager = taskManager;
        this.taskListView = taskListView;
        sc = new Scanner(System.in);
    }

    public void TaskListLoop() {
        while (!end) {
            taskListView.menu();
            try {
                int i = sc.nextInt();
                switch (i) {
                    case 1: {
                        // display tasks
                        taskListView.displayTaskList(taskManager.getTaskList());
                        break;
                    }
                    case 2: {
                        // delete tasks
                        deleteTask();
                        break;
                    }
                    case 3: {
                        // add new task
                        taskManager.addTask(getTask());
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
        System.out.println("Koniec programu");
    }

    public Task getTask() {
        Task newTask = new Task();
        System.out.print("New Task [" + newTask.getId() + "]");
        System.out.print("Enter Task Name: ");
        newTask.setName(sc.next());
        System.out.print("Enter Task Description: ");
        newTask.setDescription(sc.next());

        // Task Priority Enter
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

    // Delete task
    private void deleteTask() {
        System.out.print("Delete Task\n");
        while (true) {
            try {
                System.out.print("Enter Task ID: ");
                int idToRemove = sc.nextInt();
                taskManager.removeTask(idToRemove);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid task id.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid value that's not a number.");
                sc.nextLine();
            }
        }
    }

    // Set if tank is done
    private void setTaskDone() {
        int idIsDone;
        while (true) {
            try {
                System.out.print("Enter Task ID: ");
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


        taskManager.setTaskIsDone(idIsDone, isDone);
    }
}
