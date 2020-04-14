package Projekt_1;

import java.util.ArrayList;

public class Pomieszczenie extends Thread {

	ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();

	private static int nrMag = 0;
	private boolean WYLACZENIE;
	private Integer rozmiarPomieszczenia;
	private int kopiaRozmiaru;
	private Integer nrPomieszczenia = nrMag;
	boolean widocznosc = true;
	boolean watek = false;
	Integer liczbaDni, dniDoKoncaWynajmu = 0;
	String dataWynajecia;

	public Pomieszczenie(int rozmiar) {
		rozmiarPomieszczenia = rozmiar;
		kopiaRozmiaru = rozmiarPomieszczenia;
		nrMag++;
		nrPomieszczenia = nrMag;

	}

	public Pomieszczenie(int dl, int szer, int wys) {
		rozmiarPomieszczenia = dl * szer * wys;
		kopiaRozmiaru = rozmiarPomieszczenia;
		nrMag++;
		nrPomieszczenia = nrMag;

	}

	public String toString() {
		return "Pomieszczenie nr: " + nrPomieszczenia + " ,o rozmiarze " + kopiaRozmiaru + " m3."
				+ "\nLiczba dni najmu: " + (liczbaDni == null ? "Pomieszczenie wolne" : liczbaDni + " dni.") + " "
				+ (dataWynajecia == null ? "" : "Data wynajecia: " + dataWynajecia) + "\nStan dostepnosci : "
				+ (widocznosc ? "Dostepne." : "W trakcie wynajmu.")
				+ (dniDoKoncaWynajmu != 0 ? "\nPozostalo jeszcze: " + dniDoKoncaWynajmu + " dni wynajecia." : "")
				+ "\n";
	}

	public String toStringToWrite() {
		return "Pomieszczenie nr: " + nrPomieszczenia + " o rozmiarze " + kopiaRozmiaru + " m3."
				+ " , Pomieszczenie najemca wynajal " + liczbaDni + " dni. " + " Data wynajecia: " + dataWynajecia
				+ " , Pozostalo jeszcze: " + dniDoKoncaWynajmu + " dni do konca wynajmu";
	}

	public void dodajPrzedmiot(Przedmiot p) throws TooManyThingsException {
		if (kopiaRozmiaru >= p.wielkoscPrzedmiotu) {
			listaPrzedmiotow.add(p);
			kopiaRozmiaru -= p.wielkoscPrzedmiotu;
		} else {
			throw new TooManyThingsException();
		}
	}

	public Integer getNumer() {
		return nrPomieszczenia;
	}

	public void setLiczbaDni(Integer liczba) {
		this.liczbaDni = liczba;
	}

	public int getLiczbaDni() {
		return liczbaDni;
	}

	public void wyswietlPrzedmioty() {
		System.out.println("Pomieszczenie nr " + nrPomieszczenia + "\nDostepna pojemnosc: " + kopiaRozmiaru
				+ " \nZawiera nastepujace przedmioty: ");
		listaPrzedmiotow.forEach(przedmioty -> System.out.println(przedmioty));
		System.out.println("Przedmiotow razem: " + listaPrzedmiotow.size() + "\n");
	}

	public int getRozmiar() {
		return kopiaRozmiaru;
	}

	public void run() {
		watek = true;
		while (watek) {
			this.dniDoKoncaWynajmu = this.liczbaDni;
			try {
				for (int i = 0; i < liczbaDni; i++) {
					widocznosc = false;
					Thread.sleep(10000);
					this.dniDoKoncaWynajmu--;
					if (this.dniDoKoncaWynajmu == 0 || this.watek == false) {
						this.dniDoKoncaWynajmu = 0;
						this.liczbaDni = null;
						this.dataWynajecia = null;
						this.watek = false;
						this.widocznosc = true;
						this.kopiaRozmiaru = rozmiarPomieszczenia;
						this.interrupt();
					}
				}
			} catch (Exception ex) {
				if (widocznosc == true) {
					System.out.println("Zwolnienie pomieszczenia " + nrPomieszczenia);
				}
			}
		}
	}

	public boolean sprawdzFlage() {
		return widocznosc;
	}

	public void setWatek(boolean ustaw) {
		watek = ustaw;
	}

	public void zmienRozmiar(Przedmiot pm) {
		kopiaRozmiaru -= pm.wielkoscPrzedmiotu;
	}

	public void zwrocRozmiar(int reduktor) {
		kopiaRozmiaru += reduktor;
	}
}