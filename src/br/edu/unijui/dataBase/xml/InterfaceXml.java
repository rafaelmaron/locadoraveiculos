/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.unijui.dataBase.xml;

import br.edu.unijui.dataBase.Carro;
import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Painel;
import br.edu.unijui.dataBase.Pessoa;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Rafael
 */
public class InterfaceXml extends javax.swing.JFrame {
    
    
    DataBase db;

    /**
     * Creates new form InterfaceXml
     */
    public InterfaceXml() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtGerarXML = new javax.swing.JButton();
        jbtAbrirXML = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtGerarXML.setText("Gerar Tabela XML");
        jbtGerarXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtGerarXMLMouseClicked(evt);
            }
        });

        jbtAbrirXML.setText("Abrir Aqruivo XML");
        jbtAbrirXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAbrirXMLMouseClicked(evt);
            }
        });

        tabelaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Placa"
            }
        ));
        jScrollPane1.setViewportView(tabelaP);

        jLabel1.setText("XML Pessoas e Carros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtGerarXML)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtAbrirXML))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel1)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAbrirXML)
                    .addComponent(jbtGerarXML))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtGerarXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtGerarXMLMouseClicked
        
          try {
            /*Cria um objeto da classe DataBase para estabelecer uma conexão 
              com o banco de dados
             */
            db = new DataBase();

            Painel pn = new Painel();
            
            ArrayList lista = new ArrayList<RelacaoCarroPessoa>();
            
            //verifica se a conexão foi estabelecida
            if (db.getConnection() != null) {
                // Instanciando o objeto preparedStatement (pstmt)
                PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT pessoa.nome, carro.placa FROM pessoa JOIN carro ON pessoa.id=carro.ID");
  
                // Executando a consulta
                ResultSet resultSet = pstmt.executeQuery();
                //Obtém os metadados do resultado
                ResultSetMetaData metaData = resultSet.getMetaData();
                //monta as colunas de resultado
                int numberOfColumns = metaData.getColumnCount();
                System.out.println("clientes:");
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                }
               
                //percorre os dados retornados pela consulta exibindo-os               
                while (resultSet.next()) {
                    
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(resultSet.getString("nome"));
               
                Carro carro = new Carro();
                carro.setPlaca(resultSet.getString("placa"));
                
                RelacaoCarroPessoa relacao = new RelacaoCarroPessoa(carro, pessoa);
                lista.add(relacao);
                
                }               
                CriarXml.criarXml(lista);

                resultSet.close();
                pstmt.close();
                //encerra a conexão com o banco de dados
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Painel.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
         
        
          



    }//GEN-LAST:event_jbtGerarXMLMouseClicked

    private void jbtAbrirXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAbrirXMLMouseClicked
        // TODO add your handling code here:
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document doc = builder.parse("C:\\XML\\data.xml");
            
            NodeList listaDePessoas = doc.getElementsByTagName("pessoa");
            
            int tamanhoLista = listaDePessoas.getLength();
            
            for (int i = 0; i < tamanhoLista; i++) {
                    
                Node noPessoa = listaDePessoas.item(i);
                 
                if(noPessoa.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoPessoa = (Element) noPessoa;
                    
                    
                    String id = elementoPessoa.getAttribute("id");
                    
                    System.out.println("ID = " + id);
                    
                    NodeList listadeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    
                    int tamanhoListaFilho = listadeFilhosDaPessoa.getLength();
                    
                    DefaultTableModel dtmTabela = (DefaultTableModel) tabelaP.getModel();
                    
                    for (int j =0; j < tamanhoListaFilho; j++) {
                        Node noFilho = listadeFilhosDaPessoa.item(j);
                        
                        if(noFilho.getNodeType() == Node.ELEMENT_NODE){
                            Element elementoFilho = (Element) noFilho;
                            
                          System.out.println("000000 = " + elementoFilho.getAttribute("joao"));
                          
                            String nome = "placeholder", placa = "placeholder";
                            switch(elementoFilho.getTagName()) {
                             case "nome":
                                nome =  elementoFilho.getTextContent();
                                System.out.println("NOME = " + nome);
                                break;
                              
                            case "placaCarro":
                                placa = elementoFilho.getTextContent();
                                System.out.println("PLACA = " +placa);                                               
                                break;                       
                        }                           
                            Object[] dados = {nome, placa}; 
                            dtmTabela.addRow(dados);  
                        }
                    }
                }
            }
            
            
            
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
   
    }//GEN-LAST:event_jbtAbrirXMLMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceXml().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAbrirXML;
    private javax.swing.JButton jbtGerarXML;
    private javax.swing.JTable tabelaP;
    // End of variables declaration//GEN-END:variables
}
