An implementation of the composite design pattern.

It models a desktop computer, where a case and a motherboard are both component and composite objects which consist of other component objects such as CPU, RAM, PSU and so on. If you call the `getPrice()` method of either `Case` or `Motherboard` classes, it will iterate through all of it's childcomponents and return their combined price.

![alt text](UML%2003%20Composite.png)
