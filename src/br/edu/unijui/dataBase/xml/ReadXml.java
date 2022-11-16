/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.xml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Rafael
 */
public class ReadXml {
    
    public static void lerXml() {
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
                    
                    
                    for (int j =0; j < tamanhoListaFilho; j++) {
                        Node noFilho = listadeFilhosDaPessoa.item(j);
                        
                        if(noFilho.getNodeType() == Node.ELEMENT_NODE){
                            Element elementoFilho = (Element) noFilho;
                            
                            switch(elementoFilho.getTagName()) {
                            
                            case "nome":
                                System.out.println("NOME = " + elementoFilho.getTextContent());
                                                                                        
                                break;
     
                        }
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
        
    }
    
    
}
