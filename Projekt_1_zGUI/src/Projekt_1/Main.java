package Projekt_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javafx.scene.input.MouseButton;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NeverRentException {
		Data data = new Data("Data Lokalna", true);
		System.out.println(data.toString());
		GuiProject1 app = new GuiProject1();
		Scanner keyboard = new Scanner(System.in);
		boolean uruchomiony = true;
		Obecna obec = null;
		String wpis = null, wybor = null, wybor2 = null;
		Magazyn1 magazyn1 = Magazyn1.getInstanceOf();
		ExecutorService es = Executors.newCachedThreadPool();
		LinkedList<Przedmiot> listaPrzedmiotowDoDodania = new LinkedList<>();
		Pomieszczenie pm1 = new Pomieszczenie(12, 43, 21);
		Pomieszczenie pm2 = new Pomieszczenie(2382);
		Pomieszczenie pm3 = new Pomieszczenie(32, 22, 21);
		Pomieszczenie pm4 = new Pomieszczenie(23, 13, 233);
		Pomieszczenie pm5 = new Pomieszczenie(1322);
		Pomieszczenie pm6 = new Pomieszczenie(23, 43, 23);
		Pomieszczenie pm7 = new Pomieszczenie(4000);
		Pomieszczenie pm8 = new Pomieszczenie(10, 20, 23);
		Pomieszczenie pm9 = new Pomieszczenie(12, 122, 21);
		Pomieszczenie pm0 = new Pomieszczenie(223, 32, 23);
		Przedmiot telewizor = new Przedmiot("telewizor", 30);
		Przedmiot rower = new Przedmiot("rower", 50);
		Przedmiot klatka = new Przedmiot("klatka", 285);
		Przedmiot samochod = new Przedmiot("samochod", 1000);
		Przedmiot kuber = new Przedmiot("kontener", 30, 30, 9);
		Przedmiot kuaer = new Przedmiot("kufer", 3, 10, 9);
		listaPrzedmiotowDoDodania.add(telewizor);
		listaPrzedmiotowDoDodania.add(samochod);
		listaPrzedmiotowDoDodania.add(rower);
		listaPrzedmiotowDoDodania.add(klatka);
		listaPrzedmiotowDoDodania.add(kuber);
		listaPrzedmiotowDoDodania.add(kuaer);
		Collections.sort(listaPrzedmiotowDoDodania, new SortowaniePrzedmiotow());
		Osoba os1 = new Osoba("Bartosz", "Pniewski", "90030200246", "Elizy Orzeszkowej 32/2 kod 02-324", "02-03-1990",
				"2013-03-23");
		Osoba os2 = new Osoba("Patryk", "Modzelewski", "82051234246", "Opaczewska 12/5 kod 02-224", "12-05-1982",
				"2010-05-13");
		Osoba os3 = new Osoba("Remigiusz", "Ptasznik", "70120202323", "Malczewskiego 53/35 kod 00-556", "02-12-1970",
				"2013-03-23");
		Osoba os4 = new Osoba("Jack", "Reacher", "55041234675", "Jutrzenki 12/4 kod 54-324", "12-04-1955",
				"2010-05-13");
		Osoba os5 = new Osoba("Krzysztof", "Sosnowski", "790423200246", "Dzieci Warszawy 19/67 kod 12-364",
				"23-04-1979", "2013-03-23");
		data.start();
		ArrayList<Pomieszczenie> listaDostepnychPomieszczen = new ArrayList<>();
		listaDostepnychPomieszczen.add(pm1);
		listaDostepnychPomieszczen.add(pm2);
		listaDostepnychPomieszczen.add(pm3);
		listaDostepnychPomieszczen.add(pm4);
		listaDostepnychPomieszczen.add(pm5);
		listaDostepnychPomieszczen.add(pm6);
		listaDostepnychPomieszczen.add(pm7);
		listaDostepnychPomieszczen.add(pm8);
		listaDostepnychPomieszczen.add(pm9);
		listaDostepnychPomieszczen.add(pm0);
		Collections.sort(listaDostepnychPomieszczen, new SortowaniePomieszczenia());
		LinkedList<Osoba> osoby = new LinkedList<>();
		osoby.add(os1);
		osoby.add(os2);
		osoby.add(os3);
		osoby.add(os4);
		osoby.add(os5);
		while (uruchomiony) {
			app.jlOperacjaDyn.addMouseListener(new MouseListener() {

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					
					int s = 502;
					if(MouseEvent.MOUSE_WHEEL == s)
						{app.komunikatZielony();
					app.setText(app.jlOperacjaDyn, "Gratulacje! Znaleziono ukryte dodawanie pomieszczen!");
					app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
					while (!listaDostepnychPomieszczen.isEmpty()) {
						for (int i = 0; i < listaDostepnychPomieszczen.size(); i++) {
							magazyn1.dodajPomieszczenie(listaDostepnychPomieszczen.get(i));
							listaDostepnychPomieszczen.remove(i);
						}
					}
				
						
					}else if(e.getButton() == 3)
					{
						app.setText(app.jlOperacjaDyn, "chujasdofd"
								+ "!");
					}
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {

				}

				public void mouseReleased(MouseEvent e) {
				}

			});

			System.out.println("\nDokonaj wyboru numeru z klawiatury:\n1.Wyswietlenie dostepnych pomieszczen."
					+ "\n2.Wybierz uzytkownika:\n3.Pokaz informacje o obecnym uzytkowniku.\n4.Wyswietlenie obecnej daty.\n5.Wyloguj uzytkownika."
					+ "\n6.Wynajmij pomieszczenie.\n7.Wyswietl informacje o liscie pomieszczen uzytkownikow.\n8.Wyswietl liste osob wynajmujacych."
					+ "\n9.Dodanie przedmiotu.\n10.Wyswietlenie listy przedmiotow w pomieszczeniach.\n11.Wyswietl stan dostepnosci pomieszczen.\n12.Wyswietl zawartosc magazynu tymczasowego, jezeli nie znalazles "
					+ "swoich przedmiotow w obecnych magazynach.\n13.Wyjecie przedmiotow z magazynu uzytkownika.\n14.Zapis stanu magazynowego.\nWpisanie \"exit\" konczy program");
			String test = keyboard.nextLine();
			app.komunikatZielony();
			if (test.equals("exit")) {
				app.zakoncz();
				data.setFlaga(false);
				uruchomiony = false;
				keyboard.close();
				if (obec != null) {
					obec.setSprawdzenieWatku(false);
				}
				for (int i = 0; i < magazyn1.listaPomieszczen.size(); i++) {
					magazyn1.listaPomieszczen.get(i).interrupt();
				}
				for (Obecna lista : magazyn1.listaNajemcow) {
					lista.setSprawdzenieWatku(false);
				}
				for (int i = 0; i < magazyn1.listaNajemcow.size(); i++) {
					for (int j = 0; j < magazyn1.listaNajemcow.get(i).listaPomieszczenNajemcow.size(); j++) {
						magazyn1.listaNajemcow.get(i).listaPomieszczenNajemcow.get(j).interrupt();
						;
					}
				}
				magazyn1.wylacz();
				es.shutdown();
			}
			switch (test) {
			// Ukryta funkcja zastapiona easter egg`iem z myszka, na poczatku
			// zrobilem tylko jako najazd myszka na pole, ale to mozna zrobic
			// przez przypadek;
			/*
			 * case "0": while (!listaDostepnychPomieszczen.isEmpty()) { for
			 * (int i = 0; i < listaDostepnychPomieszczen.size(); i++) {
			 * magazyn1.dodajPomieszczenie(listaDostepnychPomieszczen.get(i));
			 * listaDostepnychPomieszczen.remove(i); } } break;
			 */
			case "1":
				app.setText(app.jlOperacjaDyn, "Wyswietlanie dostepnych pomieszczen.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				listaDostepnychPomieszczen.forEach(miejsce -> System.out.println(miejsce.toString()));
				if (!listaDostepnychPomieszczen.isEmpty()) {
					try {
						System.out.print("Podaj nr pomieszczenia do dodania: ");
						wpis = keyboard.nextLine();
						Integer wp = Integer.parseInt(wpis);
						for (int i = 0; i < listaDostepnychPomieszczen.size(); i++) {
							if (wp.equals((listaDostepnychPomieszczen.get(i).getNumer()))) {
								magazyn1.dodajPomieszczenie(listaDostepnychPomieszczen.get(i));
								listaDostepnychPomieszczen.remove(i);
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Prosze podac numer pomieszczenia.");
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze podac numer pomieszczenia.");
					}
				} else {
					System.out.println("Brak dostepnych pomieszczen.");
					app.komunikatCzerwony();
					app.setText(app.jlKomunikatyDyn, "Brak dostepnych pomieszczen.");
				}
				break;
			case "2":
				app.setText(app.jlOperacjaDyn, "Wybieranie uzytkownika.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				for (int i = 0; i < osoby.size(); i++) {
					System.out.println("Osoba nr " + i + " " + osoby.get(i));
				}
				System.out.println("Podaj nr osoby:");
				try {
					wpis = keyboard.nextLine();
					Integer wp = Integer.parseInt(wpis);
					if (wp <= (osoby.size() - 1)) {
						obec = new Obecna(osoby.get(wp));
						for (int i = 0; i < magazyn1.listaNajemcow.size(); i++) {
							if (obec.getPesel() == magazyn1.listaNajemcow.get(i).getPesel()) {
								obec = magazyn1.listaNajemcow.get(i);
							}
						}
						app.setText(app.jlUzytkownikDynDane, obec.toStringDane());
						app.setText(app.jlIloscPomieszczenDyn, String.valueOf(obec.listaPomieszczenNajemcow.size()));
						app.setText(app.jlUzytkownikDynAdres, obec.toStringAdres());

					} else {
						app.komunikatCzerwony();
						System.out.println("Bledny wybor, wybierz ponownie.");
						app.setText(app.jlKomunikatyDyn, "Bledny wybor, wybierz ponownie.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Prosze podac numer osoby.");
					app.komunikatCzerwony();
					app.setText(app.jlKomunikatyDyn, "Prosze podac numer osoby.");
					/*
					 * } catch (NullPointerException e){
					 * System.out.println("Prosze wybrac numer uzytkownika.");
					 * app.komunikatCzerwony(); app.setText(app.jlKomunikatyDyn,
					 * "Bledny wybor, wybierz ponownie."); };
					 */
				}

				break;

			case "3":
				app.setText(app.jlOperacjaDyn, "Informacja o obecnym uzytkowniku.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null) {
					System.out.println("Obecny uzytkownik: ");
					System.out.println(obec);
				} else {
					System.out.println("Brak obecnego uzytkownika.");
					app.komunikatCzerwony();
					app.setText(app.jlKomunikatyDyn, "Brak obecnego uzytkownika.");
				}
				break;
			case "4":
				app.setText(app.jlOperacjaDyn, "Aktualna data.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				System.out.println(data.toString());
				break;
			case "5":
				app.setText(app.jlOperacjaDyn, "Wylogowanie uzytkownika.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null) {
					System.out.println("Uzytkownik " + obec.imie + " " + obec.nazwisko + " wylogowany");
					obec = null;
					app.setText(app.jlUzytkownikDynDane, "Brak obecnego uzytkownika.");
					app.setText(app.jlUzytkownikDynAdres, "Brak obecnego uzytkownika.");
					app.setText(app.jlIloscPomieszczenDyn, "Brak danych.");
				} else {
					app.komunikatCzerwony();
					System.out.println("Brak zalogowanego uzytkownika.");
					app.setText(app.jlKomunikatyDyn, "Brak zalogowanego uzytkownika.");
				}
				break;
			case "6":
				app.setText(app.jlOperacjaDyn, "Wynajmowanie pomieszczen.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");

				if (obec != null && !magazyn1.listaPomieszczen.isEmpty()) {
					System.out.println("Wybierz interesujace Cie pomieszczenie w magazynie " + magazyn1.toString());
					magazyn1.wyswietlPomieszczeniaMagazynu();
					try {
						wpis = keyboard.nextLine();
						Integer wp = Integer.parseInt(wpis);
						for (int i = 0; i < magazyn1.listaPomieszczen.size(); i++) {
							if (wp.equals((magazyn1.listaPomieszczen.get(i).getNumer()))
									&& magazyn1.listaPomieszczen.get(i).sprawdzFlage()) {
								System.out.println("Podaj liczbe dni najmu pomieszczenia.");
								wybor = keyboard.nextLine();
								Integer dniWynajmu = Integer.parseInt(wybor);

								try {
									magazyn1.dodajOsobe(obec, dniWynajmu, magazyn1.listaPomieszczen.get(i));

								} catch (NeverRentException e) {
									System.out.print(e);
								}
								es.execute(magazyn1.listaPomieszczen.get(i));
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Prosze podac liczbe dni w formacie cyfrowym.");
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze podac ilosc dni.");
					}
				} else {
					if (obec == null) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");

					} else {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Brak pomieszczen do wyboru.");
					}
				}
				break;
			case "7":
				app.setText(app.jlOperacjaDyn, "Wyswietlanie listy pomieszczen uzytkownika.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null) {
					System.out.println(obec.toString());
					obec.wyswietlListePomieszczenNajemcow();
					if (obec.listaPomieszczenNajemcow.isEmpty()) {
						app.setText(app.jlKomunikatyDyn, "Brak obecnie wynajmowanych pomieszczen.");
					}
				} else {
					app.komunikatCzerwony();
					System.out.println("Prosze sie zalogowac.");
					app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");
				}
				break;
			case "8":
				app.setText(app.jlOperacjaDyn, "Wyswietlanie listy najemcow.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (!magazyn1.listaNajemcow.isEmpty()) {
					magazyn1.wyswietlListeNajemcow();
				} else {
					System.out.println("Lista najemcow jest pusta.");
					app.komunikatCzerwony();
					app.setText(app.jlKomunikatyDyn, "Lista najemcow jest pusta.");
				}
				break;
			case "9":
				app.setText(app.jlOperacjaDyn, "Dodawanie przedmiotu.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null && !obec.listaPomieszczenNajemcow.isEmpty()) {
					System.out.println("Wybierz dostepne pomieszczenie:");
					obec.wyswietlListePomieszczenNajemcow();
					try {
						wpis = keyboard.nextLine();
						Integer wp = Integer.parseInt(wpis);
						for (int i = 0; i < obec.listaPomieszczenNajemcow.size(); i++) {
							if (wp.equals((obec.listaPomieszczenNajemcow.get(i).getNumer()))) {
								System.out.println(
										"Wybierz forme dodania przedmiotu, 1 - z listy dostepnych przedmiotow ; 2 - za pomoca klawiatury.");
								try {
									wpis = keyboard.nextLine();
									Integer wb = Integer.parseInt(wpis);
									if (wb == 1) {
										System.out.println("Dodaj przedmiot z listy przedmiotow:");
										listaPrzedmiotowDoDodania
												.forEach(lista -> System.out.println(lista.toString()));
										wybor = keyboard.nextLine();
										for (int j = 0; j < listaPrzedmiotowDoDodania.size(); j++) {

											if (listaPrzedmiotowDoDodania.get(j).getNazwa().contains(wybor))
												try {
													obec.listaPomieszczenNajemcow.get(i)
															.dodajPrzedmiot(listaPrzedmiotowDoDodania.get(j));
													if (obec.listaPomieszczenNajemcow.get(i)
															.getRozmiar() >= listaPrzedmiotowDoDodania
																	.get(j).wielkoscPrzedmiotu) {
														listaPrzedmiotowDoDodania.remove(j);
													}
												} catch (TooManyThingsException e) {
													app.komunikatCzerwony();
													app.setText(app.jlKomunikatyDyn, "Za malo miejsca w magazynie.");
													System.out.println(e);
												}
										}
									} else if (wb == 2) {
										System.out.print("Podaj nazwe przedmiotu: ");
										String nazwa = keyboard.nextLine();
										System.out.print("Podaj objetosc przedmimotu: ");
										try {
											String temp = keyboard.nextLine();
											int wymiar = Integer.parseInt(temp);

											try {
												obec.listaPomieszczenNajemcow.get(i)
														.dodajPrzedmiot(new Przedmiot(nazwa, wymiar));
											} catch (TooManyThingsException e) {
												app.komunikatCzerwony();
												app.setText(app.jlKomunikatyDyn, "Za malo miejsca w magazynie.");
												System.out.println(e);
											}
										} catch (NumberFormatException e) {
											app.komunikatCzerwony();
											app.setText(app.jlKomunikatyDyn, "Prosze podac w formacie liczbowym.");
											System.out.println("Prosze podac wymiar w formacie liczbowym.");
										}

									} else {
										app.komunikatCzerwony();
										app.setText(app.jlKomunikatyDyn, "Bledny wybor, sproboj ponownie.");
										System.out.println("Bledny wybor, sproboj ponownie.");
									}
								} catch (NumberFormatException e) {
									System.out.println("Mozna wybrac tylko cyfre");
								}
							}
						}
					} catch (NumberFormatException e) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze podac w formacie liczbowym.");
						System.out.println("Prosze podac numer wyboru w formacie liczbowym.");
					}
				} else {
					if (obec == null) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");
						System.out.println("Prosze sie zalogowac.");

					} else {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Lista pomieszczen jest pusta.");
						System.out.println("Lista pomieszczen jest pusta.");
					}
				}
				break;
			case "10":
				app.setText(app.jlOperacjaDyn, "Wyswietlenie listy przedmiotow w pomieszczeniach.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null && !obec.listaPomieszczenNajemcow.isEmpty()) {
					System.out.println("Przedmioty w danych pomieszczeniach: ");
					for (int i = 0; i < obec.listaPomieszczenNajemcow.size(); i++) {
						Collections.sort(obec.listaPomieszczenNajemcow, new SortowaniePomieszczenia());
						obec.listaPomieszczenNajemcow.get(i).wyswietlPrzedmioty();
					}
				} else {
					if (obec == null) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");
					} else if (!obec.listaPomieszczenNajemcow.isEmpty()) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Lista pomieszczen jest pusta.");
					}
				}
				break;
			case "11":
				app.setText(app.jlOperacjaDyn, "Wyswietlanie zawartosci pomieszczen magazynowych.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (!magazyn1.listaPomieszczen.isEmpty()) {
					System.out.println("Wyswietla stan dostepnosci wszystkich pomieszczen magaznowych:\n");

					for (int i = 0; i < magazyn1.listaPomieszczen.size(); i++) {
						System.out.println(magazyn1.listaPomieszczen.get(i).toString());
					}
				} else {
					app.komunikatCzerwony();
					System.out.println("Brak zawartosci do wyswietlenia");
					app.setText(app.jlKomunikatyDyn, "Brak zawartosci do wyswietlenia.");
				}

				break;
			case "12":
				app.setText(app.jlOperacjaDyn, "Stan zawartosci magazynu tymaczsowego.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null) {
					if (obec.tempList.isEmpty()) {
						System.out.println("Magazyn tymczasowy jest pusty.");
						app.setText(app.jlKomunikatyDyn, "Magazyn tymczasowy jest pusty.");
					} else {
						System.out.println("przedmioty w magazynie tymczasowym: " + obec.tempList.size());
						System.out.println("Przedmioty w magazynie tymczasowym.");
						System.out.println(obec.tempList.toString());
						System.out.println("Czy chcesz dodac ktorys przedmiot do swojego obecnego magazynu?\ttak/nie");
						wybor = keyboard.nextLine();
						if (wybor.equals("tak")) {
							if (!obec.listaPomieszczenNajemcow.isEmpty()) {
								System.out.println("Wybierz magazyn do ktorego chcesz dodac przedmiot.");
								obec.wyswietlListePomieszczenNajemcow();
								wybor2 = keyboard.nextLine();
								Integer wb2 = Integer.parseInt(wybor2);
								for (int i = 0; i < obec.listaPomieszczenNajemcow.size(); i++) {
									if (wb2.equals(obec.listaPomieszczenNajemcow.get(i).getNumer())) {
										System.out.println("Wybierz nazwe przedmiotu z magazynu tymaczasowego.");
										System.out.println(obec.tempList.toString());
										wybor = keyboard.nextLine();
										for (int k = 0; k < obec.tempList.size(); k++) {
											if (wybor.equals(obec.tempList.get(k).getNazwa())) {
												{
													try {
														obec.listaPomieszczenNajemcow.get(i)
																.dodajPrzedmiot(obec.tempList.get(k));
														if (obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow
																.contains(obec.tempList.get(k))) {
															obec.tempList.remove(k);
														}
													} catch (TooManyThingsException e) {
														System.out.println(e);
														app.komunikatCzerwony();
														app.setText(app.jlKomunikatyDyn,
																"Za malo miejsca w magazynie.");
													}
												}
											}
										}
									}
								}
							} else {
								app.komunikatCzerwony();
								System.out.println("Nie posiadasz pomieszczen do dokonania transferu.");
								app.setText(app.jlKomunikatyDyn, "Brak pomieszczen do dokonania transferu.");
							}
						}
					}
				} else {
					app.komunikatCzerwony();
					System.out.println("Zaloguj sie aby zobaczyc pojemnosc magazynu tymczasowego.");
					app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");
				}
				break;
			case "13":
				app.setText(app.jlOperacjaDyn, "Wyjmowanie przedmiotow.");
				app.setText(app.jlKomunikatyDyn, "Brak komunikatow.");
				if (obec != null && !obec.listaPomieszczenNajemcow.isEmpty() && obec.getUsuwanie()) {
					while (obec.getUsuwanie()) {
						System.out.println("Wskaz numer pomieszczenia z ktorego chcesz usunac dany przedmiot:\n");
						obec.wyswietlListePomieszczenNajemcow();
						wpis = keyboard.nextLine();
						Integer wp = Integer.parseInt(wpis);
						wybor = null;
						wybor2 = null;
						for (int i = 0; i < obec.listaPomieszczenNajemcow.size(); i++) {
							if (wp.equals(obec.listaPomieszczenNajemcow.get(i).getNumer())) {
								System.out.println("Przedmioty w pomieszczeniu nr "
										+ obec.listaPomieszczenNajemcow.get(i).getNumer());
								for (int j = 0; j < obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.size(); j++) {
									System.out.println(
											obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.get(j).toString());
								}
								System.out.print("\nPodaj nazwe przedmiotu ktory chcesz usunac: ");
								for (int k = 0; k < obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.size(); k++) {
									wybor = keyboard.nextLine();
									if (wybor.equals(
											obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.get(k).getNazwa())) {
										int reduktor = obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.get(k)
												.getWielkosc();
										obec.listaPomieszczenNajemcow.get(i).zwrocRozmiar(reduktor);
										obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.remove(k);
										if (!obec.listaPomieszczenNajemcow.get(i).listaPrzedmiotow.isEmpty()) {
											System.out.println("Czy chcesz usunac nastepny przedmiot?\ttak/nie");
											wybor2 = keyboard.nextLine();
											if (wybor2.equals("tak")) {
												System.out.println("Kontynuuje usuwanie.");
												app.setText(app.jlKomunikatyDyn, "Kontynuuje usuwanie.");
												obec.setUsuwanie(true);
											} else if (wybor2.equals("nie")) {
												obec.setUsuwanie(false);
												app.komunikatCzerwony();
												System.out.println("Przerywam operacje usuwanie przedmiotow.");
												app.setText(app.jlKomunikatyDyn,
														"Przerywam operacje usuwanie przedmiotow.");
											}
										} else {
											app.komunikatCzerwony();
											obec.setUsuwanie(false);
											System.out.println("Brak przedmiotow w pomieszczeniu do usuniecia.");
											app.setText(app.jlKomunikatyDyn, "Brak przedmiotow w pomieszczeniu.");
										}
									}
								}
							}
						}
					}
				} else {
					System.out.println("Musisz byc zalogowany, lub nie posiadasz pomieszczenia obecnie wynajetego.");
					if (obec == null) {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Prosze sie zalogowac.");
					} else {
						app.komunikatCzerwony();
						app.setText(app.jlKomunikatyDyn, "Brak obecnie wynajmowanych pomieszczen.");
					}
				}
				if (obec != null) {
					obec.setUsuwanie(true);
				}
				break;
			case "14":
				app.setText(app.jlOperacjaDyn, "Zapis stanu magazynu.");
				app.setText(app.jlKomunikatyDyn, "Stan magazynu zapisany do stanMagazynu.txt");
				if (!magazyn1.listaMagazynu.isEmpty() && !magazyn1.listaNajemcow.isEmpty()) {
					magazyn1.zapisDanych();
				} else {
					app.komunikatCzerwony();
					app.setText(app.jlKomunikatyDyn, "Brak danych potrzebnych do zapisania stanu magazynu.");
					System.out.println("Brak danych potrzebnych do zapisania stanu magazynowego.");
				}
				break;
			default:
				app.komunikatCzerwony();
				System.out.println("Prosze wybrac numer z listy.");
				app.setText(app.jlKomunikatyDyn, "Prosze wybrac numer z listy.");

			}
			if (obec != null) {
				app.setText(app.jlIloscPomieszczenDyn, String.valueOf(obec.listaPomieszczenNajemcow.size()));
			}

		}

	}
}