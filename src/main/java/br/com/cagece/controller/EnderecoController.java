package br.com.cagece.controller;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ViewScoped
@ManagedBean(name="enderecoBean")
public class EnderecoController implements Serializable {
    
    @Inject
    private EntityManager manager;
    private Endereco endereco;
    private Usuario usuario;
    private Integer usuarioId;

    public EnderecoController(){
        this.endereco = new Endereco();
    }
    
    public List<Endereco> listarEnderecos(){
        return manager.createNativeQuery("SELECT * FROM endereco", Endereco.class).getResultList();
    }
    
    public String salvarEndereco(){
        manager.getTransaction().begin();
               
        System.out.println("--------------UsuarioId: " +this.usuario.getId());
        Usuario usuario = manager.find(Usuario.class, this.usuario.getId());
        System.out.println("------------------Usuario: " +usuario);
        this.endereco.setUsuario(usuario);
        usuario.setEndereco(this.endereco);
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

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
}