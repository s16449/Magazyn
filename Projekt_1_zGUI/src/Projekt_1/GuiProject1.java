package Projekt_1;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiProject1 {

	JLabel jlUzytkownikAdres, jlUzytkownikDane, jlUzytkownikDynDane, jlUzytkownikDynAdres, jlOperacjaDyn,
			jlIloscPomieszczenDyn, jlKomunikatyDyn;
	JLabel jNiezmiennyUzytkownik, jNiezmiennaOperacja, jDataLokalna, jIloscPomieszczen, jWazniejszeKomunikaty;
	static JLabel jlData;
	JFrame okno;
	JPanel panelUzytkownik, panelOperacja;
	static boolean trofka = false;

	public GuiProject1() {

		panelUzytkownik = new JPanel();
		panelOperacja = new JPanel();

		jDataLokalna = new JLabel("Data lokalna:");
		jDataLokalna.setFont(new Font("SansSerif", Font.BOLD, 18));
		jDataLokalna.setForeground(Color.GREEN);

		jlData = new JLabel(Data.localna);
		jlData.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlData.setForeground(Color.GREEN);

		jWazniejszeKomunikaty = new JLabel("Ostatnie komunikaty:");
		jWazniejszeKomunikaty.setFont(new Font("SansSerif", Font.BOLD, 18));
		jWazniejszeKomunikaty.setForeground(Color.GREEN);

		jlKomunikatyDyn = new JLabel("Brak komunikatow.");
		jlKomunikatyDyn.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlKomunikatyDyn.setForeground(Color.GREEN);

		jNiezmiennyUzytkownik = new JLabel("Imie, Nazwisko i Pesel uzytkownika:");
		jNiezmiennyUzytkownik.setFont(new Font("SansSerif", Font.BOLD, 18));
		jNiezmiennyUzytkownik.setForeground(Color.CYAN);

		jNiezmiennaOperacja = new JLabel("Ostatnia operacja:");
		jNiezmiennaOperacja.setFont(new Font("SansSerif", Font.BOLD, 18));
		jNiezmiennaOperacja.setForeground(Color.GREEN);

		jlOperacjaDyn = new JLabel("Glowne menu.");
		jlOperacjaDyn.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlOperacjaDyn.setForeground(Color.GREEN);

		jlUzytkownikDynAdres = new JLabel("Brak obecnego uzytkownika.");
		jlUzytkownikDynAdres.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlUzytkownikDynAdres.setForeground(Color.CYAN);

		jlUzytkownikDynDane = new JLabel("Brak obecnego uzytkownika.");
		jlUzytkownikDynDane.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlUzytkownikDynDane.setForeground(Color.CYAN);

		jlUzytkownikAdres = new JLabel("Adres zamieszkania:");
		jlUzytkownikAdres.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlUzytkownikAdres.setForeground(Color.CYAN);

		jIloscPomieszczen = new JLabel("Ilosc wynajmowanych pomieszczen:");
		jIloscPomieszczen.setFont(new Font("SansSerif", Font.BOLD, 18));
		jIloscPomieszczen.setForeground(Color.CYAN);

		jlIloscPomieszczenDyn = new JLabel("Brak danych.");
		jlIloscPomieszczenDyn.setFont(new Font("SansSerif", Font.BOLD, 18));
		jlIloscPomieszczenDyn.setForeground(Color.CYAN);

		panelOperacja.add(jDataLokalna);
		panelOperacja.add(jlData);
		panelOperacja.add(jNiezmiennaOperacja);
		panelOperacja.add(jlOperacjaDyn);
		panelOperacja.add(jWazniejszeKomunikaty);
		panelOperacja.add(jlKomunikatyDyn);
		panelUzytkownik.add(jNiezmiennyUzytkownik);
		panelUzytkownik.add(jlUzytkownikDynDane);
		panelUzytkownik.add(jlUzytkownikAdres);
		panelUzytkownik.add(jlUzytkownikDynAdres);
		panelUzytkownik.add(jIloscPomieszczen);
		panelUzytkownik.add(jlIloscPomieszczenDyn);

		panelOperacja.setLayout(new GridLayout(3, 3));
		panelOperacja.setBackground(Color.BLACK);
		panelOperacja.setToolTipText(
				"Informacje o dacie, ostatniej wykonanej operacji i wazniejszych komunikatach dotyczacych ostatniej operacji.");
		panelUzytkownik.setLayout(new GridLayout(3, 3));
		panelUzytkownik.setBackground(Color.BLACK);
		panelUzytkownik.setToolTipText(
				"Informacje o obecnym uzytkowniku, jego dane, adres i ilosc obecnie wynajmowanych pomieszczen.");
		okno = new JFrame("Magazyn Monitor");
		okno.setLayout(new GridLayout(2, 2));

		okno.getContentPane().add(panelOperacja);
		okno.getContentPane().add(panelUzytkownik);
		okno.setSize(new Dimension(1000, 300));
		okno.setLocationRelativeTo(null);
		okno.setVisible(true);
		okno.setAlwaysOnTop(true);
		okno.setResizable(false);
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setText(JLabel zmienna, String text) {
		zmienna.setText(text);
	}

	public void zakoncz() {
		okno.dispose();
	}
	public void komunikatCzerwony()
	{
		jlKomunikatyDyn.setForeground(Color.RED);
	}
	public void komunikatZielony()
	{
		jlKomunikatyDyn.setForeground(Color.GREEN);
	}
}
