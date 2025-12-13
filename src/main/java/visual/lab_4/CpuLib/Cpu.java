package visual.lab_4.CpuLib;

class Cpu implements ICpu{
    private int a;
    private int b;
    private int c;
    private int d;
    private final int[] mem = new int[1024];
    Handler handler = new Handler();

    public Handler getHandler() {
        return handler;
    }

    public int getRegister(String string) throws CpuException {
        int number;
        switch (string) {
            case "a" -> number = a;
            case "b" -> number = b;
            case "c" -> number = c;
            case "d" -> number = d;
            default -> throw new CpuException("Не существует такого регистра: " + string);
        }

        return number;
    }

    public int[] getAllMemory()
    {
        return mem;
    }
    public void setRegister(String string, int number) throws CpuException {
        switch (string) {
            case "a" -> a = number;
            case "c" -> c = number;
            case "d" -> d = number;
            case "b" -> b = number;
            default -> throw new CpuException("Не существует регистра: " + string);
        }

    }

    public void setMem(int addr, int value) throws CpuException {
        if (addr < 0 )
            throw new CpuException("Не существует отрицательного аддресса: " + addr);
        else if(addr >= mem.length)
            throw new CpuException("Слишком большой аддресс: " + addr);

        mem[addr] = value;
    }

    public int getMem(int addr) throws CpuException {
        if (addr < 0 )
            throw new CpuException("Не существует отрицательного аддресса: " + addr);
        if(addr >= mem.length)
            throw new CpuException("Слишком большой аддресс: " + addr);

        return mem[addr];
    }

    public void execute(Command command) throws CpuException {
        this.handler.run(command, this);
    }

    public String toString() {
        return "Cpu{a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + "}";
    }

}
