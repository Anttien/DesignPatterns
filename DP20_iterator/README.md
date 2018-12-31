A test for the Java's Iterator and how it behaves under different circumstances.

**Test 1**: How will the Iterator behave,  when one collection is being iterated by two threads at the same time and each one is using their own Iterator instances?
**Result**: Both threads will iterate through all the elements of the list by their own.

**Test 2**: Same but both threads are using the same Iterator instance?
**Result**: As the Iterator is shared, the list is iterated only once.

**Test 3**: What happens if you add to the collection during iterating?
**Result**: Iterator will throw ConcurrentModificationException. AbstractList and Iterator keeps track of the modifications that has been made to the List, and if any modifications are made to the List that has been done without using Iterator's methods, it will throw this error.

**Test 4**: What happens if you add to the collection during iterating using ListIterator?
**Result**: Adding with ListIterator's add() method, a new element is inserted before the element that would be returned by next().

**Test 5**: What happens if you remove from the collection that is iterated by two threads at the same time with the same Iterator using Iterator.remove()?
**Result**: Using Iterator's own modification method will be successful and the list is iterated only once.

**Test 6**: What happens if you remove from the collection that is iterated by two threads at the same time with different Iterators using Iterator.remove()?
**Result**: The first iterator to find out that the List has changed will throw ConcurrentModificationException and the other will iterate succesfully to the end.

**Example output:**
```
---Test 1---
Thread 1: running with iterator (hash): 1918543628
Thread 2: running with iterator (hash): 1072770020
Thread 1: - a
Thread 1: - b
Thread 1: - c
Thread 1: - d
Thread 2: - a
Thread 2: - b
Thread 2: - c
Thread 2: - d
Thread 1: - e
Thread 2: - e
Thread 1: - f
Thread 1: - g
Thread 2: - f
Thread 1: - h
Thread 1: - i
Thread 2: - g
Thread 2: - h
Thread 2: - i
---Test 2---
Thread 1: running with iterator (hash): 510440134
Thread 2: running with iterator (hash): 510440134
Thread 1: - a
Thread 1: - c
Thread 1: - d
Thread 1: - e
Thread 1: - f
Thread 2: - b
Thread 1: - g
Thread 2: - h
Thread 1: - i
---Test 3---
Thread 1: running with iterator (hash): 1842795253
Thread 1: - a
Thread 1: - b
Thread 1: - c
Exception in thread "1" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.next(ArrayList.java:859)
	at dp20_iterator.IteratorTest$3.run(IteratorTest.java:90)
---Test 4---
Thread 1: running with iterator (hash): 1022787014
Thread 1: - a
Thread 1: - b
Thread 1: - c
Thread 1: - d
Thread 1: - e
Thread 1: - f
Thread 1: - g
Thread 1: - h
Thread 1: - i
---Test 5---
Thread 1: running with iterator (hash): 1408828017
Thread 2: running with iterator (hash): 1408828017
Thread 1: - a
Thread 1: - c
Thread 1: - d
Thread 2: - b
Thread 2: - f
Thread 1: - e
Thread 1: - h
Thread 1: - i
Thread 2: - g
---Test 6---
Thread 1: running with iterator (hash): 636968915
Thread 2: running with iterator (hash): 1587602099
Thread 2: - a
Thread 2: - b
Thread 1: - a
Thread 1: - b
Thread 1: - c
Exception in thread "2" java.util.ConcurrentModificationException
Thread 1: - d
Thread 1: - e
Thread 2: - c
Thread 1: - f
Thread 1: - g
Thread 1: - h
Thread 1: - i
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.remove(ArrayList.java:873)
	at dp20_iterator.IteratorTest$6.run(IteratorTest.java:160)
BUILD SUCCESSFUL (total time: 6 seconds)
```