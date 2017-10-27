package br.com.cagece.controller;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ViewScoped
@ManagedBean(name="enderecoBean")
public class EnderecoController implements Serializable {
    
    @Inject
    private EntityManager manager;
    private Endereco endereco;

    public EnderecoController(){
        this.endereco = new Endereco();
    }
    /*
    public List<Endereco> listarEnderecos(){
        return manager.createNativeQuery("SELECT * FROM usuario", Endereco.class).getResultList();
    }*/
    
    public String salvarEndereco(){
        manager.getTransaction().begin();
        manager.persist(endereco);
        manager.getTransaction().commit();
        manager.close();
        return "endereco?faces-redirect=true";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
        
}