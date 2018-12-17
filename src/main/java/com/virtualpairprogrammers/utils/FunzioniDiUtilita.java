package com.virtualpairprogrammers.utils;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.dto.MessageDTO;

public class FunzioniDiUtilita {

	public static List<MessageDTO> stampaChat(List<MessageDTO> list, int inizio, int fine) {

		final List<MessageDTO> daVisitareList = new ArrayList<>();
		final List<MessageDTO> visitati = new ArrayList<>();

		for (final MessageDTO node : list) {
			if (node.getMessageFK().getMessageId() == inizio) {
				daVisitareList.add(node);
				// System.out.println("Nodo iniziale: " + node.getPadre());
				break;
			}
		}
		while (!daVisitareList.isEmpty()) {

			for (int i = 0; i < daVisitareList.size(); i++) {
				// System.out.println("Nodo Padre: " + daVisitareList.get(i).getPadre());

				for (int j = 0; j < list.size(); j++) {

					if (daVisitareList.get(i).getMessageId() == list.get(j).getMessageFK().getMessageId()
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
		for (MessageDTO node : list) {
			boolean check =false;
			for (MessageDTO node2 : list) {
				if(node.getMessageId() == node2.getMessageFK().getMessageId() && node!=node2)
					check= true;
			}
			if(!check)
				visitati.add(node);
		}

/*		for (final MessageDTO node : visitati) {
			System.out.println("Nodo Padre: " + node.getMessageFK().getMessageId());
			System.out.println("Nodo Figlio: " + node.getMessageId());
		}*/
return visitati;
	}
}
