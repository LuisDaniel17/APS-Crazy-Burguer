/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import Entidade.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisd
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "CrazyBurguerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

  
    
    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Boolean validaLogin(String email, String senha){
        
        List<Cliente> clientes;
        clientes =  em.createQuery("select c from Cliente as c where c.email = '" + email + "' and c.senha = '" + senha +"'").getResultList();
        
        if(clientes.isEmpty()){
            return false;
        }else{
            return true;
        }
        
    }


    
}
