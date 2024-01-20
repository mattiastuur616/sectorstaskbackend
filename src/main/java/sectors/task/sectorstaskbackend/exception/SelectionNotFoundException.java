package sectors.task.sectorstaskbackend.exception;

public class SelectionNotFoundException extends Throwable {
    public String message;

    public SelectionNotFoundException(String message) {
        this.message = message;
    }
}
