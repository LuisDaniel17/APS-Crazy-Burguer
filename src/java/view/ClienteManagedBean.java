/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entidade.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
//import javax.ejb.EJB;
//import javax.ejb.Init;
//import javax.inject.Named;
import javax.faces.bean.ManagedBean;
///import javax.faces.bean.RequestScoped;
import sessao.ClienteFacade;

/**
 *
 * @author luisd
 */
//@Named(value = "clienteManagedBean")
//@RequestScoped
@ManagedBean(name = "clienteManagedBean")
public class ClienteManagedBean implements Serializable{

   @EJB
   private ClienteFacade clienteFacade;
   private Cliente cliente;
   
   public String nome;
   
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
   

  

    public Cliente getCliente() {
        
        if(cliente == null){
        
        cliente = new Cliente();
            
        }
        return cliente;
    }
    
    public String inserir(){
    
    this.clienteFacade.create(cliente);
    return null;
        
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
   
   
    public ClienteManagedBean() {
        cliente = new Cliente();
    }
    
    
    
  
    
}
