package bean;

import dao.AlunoDao;
import dao.CursoDao;
import entity.Curso;
import dao.SupervisorDao;
import entity.Supervisor;
import entity.Aluno;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class AlunoBean {

    private Long id_supervisor;
    private SupervisorDao supervisorDao;
    private Long id_curso;
    private CursoDao cursoDao;
    private Aluno aluno;
    private AlunoDao alunoDao;
    private DataModel listaAlunos;
    private List<Curso> listaCursos;
    private List<Supervisor> listaSupervisor;

    public AlunoBean() {
        aluno = new Aluno();
    }

    public Long getId_supervisor() {
        return id_supervisor;
    }
    
    public Long getId_curso() {
        return id_curso;
    }

    public void setId_supervisor(Long id_supervisor) {
        this.id_supervisor = id_supervisor;
    }
    
    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public List<Curso> getListaCursos() {
        cursoDao = new CursoDao();
        listaCursos = cursoDao.buscarTodos();
        return listaCursos;
    }
    
    public List<Supervisor> getListaSupervisor() {
        supervisorDao = new SupervisorDao();
        listaSupervisor = supervisorDao.buscarTodos();
        return listaSupervisor;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DataModel getListaAlunos() {
        this.alunoDao = new AlunoDao();
        List<Aluno> alunos = alunoDao.buscarTodos();
        this.listaAlunos = new ListDataModel(alunos);
        return listaAlunos;
    }

    public String prepararAdicionarAluno() {
        this.aluno = new Aluno();
        return "ialuno";
    }

    public String adicionarAluno() {
        this.cursoDao = new CursoDao();
        this.aluno.setCurso(cursoDao.buscarUm(id_curso));
        this.supervisorDao = new SupervisorDao();
        this.aluno.setSupervisor(supervisorDao.buscarUm(id_supervisor));        
        this.alunoDao = new AlunoDao();
        this.alunoDao.incluir(aluno);
        return "ealuno";
    }
    
    public String excluirAluno() {
        this.alunoDao = new AlunoDao();
        this.aluno = (Aluno) listaAlunos.getRowData();
        this.alunoDao.excluir(aluno);
        return "ealuno";
    }

    public String preparaAlterarAluno() {
        this.aluno = (Aluno) listaAlunos.getRowData();
        return "aaluno";
    }

    public String alterarAluno() { 
        this.alunoDao = new AlunoDao();
        this.alunoDao.alterar(aluno);
        return "ealuno";
    }
}
