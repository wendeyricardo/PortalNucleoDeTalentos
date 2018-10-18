package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue
    private Long id_curso;
    private String nome;
    private String cidade;
    private String graduacao;
    private String unidade;
    @OneToMany
    @JoinTable(name = "curso")
    private List<Aluno> alunos;

    public Curso() {
    }

    public Curso(Long id_curso, String nome, String cidade, String graduacao, String unidade, List<Aluno> alunos) {
        this.id_curso = id_curso;
        this.nome = nome;
        this.cidade = cidade;
        this.graduacao = graduacao;
        this.unidade = unidade;
        this.alunos = alunos;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
