/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import Entidade.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author luisd
 */
@Stateless
public class ProdutoFacade extends AbstractFacade<Produto> {

    @PersistenceContext(unitName = "CrazyBurguerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }
    
    public Produto buscaProduto(String descProduto){
        TypedQuery query = em.createNamedQuery("Produto.findByDescProduto", Produto.class );
        query.setParameter("descProduto", descProduto);
        Produto p = (Produto)query.getSingleResult();
        System.out.println("Teste:"+p.getDescProduto());
        return p;
    }
    public void bucarTodos()
    {
        TypedQuery query = em.createNamedQuery("Produto.findAll", Produto.class);
        List<Produto> lista = query.getResultList();
        for(Produto l : lista)
            System.out.println("item:"+l.getDescProduto());
                
    }
}
