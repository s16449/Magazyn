package Projekt_1;

import java.util.Comparator;

public class SortowaniePomieszczenia implements Comparator<Pomieszczenie> {

	public int compare(Pomieszczenie pm1, Pomieszczenie pm2) {
		if (pm1.getRozmiar() > pm2.getRozmiar()) {
			return 1;
		} else {
			return -1;
		}
	}
}