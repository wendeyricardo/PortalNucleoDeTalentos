package dao;

import entity.Supervisor;
import entity.Vagas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SupervisorDao {

    private Session session;

    public void incluir(Supervisor supervisor) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(supervisor);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Supervisor supervisor) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(supervisor);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Supervisor supervisor) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(supervisor);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Supervisor buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Supervisor) session.load(Supervisor.class, id);
        } finally {
            session.close();
        }
    }

    public List<Supervisor> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List supervisores = session.createQuery("from Supervisor").list();
            return supervisores;
        } finally {
            session.close();
        }
    }

    public void incluir(Vagas vaga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
