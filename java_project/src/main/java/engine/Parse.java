import java.util.List;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
/**
 * Classe que retira as informações dos snapshots e as insere nas estruturas criadas.
 */
public class Parse{

	/**
	 * Construtores
	 */

    /**
	 * Construtor vazio que cria uma instância Parse
	 */
	public Parse(){}

	/**
	 * Métodos de Instância
	 */

	/**
	 * Método que conta o número de palavras contidas num determinado texto 
	 *
	 * @param texto	  O texto em questão
	 * @return   O número total de palavras
	 */
	public long contaPalavras(String texto){
        return 0; //FAZEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER
	}

	/**
	 * Método auxiliar de "parse" que faz parse de um documento
	 *
	 * @param docname	Nome do documento
	 * @param est 		Estrutura onde será inserida a informação
	 * @return			Uma cópia da estrutura com a informação inserida
	 */
	public Estruturas parseDoc(String docname, Estruturas est){
		int idEncontrados = 0;
      	boolean pageConteudo = false, title = false, idArt = false, idRev = false, idCont = false, nomeCont = false, timestp = false, text = false;
      	long nrPages = 0, idArtigo = 0, idContribuidor = -1, idRevisao = 0, nrChars = 0, nrPalavras = 0;
      	String titulo = " ", nomeContribuidor = " ", timestamp = " ", texto = " ";

      	try {
         	XMLInputFactory factory = XMLInputFactory.newInstance();
         	XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(docname));

            while(eventReader.hasNext()){
               XMLEvent event = eventReader.nextEvent();
               switch(event.getEventType()){
                  	case XMLStreamConstants.START_ELEMENT:
                     	StartElement startElement = event.asStartElement();
                     	String qName = startElement.getName().getLocalPart();
                     	if(qName.equalsIgnoreCase("page")) {
                        	nrPages++;
                     	}
                     	else if(qName.equalsIgnoreCase("title")) {
                       		title = true;
                       		pageConteudo = true;
                     	}  
                    	 else if(qName.equalsIgnoreCase("id") && idEncontrados == 0) {
                     		idEncontrados++;
                     		idArt = true;
                    	}
                     	else if(qName.equalsIgnoreCase("id") && idEncontrados == 1) {
                     		idEncontrados++;
                     		idRev = true;
                    	} 
                     	else if(qName.equalsIgnoreCase("timestamp")) {
                        	timestp = true;
                     	}
                     	else if(qName.equalsIgnoreCase("username")) {
                        	nomeCont = true;
                     	}
                     	else if(qName.equalsIgnoreCase("id") && idEncontrados == 2) {
                     		idCont = true;
                     	}
                     	else if(qName.equalsIgnoreCase("text")) {
                        	text = true;
                     	}
                     	break;

                  	case XMLStreamConstants.CHARACTERS:
                     	Characters characters = event.asCharacters();

                     	if(title){
                        	titulo = characters.getData();
                        	title = false;
                     	}
                     	if(idArt){
                        	idArtigo = new Long(characters.getData()); 
                        	idArt = false;
                     	}
                     	if(idRev){
                        	idRevisao = new Long(characters.getData()); 
                        	idRev = false;

                     	}
                     	if(timestp){
                        	timestamp = characters.getData(); 
                        	timestp = false;
                     	}
                     	if(nomeCont){
                        	nomeContribuidor = characters.getData();
                        	nomeCont = false;
                     	}
                     	if(idCont){
                        	idContribuidor = new Long(characters.getData()); 
                        	idCont = false;
                     	}
                     	if(text){
                        	texto = characters.getData();
                        	nrChars = texto.length();
                        	nrPalavras = contaPalavras(texto);
                        	text = false;
                     	}
                     	break;
      
                  	case  XMLStreamConstants.END_ELEMENT:
                     	EndElement endElement = event.asEndElement();
                     	if(endElement.getName().getLocalPart().equalsIgnoreCase("page")){
                        	if(pageConteudo){
                           		est.adicionaRevisao(idRevisao, timestamp);
                           		est.renovaArtigo(idArtigo, titulo, nrChars, nrPalavras);
                           		if(idContribuidor != -1) est.renovaContribuidor(idContribuidor, nomeContribuidor);
                           		pageConteudo = false;
                         	}

                         	idEncontrados = 0;
                         	idContribuidor = -1;
                     	}
                     	break;
               	}         
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }

		est.aumentaPages(nrPages);
		return est.clone();
	}

	/**
	 *Método que faz parse dos snapshots
	 *
	 * @param nsnaps			O número de snapshots passados
	 * @param snaps_paths	O nome dos snapshots passados
	 */
	public Estruturas parseSnaps(int nsnaps, ArrayList<String> snaps_paths){
		Estruturas est = new Estruturas();

		for(String docname: snaps_paths){
			est = parseDoc(docname, est);
		}

		return est.clone();
	}
}
