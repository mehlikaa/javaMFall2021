package geometrik_hesaplama;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MRunner {
	public static Scanner scan = new Scanner(System.in);
	static double kisaKenar;
	static double uzunKenar;
	static double yaricap;

	public static void main(String[] args) {

		System.out.println("\n\t~~~ M E R H A B A  ~~~\n");
		hesaplama();
	}

	private static void hesaplama() {
		System.out.print(
				"Hangi sekil icin hesaplama yapmak istersiniz?\n(K)are\t(D)ikdortgen\t(K)are\tCikis icin Q. \nSeciminiz :");
		char sekil = scan.next().toLowerCase().charAt(0);

		switch (sekil) {
		case 'c':
			cember();
			devamTamam();
			break;
		case 'k':
			kare();
			devamTamam();
			break;
		case 'd':
			dikDortgen();
			devamTamam();
			break;
		case 'q':
			cikis();
			break;
		default:
			System.out.println("\n\t==>Sekil basharflerinden birini giriniz.\n");
			hesaplama();
			break;
		}

	}

	private static void kare() {
		try {
			System.out.print("Kenar uzunlugunu olcusunu giriniz :");
			kisaKenar = scan.nextDouble();

		} catch (InputMismatchException e) {
			System.out.println("\n\t==>Lutfen sayi degeri giriniz ,");
			scan.next();
			kare();

		}
		MKare k = new MKare(uzunKenar, kisaKenar);
		System.out.println("Kare  " + k);
		System.out.println("Kare Cevre : " + k.kareAlan());
		System.out.println("Kare Alan : " + k.kareCevre());
		devamTamam();

	}

	private static void dikDortgen() {
		try {
			System.out.print("Kisa kenar uzunlugunu olcusunu giriniz :");
			kisaKenar = scan.nextDouble();
			System.out.print("Uzun kenar uzunlugunu olcusunu giriniz :");
			uzunKenar = scan.nextDouble();

		} catch (InputMismatchException e) {

			System.out.println("\n\t==>Lutfen sayi degeri giriniz ,");
			scan.next();
			dikDortgen();
		}

		MDikdortgen d = new MDikdortgen(uzunKenar, kisaKenar);
		System.out.println("Dikdortgen  " + d);
		System.out.println("Dikdortgen Cevre : " + d.dikdortgenAlan());
		System.out.println("Dikdortgen Alan : " + d.dikdortgenCevre());
		devamTamam();
	}

	private static void cember() {
		try {
			System.out.print("Yaricap olcusunu giriniz :");
			yaricap = scan.nextDouble();
		} catch (InputMismatchException e) {

			System.out.println("\n\t==>Lutfen sayi degeri giriniz ,");
			scan.next();
			cember();
		}
		MCember c = new MCember(yaricap);
		System.out.println("Cember " + c);
		System.out.println("Cember cevre ==> " + c.yariCap + "*2*3.14 = " + c.cevreHesaplama());
		System.out.println("Cember Alan : " + c.alanHesaplamaCember());
		devamTamam();
	}

	private static void devamTamam() {

		System.out.println("\n\tYeni Hesaplama: H / Cikis: Q\t\t Seciminiz :");
		char sec = scan.next().toLowerCase().charAt(0);
		if (sec == 'q') {
			cikis();
		} else if (sec == 'h') {
			hesaplama();
		} else if ((sec != 'q') && (sec != 'h')) {
			System.out.println("\n\t==>Yanlis giris yapildi. ");
		} else {
			cikis();
		}
	}

	private static void cikis() {

		System.out.print("\n~ ~ ~   Mutlu gunler   ~ ~ ~");
		scan.next();
	}
}
