package polsl.pl.model.TaskList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @org.junit.jupiter.api.Test
    void getTaskList() {
        TaskList taskList = new TaskList();

        ArrayList<Task> list = taskList.getTaskList();

        assertNotNull(list,"TaskList should not be null");
        assertTrue(list.isEmpty(), "Task list should be empty initially");



        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, false));
        taskList.addTask(new Task("Task2", "Description 3", Priority.HIGH, false));
        list = taskList.getTaskList();

        assertFalse(list.isEmpty(), "Task list should not be empty after adding Tasks");

        assertEquals(3, list.size(), "Task list should contain 3 tasks");
    }

    @org.junit.jupiter.api.Test
    void getTask() {
        TaskList taskList = new TaskList();

        // Test before adding data to taskList
        assertNull(taskList.getTask(0),"Task list should be null");
        assertNull(taskList.getTask(100), "Task with invalid ID 100 should be null");

        // Adding data to taskList for Tests
        Task task0 = new Task("Task0", "Description 1", Priority.LOW, false);
        Task task1 = new Task("Task1", "Description 2", Priority.MEDIUM, true);
        Task task2 = new Task("Task2", "Description 3", Priority.HIGH, false);

        taskList.addTask(task0);
        taskList.addTask(task1);
        taskList.addTask(task2);

        // Test after adding data to taskList
        assertNull(taskList.getTask(100), "Task with invalid ID 100 should be null");


        // Test if Task is not null
        assertNotNull(taskList.getTask(0),"Task with ID 0 should not be null");
        assertNotNull(taskList.getTask(1),"Task with ID 1 should not be null");
        assertNotNull(taskList.getTask(2),"Task with ID 2 should not be null");

        // Test if Task name is correct
        assertEquals(task0.getName(), taskList.getTask(0).getName(), "Task name with ID 0 should be " + task0.getName());
        assertEquals(task1.getName(), taskList.getTask(1).getName(), "Task name with ID 1 should be " + task1.getName());
        assertEquals(task2.getName(), taskList.getTask(2).getName(), "Task name with ID 2 should be " + task2.getName());

        assertEquals(task0.getDescription(), taskList.getTask(0).getDescription(), "Task description with ID 0 should be " + task0.getDescription());
        assertEquals(task1.getDescription() , taskList.getTask(1).getDescription(), "Task description with ID 1 should be " + task1.getDescription());
        assertEquals(task2.getDescription(), taskList.getTask(2).getDescription(), "Task description with ID 2 should be " + task2.getDescription());

        //Test if Task Priority is correct
        assertEquals(task0.getPriority(), taskList.getTask(0).getPriority(), "Task Priority with id 0 should be " + task0.getPriority());
        assertEquals(task1.getPriority(), taskList.getTask(1).getPriority(), "Task Priority with id 1 should be " + task1.getPriority());
        assertEquals(task2.getPriority(), taskList.getTask(2).getPriority(), "Task Priority with id 2 should be " + task2.getPriority());

        //Test if Task isDone is correct
        assertFalse(taskList.getTask(0).isDone(), "Task isDone with id 0 should be " + task0.isDone());
        assertTrue(taskList.getTask(1).isDone(), "Task isDone with id 1 should be " + task1.isDone());
        assertFalse(taskList.getTask(2).isDone(), "Task isDone with id 2 should be " + task2.isDone());
    }

    @org.junit.jupiter.api.Test
    void setTaskIsDone() {
    }

    @org.junit.jupiter.api.Test
    void removeTask() {
    }

    @org.junit.jupiter.api.Test
    void addTask() {
    }
}