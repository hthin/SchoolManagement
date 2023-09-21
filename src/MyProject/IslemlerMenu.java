package MyProject;

import java.util.Map;
import java.util.Scanner;

public class IslemlerMenu implements IIslemler {
    static String c_CYAN   = "\u001B[36m";
    static String c_RED    = "\u001B[31m";
    static String c_PURPLE = "\u001B[35m";
    static String c_RESET  = "\u001B[0m";
    static String BOLD     = "\033[0;1m";
    static String c_GREEN  = "\u001B[32m";
    static int value = 0;  // bu değer bize öğrenci mi yoksa öğretmen mi olduğunu belirtiyor.
    static Scanner scan = new Scanner(System.in);

    @Override
    public void ekleme() throws InterruptedException {
        System.out.println("\nKimlik numarası giriniz : ");
        String kimlikNo = TryCatch.stringGirisi(); // TODO tryCatch ile kontrol et;

        if (Ogrenci.ogrenciListesiMap.containsKey(kimlikNo) ) {
            System.out.println("\nBu kimlik numaralı kişi ÖĞRENCİMİZDİR..");
            System.out.println("Işlemler Menüsüne yönlendiriliyorsunuz..");
            Thread.sleep(2000);
        }
        else if (Ogretmen.ogretmenListesiMap.containsKey(kimlikNo)) {
            System.out.println("\nBu kimlik numaralı kişi ÖĞRETMENİMİZDİR..");
            System.out.println("Işlemler Menüsüne yönlendiriliyorsunuz..");
            Thread.sleep(2000);
        }
        else {
            bilgiAlKaydet(value,kimlikNo);
        }

    }

    private void bilgiAlKaydet(int value,String kimlikNo) throws InterruptedException {
        scan = new Scanner(System.in);
        System.out.print("Ad ve Soyad giriniz: ");
        String name = TryCatch.stringGirisi();

        System.out.println("Yaş giriniz : ");
        String yas = TryCatch.stringGirisi();

        if (value == 2) {
            System.out.println("Öğrenci numarasını giriniz : ");
            String numara = TryCatch.stringGirisi();

            System.out.println("Öğrenci sınıfını giriniz : ");
            String sinif = TryCatch.stringGirisi();

            Ogrenci objeOgrenci = new Ogrenci(name,yas,sinif,numara);
            Ogrenci.ogrenciListesiMap.put(kimlikNo,objeOgrenci);
            System.out.println("\nBaşarıyla kayıt yapıldı...");
            System.out.println(BOLD+c_GREEN+"Işlemler Menüsüne yönlendiriliyorsunuz.."+c_RESET);
            Thread.sleep(2000);
        }
        else {
            System.out.println("Sicil numarası giriniz : ");
            String sicil = TryCatch.stringGirisi();

            System.out.println("Bölüm giriniz : ");
            String bolum = TryCatch.stringGirisi();
            Ogretmen objeOgretmen = new Ogretmen(name,yas,sicil,bolum);
            Ogretmen.ogretmenListesiMap.put(kimlikNo,objeOgretmen);
            System.out.println("\nBaşarıyla kayıt yapıldı...");
            System.out.println(BOLD+c_GREEN+"Işlemler Menüsüne yönlendiriliyorsunuz.."+c_RESET);
            Thread.sleep(2000);
        }

    }


