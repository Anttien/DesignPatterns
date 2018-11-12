An implementation of the State design pattern.

It models a dragon that has different behaviours `move`, `claw`, `breathe` and `grow`. Those behaviours depend on the state of the dragon, which are encapsulated in the implementations of the `DragonState` interface, namely in the `DragonBaby`, `DragonYoung`, `DragonAdult`, `DragonElder` classes. The `grow` method switches the state of the dragon object, whereas the others just print stuff to the console.

![alt text](UML%2007%20State.png)
