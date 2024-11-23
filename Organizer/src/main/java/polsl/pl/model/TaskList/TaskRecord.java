package polsl.pl.model.TaskList;

import java.util.Objects;
/**
 * Record used for printing Task with not full data
 * @author Dawid Polczyk
 * @version 1.0
 */
public record TaskRecord(String name, String description) {

    public TaskRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
    }
}
