package model;

import org.junit.jupiter.api.BeforeEach;
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

    private TaskList taskList;

    /**
     * Sets up a fresh TaskList instance before each test.
     */
    @BeforeEach
    void setUp() {
        taskList = new TaskList();
        taskList.getTaskList().clear(); // Clear any default tasks
    }

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
        int initialSize = taskList.getTaskList().size();

        Task task = new Task(name, description, priority, isDone);
        taskList.addTask(task);

        assertEquals(initialSize + 1, taskList.getTaskList().size(), "Task list size should increase by 1 after adding a task");
    }

    /**
     * Test for retrieving tasks with invalid indices.
     * Ensures the method returns null for invalid indices.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 100})
    void getTaskShouldReturnNullForInvalidIndex(int index) {
        assertNull(taskList.getTaskById(index), "Task list should return null for invalid index");
    }

    /**
     * Tests retrieving tasks by valid IDs.
     */
    @ParameterizedTest
    @CsvSource({"Task0, Description 1, LOW, false"})
    void getTaskShouldReturnCorrectTask(String name, String description, Priority priority, boolean isDone) {
        Task task = new Task(name, description, priority, isDone);
        taskList.addTask(task);

        Task retrievedTask = taskList.getTaskById(task.getId());

        assertNotNull(retrievedTask, "Task should not be null");
        assertEquals(name, retrievedTask.getName(), "Task name should match");
        assertEquals(description, retrievedTask.getDescription(), "Task description should match");
        assertEquals(priority, retrievedTask.getPriority(), "Task priority should match");
        assertEquals(isDone, retrievedTask.isDone(), "Task isDone status should match");
    }

    /**
     * Test for setting the isDone status of tasks with invalid IDs.
     * Ensures the operation does not throw exceptions for invalid IDs.
     */
    @ParameterizedTest
    @ValueSource(ints = {999})
    void setTaskIsDoneShouldNotFailForNonExistentTask(int id) {
        assertDoesNotThrow(() -> taskList.setTaskIsDone(id, true));
    }

    /**
     * Test for updating the isDone status of tasks.
     * Ensures the status is updated correctly.
     */
    @ParameterizedTest
    @CsvSource({"Task, Description, LOW, false, true"})
    void setTaskIsDoneShouldUpdateStatus(String name, String description, Priority priority, boolean initialStatus, boolean newStatus) {
        Task task = new Task(name, description, priority, initialStatus);
        taskList.addTask(task);

        taskList.setTaskIsDone(task.getId(), newStatus);

        Task updatedTask = taskList.getTaskById(task.getId());
        assertNotNull(updatedTask, "Task should exist");
        assertEquals(newStatus, updatedTask.isDone(), "isDone should update correctly");
    }

    /**
     * Test for removing tasks by ID.
     * Ensures the task list size decreases appropriately.
     */
    @ParameterizedTest
    @CsvSource({"0"})
    void removeTaskShouldReduceTaskListSize(int id) {
        Task task = new Task("Task0", "Description", Priority.LOW, false);
        taskList.addTask(task);

        int initialSize = taskList.getTaskList().size();
        taskList.removeTask(task.getId());

        assertEquals(initialSize - 1, taskList.getTaskList().size(), "Task list size should decrease by 1 after removing a task");
    }

    /**
     * Test for removing tasks with invalid IDs.
     * Ensures the operation does not throw exceptions for invalid IDs.
     */
    @ParameterizedTest
    @ValueSource(ints = {999})
    void removeTaskShouldNotThrowForNonExistentTask(int id) {
        assertDoesNotThrow(() -> taskList.removeTask(id));
    }
}
