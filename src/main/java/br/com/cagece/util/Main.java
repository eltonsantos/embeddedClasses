package br.com.cagece.util;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("embeddedPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Elton");
        
        Endereco endereco1 = new Endereco();
        endereco1.setRua("Rua tal");
        endereco1.setCep("60410-072");
        endereco1.setCidade("Fortaleza");
        endereco1.setEstado("Ceará");
        endereco1.setUsuario(usuario1);
        
        //em.persist(usuario1);
        em.persist(endereco1);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        System.out.println("Usuario: " + usuario1.getNome());
        System.out.println("Rua: " + endereco1.getRua());
        System.out.println("CEP: " + endereco1.getCep());
        System.out.println("Cidade: " + endereco1.getCidade());
        System.out.println("Estado: " + endereco1.getEstado());
        
    }
    
}
