package dao;

import entity.Administrador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AdministradorDao {

    private Session session;

    public void incluir(Administrador administrador) {        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(administrador);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Administrador administrador) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(administrador);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Administrador administrador) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(administrador);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Administrador buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Administrador) session.load(Administrador.class, id);
        } finally {
            session.close();
        }
    }

    public List<Administrador> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List administradores = session.createQuery("from Administrador").list();
            return administradores;
        } finally {
            session.close();
        }
    }
}
