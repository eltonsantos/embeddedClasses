package br.com.cagece.controller;

import br.com.cagece.model.Usuario;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ManagedBean(name = "usuarioBean")
public class UsuarioController implements Serializable {
    
    @Inject
    private EntityManager manager;
    private Usuario usuario;
    
    public String salvarUsuario(){
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
        return "index?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}