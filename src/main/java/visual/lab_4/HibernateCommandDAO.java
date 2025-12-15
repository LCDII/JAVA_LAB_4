package visual.lab_4;

import org.hibernate.Session;
import org.hibernate.Transaction;
import visual.lab_4.CpuLib.Command;
import visual.lab_4.CpuLib.CommandType;

import java.util.ArrayList;
import java.util.List;

public class HibernateCommandDAO extends CommandDAO{

    Session session = null;
    Transaction transaction = null;

    @Override
    public ArrayList<Command> getCommands() {
        ArrayList<Command> Commands = super.getCommands();
        Commands.clear();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<Command> commands = session.createQuery("FROM Command", Command.class).getResultList();
            commands.forEach(Commands::add);
            commands.forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return Commands;
    }

    @Override
    public void add(Command cmd) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(cmd);
            System.out.println("Команда сохранена: " + cmd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Command cmd) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.remove(session.find(Command.class, cmd.getId()));
            System.out.println("Команда удалена: " + cmd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void swap(Command cmd1, Command cmd2)
    {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            // Перезагружаем команды из БД, чтобы получить актуальные данные
            Command managedCmd1 = session.find(Command.class, cmd1.getId());
            Command managedCmd2 = session.find(Command.class, cmd2.getId());

            if (managedCmd1 != null && managedCmd2 != null) {
                // Сохраняем значения первой команды
                CommandType tempType = managedCmd1.getType();
                String[] tempArgs = managedCmd1.getArgs();

                // Меняем местами
                managedCmd1.setType(managedCmd2.getType());
                managedCmd1.setArgs(managedCmd2.getArgs());

                managedCmd2.setType(tempType);
                managedCmd2.setArgs(tempArgs);

                System.out.println("Команды поменяны местами: " +
                        managedCmd1.getId() + " <-> " + managedCmd2.getId());
            } else {
                System.out.println("Одна из команд не найдена в БД");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
