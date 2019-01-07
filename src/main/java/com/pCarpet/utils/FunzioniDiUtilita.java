package com.pCarpet.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.pCarpet.dto.NodoDTO;

public class FunzioniDiUtilita {

	/**
	 * Crea un file xml contenente la lista dei nodi appartenenti ad una chat
	 * 
	 * @param list
	 * @return
	 */
//	public static boolean printXML(List<NodesDTO> list) {
//
//		/**
//		 * Prendo un set di interi rappresentanti i padri
//		 */
//		final Set<Integer> padri = new HashSet<>();
//		for (final NodesDTO node : list) {
//			padri.add(node.getIdNodoPadre());
//		}
//
//		try {
//
//			/**
//			 * Creiamo il DOM XML
//			 */
//			final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
//			final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
//			final Document document = documentBuilder.newDocument();
//
//			/**
//			 * Elemento radice
//			 */
//			final Element root = document.createElement("metabot");
//			document.appendChild(root);
//
//			/**
//			 * Ciclo la lista dei padri e all'interno la lista della chat e appendo padre e
//			 * figlio in maniera opportuna
//			 */
//			for (final Integer padre : padri) {
//
//				final Element padreElement = document.createElement("Padre");
//				root.appendChild(padreElement);
//				final Attr attr = document.createAttribute("id");
//				attr.setValue("" + padre + "");
//				padreElement.setAttributeNode(attr);
//
//				for (final NodesDTO nodeFiglio : list) {
//
//					if (nodeFiglio.getIdNodoPadre() == padre) {
//						final Element figlioElement = document.createElement("Figlio");
//						figlioElement.appendChild(
//								document.createTextNode("" + nodeFiglio.getId() + ": " + nodeFiglio.getText() + ""));
//						padreElement.appendChild(figlioElement);
//					}
//				}
//
//			}
//
//			/**
//			 * Trasformo il DOM in un xml e lo streammo nel file.xml
//			 */
//			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			final Transformer transformer = transformerFactory.newTransformer();
//			final DOMSource domSource = new DOMSource(document);
//			final StreamResult streamResult = new StreamResult(new File("albero.xml"));
//			transformer.transform(domSource, streamResult);
//
//			return true;
//		} catch (final ParserConfigurationException pce) {
//			pce.printStackTrace();
//		} catch (final TransformerException tfe) {
//			tfe.printStackTrace();
//
//		}
//
//		return false;
	// }

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
}
