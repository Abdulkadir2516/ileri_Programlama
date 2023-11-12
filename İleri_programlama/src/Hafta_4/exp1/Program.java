/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp1;

/**
 * !Deadlock, starvation(açlık), livelock!
 *
 * Deadlock (Çıkmaz): Birden fazla iş parçacığı veya işlem arasında kaynakları
 * (örneğin, bellek, dosya, veritabanı bağlantısı) kullanma konusunda birbirini
 * beklemesi sonucu oluşan bir durumdur. Bu iş parçacıkları veya işlemler
 * birbirlerini bekler ve kaynaklara erişimde bir çıkmazda bulunurlar,
 *
 * Starvation(Açlık); bir iş parçacığının veya işlemin diğerlerine göre sürekli
 * olarak öncelik alması sonucu oluşan bir durumdur. Düşük öncelikli iş
 * parçacıkları veya işlemler, gerektiği gibi kaynaklara erişememek veya işlem
 * yapamamak konusunda sürekli olarak zorluk yaşarlar. yani ilerleyemezler.
 * https://www.youtube.com/watch?v=MSwWNj9egNM
 *
 * Livelock; İş parçacıklarının birbirlerine tepki vererek durmaksızın işlem
 * yapmaya devam ettiği bir durumu ifade eder. Livelock, deadlock'a benzer,
 * ancak iş parçacıkları sürekli olarak durumlarını değiştirirler ve sonuçta
 * ilerleme sağlanamaz. İş parçacıkları birbirlerine engel olurlar, ancak
 * gerçekte hiçbir işlem tamamlanmaz. Livelock durumları genellikle iş
 * parçacıkları arasında bir iletişim eksikliği veya yanıt alışverişi sorunları
 * nedeniyle meydana gelir.
 *
 * 'Starvation durumu, yanlış konfigürasyon veya işlemci yönetimi nedeniyle
 * deadlock durumuna yol açabilir veya deadlock'i daha olası hale getirebilir.
 * Deadlock’ın sonucunda Starvation olabilir. Starvation olabilmesi için
 * Process’e ihtiyaç duyulan kaynağın verilmemesi gerekir.' => fatih hoca sebep
 * olmayacağını söyledi
 *
 * @author yesil
 */
public class Program {

    public static void main(String[] args) {
        Deadlock obj1 = new Deadlock("Ahmet");
        Deadlock obj2 = new Deadlock("Mehmet");

        new Thread(() -> {
            obj1.sayHello(obj2);
        }).start();

        new Thread(() -> {
            obj2.sayHello(obj1);
        }).start();
    }
}
