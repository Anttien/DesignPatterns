
package memento;

import java.util.Random;

/**
 *
 * @author Antti Nieminen
 */
public class Riddler {
    
    Random random;

    public Riddler() {
        random = new Random();
    }
    
    public Object joinGame() {
        // Create a random number and store it in memento, return it
        int rightAnswer = random.nextInt(1000);
        Answer answer = new Answer(rightAnswer);
        return answer;
    }
    
    public boolean guess(Object hiddenAnswer, int answer) {
        Answer rightAnswer = (Answer)hiddenAnswer;
        return rightAnswer.getAnswer() == answer;
    }
    
    private class Answer {
        
        int answer;

        public Answer(int answer) {
            this.answer = answer;
        }

        public int getAnswer() {
            return answer;
        }
    }

}
