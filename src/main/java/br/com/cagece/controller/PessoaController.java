/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cagece.controller;

import br.com.cagece.model.Pessoa;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pessoaBean")
public class PessoaController {
    
    private Pessoa pessoa = new Pessoa();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
