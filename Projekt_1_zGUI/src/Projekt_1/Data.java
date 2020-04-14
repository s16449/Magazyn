package Projekt_1;

import java.time.LocalDate;

public class Data extends Thread {

	private static boolean flaga = false;
	private static LocalDate local = LocalDate.now();
	String nazwa;
	public static String localna = local.toString();

	public Data(String nazwa, boolean start) {
		this.nazwa = nazwa;
		flaga = start;
	}

	public void run() {
		while (flaga) {
			try {
				Thread.sleep(10000);
				local = local.plusDays(1);
				localna = local.toString();
				GuiProject1.jlData.setText(localna);
			} catch (InterruptedException e) {
				System.out.print("Watek Daty Lokalnej zostal przerwany");
			}
		}
	}

	public String toString() {
		return nazwa + ": " + local;
	}

	public void setFlaga(boolean set) {
		flaga = set;
	}
}