/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author Antti Nieminen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clock clock = new Clock((PointerHour) PointerFactory.getPointer("hour"),
                (PointerMinute) PointerFactory.getPointer("minute"),
                (PointerSecond) PointerFactory.getPointer("second"));
        clock.setHour(23);
        clock.setMinute(59);
        clock.setSecond(23);
        Thread t = new Thread(clock);
        t.start();

        Clock clock2 = (Clock) clock.clone();
        clock2.setHour(4);
        clock2.setMinute(20);
        clock2.setSecond(0);
        Thread t2 = new Thread(clock2);
        t2.start();
    }

}
