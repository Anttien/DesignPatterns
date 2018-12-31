Two simple tests to see how Java uses shared flyweight objects within String and Swing libraries. The tests are based on David Geary's article in JavaWorld (https://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html).

##### StringTest

Strings that are specified at compile-time and that contain the same character sequence are flyweights in Java. That´s why the strings `fly` and `fly2` refer to the same String instance. On the other hand, if String objects are concatenated, it is done during runtime and the products of this are not flyweights by default. This can be avoided with the method `String.intern()`, which returns flyweights for strings computed at runtime.

##### SwingTest

Swing provides a border factory that creates flyweight borders. Therefore the comparing of `border1` and `border2` results true. Each border has shared intrinsic states, and the extrinsic states (in this case only `Dimension`) are passed in during runtime. 
 
