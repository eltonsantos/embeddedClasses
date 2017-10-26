package br.com.cagece.controller;

import br.com.cagece.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ViewScoped
@ManagedBean(name="usuarioBean")
public class UsuarioController implements Serializable {
    
    @Inject
    private EntityManager manager;
    private Usuario usuario;
    
    public UsuarioController(){
        this.usuario = new Usuario();
    }
    
    public List<Usuario> listarUsuarios(){
        return manager.createNativeQuery("SELECT * FROM usuario", Usuario.class).getResultList();
    }
    
    public String salvarUsuario(){
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
        return "index?faces-redirect=true";
    }
    
    public String executar(){
        
        return "endereco?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}