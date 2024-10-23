package polsl.pl.model;

public class OutOfRangePriority extends RuntimeException {
    public OutOfRangePriority(String message) {
        super(message);
    }
}
