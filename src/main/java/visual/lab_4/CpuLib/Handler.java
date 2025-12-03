package visual.lab_4.CpuLib;

public class Handler {
    Handler next;
    protected final String a = "a";
    protected final String b = "b";
    protected final String c = "c";
    protected final String d = "d";

    void run(Command command, Cpu cpu) throws CpuException {
        if (this.next != null)
            this.next.run(command, cpu);
        else
            throw new CpuException("Невозможно выполнить: " + command.toString());
    }

    Handler add(Handler next) {
        this.next = next;
        return next;
    }
}
