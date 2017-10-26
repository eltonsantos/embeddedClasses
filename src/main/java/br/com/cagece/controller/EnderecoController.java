package br.com.cagece.controller;

import br.com.cagece.model.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@SessionScoped
@ManagedBean(name="enderecoBean")
public class EnderecoController {
    
    @Inject
    private EntityManager manager;
    private Endereco endereco;
    
    public EnderecoController(){
        this.endereco = new Endereco();
    }
    
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