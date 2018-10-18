package bean;

import dao.CursoDao;
import entity.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class CursoBean {

    private Curso curso;
    private CursoDao cursoDao;
    private DataModel listaCursos;

    public CursoBean() {
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public DataModel getListaCurso() {
        this.cursoDao = new CursoDao();
        List<Curso> cursos = cursoDao.buscarTodos();
        this.listaCursos = new ListDataModel(cursos);
        return listaCursos;
    }

    public String prepararAdicionarCurso() {
        this.curso = new Curso();
        return "icurso";
    }

    public String adicionarCurso() {
        this.cursoDao = new CursoDao();
        this.cursoDao.incluir(curso);
        return "ecurso";
    }

    public String excluirCurso() {
        this.cursoDao = new CursoDao();
        this.curso = (Curso) listaCursos.getRowData();
        this.cursoDao.excluir(curso);
        return "ecurso";
    }

    public String prepararAlterarCurso() {
        this.curso = (Curso) listaCursos.getRowData();
        return "acurso";       
    }

    public String alterarCurso() {
        this.cursoDao = new CursoDao();
        this.cursoDao.alterar(curso);
        return "ecurso";
    }
}
