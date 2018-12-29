package adapter;

/**
 * An interface for the "UI" of a recorder. This class is the target of the
 * adapted design pattern. 
 *
 * @author Antti Nieminen
 */
public interface GuitarRecorder {

    public void plugInGuitar(UnbalancedMonoCable guitarIn);

    public void plugInHeadphones(Headphones headphones);

    public BalancedStereoCable headphonesOut();

    public void record(String signalIn);
}
