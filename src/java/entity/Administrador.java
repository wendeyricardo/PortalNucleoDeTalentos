package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Administrador implements Serializable {

    @Id
    @GeneratedValue
    private Long id_administrador;
    private String nome;
    private String email;
    private String sexo;
    private String endereco;
    private Integer telefone;
    private Integer cpf;
    private Integer rg;
    @OneToMany
    @JoinTable(name = "supervisor")
    private List<Supervisor> supervisores;

    public Administrador() {
    }

    public Administrador(Long id_administrador, String nome, String email, String sexo, String endereco, Integer telefone, Integer cpf, Integer rg, List<Supervisor> supervisores) {
        this.id_administrador = id_administrador;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.supervisores = supervisores;
    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
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

    public List<Supervisor> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Supervisor> supervisores) {
        this.supervisores = supervisores;
    }

}
