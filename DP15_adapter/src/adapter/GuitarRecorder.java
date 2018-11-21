package adapter;

public interface GuitarRecorder {
	public void plugInGuitar(UnbalancedMonoCable guitarIn);
        public void plugInHeadphones(Headphones headphones);
	public BalancedStereoCable headphonesOut();
        public void record(String signalIn);
}
