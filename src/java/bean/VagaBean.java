package bean;

import dao.SupervisorDao;
import dao.VagaDao;
import entity.Supervisor;
import entity.Vagas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class VagaBean {

    private Vagas vaga;
    private VagaDao vagaDao;
    private DataModel listaVaga;
    //isso é necessario por causa da chave estrangeira
    private Long idsupervisor;
    private SupervisorDao supervisorDao;    
    private List<Supervisor> listaSupervisores;

    //fk
    public Long getIdsupervisor() {
        return idsupervisor;
    }

    //fk
    public void setIdsupervisor(Long idsupervisor) {
        this.idsupervisor = idsupervisor;
    }        
    //fk
    public List<Supervisor> getListaSupervisor() {
        supervisorDao = new SupervisorDao();
        listaSupervisores = supervisorDao.buscarTodos();
        return listaSupervisores;
    }

    public VagaBean() {
        vaga = new Vagas();
    }

    public Vagas getVaga() {
        return vaga;
    }

    public void setVaga(Vagas vaga) {
        this.vaga = vaga;
    }

    public DataModel getListaVaga() {
        this.vagaDao = new VagaDao();
        List<Vagas> vaga = vagaDao.buscarTodos();
        this.listaVaga = new ListDataModel(vaga);
        return listaVaga;
    }

    public String prepararAdicionarVaga() {
        this.vaga = new Vagas();
        return "ivaga";
    }

    public String adicionarVaga() {
        //fk
        this.supervisorDao = new SupervisorDao();
        this.vaga.setSupervisor(supervisorDao.buscarUm(idsupervisor));
        
        this.vagaDao = new VagaDao();
        this.vagaDao.incluir(vaga);
        return "evaga";
    }

    public String excluirVaga() {
        this.vagaDao = new VagaDao();
        this.vaga = (Vagas) listaVaga.getRowData();
        this.vagaDao.excluir(vaga);
        return "evaga";
    }

    public String prepararAlterarVaga() {
        this.vaga = (Vagas) listaVaga.getRowData();
        return "avaga";
    }

    public String alterarVaga() {
        //fk
        this.supervisorDao = new SupervisorDao();
        this.vaga.setSupervisor(supervisorDao.buscarUm(idsupervisor));
        
        this.vagaDao = new VagaDao();
        this.vagaDao.alterar(vaga);
        return "evaga";
    }
}