package singleton;

public class SpaceBeeFactory {

	public synchronized SpaceBee createSpaceBee(SpaceBeeHive hive) {
            return new SpaceBee(hive);
	}

}