    @Override
    public void arama() {
        scan = new Scanner(System.in);
        System.out.println("\nAramak istediğiniz kimlik noyu girin : ");
        String kimlikNumarasi = TryCatch.stringGirisi();

        if (Ogrenci.ogrenciListesiMap.containsKey(kimlikNumarasi)) {
            System.out.println("\nÖğrenciye ilişkin bilgiler aşağıdadır.");
            System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikNumarasi).toString());
        }
        else if (Ogretmen.ogretmenListesiMap.containsKey(kimlikNumarasi)) {
            System.out.println("\nÖğretmene ilişkin bilgiler aşağıdadır.");
            System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikNumarasi).toString());
        }
        else {
            System.out.println("\nKayıt bulunamadı..");
        }

    }

    @Override
    public void listeleme() {
        if (value == 1) {
            System.out.println();
            System.out.printf(BOLD+c_CYAN+"%20s%20s%10s%15s%20s","Kimlik No","Adı ve Soyadı","Yas","Sicil","Bölüm"+c_RESET);
            System.out.println();

            for (Map.Entry<String, Ogretmen> val : Ogretmen.ogretmenListesiMap.entrySet()) {
                String key = val.getKey();
                String name = val.getValue().getAdSoyad();
                String yas = val.getValue().getYas();
                String sicil = val.getValue().getSicil();
                String bolum = val.getValue().getBolum();
                System.out.printf("%20s%20s%10s%15s%18s",key,name,yas,sicil,bolum);
                System.out.println();
            }
        }
        else if (value == 2) {
            System.out.println();
            System.out.printf(BOLD+c_CYAN+"%20s%20s%10s%20s%20s","Kimlik No","Adı ve Soyadı","Yas","Sınıf","Öğrenci No"+c_RESET);
            System.out.println();

            for (Map.Entry<String, Ogrenci> val : Ogrenci.ogrenciListesiMap.entrySet()) {
                String key = val.getKey();
                String name = val.getValue().getAdSoyad();
                String yas = val.getValue().getYas();
                String sinif = val.getValue().getSinif();
                String no = val.getValue().getNumara();
                System.out.printf("%20s%20s%10s%20s%15s",key,name,yas,sinif,no);
                System.out.println();
            }
        }

    }

    @Override
    public void silme() {
        scan = new Scanner(System.in);
        System.out.println("\nSilmek istediğiniz kişinin kimlik numarasını giriniz : ");
        String kNo = TryCatch.stringGirisi();

        if (Ogretmen.ogretmenListesiMap.containsKey(kNo)) {
            Ogretmen.ogretmenListesiMap.remove(kNo);
            System.out.println("Kayıt silindi..");

        }
        else if(Ogrenci.ogrenciListesiMap.containsKey(kNo)) {
            Ogrenci.ogrenciListesiMap.remove(kNo);
            System.out.println("Kayıt silindi..");
        }
        else {
            System.out.println("Kayıtlarda böyle bir kimlik numarası bulunamadı..");
        }
    }

    @Override
    public void anaMenu() throws InterruptedException {
        System.out.println(BOLD+c_GREEN+"\nAna Menüye yönlendiriliyorsunuz.."+c_RESET);
        Thread.sleep(2000);
        AnaMenu.girisEkrani();

    }

    @Override
    public void cikis() {

        System.out.println(BOLD+c_GREEN+"\nÇıkış yapıyorsunuz. Iyi günler dileriz.."+c_RESET);
    }

    public static void islemlerMenusu(int i) throws InterruptedException {
        IslemlerMenu obje = new IslemlerMenu();
        System.out.println();
        value = i;

        System.out.println(BOLD+c_PURPLE+"\t============= İŞLEMLER =============");
        System.out.println("\t1 - Ekleme ");
        System.out.println("\t2 - Arama ");
        System.out.println("\t3 - Listeleme ");
        System.out.println("\t4 - Silme ");
        System.out.println("\t5 - Ana Menü ");
        System.out.println("\t6 - Çıkış ");
        System.out.print("\tSeçiminiz : "+c_RESET);
        int secim = TryCatch.intGirisi();

        switch (secim) {
            case 1:
                obje.ekleme();
                islemlerMenusu(value);
                break;
            case 2:
                obje.arama();
                islemlerMenusu(value);
                break;
            case 3:
                obje.listeleme();
                islemlerMenusu(value);
                break;
            case 4:
                obje.silme();
                islemlerMenusu(value);
                break;
            case 5:
                obje.anaMenu();
                break;
            case 6:
                obje.cikis();
                break;
            default:
                System.out.println(BOLD+c_RED+"\n*** Hatalı Giriş. Yeniden Deneyin ***"+c_RESET);
                islemlerMenusu(value);
                break;
        }

    }

}
