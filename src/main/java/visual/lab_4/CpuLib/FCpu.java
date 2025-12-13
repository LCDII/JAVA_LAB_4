package visual.lab_4.CpuLib;

public class FCpu {
    static Cpu cpu;

    public static ICpu build() {
        if (cpu == null) {
            cpu = new Cpu();
            cpu.getHandler().add(new ALUHandler()).add(new CMDHandler()).add(new MemHandler());
        }

        return cpu;
    }
    public static ICpu reBuild()
    {
        cpu = null;
        cpu = new Cpu();
        cpu.getHandler().add(new ALUHandler()).add(new CMDHandler()).add(new MemHandler());

        return cpu;
    }

    public static void resetCpu()
    {
        cpu = new Cpu();
        cpu.getHandler().add(new ALUHandler()).add(new CMDHandler()).add(new MemHandler());
    }
}
