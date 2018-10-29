An implementation that combines both the composite design pattern and abstract factory.

It models a desktop computer, where a case and a motherboard are both component and composite objects which consist of other component objects such as CPU, RAM, PSU and so on. If you call the `getPrice()` method of either `Case` or `Motherboard` classes, it will iterate through all of it's childcomponents and return their combined price. `ComponentAbstract` is needed to provide implementation for `add`, `remove` and `getChildComponents` in those subclasses that cannot have child components.

The abstract factory method allows a way to create and change product families (in this case, "Expensive" and "Cheap") on the fly without the client knowing about the details.

![alt text](UML%2003b%20Composite%20Abstract%20Factory.png)
