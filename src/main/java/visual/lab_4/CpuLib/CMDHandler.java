package visual.lab_4.CpuLib;

public class CMDHandler extends Handler {
    void run(Command command, Cpu cpu) throws CpuException {
        if (command.getType() == CommandType.INIT) {
            String[] a = command.getArgs();
            if (a.length != 2)
                throw new CpuException("Неверное количество аргументов, предполагается 2");
            else
                cpu.setMem(Integer.parseInt(a[0]), (int)Integer.parseInt(a[1]));
        }//INIT
        else if (command.getType() == CommandType.PRINT)
            System.out.printf("%d %d %d %d%n",
                    cpu.getRegister(super.a),
                    cpu.getRegister(super.b),
                    cpu.getRegister(super.c),
                    cpu.getRegister(super.d));//Print
        else
            super.run(command, cpu);//иначе следующий или ошибка
    }
}
