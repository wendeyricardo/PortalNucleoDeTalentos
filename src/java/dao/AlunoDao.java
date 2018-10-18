package dao;

import entity.Aluno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AlunoDao {

    private Session session;

    public void incluir(Aluno aluno) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(aluno);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Aluno aluno) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(aluno);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Aluno aluno) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(aluno);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Aluno buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Aluno) session.load(Aluno.class, id);
        } finally {
            session.close();
        }
    }

    public List<Aluno> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List alunos = session.createQuery("from Aluno").list();
            return alunos;
        } finally {
            session.close();
        }
    }
}
