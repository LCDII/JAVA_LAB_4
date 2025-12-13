package visual.lab_4.CpuLib;

public interface ICpu {
    void execute(Command cmd) throws CpuException;
    int getRegister(String string) throws CpuException;
    int[] getAllMemory();
}
