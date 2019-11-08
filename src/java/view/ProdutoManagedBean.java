
package view;


import javax.inject.Named;
import javax.enterprise.context.Dependent;
import Entidade.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessao.ProdutoFacade;

@ManagedBean(name = "produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean implements Serializable {
    @EJB
    private ProdutoFacade produtoFacade;
    private Produto produto;
    private List<Produto> ingredientes;
    private Double vrtotal;
 
    
    public ProdutoManagedBean() {
        produto = new Produto();
        ingredientes = new ArrayList<Produto>();
        vrtotal = 0D;
        
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void buscarDesc(){
        this.produto = this.produtoFacade.buscaProduto(produto.getDescProduto());
    }
    
    public void adicionaIngredientes(){
        vrtotal = vrtotal + produto.getPreco().doubleValue();
        ingredientes.add(produto);
        produto = new Produto();
    }

    public Double getVrtotal() {
        return vrtotal;
    }

    public void setVrtotal(Double vrtotal) {
        this.vrtotal = vrtotal;
    }

    public List<Produto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Produto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    
}
