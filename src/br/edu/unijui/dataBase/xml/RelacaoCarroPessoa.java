/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.xml;

import br.edu.unijui.dataBase.Carro;
import br.edu.unijui.dataBase.Pessoa;


public class RelacaoCarroPessoa {
    
    public Carro carro;
    public Pessoa pessoa;

    public RelacaoCarroPessoa(Carro carro, Pessoa pessoa) {
        this.carro = carro;
        this.pessoa = pessoa;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
}
