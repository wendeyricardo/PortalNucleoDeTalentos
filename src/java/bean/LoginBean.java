package bean;

import dao.AdministradorDao;
import dao.LoginDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class LoginBean {

    private String fLogin;
    private String fSenha;
    private LoginDao loginDao;
    private String fPerfil;

    public LoginBean() {
    }

    public String getfLogin() {
        return fLogin;
    }

    public void setfLogin(String fLogin) {
        this.fLogin = fLogin;
    }

    public String getfSenha() {
        return fSenha;
    }

    public void setfSenha(String fSenha) {
        this.fSenha = fSenha;
    }

    public String getfPerfil() {
        return fPerfil;
    }

    public void setfPerfil(String fPerfil) {
        this.fPerfil = fPerfil;
    }
/*
    public String validarUsuario() {
        if (fPerfil.equals("Administrador")) {
            FacesContext fc = FacesContext.getCurrentInstance();
            this.administradorDao = new AdministradorDao();
            //um metodo validarLogin em cada dao que fizer login
            if (loginDao.validarLogin(fLogin, fSenha)) {
                return "/paginas/principal/principal_administrador.xhtml?faces-redirect=true";
            } else {
                FacesMessage fm = new FacesMessage("Login e/ou senha inválidos");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                fc.addMessage(null, fm);
                return null;
            }
        } else (fPerfil.equals("Aluno")){
            
      

        }

    }
*/
    public String registraSaida() {
        return "index.xhtml";
    }
}
