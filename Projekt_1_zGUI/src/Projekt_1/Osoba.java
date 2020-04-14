package Projekt_1;

public class Osoba {

	String imie, nazwisko, adresZamieszkania, dataUrodzenia, dataPierwszegoNajmu, pesel;

	public Osoba(String imie, String nazwisko, String pesel, String adresZamieszkania, String dataUrodzenia,
			String dataPierwszegoNajmu) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.adresZamieszkania = adresZamieszkania;
		this.dataUrodzenia = dataUrodzenia;
		this.dataPierwszegoNajmu = dataPierwszegoNajmu;
	}

	public String toString() {
		return "\nDane osoby:\nImie: " + imie + "\nNazwisko: " + nazwisko + "\nNr pesel: " + pesel
				+ "\nAdres zamieszkania: " + adresZamieszkania + "\nData urodzenia: " + dataUrodzenia;
	}

	public String getImie() {
		return imie;
	}

	public String getPesel() {
		return pesel;
	}
}