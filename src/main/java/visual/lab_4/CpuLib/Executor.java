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

    public void run() throws CpuException{
        for (Command command : programm) {
            try {
                cpu.execute(command);
                programm.incrementCurrentInstruction();
            } catch (CpuException e) {
                System.out.println(e.getMessage());

            }
        }
    }

    public void executeOne() throws CpuException
    {
        try{
            cpu.execute(programm.getElem(programm.getCurrentInstructionIndex()));
            programm.incrementCurrentInstruction();
        }
        catch (CpuException e){
            System.out.println(e.getMessage());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
