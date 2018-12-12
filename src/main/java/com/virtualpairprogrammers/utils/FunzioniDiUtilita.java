package com.virtualpairprogrammers.utils;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.NodeToNode;

/**
 * Contenitore di funzioni di utilità
 */
public class FunzioniDiUtilita {

	/**
	 * Stampa la la chat voluta esplorandola come un albero attraverso una semplice
	 * BFS
	 *
	 * @param list
	 * @param nodoInizio
	 * @param nodoFine
	 */
	public static void stampaChat(List<NodeToNode> list, Integer nodoInizio, Integer nodoFine) {

		/**
		 * Non vogliamo che il nodo iniziale e il nodo finale coincidano
		 */
		if (nodoInizio == nodoFine) {
			throw new RuntimeException("Non è possibile che nodoInizio e nodoFine coincidano");
		} else {
			/**
			 * Creiamo la lista dei nodi da visitare e la lista dei nodi visitati <br>
			 * NB: la lista "visitati" sarà la lista di ritorno rappresentante l'alberatura
			 * voluta
			 */
			final List<NodeToNode> daVisitareList = new ArrayList<>();
			final List<NodeToNode> visitati = new ArrayList<>();

			/**
			 * Mettiamo i nodi collegati al nodo iniziale nella lista dei nodi da visitare
			 */
			for (final NodeToNode NodeToNode : list) {
				if (NodeToNode.getFirstNodeId() == nodoInizio) {
					daVisitareList.add(NodeToNode);
					// System.out.println("Nodo iniziale: " + NodeToNode.getFirstNodeId());
					break;
				}
			}
			/**
			 * Contiuamo a iterare fintantoché la lista da visitare è vuota
			 */
			while (!daVisitareList.isEmpty()) {

				/**
				 * Scorriamo la lista dei nodi da visitare
				 */
				for (int i = 0; i < daVisitareList.size(); i++) {
					/**
					 * Scorriamo la lista dei nodi principale
					 */
					for (int j = 0; j < list.size(); j++) {

						/**
						 * Condizione (1) Cerchiamo quei nodi non ancora visitati che hanno il nodo
						 * padre della lista principale uguale al nodo figlio della vista daVistare
						 */
						if (daVisitareList.get(i).getSecondNodeId() == list.get(j).getFirstNodeId()
								&& !visitati.contains(list.get(j))) {
							/**
							 * Mettiamo nella lista dei visitati quei nodi daVisitare che non sono stati gia
							 * inseriti cosi evitiamo duplicati
							 */
							if (!visitati.contains(daVisitareList.get(i))) {
								visitati.add(daVisitareList.get(i));
							}
							/**
							 * aggiungiamo nella vista dei daVisitare quei nodi che rispettano la condizione
							 * (1)
							 */
							daVisitareList.add(list.get(j));
						}
					}
					/**
					 * Rimuoviamo il nodo appena visitato dalla lista dei daVisitare perchè
					 * completata l'analisi sul suddetto
					 */
					daVisitareList.remove(daVisitareList.get(i));

				}

			}
			/**
			 * Riesploriamo la lista principale alla ricerca dei nodi foglia
			 */
			for (final NodeToNode NodeToNode : list) {
				if (NodeToNode.getSecondNodeId() == nodoFine) {
					visitati.add(NodeToNode);
				}
			}
			/**
			 * Decommentare per debug
			 */
			// for (final NodeToNode NodeToNode : visitati) {
			// System.out.println("Nodo Padre: " + NodeToNode.getFirstNodeId());
			// System.out.println("Nodo Figlio: " + NodeToNode.getSecondNodeId());
			// }
		}
	}

}
