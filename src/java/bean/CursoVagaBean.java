package bean;

import dao.CursoDao;
import dao.VagaDao;
import dao.CursoVagaDao;
import entity.Curso;
import entity.Vagas;
import entity.CursoVaga;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class CursoVagaBean {

    private Long id_curso;
    private Long id_vaga;
    private CursoDao cursoDao;
    private VagaDao vagaDao;
    private CursoVaga cursovaga;
    private CursoVagaDao cursovagaDao;
    private DataModel listaCursoVaga;
    private List<Curso> listaCurso;
    private List<Vagas> listaVaga;

    public CursoVagaBean() {
        cursovaga = new CursoVaga();
    }

    public Long getId_curso() {
        return id_curso;
    }
    public Long getId_Vaga() {
        return id_vaga;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }
    public void setId_vaga(Long id_vaga) {
        this.id_vaga = id_vaga;
    }

    public List<Curso> getListaCurso() {
        cursoDao = new CursoDao();
        listaCurso = cursoDao.buscarTodos();
        return listaCurso;
    }
    
    public List<Vagas> getListaVaga() {
        vagaDao = new VagaDao();
        listaVaga = vagaDao.buscarTodos();
        return listaVaga;
    }

    public CursoVaga getCursoVaga() {
        return cursovaga;
    }

    public void setCursoVaga(CursoVaga cursovaga) {
        this.cursovaga = cursovaga;
    }

    public DataModel getListaCursoVaga() {
        this.cursovagaDao = new CursoVagaDao();
        List<CursoVaga> cursoVagas = cursovagaDao.buscarTodos();
        this.listaCursoVaga = new ListDataModel(cursoVagas);
        return listaCursoVaga;
    }

    public String prepararAdicionarCursoVaga() {
        this.cursovaga = new CursoVaga();
        return "icursovaga";
    }

    public String adicionarCursoVaga() {
        this.cursovagaDao = new CursoVagaDao();
        this.cursovaga.setCurso(cursoDao.buscarUm(id_curso));
        this.cursovagaDao = new CursoVagaDao();
        this.cursovagaDao.incluir(cursovaga);
        return "ecursovaga";
    }

    public String excluirCursoVaga() {
        this.cursovagaDao = new CursoVagaDao();
        this.cursovaga = (CursoVaga) listaCursoVaga.getRowData();
        this.cursovagaDao.excluir(cursovaga);
        return "ecursovaga";
    }

    public String preparaAlterarCursoVaga() {
        this.cursovaga = (CursoVaga) listaCursoVaga.getRowData();
        return "acursovaga";
    }

    public String alterarCursoVaga() {
        this.cursoDao = new CursoDao();        
        this.cursovagaDao = new CursoVagaDao();
        this.cursovagaDao.alterar(cursovaga);
        return "eCursoVaga";
    }
}
