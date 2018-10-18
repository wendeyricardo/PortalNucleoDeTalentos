package util;

import entity.Administrador;
import entity.Aluno;
import entity.Curso;
import entity.CursoVaga;
import entity.Supervisor;
import entity.Vagas;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Administrador.class);
                ac.addAnnotatedClass(Aluno.class);
                ac.addAnnotatedClass(Curso.class);
                ac.addAnnotatedClass(Supervisor.class);
                ac.addAnnotatedClass(Vagas.class);
                ac.addAnnotatedClass(CursoVaga.class);

                sessionFactory = ac.configure().buildSessionFactory();                                                
            } catch (HibernateException ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}