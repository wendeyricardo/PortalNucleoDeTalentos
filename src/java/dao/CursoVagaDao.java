package dao;

import entity.CursoVaga;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CursoVagaDao {

    private Session session;

    public void incluir(CursoVaga cursovaga) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(cursovaga);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(CursoVaga cursovaga) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(cursovaga);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(CursoVaga cursovaga) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(cursovaga);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public CursoVaga buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (CursoVaga) session.load(CursoVaga.class, id);
        } finally {
            session.close();
        }
    }

    public List<CursoVaga> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List cursovagas = session.createQuery("from vaga_curso").list();
            return cursovagas;
        } finally {
            session.close();
        }
    }
}
