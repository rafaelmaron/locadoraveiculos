/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.xml;

import br.edu.unijui.dataBase.Pessoa;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Rafael
 */
public class CriarXml {
    
    public static void criarXml(List<RelacaoCarroPessoa> listaPessoas) throws TransformerException{
        
             
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            Document documentoXML = documentBuilder.newDocument();
            
            Element pessoas = documentoXML.createElement("pessoas");
            documentoXML.appendChild(pessoas);
            
            
            for(RelacaoCarroPessoa p: listaPessoas){
           
            Element pessoa = documentoXML.createElement("pessoa");
           
            Attr id = documentoXML.createAttribute("id");
            id.setValue(String.valueOf(p.getPessoa().getId()));
            pessoa.setAttributeNode(id);

            pessoas.appendChild(pessoa);
     
            Element nome = documentoXML.createElement("nome");
            nome.appendChild(documentoXML.createTextNode(p.getPessoa().getNome()));
            pessoa.appendChild(nome);
            
            Element placa = documentoXML.createElement("placaCarro");
            placa.appendChild(documentoXML.createTextNode(p.getCarro().getPlaca()));
            pessoa.appendChild(placa);
                 
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource documentoFonte = new DOMSource(documentoXML);
            
            StreamResult documentoFinal = new StreamResult(new File("C:\\XML\\data.xml"));
            
            transformer.transform(documentoFonte, documentoFinal);
                    
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CriarXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CriarXml.class.getName()).log(Level.SEVERE, null, ex);
        }

    }            
 }
    
    

