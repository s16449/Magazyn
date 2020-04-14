package Projekt_1;

public class Przedmiot {

	String nazwaPrzedmiotu;
	int wielkoscPrzedmiotu;
	int nrPrzedmiotu;

	public Przedmiot(String nazwaPrzedmiotu, int wielkoscPrzedmiotu) {
		this.nazwaPrzedmiotu = nazwaPrzedmiotu;
		this.wielkoscPrzedmiotu = wielkoscPrzedmiotu;

	}

	public Przedmiot(String nazwaPrzedmiotu, int dl, int szer, int wys) {
		this.nazwaPrzedmiotu = nazwaPrzedmiotu;
		this.wielkoscPrzedmiotu = dl * szer * wys;
	}

	public String toString() {
		return "Przedmiot: " + nazwaPrzedmiotu + "\nWielkosc przedmiotu: " + wielkoscPrzedmiotu;
	}

	public String toStringToWrite() {
		return "Przedmiot: " + nazwaPrzedmiotu + " , Wielkosc przedmiotu: " + wielkoscPrzedmiotu;
	}

	public String getNazwa() {
		return nazwaPrzedmiotu;
	}

	public int getWielkosc() {
		return wielkoscPrzedmiotu;
	}
}