package bean;

import dao.AdministradorDao;
import entity.Administrador;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class AdministradorBean {

    private Administrador administrador;
    private AdministradorDao administradorDao;
    private DataModel listaAdministrador;

    public AdministradorBean() {
        administrador = new Administrador();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public DataModel getListaAdministrador() {
        this.administradorDao = new AdministradorDao();
        List<Administrador> administradores = administradorDao.buscarTodos();
        this.listaAdministrador = new ListDataModel(administradores);
        return listaAdministrador;
    }

    public String prepararAdicionarAdministrador() {
        this.administrador = new Administrador();
        return "iadministrador";
    }

    public String adicionarAdministrador() {
        this.administradorDao = new AdministradorDao();
        this.administradorDao.incluir(administrador);
        return "eadministrador";
    }

    public String excluirAdministrador() {
        this.administradorDao = new AdministradorDao();
        this.administrador = (Administrador) listaAdministrador.getRowData();
        this.administradorDao.excluir(administrador);
        return "eadministrador";
    }

    public String prepararAlterarAdministrador() {
        this.administrador = (Administrador) listaAdministrador.getRowData();
        return "aadministrador";       
    }

    public String alterarAdministrador() {
        this.administradorDao = new AdministradorDao();
        this.administradorDao.alterar(administrador);
        return "eadministrador";
    }
    
    
    
}
