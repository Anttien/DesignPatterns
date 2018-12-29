package adapter;

/**
 * The main driver class for the program that implements the adapter design
 * pattern. This program represents a situation where a guitar player wants to
 * record and listen to his playing using a modern digital recorder or an old
 * analog recorder. The old analog recorder has a different UI than the modern
 * one, but the player prefers the modern UI. An adapter is used to make the
 * needed connections to fill this requirement.
 *
 * @author Antti Nieminen
 */
public class GuitarPlayer {

    private GuitarRecorder recorder;
    private Headphones headphones;

    public void setup(GuitarRecorder recorder) {
        this.recorder = recorder;
        this.headphones = new Headphones();
        recorder.plugInGuitar(new UnbalancedMonoCable());
        recorder.plugInHeadphones(headphones);
    }

    public void play() {
        System.out.println(headphones.listen());
        recorder.record("A cheesy guitar solo");
        System.out.println(headphones.listen());
    }

    public static void main(String[] args) {
        GuitarPlayer steveVai = new GuitarPlayer();
        steveVai.setup(new ModernRecorder());
        steveVai.play();
        steveVai.setup(new LegacyRecorderAdapter(new LegacyRecorder()));
        steveVai.play();
    }

}
