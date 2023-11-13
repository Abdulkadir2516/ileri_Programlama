/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp1;

import java.math.BigInteger;

/**
 * Volatile (volatile):
 *
 * volatile anahtar kelimesi, bir değişkenin iş parçacıkları arasında güvenli
 * bir şekilde paylaşılmasını sağlar. volatile olarak işaretlenen bir değişken,
 * önbellek sorunlarını çözmek ve değişkenin değerini güncel ve görünür tutmak
 * için kullanılır. volatile değişkenler, her bir iş parçacığının bu değişkeni
 * kendi yerel önbelleğinde saklamasını önler. Bu sayede, bir iş parçacığı
 * tarafından yapılan değişiklikler hemen diğer iş parçacıkları tarafından
 * görülebilir.
 * !Kısaca değişkenler işlemcinin cache belleğinde tutuluyor ve bu da olan güncellemelerden
 * diğer iş parçacıklarının geç haberi oluyor, bunu önlemek amacıyla veriler işlemci üzerindeki
 * cache bellek yerine direkt ramde tutuluyor ki o değişkenle ihtiyacı olan iş parçacıklarının
 * o verinin güncel halini anlık olarak görebilsin.!
 * @author recep
 */
public class Factorial extends Thread {

    private final int number;
    //private BigInteger result;
    //private votalite boolean isRunning;

    public Factorial(int number) {
        this.number = number;
        //result = BigInteger;
    }

    @SuppressWarnings("empty-statement")
    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        //isRunning = true;
        if (1 < number) {

        }
    }

}
