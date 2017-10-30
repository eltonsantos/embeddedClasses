package br.com.cagece.util;

import br.com.cagece.model.Endereco;
import br.com.cagece.model.Usuario;

public class Main {
    
    public static void main(String[] args) {
        
        
        Usuario u = new Usuario();
        u.setNome("Elton");
        
        Endereco e = new Endereco();
        e.setRua("Rua tal");
        e.setCep("123456789");
        e.setCidade("Fortaleza");
        e.setEstado("Ceará");
        e.setUsuario(u);
        
        
        System.out.println("Salvo");
    }
    
}
