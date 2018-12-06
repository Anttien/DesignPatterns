This project simulates a system of 3 Christmas lights that are controller by switches that can turn each lights on/off or have them all blink in a sequence. The project implements the command design pattern by decoupling the operation invoking objects from the objects that perform the operation.

The invoker class `Switch` simulates both an on/off switch and a button. With the composite/macro command `BlinkAllCommand`, all lights can be turned on and off in a sequential manner. The command is called by a thread in a button-type invoker object to simulate continuos action.

![alt text](https://github.com/Iepvzaeh/DesignPatterns/blob/master/DP22_command/UML%2022%20Command.png)