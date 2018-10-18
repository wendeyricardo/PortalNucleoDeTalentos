package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue
    private Long id_aluno;
    private String nome;
    private Integer matricula;
    private String email;
    private String sexo;
    private String endereco;
    private String nascimento;
    private String naturalidade;
    private Integer cpf;
    private Integer rg;
    
    @ManyToOne
    @JoinColumn(name = "curso_id_curso", referencedColumnName = "id_curso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "supervisor_id_supervisor", referencedColumnName = "id_supervisor")
    private Supervisor Supervisor;

    public Aluno() {
    }

    public Aluno(Long id_aluno, String nome, String email, String sexo, String endereco, String nascimento, String naturalidade, Integer cpf, Integer rg, Integer matricula, Curso curso, Supervisor Supervisor) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.naturalidade = naturalidade;
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.curso = curso;
        this.Supervisor = Supervisor;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Supervisor getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(Supervisor Supervisor) {
        this.Supervisor = Supervisor;
    }

}
