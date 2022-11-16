package br.edu.unijui.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private String url;
    private String userName;
    private String password;
    private Connection connection;
    
    // banco de dados padrão
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/carros";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public DataBase(String url, String userName, String password) throws SQLException {
        this.url = url;
        this.userName = userName;
        this.password = password;
        //chama o método que estabelece a conexão
        setConnection();
    }

    public DataBase() throws SQLException {
        this.url = DATABASE_URL;
        this.userName = USERNAME;
        this.password = PASSWORD;
        //chama o método que estabelece a conexão
        setConnection();
    }

    private void setConnection() throws SQLException{
        try {
            //estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar o Banco de Dados. " + ex.getMessage());
        }
    }
            
    public Connection getConnection(){
      //retorna a conexão estabelecida com o banco de dados 
      return connection;
    } 
    
    public void close () throws SQLException{
        //encerra a conexão com o banco de dados
        connection.close();
    }
    
    /*métodos get e set para os demais atributos*/
    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
