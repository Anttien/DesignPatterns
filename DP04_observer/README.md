An implementation of Observer Design Pattern using the Java Observer and Observable API. It implements both the Push and Pull models.

`ClockTimer` is an `Observable` or Subject that updates every second and keeps track of seconds, minutes and hours. It does so
by starting a Thread that updates the time every second. `Clock`, `PointerHour`, `PointerMinute` and `PointerSecond` are Observers, from which the first one is updated by the Subject pushing it's state into it, and the rest are updated by pulling the state from the Observer.

![alt text](UML%2004%20Observer.png)
