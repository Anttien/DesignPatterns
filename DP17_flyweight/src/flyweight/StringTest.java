package flyweight;

/**
 * Tests if java String objects are flyweight objects.
 *
 * Source:
 * <a href=https://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html>
 * Javaworld </a>
 */
public class StringTest {

    public static void main(String[] args) {
        String fly = "fly", weight = "weight";
        String fly2 = "fly", weight2 = "weight";
        System.out.println(fly == fly2);       // fly and fly2 refer to the same String instance
        System.out.println(weight == weight2); // weight and weight2 also

        // Concatenated String literals are interned and refer to the same String instance
        String distinctString1 = "fly" + "weight";
        System.out.println(distinctString1 == "flyweight");

        // If the String concatenation has a String object as one of it's operand,
        // it is computed at run-time and is not referring to the flyweight object by default.
        String distinctString2 = "fly" + weight;
        System.out.println(distinctString2 == "flyweight");
        String distinctString3 = fly + weight;
        System.out.println(distinctString3 == "flyweight");
        String flyweight = (fly + weight).intern();
        System.out.println(flyweight == "flyweight"); // The intern() method returns a flyweight
    }
}
