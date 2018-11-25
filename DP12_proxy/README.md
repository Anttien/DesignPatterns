This project implements the Virtual Proxy design pattern. The `RealImage` represents an heavy object (an image on a file system) that is not loaded until it is needed but is represented using a virtual proxy object `ProxyImage`. `ProxyImage` knows only the name of the image file and loads the actual `RealImage` object on demand. This provides a way to list images on a file system without using bandwidth for loading resources that are not relevant.

![alt text](https://github.com/Iepvzaeh/DesignPatterns/blob/master/DP12_proxy/UML%2012%20Proxy.png)
