package br.edu.unijui.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {
    
    int id;
    String nome;
    int cpf;
    String endereco;
    String carro;
  
    
    
    public Pessoa(ResultSet resultSet) throws SQLException {
        this.id =  (int) resultSet.getObject(1);
        this.nome = (String) resultSet.getObject(2);
        this.cpf = (int) resultSet.getObject(3);
        this.endereco = (String) resultSet.getObject(4);
        this.carro = (String) resultSet.getObject(5);
        
    }

    public Pessoa() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

 
    
}
