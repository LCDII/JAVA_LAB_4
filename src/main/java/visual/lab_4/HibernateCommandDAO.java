package visual.lab_4;

import org.hibernate.Session;
import org.hibernate.Transaction;
import visual.lab_4.CpuLib.Command;

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
}
