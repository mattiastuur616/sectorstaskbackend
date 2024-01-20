package sectors.task.sectorstaskbackend.exception;

public class SectorNotFoundException extends Throwable {
    public String message;
    public SectorNotFoundException(String message) {
        this.message = message;
    }
}
