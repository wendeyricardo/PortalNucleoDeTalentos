package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "vaga_curso")
public class CursoVaga implements Serializable {

    @Id
    @GeneratedValue
    private Integer id_curso_vaga;
    
    @ManyToOne
    @JoinColumn(name = "vagas_id_vaga", referencedColumnName = "id_vaga")
    private Vagas vaga;

    @ManyToOne
    @JoinColumn(name = "curso_id_curso", referencedColumnName = "id_curso")
    private Curso curso;

    public CursoVaga() {
    }

    public CursoVaga(Integer id_curso_vaga, Vagas vaga, Curso curso) {
        this.id_curso_vaga = id_curso_vaga;
        this.vaga = vaga;
        this.curso = curso;
    }

    public Integer getId_curso_vaga() {
        return id_curso_vaga;
    }

    public void setId_curso_vaga(Integer id_curso_vaga) {
        this.id_curso_vaga = id_curso_vaga;
    }

    public Vagas getVaga() {
        return vaga;
    }

    public void setVaga(Vagas vaga) {
        this.vaga = vaga;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
