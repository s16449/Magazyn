package Projekt_1;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Magazyn1 {

	LinkedList<Pomieszczenie> listaPomieszczen = new LinkedList<>();
	LinkedList<Obecna> listaNajemcow = new LinkedList<>();
	HashMap<Obecna, LinkedList<Pomieszczenie>> listaMagazynu = new HashMap<>();
	Integer dniWynajmu;
	private Pomieszczenie pomieszczenie;
	private static Magazyn1 instancja = null;

	private Magazyn1() {
	};

	public static Magazyn1 getInstanceOf() {
		if (instancja == null) {
			instancja = new Magazyn1();
		}
		return instancja;
	}

	public void wyswietlPomieszczeniaMagazynu() {
		Collections.sort(listaPomieszczen, new SortowaniePomieszczenia());
		listaPomieszczen.forEach(lista -> System.out.println(lista));
	}

	public void dodajPomieszczenie(Pomieszczenie pm) {
		listaPomieszczen.add(pm);
	}

	public void dodajOsobe(Obecna ob, Integer dniWynajmu, Pomieszczenie pm) throws NeverRentException {
		pm.dataWynajecia = Data.localna;
		this.dniWynajmu = dniWynajmu;
		pomieszczenie = pm;
		if (ob.wynajecie != 0) {
			ob.wynajecie++;
			ob.listaPomieszczenNajemcow.add(pm);
			pm.setLiczbaDni(dniWynajmu);
			pm.widocznosc = true;
			try {
				pm.start();
			} catch (IllegalThreadStateException e) {
				System.out.println("Pomieszczenie nr. " + pm.getNumer() + " wynajete kolejny raz.");
			}
			for (int i = 0; i < ob.listaPomieszczenNajemcow.size(); i++) {
				if (ob.listaPomieszczenNajemcow.contains(pm)) {
					listaMagazynu.put(ob, ob.listaPomieszczenNajemcow);
				}
			}
		} else {
			listaNajemcow.add(ob);
			ob.wynajecie++;
			ob.listaPomieszczenNajemcow.add(pm);
			pm.setLiczbaDni(dniWynajmu);
			pm.widocznosc = true;
			try {
				if (!pm.isAlive())
					pm.start();
			} catch (IllegalThreadStateException e) {
				System.out.println("Pomieszczenie nr. " + pm.getNumer() + " wynajete kolejny raz.");
			}
			for (int i = 0; i < ob.listaPomieszczenNajemcow.size(); i++) {
				if (listaPomieszczen.contains(ob.listaPomieszczenNajemcow.get(i))) {
					listaMagazynu.put(ob, ob.listaPomieszczenNajemcow);
				}
			}
			throw new NeverRentException();
		}
	}

	public String toString() {
		return "Magazyn 1.\nIlosc pomieszczen: " + listaPomieszczen.size();
	}

	public void wyswietlListeNajemcow() {
		listaNajemcow.forEach(lista -> System.out.println(lista.toString()));
	}

	public void wyswietlListeMagazynu() {
		System.out.println("----- Lista Pomieszczen ----");
		for (Map.Entry<Obecna, LinkedList<Pomieszczenie>> entry : listaMagazynu.entrySet()) {
			System.out.println(entry.getKey() + "\n" + entry.getValue());
			System.out.println("---------------------------");
		}
	}

	public void wylacz() {
		for (Map.Entry<Obecna, LinkedList<Pomieszczenie>> entry : listaMagazynu.entrySet()) {
			entry.getKey().setSprawdzenieWatku(false);
			entry.getValue().listIterator().next().setWatek(false);
		}
	}

	public void zapisDanych() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("stanMagazynu.txt"));
			bw.write("!=-_Stan Magazynu_-=!");
			bw.newLine();
			bw.newLine();
			bw.write("Stan magazynowy na dzien " + Data.localna);
			bw.newLine();
			bw.newLine();
			bw.write("Dane najemcow: ");
			bw.newLine();

			for (Map.Entry<Obecna, LinkedList<Pomieszczenie>> entry : listaMagazynu.entrySet()) {
				bw.newLine();
				bw.write(entry.getKey().toStringToWrite());
				bw.newLine();
				bw.newLine();
				bw.write("------------Powyzszy najemca wynajmuje nastepujace pomieszczenia: ------------");
				bw.newLine();
				entry.getValue().forEach(new Consumer<Pomieszczenie>() {
					public void accept(Pomieszczenie pomieszczenia) {
						try {
							bw.newLine();
							bw.write(pomieszczenia.toStringToWrite());
							bw.newLine();
							if (!pomieszczenia.listaPrzedmiotow.isEmpty()) {
								bw.newLine();
								bw.newLine();
								bw.write("Pomieszczenie zawiera nastepujace przedmioty: ");
								bw.newLine();
								for (int i = 0; i < pomieszczenia.listaPrzedmiotow.size(); i++) {
									bw.newLine();
									bw.write(pomieszczenia.listaPrzedmiotow.get(i).toStringToWrite());
									bw.newLine();
								}
							}
							bw.newLine();
							bw.write("------------------------------------------------------------------------------");
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				if (!entry.getKey().tempList.isEmpty()) {
					bw.write("Posiada nastepujace przedmioty w tablicy tymczasowej: ");
					bw.write(entry.getKey().tempList.toString());
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}