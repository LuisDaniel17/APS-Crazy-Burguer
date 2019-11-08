/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entidade.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.ClienteFacade;

/**
 *
 * @author luisd
 */
@ManagedBean(name="login")
@SessionScoped

public class LoginManagedBean implements Serializable{
    
   @EJB
   private ClienteFacade clienteFacade;
   private Cliente cliente;

    public Cliente getCliente() {
        
        if(cliente == null){
            cliente = new Cliente();
        }
        
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
   
    private String email;
    private String senha;
    

    


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String vslida(){
        Boolean verdadeFalso = clienteFacade.validaLogin(email, senha);
        
        if(verdadeFalso){
            return "FacaSeuPedido";
        }
        else{
            return "LoginIncorreto";
        }
    }
    
    
}
