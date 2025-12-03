package visual.lab_4.CpuLib;

public class CpuException extends RuntimeException {
    public CpuException(String message) {
        super(message);
    }

    public String getMessage() {
        return "CpuException: " + super.getMessage();
    }
}
