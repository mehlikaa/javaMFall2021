package Dec12_proje_kitapci;

import java.util.Scanner;

public class Kitaplik {

	static Scanner scan = new Scanner(System.in);
	static char secim = ' ';

	public static void main(String[] args) {

		System.out.println("\n======Kitapligimiza Hosgeldiniz======");
		menu();

	}

	public static void menu() {
		System.out.print("\t  \nHangi islemi yapmak istersiniz?" + "\n------------------------------------"
				+ " \n1-Kitap ekle\n" + "2-Numara ile kitap goruntule\n" + "3-Bilgi ile kitap goruntule\n"
				+ "4-Numara ile kitap sil\n" + "5-Tum kitaplari listele\n"
				+ "6-Cikis\nLutfen menudeki numaralardan birini yaziniz.\n =>Seciminiz :");

		secim = scan.next().charAt(0);

		if (Character.isDigit(secim)) {
			if (!(secim > 0 && secim < 7)) {

				switch (secim) {
				case '1':
					kitapEkle();
					menu();
					break;

				case '2':
					numaraIleKitapSorgu();
					menu();
					break;

				case '3':
					kelimeIleKitapSorgu();
					break;

				case '4':
					numaraIleKitapSil();
					menu();
					break;

				case '5':
					tumKitaplariListele();
					break;

				case '6':
					System.out.println("====      YINE BEKLERIZ      ======");
					break;

				default:
					System.out.println("Lutfen menudeki sayilardan birini giriniz ...");
					break;
				}
			} else if ((secim > 7)) {
				System.out.println("Else, Lutfen menudeki sayilardan birini giriniz ...");
			}

		} else {
			System.out.println("Lutfen sayi giriniz ...");
			// System.out.println("Yeni seciminiz: "); //istedigimiz satira goturme var mi?

		}
		menu();
	}

	public static void kitapEkle() {
		System.out.print("Girmek istediginiz Kitabin adini giriniz        : ");
		String yeniKitap = scan.next();
		// nextLine kullanamiyorum ??????????
		Kitap kitapEkle = new Kitap();

		kitapEkle.kitaplar.add(yeniKitap);
		kitapEkle.kitapNo.add(kitapEkle.kitapNo.size() + 1);

		System.out.println("Eklenen kitap : " + kitapEkle.kitapNo.size() + " - "
				+ kitapEkle.kitaplar.get(kitapEkle.kitaplar.size() - 1));

		System.out.print("Yeni Kitap listemizi gormek ister misiniz? (E/H): ");
		if (scan.next().equalsIgnoreCase("E")) {
			tumKitaplariListele();
		} else {
			System.out.println("Yanlis giris sizi menuye aliyorum. ");
			menu();
		}
	}

	@SuppressWarnings("static-access")
	public static void numaraIleKitapSorgu() {
		Kitap numaraIleAra = new Kitap();
		System.out.print("Hangi numarali kitabi ariyorsunuz?");
		int numaraKitap = scan.nextInt();
		for (int i = 0; i < numaraIleAra.kitapNo.size() - 1; i++) {
			if (numaraIleAra.kitapNo.get(i) == numaraKitap) {
				System.out.println("Aradiginiz numaradaki kitabiniz : " + numaraIleAra.kitapNo.get(i) + " - "
						+ numaraIleAra.kitaplar.get(i));

				System.out.print("Menuyu gormek ister misiniz? (E/H): ");

				String sec = scan.next();
				if (sec.equalsIgnoreCase("e")) {
					menu();
				} else if (sec.equalsIgnoreCase("h")) {
					System.out.println("====      YINE BEKLERIZ      ======");

				} else {
					System.out.println("Yanlis giris sizi menuye aliyorum. ");
					menu();
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void kelimeIleKitapSorgu() {
		//////
		Kitap kelimeIleAra = new Kitap();
		System.out.print("Istediginiz kitabin ismini yaziniz : ");
		String kelimeIleSorgu = scan.next().toUpperCase();
		for (int i = 1; i < kelimeIleAra.kitaplar.size(); i++) {
			// System.out.println(kelimeIleAra.kitaplar.get(i));
			if (kelimeIleAra.kitaplar.get(i).toUpperCase().contains(kelimeIleSorgu)) {
				System.out.println("Aradiginiz isimdeki kitabiniz : " + kelimeIleAra.kitapNo.get(i) + " - "
						+ kelimeIleAra.kitaplar.get(i));
			}
		}
		System.out.println("Aradiginiz kelime ile bir kitap bulamadim.");

		System.out.print("Menuyu gormek ister misiniz? (E/H): ");

		String sec = scan.next();
		if (sec.equalsIgnoreCase("e")) {
			menu();
		} else if (sec.equalsIgnoreCase("h")) {
			System.out.println("====      YINE BEKLERIZ      ======");

		} else {
			System.out.println("Yanlis giris sizi menuye aliyorum. ");
			menu();
		}
	}

	public static void numaraIleKitapSil() {
		int sil = 0;

		// tumKitaplariListele();

		System.out.print("Hangi sira numarasindaki kitabi silmek istersiniz ?");
		sil = scan.nextInt();

		Kitap silKitap = new Kitap();

		if ((sil > 0) && (sil < silKitap.kitapNo.size())) {
			silKitap.kitapNo.remove(Kitap.kitapNo.size() - 1); // sonuncu sira numarasini sildim.
			silKitap.kitaplar.remove(sil - 1);
		} else {
			System.out.println("Yanlis giris yaptiniz...islemi basa aliyorum.");
			numaraIleKitapSil();
		}
	}

	public static void tumKitaplariListele() {
		Kitap kitap = new Kitap();
		System.out.println("  Sira No         Kitap Adi     \n========================");
		for (int i = 0; i < kitap.kitaplar.size(); i++) {
			System.out.println("\t" + kitap.kitapNo.get(i) + "\t | \t" + kitap.kitaplar.get(i));
		}
		System.out.print("Menuyu gormek ister misiniz? (E/H): ");

		String sec = scan.next();
		if (sec.equalsIgnoreCase("e")) {
			menu();
		} else if (sec.equalsIgnoreCase("h")) {
			System.out.println("====      YINE BEKLERIZ      ======");

		} else {
			System.out.println("Yanlis giris sizi menuye aliyorum. ");
			menu();
		}
	}
}
