package br.com.cagece.controller;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private Usuario usuario = new Usuario();
    private Integer usuarioId;
    /*
    @PostConstruct
    public void init(){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();  
        this.usuario = new Usuario();
    }
    */
    public EnderecoController(){
        this.endereco = new Endereco();
    }
    
    public List<Endereco> listarEnderecos(){
        return manager.createNativeQuery("SELECT * FROM endereco", Endereco.class).getResultList();
    }
    
    public String salvarEndereco(){
        System.out.println("--------------ENTRA AQUI");
        manager.getTransaction().begin();
               
        System.out.println("--------------UsuarioId: " +this.usuarioId);
        Usuario usu = manager.find(Usuario.class, this.usuarioId);
        System.out.println("------------------Usuario: " +usu);
        this.endereco.setUsuario(usu);
        usu.setEndereco(this.endereco);
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