package visual.lab_4.CpuLib;

public class ALUHandler extends Handler{
    void run(Command command, Cpu cpu) throws CpuException {
        if (command.getType() == CommandType.ADD) {
            int a = cpu.getRegister(super.a);
            int b = cpu.getRegister(super.b);
            cpu.setRegister(super.d, a + b);
        } // Сложение
        else if (command.getType() == CommandType.SUB) {
            int a = cpu.getRegister(super.a);
            int b = cpu.getRegister(super.b);
            cpu.setRegister(super.d, a - b);
        }//Вычитание
        else if (command.getType() == CommandType.DIV) {
            int a = cpu.getRegister(super.a);
            int b = cpu.getRegister(super.b);
            if (b == 0)
                throw new CpuException("Деление на ноль невозможно!");
            else
                cpu.setRegister(super.d, a / b);
        }//Деление
        else if (command.getType() == CommandType.MULT) {
            int a = cpu.getRegister(super.a);
            int b = cpu.getRegister(super.b);
            cpu.setRegister(super.d, a * b);
        }//Умножение
        else
            super.run(command, cpu);//иначе следующий или ошибка
    }

}
