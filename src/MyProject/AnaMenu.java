package MyProject;

import java.util.Scanner;

public class AnaMenu implements IAnaMenu{
    static String c_RESET  = "\u001B[0m";
    static String BOLD     = "\033[0;1m";
    static String c_BLUE   = "\u001B[34m";
    static String c_RED    = "\u001B[31m";
    static String c_GREEN  = "\u001B[32m";
    static Scanner scan = new Scanner(System.in);

    public static void girisEkrani() throws InterruptedException {
        AnaMenu obje = new AnaMenu();

        System.out.println(BOLD+c_BLUE+"====================================");
        System.out.println(" ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("====================================");
        System.out.println();
        System.out.println("1 - Öğretmen Işlemleri ");
        System.out.println("2 - Öğrenci Işlemleri ");
        System.out.println("3 - Çıkış ");
        System.out.print("Seçiniz : "+c_RESET);

        String secim = TryCatch.stringGirisi(); // burda tryCatch ile kontrol yapıyorum

        switch(secim) {
            case "1" :
                System.out.println(BOLD+c_GREEN+"\nİşlemler Menüsüne Yönlendiriliyorsunuz.."+c_RESET);
                Thread.sleep(2000);
                obje.ogretmenIslemleri();
                break;
            case "2" : obje.ogrenciIslemleri();
                System.out.println(BOLD+c_GREEN+"\nİşlemler Menüsüne Yönlendiriliyorsunuz.."+c_RESET);
                Thread.sleep(2000);
                obje.ogrenciIslemleri();
                break;
            case "3" : obje.cikis();
            break;
            default:
                System.out.println(BOLD+c_RED+"\n*** Hatalı Giriş. Yeniden Deneyin ***"+c_RESET);
                girisEkrani();
                break;
        }

    }

    @Override
    public void ogretmenIslemleri() throws InterruptedException {

        IslemlerMenu.islemlerMenusu(1);
    }

    @Override
    public void ogrenciIslemleri() throws InterruptedException {
        IslemlerMenu.islemlerMenusu(2);
    }

    @Override
    public void cikis() {
        System.out.println(BOLD+c_GREEN+"\nÇıkış Yapıyorsunuz. Iyi günler dileriz.."+c_RESET);

    }


}
