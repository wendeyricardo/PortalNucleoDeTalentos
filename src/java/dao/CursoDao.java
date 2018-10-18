package dao;

import entity.Curso;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CursoDao {

    private Session session;

    public void incluir(Curso curso) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(curso);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Curso curso) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(curso);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Curso curso) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(curso);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Curso buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Curso) session.load(Curso.class, id);
        } finally {
            session.close();
        }
    }

    public List<Curso> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List cursos = session.createQuery("from Curso").list();
            return cursos;
        } finally {
            session.close();
        }
    }
}
