package com.virtualpairprogrammers.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import com.virtualpairprogrammers.dto.NodesDTO;

public class FunzioniDiUtilita {

	/**
	 * Crea un file xml contenente la lista dei nodi appartenenti ad una chat
	 * 
	 * @param list
	 * @return
	 */
	public static boolean printXML(List<NodesDTO> list) {

		/**
		 * Prendo un set di interi rappresentanti i padri
		 */
		Set<Integer> padri = new HashSet<>();
		for (NodesDTO node : list) {
			padri.add(node.getIdNodoPadre());
		}

		try {

			/**
			 * Creiamo il DOM XML
			 */
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			/**
			 * Elemento radice
			 */
			Element root = document.createElement("metabot");
			document.appendChild(root);

			/**
			 * Ciclo la lista dei padri e all'interno la lista della chat e appendo padre e
			 * figlio in maniera opportuna
			 */
			for (Integer padre : padri) {

				Element padreElement = document.createElement("Padre");
				root.appendChild(padreElement);
				Attr attr = document.createAttribute("id");
				attr.setValue("" + padre + "");
				padreElement.setAttributeNode(attr);

				for (NodesDTO nodeFiglio : list) {

					if (nodeFiglio.getIdNodoPadre() == padre) {
						Element figlioElement = document.createElement("Figlio");
						figlioElement.appendChild(
								document.createTextNode("" + nodeFiglio.getId() + ": " + nodeFiglio.getText() + ""));
						padreElement.appendChild(figlioElement);
					}
				}

			}

			/**
			 * Trasformo il DOM in un xml e lo streammo nel file.xml
			 */
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("albero.xml"));
			transformer.transform(domSource, streamResult);

			return true;
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();

		}

		return false;
	}

	/**
	 * Data una lista di nodi non ordinata, restituisce la lista ordinata secondo un
	 * algoritmo di BFS
	 * 
	 * @param list
	 * @param inizio
	 * @param fine
	 * @return
	 */
	public static List<NodesDTO> stampaChat(List<NodesDTO> list, int inizio, int fine) {

		final List<NodesDTO> daVisitareList = new ArrayList<>();
		final List<NodesDTO> visitati = new ArrayList<>();

		for (final NodesDTO node : list) {
			if (node.getIdNodoPadre() == inizio) {
				daVisitareList.add(node);
				// System.out.println("Nodo iniziale: " + node.getPadre());
				break;
			}
		}
		while (!daVisitareList.isEmpty()) {

			for (int i = 0; i < daVisitareList.size(); i++) {
				// System.out.println("Nodo Padre: " + daVisitareList.get(i).getPadre());

				for (int j = 0; j < list.size(); j++) {

					if (daVisitareList.get(i).getId() == list.get(j).getIdNodoPadre()
							&& !visitati.contains(list.get(j))) {

						if (!visitati.contains(daVisitareList.get(i))) {
							visitati.add(daVisitareList.get(i));
						}
						daVisitareList.add(list.get(j));
						// System.out.println("nodo padre di da visitare: " +
						// daVisitareList.get(i).getPadre());
						// System.out.println("Nodo Figlio: " + daVisitareList.get(i).getFiglio());

					}
				}
				daVisitareList.remove(daVisitareList.get(i));

			}

		}
//		for (final Node node : list) {
//			if (node.getFiglio() == fine) {
//				visitati.add(node);
//			}
//		}
		for (NodesDTO node : list) {
			boolean check = false;
			for (NodesDTO node2 : list) {
				if (node.getId() == node2.getIdNodoPadre() && node != node2)
					check = true;
			}
			if (!check)
				visitati.add(node);
		}

		/*
		 * for (final MessageDTO node : visitati) { System.out.println("Nodo Padre: " +
		 * node.getMessageFK().getMessageId()); System.out.println("Nodo Figlio: " +
		 * node.getMessageId()); }
		 */
		return visitati;
	}
}
