package singleton;

public class SpaceBeeFactory {

	public SpaceBee createSpaceBee(SpaceBeeHive hive) {
            return new SpaceBee(hive);
	}

}
