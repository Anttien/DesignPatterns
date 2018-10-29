An implementation of abstract factory design pattern. 

There are two product families - Adidas and Boss - and a factory for each family. The `Student` object has each of the family products as an instance variable. The idea is to provide an easy way for the client to change the clothes of the student without it knowing the details of the object creation.

It also uses the reflection API to fetch factory names from a .properties file providing a dynamic way to change or upgrade factories.

![alt text](UML%2002%20Abstract%20Factory.png)
