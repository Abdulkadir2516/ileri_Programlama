/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp4;

import java.util.Random;

/**
 *
 * @author abdul
 */
public class Predictor extends Thread {

    private final Random rnd;
    private final Producer producer;
    private final int numOfPredictors;
    private volatile int val;

    public Predictor(Producer producer, int numOfPredictors) {
        rnd = new Random();
        this.producer = producer;
        this.numOfPredictors = numOfPredictors;

    }

    @Override
    public void run() {
        while (true) {
            val = rnd.nextInt(numOfPredictors * 2);
            if (producer.value() == val) {
                System.out.println(getName() + "predict accurately (" + val + ")");
            } else {
                System.out.println(getName() + "predict inaccurately (" + val + ")");
            }

            synchronized (producer.isDone) {
                producer.isDone.set(Integer.parseInt(getName().substring(7)) - 1, true);

            }
            synchronized (producer) {
                if (producer.isDone.cardinality() == numOfPredictors) {
                    producer.notify();
                }

            }

            synchronized (producer.notifier) {
                try {
                    if (producer.isDone.get(Integer.parseInt(getName().substring(7)) - 1)) {
                        producer.notifier.wait();
                    }
                } catch (InterruptedException e) {
                }

            }

        }
    }

}
