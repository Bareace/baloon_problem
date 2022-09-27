package quiz3;

import java.util.Scanner;

public class Quiz3 {

    //Patlamadan kalan balonun pozisyonunun bulunduğu metot
    static void balonPozisyonuBul(int n, int k) {

        //n adet balondan oluşan dairesel bağlı listenin oluşturulması
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i < n + 1; i++) {
            temp.link = new Node(i);
            temp = temp.link;

        }
        //Son düğümle ilk düğümün birbirine bağlanması
        temp.link = head;

        //Listenin içinde dolanacak olan 2 balonun başlangıça eşitlenmesi
        Node bal1 = head;
        Node bal2 = head;
        //Bağlandığı balon kendisi olmadığı sürece dönecek olan döngü
        while (bal1.link != bal1) {
            int sira = 1;
            while (sira != k) { //Sıra k. balonda olmadığı sürece dönecek olan döngü
                //Patlaması gerekmeyen balonun listede ilerlemesi
                bal2 = bal1;
                bal1 = bal1.link;
                sira++;
            }
            //Patlaması gereken balonun listeden çıkarılması
            bal2.link = bal1.link;
            bal1 = bal2.link;

        }
        //Eğer 1. sıradaki balonlar patlatılırsa kalan balonun son balona eşitlenmesi
        if (k == 1) {
            bal1.data = n;
        }
        //Son kalan balonun pozisyonunun yazdırılması
        System.out.println(bal1.data + ". pozisyondaki balon patlamadan kalır.");

    }

    //Kullanıcıdan bilgilerin alınıp sonuçların yazdırılacağı main metodu
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Balon sayısını giriniz:");
        int n = input.nextInt(); //Kullanıcıdan balon sayısının alınması
        System.out.println("Her seferinde kaçıncı balonun patlatılacağını giriniz:");
        int k = input.nextInt();//Kullanıcıdan her seferinde kaçıncı balonun patlatılacağının bilgisinin alınması
        System.out.println("n = " + n + " ve k = " + k + " için");
        balonPozisyonuBul(n, k); //Kullanıcıdan alınan bilgilere göre metodun çağrılması

    }
}
