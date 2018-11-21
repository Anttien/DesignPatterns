package adapter;

/**
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
