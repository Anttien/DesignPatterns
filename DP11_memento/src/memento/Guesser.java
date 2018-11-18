
package memento;

import java.util.Random;

/**
 *
 * @author Antti Nieminen
 */
public class Guesser implements Runnable {
    
    private final Riddler riddler;
    private Object answer;
    private final Random random;

    public Guesser(Riddler riddler) {
        this.riddler = riddler;
        random = new Random();
    }

    @Override
    public void run() {
        answer = riddler.joinGame(this);
        int guess = random.nextInt(1000);
        while(!riddler.guess(answer, guess)) {
            guess = random.nextInt(1000);
        }
        System.out.println("Got it! It was " + guess);
    }

}
