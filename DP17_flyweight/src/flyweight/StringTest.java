package flyweight;

/**
 * Tests when Java String objects are flyweight objects. Strings that are
 * specified at compile-time and that contain the same character sequence are
 * flyweights in Java. That´s why the strings `fly` and `fly2` refer to the same
 * String instance. On the other hand, if String objects are concatenated, it is
 * done during runtime and the products of this are not flyweights by default.
 * This can be avoided with the method String.intern(), which returns flyweights
 * for strings computed at runtime. 
 * 
 * Source:
 * <a href=https://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html>
 * Javaworld </a>
 */
public class StringTest {

    public static void main(String[] args) {
        /* 
        * true: String objects instantiated at compile-time refer to the same 
        * String instance, if the content is same
         */
        String fly = "fly", weight = "weight";
        String fly2 = "fly", weight2 = "weight";
        System.out.println(fly == fly2);
        System.out.println(weight == weight2);

        // true : concatenated String literals are interned and refer to the same String instance
        String distinctString1 = "fly" + "weight";
        System.out.println(distinctString1 == "flyweight");

        /* 
        * false: if the String concatenation has a String object as one of it's operand,
        * it is computed at run-time and is not referring to the flyweight object by default.
         */
        String distinctString2 = "fly" + weight;
        System.out.println(distinctString2 == "flyweight");
        String distinctString3 = fly + weight;
        System.out.println(distinctString3 == "flyweight");

        // true: The intern() method returns a flyweight
        String flyweight = (fly + weight).intern();
        System.out.println(flyweight == "flyweight");
    }
}
