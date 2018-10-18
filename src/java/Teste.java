

import dao.AdministradorDao;
import entity.Administrador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joao
 */
public class Teste {

    public static void main(String[] args) throws ParseException {
        Administrador a = new Administrador();
        a.setCpf(1234567789);
        a.setEmail("teste@teste.com.br");
        a.setEndereco("teste");
        a.setNome("Teste");
        a.setRg(123456789);
        a.setSexo("Masculino");
        AdministradorDao ad = new AdministradorDao();
        ad.incluir(a);        
    }
}
