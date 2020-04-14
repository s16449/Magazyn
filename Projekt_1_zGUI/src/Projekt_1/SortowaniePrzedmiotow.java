package Projekt_1;

import java.util.Comparator;

public class SortowaniePrzedmiotow implements Comparator<Przedmiot> {

	public int compare(Przedmiot p1, Przedmiot p2) {
		if (p1.getWielkosc() != p2.getWielkosc()) {
			if (p1.getWielkosc() < p2.getWielkosc()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return p1.getNazwa().compareTo(p2.getNazwa());
		}
	}
}