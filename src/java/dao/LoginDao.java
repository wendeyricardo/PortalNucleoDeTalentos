/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Login;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LoginDao {

    private Session session;

    public void incluir(Login login) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(login);//incluir no banco de dados
            transaction.commit();
        } finally {
            session.close();
        }

    }

    public void alterar(Login login) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(login);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void excluir(Login login) {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(login);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public Login buscarUm(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (Login) session.load(Login.class, id);
        } finally {
            session.close();
        }
    }

    public List<Login> buscarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List usuarios = session.createQuery("from Login").list();
            return usuarios;
        } finally {
            session.close();
        }
    }

    public boolean validarLogin(String login, String senha) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List logins = session.createQuery("from Usuario where login = :login and senha = :senha")                    
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .list();
            if (logins.size() > 0) {
                return true;
            }
            return false;
        } finally {
            session.close();
        }
    }    
}

