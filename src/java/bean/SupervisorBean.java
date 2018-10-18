package bean;

import dao.AdministradorDao;
import dao.SupervisorDao;
import entity.Administrador;
import entity.Supervisor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class SupervisorBean {

    private Supervisor supervisor;
    private SupervisorDao supervisorDao;
    private DataModel listaSupervisor;
    //isso é necessario por causa da chave estrangeira
    private Long idAdministrador;
    private AdministradorDao administradorDao;    
    private List<Administrador> listaAdministradores;

    //fk
    public Long getIdAdministrador() {
        return idAdministrador;
    }

    //fk
    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }        
    //fk
    public List<Administrador> getListaAdministradores() {
        administradorDao = new AdministradorDao();
        listaAdministradores = administradorDao.buscarTodos();
        return listaAdministradores;
    }

    public SupervisorBean() {
        supervisor = new Supervisor();
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public DataModel getListaSupervisor() {
        this.supervisorDao = new SupervisorDao();
        List<Supervisor> supervisor = supervisorDao.buscarTodos();
        this.listaSupervisor = new ListDataModel(supervisor);
        return listaSupervisor;
    }

    public String prepararAdicionarSupervisor() {
        this.supervisor = new Supervisor();
        return "isupervisor";
    }

    public String adicionarSupervisor() {
        //fk
        this.administradorDao = new AdministradorDao();
        this.supervisor.setAdministrador(administradorDao.buscarUm(idAdministrador));
        
        this.supervisorDao = new SupervisorDao();
        this.supervisorDao.incluir(supervisor);
        return "esupervisor";
    }

    public String excluirSupervisor() {
        this.supervisorDao = new SupervisorDao();
        this.supervisor = (Supervisor) listaSupervisor.getRowData();
        this.supervisorDao.excluir(supervisor);
        return "esupervisor";
    }

    public String prepararAlterarSupervisor() {
        this.supervisor = (Supervisor) listaSupervisor.getRowData();
        return "asupervisor";
    }

    public String alterarSupervisor() {
        //fk
        this.administradorDao = new AdministradorDao();
        this.supervisor.setAdministrador(administradorDao.buscarUm(idAdministrador));
        
        this.supervisorDao = new SupervisorDao();
        this.supervisorDao.alterar(supervisor);
        return "esupervisor";
    }
}
