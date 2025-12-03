package visual.lab_4.CpuLib;

public class MemHandler extends Handler{
    void run(Command command, Cpu cpu) throws CpuException {
        if (command.getType() == CommandType.LD) {
            String[] a = command.getArgs();
            if (a.length != 2)
                throw new CpuException("Неверное количество аргументов, предполагается 2");
            else
                cpu.setRegister(a[0], cpu.getMem(Integer.parseInt(a[1])));
        }//LD
        else if (command.getType() == CommandType.ST) {
            String[] a = command.getArgs();
            if (a.length != 2)
                throw new CpuException("Неверное количество аргументов, предполагается 2");
            else
                cpu.setMem(Integer.parseInt(a[1]), cpu.getRegister(a[0]));
        }//ST
        else if ( command.getType() == CommandType.MV) {
            String[] a = command.getArgs();
            if (a.length != 2)
                throw new CpuException("Неверное количество аргументов, предполагается 2");
            else
                cpu.setRegister(a[0], cpu.getRegister(a[1]));
        }//MOV
        else
            super.run(command, cpu);//иначе следующий или ошибка
    }
}
