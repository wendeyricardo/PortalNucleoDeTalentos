package entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity(name = "vagas")
public class Vagas implements Serializable {
    @Id
    @GeneratedValue 
    private Long id_vaga;
    private  String nome;
    private  String descricao;
    private  String beneficios;
    private  String cidade;
    private  Integer numero_de_vagas;
    private  Integer carga_horaria;
    private  Double horario;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date data_de_vigencia;
    @ManyToOne
    @JoinColumn(name = "supervisor_id_supervisor", referencedColumnName = "id_supervisor")
    private Supervisor supervisor;
    @OneToMany
    @JoinTable(name="curso_vagas")
    private List<CursoVaga> cursoVagas;

    public Vagas() {
    }

    public Vagas(Long id_vaga, String nome, String descricao, String beneficios, String cidade, Integer numero_de_vagas, Integer carga_horaria, Double horario, Date data_de_vigencia, Supervisor supervisor, List<CursoVaga> cursoVagas) {
        this.id_vaga = id_vaga;
        this.nome = nome;
        this.descricao = descricao;
        this.beneficios = beneficios;
        this.cidade = cidade;
        this.numero_de_vagas = numero_de_vagas;
        this.carga_horaria = carga_horaria;
        this.horario = horario;
        this.data_de_vigencia = data_de_vigencia;
        this.supervisor = supervisor;
        this.cursoVagas = cursoVagas;
    }

    public Long getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(Long id_vaga) {
        this.id_vaga = id_vaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero_de_vagas() {
        return numero_de_vagas;
    }

    public void setNumero_de_vagas(Integer numero_de_vagas) {
        this.numero_de_vagas = numero_de_vagas;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Double getHorario() {
        return horario;
    }

    public void setHorario(Double horario) {
        this.horario = horario;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<CursoVaga> getCursoVagas() {
        return cursoVagas;
    }

    public void setCursoVagas(List<CursoVaga> cursoVagas) {
        this.cursoVagas = cursoVagas;
    }

    public Date getData_de_vigencia() {
        return data_de_vigencia;
    }

    public void setData_de_vigencia(Date data_de_vigencia) {
        this.data_de_vigencia = data_de_vigencia;
    }
    
    
       
}
