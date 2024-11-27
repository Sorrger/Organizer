package polsl.pl.model.TaskList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @org.junit.jupiter.api.Test
    void taskListShouldBeEmptyInitially() {
        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getTaskList();

        assertNotNull(list, "TaskList should not be null");
        assertTrue(list.isEmpty(), "Task list should be empty initially");
    }

    @org.junit.jupiter.api.Test
    void addingTasksShouldIncreaseListSize() {
        TaskList taskList = new TaskList();
        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, false));
        taskList.addTask(new Task("Task2", "Description 3", Priority.HIGH, false));

        ArrayList<Task> list = taskList.getTaskList();
        assertFalse(list.isEmpty(), "Task list should not be empty after adding Tasks");
        assertEquals(3, list.size(), "Task list should contain 3 tasks");
    }

    @org.junit.jupiter.api.Test
    void getTaskShouldReturnCorrectTask() {
        TaskList taskList = new TaskList();
        Task task0 = new Task("Task0", "Description 1", Priority.LOW, false);
        Task task1 = new Task("Task1", "Description 2", Priority.MEDIUM, true);
        Task task2 = new Task("Task2", "Description 3", Priority.HIGH, false);

        taskList.addTask(task0);
        taskList.addTask(task1);
        taskList.addTask(task2);

        assertEquals(task0.getName(), taskList.getTask(0).getName(), "Task name with ID 0 should match");
        assertEquals(task1.getDescription(), taskList.getTask(1).getDescription(), "Task description with ID 1 should match");
        assertEquals(task2.getPriority(), taskList.getTask(2).getPriority(), "Task priority with ID 2 should match");
    }

    @org.junit.jupiter.api.Test
    void getTaskShouldReturnNullForInvalidIndex() {
        TaskList taskList = new TaskList();
        assertNull(taskList.getTask(0), "Task list should return null for invalid index");
        assertNull(taskList.getTask(100), "Task with invalid ID 100 should be null");
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void setTaskIsDoneShouldUpdateStatus(boolean initialStatus) {
        TaskList taskList = new TaskList();
        Task task = new Task("Task0", "Description 1", Priority.LOW, initialStatus);
        taskList.addTask(task);

        assertEquals(initialStatus, taskList.getTask(0).isDone(), "Initial isDone status should match");

        boolean newStatus = !initialStatus;
        taskList.setTaskIsDone(0, newStatus);

        assertEquals(newStatus, taskList.getTask(0).isDone(), "Updated isDone status should match");

    }

    @org.junit.jupiter.api.Test
    void setTaskIsDoneShouldThrowExceptionForInvalidIndex() {
        TaskList taskList = new TaskList();
        assertThrows(IndexOutOfBoundsException.class,
                () -> taskList.setTaskIsDone(100, true),
                "This should throw an IndexOutOfBoundsException");
    }

    @org.junit.jupiter.api.Test
    void removeTaskShouldReduceTaskListSize() {
        TaskList taskList = new TaskList();
        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, true));

        ArrayList<Task> list = taskList.getTaskList();
        assertEquals(2, list.size(), "Task list should initially contain 2 tasks");

        taskList.removeTask(0);
        assertEquals(1, list.size(), "Task list should contain 1 task after removal");
        taskList.removeTask(0);
        assertEquals(0, list.size(), "Task list should contain 0 tasks after removing all");
    }

    @org.junit.jupiter.api.Test
    void removeTaskShouldThrowExceptionForInvalidIndex() {
        TaskList taskList = new TaskList();
        assertThrows(IndexOutOfBoundsException.class,
                () -> taskList.removeTask(0),
                "This should throw an IndexOutOfBoundsException");
    }
    @org.junit.jupiter.api.Test
    void setTaskIsDoneShouldNotThrowExceptionForValidIndex() {
        TaskList taskList = new TaskList();
        Task task = new Task("Task0", "Description 1", Priority.LOW, false);
        taskList.addTask(task);

        assertDoesNotThrow(() -> taskList.setTaskIsDone(0, true),
                "This should not throw any exception when setting isDone for a valid task index");
    }

    @org.junit.jupiter.api.Test
    void addTaskShouldIncreaseTaskListSize() {
        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getTaskList();
        assertEquals(0, list.size(), "Task list should initially contain 0 tasks");

        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        assertEquals(1, list.size(), "Task list should contain 1 task after adding");

        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, false));
        assertEquals(2, list.size(), "Task list should contain 2 tasks after adding");
    }

}
