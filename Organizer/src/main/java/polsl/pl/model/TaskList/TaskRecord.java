package polsl.pl.model.TaskList;

import java.util.Objects;

public record TaskRecord(String name, String description) {

    public TaskRecord {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
    }
}
