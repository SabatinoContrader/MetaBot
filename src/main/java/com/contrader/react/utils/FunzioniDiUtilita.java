package com.contrader.react.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.contrader.react.dto.NodoDTO;

public class FunzioniDiUtilita {

	/**
	 * Data una lista di nodi non ordinata, restituisce la lista ordinata secondo un
	 * algoritmo di BFS
	 * 
	 * @param list
	 * @param inizio
	 * @param fine
	 * @return
	 */
	public static List<NodoDTO> recuperaAlberoOrdinato(List<NodoDTO> list, int inizio) {

		final List<NodoDTO> daVisitareList = new ArrayList<>();
		final List<NodoDTO> visitati = new ArrayList<>();

		list.forEach(i -> {
			if (i.getIdNodo() == inizio) {
				daVisitareList.add(i);
				visitati.add(i);
			}
		});
		// list.remove(daVisitareList.get(0));

		while (!daVisitareList.isEmpty()) {

			for (int i = 0; i < daVisitareList.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getNodoPadre() != null) {
						if (daVisitareList.get(i).getIdNodo() == list.get(j).getNodoPadre().getIdNodo()
								&& !visitati.contains(list.get(j))) {
							if (!visitati.contains(daVisitareList.get(i))) {
								visitati.add(daVisitareList.get(i));
							}
							daVisitareList.add(list.get(j));
						}
					}
				}
				daVisitareList.remove(daVisitareList.get(i));
			}
		}

		// Metto listIterator perchè da un java.util.ConcurrentModificationException:
		// null se provo ad aggiungere o togliere elementi mentre itero la collection
		for (final ListIterator<NodoDTO> iterator = visitati.listIterator(); iterator.hasNext();) {
			final NodoDTO nodoVisitati = iterator.next();
			for (final NodoDTO nodoLista : list) {

				if (nodoLista.getNodoPadre() != null) {

					if (!visitati.contains(nodoLista)
							&& nodoLista.getNodoPadre().getIdNodo() == nodoVisitati.getIdNodo()) {
						iterator.add(nodoLista);
					}
				}
			}
		}

		// la lista che ritorna è ordinata per profondità
		return visitati;
	}

	/**
	 * Crea un file xml contenente la lista dei nodi appartenenti ad una chat
	 * 
	 * @param list
	 * @return
	 */

	public static boolean printXML(Integer idChat, List<NodoDTO> list, String pathCompleto) {

		/**
		 * Prendo un set di interi rappresentanti i padri
		 */

		final Set<Integer> padri = new HashSet<>();
		for (final NodoDTO node : list) {
			if (node.getNodoPadre() != null) {
				padri.add(node.getNodoPadre().getIdNodo());
			} else {
				padri.add(0);
			}
		}

		try {

			/**
			 * Creiamo il DOM XML
			 */
			final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			final Document document = documentBuilder.newDocument();

			/**
			 * Elemento radice
			 */
			final Element root = document.createElement("Chat");
			document.appendChild(root);
			Attr attr = document.createAttribute("id");
			attr.setValue("" + idChat + "");
			root.setAttributeNode(attr);

			// System.out.println("document: " + document);
			/**
			 * Ciclo la lista dei padri e all'interno la lista della chat e appendo padre e
			 * figlio in maniera opportuna
			 */
			for (final Integer padre : padri) {

				final Element padreElement = document.createElement("Padre");
				root.appendChild(padreElement);
				attr = document.createAttribute("id");
				attr.setValue("" + padre + "");
				padreElement.setAttributeNode(attr);

				for (final NodoDTO nodeFiglio : list) {
					if (nodeFiglio.getNodoPadre() != null) {
						if (nodeFiglio.getNodoPadre().getIdNodo() == padre) {

							final Element figlioElement = document.createElement("Figlio");

							figlioElement.appendChild(document.createTextNode("" + nodeFiglio.getText() + ""));
							padreElement.appendChild(figlioElement);
							attr = document.createAttribute("id");
							attr.setValue("" + nodeFiglio.getIdNodo() + "");
							figlioElement.setAttributeNode(attr);
						}
					} else {
						if (0 == padre) {
							final Element figlioElement = document.createElement("Figlio");

							figlioElement.appendChild(document.createTextNode("" + nodeFiglio.getText() + ""));
							padreElement.appendChild(figlioElement);
							attr = document.createAttribute("id");
							attr.setValue("" + nodeFiglio.getIdNodo() + "");
							figlioElement.setAttributeNode(attr);
						}
					}
				}

			}
			// System.out.println("padre: " + document);
			/**
			 * Trasformo il DOM in un xml e lo streammo nel file.xml
			 */
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource domSource = new DOMSource(document);
			final StreamResult streamResult = new StreamResult(new File(pathCompleto));
			// System.out.println("streamResult: " + streamResult);
			transformer.transform(domSource, streamResult);

			return true;
		} catch (final ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (final TransformerException tfe) {
			tfe.printStackTrace();

		}

		return false;
	}

	/**
	 * inserito il pathCompleto per recuperare il file opportuno
	 * 
	 * @param pathCompleto
	 * @return
	 */
	public static Integer readXML(String pathCompleto) {

		Integer retorno = 0;
		try {
			final File fXmlFile = new File(pathCompleto);
			final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			final Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			final Node nNode = doc.getFirstChild();
			final Element eElement = (Element) nNode;
			retorno = Integer.parseInt(eElement.getAttribute("id"));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
