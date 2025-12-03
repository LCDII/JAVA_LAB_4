package visual.lab_4.CpuLib;

public class Executor {
    private ICpu cpu;
    private Prog programm;

    public Executor(ICpu cpu) {
        this.cpu = cpu;
    }
    public Executor(ICpu cpu, Prog programm) {
        this.cpu = cpu;
        this.programm = programm;
    }
    void setProgramm(Prog programm)
    {
        this.programm = programm;
    }

    public void run(Prog prog) {
        for (Command command : prog) {
            try {
                cpu.execute(command);
            } catch (CpuException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
