package Projekt_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Obecna extends Osoba {

	Integer okresWynajmu;
	Integer wynajecie = 0;
	String dataPierwszegoNajmu;
	private boolean sprawdzanieWatku = true;
	private boolean usuwanie = true;
	ExecutorService es = Executors.newCachedThreadPool();
	LinkedList<Pomieszczenie> listaPomieszczenNajemcow = new LinkedList<>();
	ArrayList<Przedmiot> tempList = new ArrayList<>();
	int dniTempListy = 0;

	public Obecna(String imie, String nazwisko, String pesel, String adresZamieszkania, String dataUrodzenia,
			String dataPierwszegoNajmu) {
		super(imie, nazwisko, pesel, adresZamieszkania, dataUrodzenia, dataPierwszegoNajmu);

	}

	public Obecna(Osoba o) {
		super(o.imie, o.nazwisko, o.pesel, o.adresZamieszkania, o.dataUrodzenia, o.dataPierwszegoNajmu);
		Runnable usuniecieWynajmu = () -> {

			while (sprawdzanieWatku) {
				try {
					Thread.sleep(100);
					for (int i = 0; i < listaPomieszczenNajemcow.size(); i++) {
						
						if (listaPomieszczenNajemcow.get(i).sprawdzFlage() == true) {

							if (listaPomieszczenNajemcow.get(i).listaPrzedmiotow.isEmpty()) {
								listaPomieszczenNajemcow.remove(i);
							} else if (!listaPomieszczenNajemcow.get(i).listaPrzedmiotow.isEmpty()) {
								for (int j = 0; j < listaPomieszczenNajemcow.get(i).listaPrzedmiotow.size(); j++) {
									tempList.add(listaPomieszczenNajemcow.get(i).listaPrzedmiotow.get(j));
									listaPomieszczenNajemcow.get(i).listaPrzedmiotow.remove(j);
									if (listaPomieszczenNajemcow.get(i).listaPrzedmiotow.isEmpty())
										listaPomieszczenNajemcow.remove(i);
								}
							}
						}
					}
					if (sprawdzanieWatku == false) {
						this.es.shutdown();
					}
				} catch (Exception e) {
					System.out.println("Zapis do tablicy tymczasowej.");
				}
			}
		};
		es.execute(usuniecieWynajmu);
	}

	public void wyswietlListePomieszczenNajemcow() {
		Collections.sort(listaPomieszczenNajemcow, new SortowaniePomieszczenia());
		listaPomieszczenNajemcow.forEach(lista -> System.out.println(lista.toString()));
	}

	public String toStringToWrite() {
		return "Imie: " + imie + " Nazwisko: " + nazwisko + " , Nr pesel: " + pesel + " , Adres zamieszkania: "
				+ adresZamieszkania + " , Data urodzenia: " + dataUrodzenia;
	}
	public String toStringDane()
	{
		return imie + " " + nazwisko + " , Nr pesel: " + pesel;
	}
	public String toStringAdres()
	{
		return adresZamieszkania;
	}

	public void wyswietlZawartoscPomieszczen() {
		for (Pomieszczenie lista : listaPomieszczenNajemcow) {
			System.out.println(lista.listaPrzedmiotow.toString());
		}
	}

	public void setSprawdzenieWatku(boolean ustaw) {
		sprawdzanieWatku = ustaw;
	}

	public void shutdown() {
		es.shutdown();
	}

	public void setUsuwanie(boolean flaga) {
		usuwanie = flaga;
	}

	public boolean getUsuwanie() {
		return usuwanie;
	}

}