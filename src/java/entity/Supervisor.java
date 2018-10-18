package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Supervisor implements Serializable {

    @Id
    @GeneratedValue
    private Long id_supervisor;
    private String nome;
    private String email;
    private String sexo;
    private String endereco;
    private Integer cpf;
    private Integer rg;
    private Integer telefone;
    private Integer matricula;
    @ManyToOne
    @JoinColumn(name = "administrador_id_administrador", referencedColumnName = "id_administrador")
    private Administrador administrador;
    @OneToMany
    @JoinTable(name = "vaga")    
    private List<Vagas> vagas;
    @OneToMany
    @JoinTable(name = "aluno") 
    private List<Aluno> alunos;

    public Supervisor() {
    }

    public Supervisor(Long id_supervisor, String nome, String email, String sexo, String endereco, Integer cpf, Integer rg, Integer telefone, Integer matricula, Administrador administrador, List<Vagas> vagas, List<Aluno> alunos) {
        this.id_supervisor = id_supervisor;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.matricula = matricula;
        this.administrador = administrador;
        this.vagas = vagas;
        this.alunos = alunos;
    }

    public Long getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(Long id_supervisor) {
        this.id_supervisor = id_supervisor;
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Vagas> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vagas> vagas) {
        this.vagas = vagas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
    
    
}
