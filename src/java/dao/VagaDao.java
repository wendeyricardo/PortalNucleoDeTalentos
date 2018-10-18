package dao;

import entity.Vagas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class VagaDao {

    private Session session;

    public void incluir(Vagas vaga) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(vaga);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Vagas vaga) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(vaga);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Vagas vaga) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(vaga);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Vagas buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Vagas) session.load(Vagas.class, id);
        } finally {
            session.close();
        }
    }

    public List<Vagas> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List vaga = session.createQuery("from vagas").list();
            return vaga;
        } finally {
            session.close();
        }
    }
}
