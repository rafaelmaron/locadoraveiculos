package br.edu.unijui.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro {
    
    
    int id;
    String marca;
    String modelo;
    int ano;
    String placa;
    int locadoraID;
    String status;
    int pessoaID;

    public Carro(ResultSet resultSet) throws SQLException {
        this.id =  (int) resultSet.getObject(1);
        this.marca = (String) resultSet.getObject(2);
        this.modelo = (String) resultSet.getObject(3);
        this.ano = (int) resultSet.getObject(4);
        this.placa = (String) resultSet.getObject(5);
        this.locadoraID = (int) resultSet.getObject(6);
        this.status = (String) resultSet.getObject(7);
        this.pessoaID = (Integer) resultSet.getObject(8);
    }

    public Carro() {
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getLocadoraID() {
        return locadoraID;
    }

    public void setLocadoraID(int locadoraID) {
        this.locadoraID = locadoraID;
    }
    
}
