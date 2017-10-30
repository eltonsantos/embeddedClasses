package br.com.cagece.controller;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ViewScoped
@ManagedBean(name="usuarioBean")
public class UsuarioController implements Serializable {
    
    @Inject
    private EntityManager manager;
    private Usuario usuario;
    private Endereco endereco;
    
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
    
    public String executar(Usuario usuario){
       System.out.println("------------------- Passa aqui usuario: "+this.usuario);
       Integer u = usuario.getId();
       System.out.println("------------------- Passa aqui u: "+u);
       return "endereco?faces-redirect=true&usuarioId="+u;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    /*
    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }*/
    
}