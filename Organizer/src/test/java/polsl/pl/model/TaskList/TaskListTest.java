package polsl.pl.model.TaskList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the TaskList class.
 * Tests cover all public methods except constructors, accessors, and mutators.
 * Includes valid, invalid, and boundary scenarios.
 */
class TaskListTest {

    /**
     * Test for adding tasks to the task list.
     * Ensures the list size increases appropriately after each addition.
     * @param name the name of the task
     * @param description the description of the task
     * @param priority the priority of the task
     * @param isDone the initial done status of the task
     */
    @ParameterizedTest
    @CsvSource({"Task0, Description 1, LOW, false", "Task1, Description 2, MEDIUM, true", "Task2, Description 3, HIGH, false"})
    void addingTasksShouldIncreaseListSize(String name, String description, Priority priority, boolean isDone) {
        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getTaskList();
        int initialSize = list.size();

        Task task = new Task(name, description, priority, isDone);
        taskList.addTask(task);

        assertEquals(initialSize + 1, list.size(), "Task list size should increase by 1 after adding a task");
    }

    /**
     * Test for retrieving tasks with invalid indices.
     * Ensures the method returns null for invalid indices.
     * @param index the index to retrieve
     * @param expected the expected result (null)
     */
    @ParameterizedTest
    @CsvSource({"0, null", "100, null"})
    void getTaskShouldReturnNullForInvalidIndex(int index, String expected) {
        TaskList taskList = new TaskList();
        assertNull(taskList.getTask(index), "Task list should return null for invalid index");
    }

    /**
     * Test for retrieving tasks by index.
     * Verifies that the correct task details are returned.
     * @param name the name of the task
     * @param description the description of the task
     * @param priority the priority of the task
     * @param isDone the initial done status of the task
     */
    @ParameterizedTest
    @CsvSource({"Task0, Description 1, LOW, false", "Task1, Description 2, MEDIUM, true", "Task2, Description 3, HIGH, false"})
    void getTaskShouldReturnCorrectTask(String name, String description, Priority priority, boolean isDone) {
        TaskList taskList = new TaskList();
        Task task = new Task(name, description, priority, isDone);
        taskList.addTask(task);

        Task retrievedTask = taskList.getTask(0);
        assertNotNull(retrievedTask, "Task should not be null");
        assertEquals(name, retrievedTask.getName(), "Task name should match");
        assertEquals(description, retrievedTask.getDescription(), "Task description should match");
        assertEquals(priority, retrievedTask.getPriority(), "Task priority should match");
        assertEquals(isDone, retrievedTask.isDone(), "Task isDone status should match");
    }

    /**
     * Test for setting the isDone status of tasks with invalid indices.
     * Ensures an IndexOutOfBoundsException is thrown.
     * @param index the index to update
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void setTaskIsDoneShouldThrowExceptionForInvalidIndex(int index) {
        TaskList taskList = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.setTaskIsDone(index, true), "This should throw an IndexOutOfBoundsException");
    }

    /**
     * Test for updating the isDone status of tasks.
     * Ensures the status is updated correctly.
     * @param name the name of the task
     * @param description the description of the task
     * @param priority the priority of the task
     * @param initialStatus the initial done status of the task
     * @param newStatus the new done status of the task
     */
    @ParameterizedTest
    @CsvSource({"Task0, Description 1, LOW, false, true", "Task1, Description 2, MEDIUM, true, false"})
    void setTaskIsDoneShouldUpdateStatus(String name, String description, Priority priority, boolean initialStatus, boolean newStatus) {
        TaskList taskList = new TaskList();
        Task task = new Task(name, description, priority, initialStatus);
        taskList.addTask(task);

        assertEquals(initialStatus, taskList.getTask(0).isDone(), "Initial isDone status should match");

        taskList.setTaskIsDone(0, newStatus);

        assertEquals(newStatus, taskList.getTask(0).isDone(), "Updated isDone status should match");
    }

    /**
     * Test for removing tasks by index.
     * Ensures the task list size decreases appropriately.
     * @param index the index to remove
     */
    @ParameterizedTest
    @CsvSource({"0", "1"})
    void removeTaskShouldReduceTaskListSize(int index) {
        TaskList taskList = new TaskList();
        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, true));

        ArrayList<Task> list = taskList.getTaskList();
        int initialSize = list.size();

        taskList.removeTask(index);

        assertEquals(initialSize - 1, list.size(), "Task list size should decrease by 1 after removing a task");
    }

    /**
     * Test for removing tasks with invalid indices.
     * Ensures an IndexOutOfBoundsException is thrown.
     * @param index the index to remove
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void removeTaskShouldThrowExceptionForInvalidIndex(int index) {
        TaskList taskList = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> taskList.removeTask(index), "This should throw an IndexOutOfBoundsException");
    }

    /**
     * Test for adding tasks to the task list.
     * Verifies that the list size increases appropriately.
     * @param name the name of the task
     * @param description the description of the task
     * @param priority the priority of the task
     * @param isDone the initial done status of the task
     */
    @ParameterizedTest
    @CsvSource({"Task0, Description 1, LOW, false", "Task1, Description 2, MEDIUM, true"})
    void addTaskShouldIncreaseTaskListSize(String name, String description, Priority priority, boolean isDone) {
        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getTaskList();
        int initialSize = list.size();

        taskList.addTask(new Task(name, description, priority, isDone));

        assertEquals(initialSize + 1, list.size(), "Task list size should increase after adding a task");
    }
}