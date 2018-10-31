An implementation of Observer Design Pattern using the Java Observer and Observable API. It models two clocks simultaneously, each implementing either the Push or the Pull model.

`ClockTimer` is an `Observable` (or subject) that updates every second and keeps track of seconds, minutes and hours. It does so
by starting a thread that updates the time every second. 

`Clock`, `PointerHour`, `PointerMinute` and `PointerSecond` are observers, from which the first one is updated by the subject pushing it's state into it and the rest are updated by pulling the state from the observer. Every observer prints their state to the console once they are notified.

![alt text](UML%2004%20Observer.png)
