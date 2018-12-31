package dp20_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A test for the Java's Iterator and how it behaves under different circumstances.
 * @author Antti Nieminen
 */
public class IteratorTest {

    private List list;
    private Iterator instanceIterator;

    public IteratorTest() {
        initializeList();
    }

    public void initializeList() {
        list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        instanceIterator = list.iterator();
    }

    /**
     * Test 1: How will the Iterator behave, when one collection is being
     * iterated by two Threads at the same time and each one is using their own
     * iterator instances?
     */
    public void test1() {
        initializeList();
        for (int i = 1; i < 3; i++) {
            Iterator iterator = list.iterator();
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread " + getName() + ": running with iterator (hash): " + list.iterator().hashCode());
                    while (iterator.hasNext()) {
                        Object next = iterator.next();
                        System.out.println("Thread " + getName() + ": - " + next.toString());
                    }
                }
            }.start();
        }
    }

    /**
     * Same as test 1 but both Threads are using the same Iterator instance?
     */
    public void test2() {
        initializeList();
        Iterator iterator = list.iterator();
        for (int i = 1; i < 3; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread " + getName() + ": running with iterator (hash): " + iterator.hashCode());
                    while (iterator.hasNext()) {
                        Object next = iterator.next();
                        System.out.println("Thread " + getName() + ": - " + next.toString());
                    }
                }
            }.start();
        }
    }

    /**
     * Test 3: What happens if you add to the collection during iterating?
     */
    public void test3() {
        initializeList();
        Iterator iterator = list.iterator();
        new Thread("" + 1) {
            public void run() {
                System.out.println("Thread " + getName() + ": running with iterator (hash): " + list.iterator().hashCode());
                int j = 0;
                while (iterator.hasNext()) {
                    if (j == 3) {
                        list.add(Math.random());
                    }
                    j++;
                    Object next = iterator.next();
                    System.out.println("Thread " + getName() + ": - " + next.toString());
                }
            }
        }.start();
    }

    /**
     * Test 4: What happens if you add to the collection during iterating using
     * ListIterator?
     */
    public void test4() {
        initializeList();
        ListIterator iterator = list.listIterator();
        new Thread("" + 1) {
            public void run() {
                System.out.println("Thread " + getName() + ": running with iterator (hash): " + iterator.hashCode());
                int j = 0;
                while (iterator.hasNext()) {
                    if (j == 3) {
                        iterator.add("O");
                    }
                    j++;
                    Object next = iterator.next();
                    System.out.println("Thread " + getName() + ": - " + next.toString());
                }
            }
        }.start();
    }

    /**
     * Test 5: What happens if you remove from the collection that is iterated
     * by two Threads at the same time with the same Iterator using
     * Iterator.remove()?
     */
    public void test5() {
        initializeList();
        for (int i = 1; i < 3; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread " + getName() + ": running with iterator (hash): " + instanceIterator.hashCode());
                    int j = 0;
                    while (instanceIterator.hasNext()) {
                        if (j == 3) {
                            instanceIterator.remove();
                        }
                        j++;
                        Object next = instanceIterator.next();
                        System.out.println("Thread " + getName() + ": - " + next.toString());
                    }
                }
            }.start();
        }
    }

    /**
     * Test 6: What happens if you remove from the collection that is iterated
     * by two Threads at the same time with different Iterators using
     * Iterator.remove()?
     */
    public void test6() {
        initializeList();
        for (int i = 1; i < 3; i++) {
            Iterator iterator = list.iterator();
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread " + getName() + ": running with iterator (hash): " + iterator.hashCode());
                    int j = 0;
                    while (iterator.hasNext()) {
                        if (j == 3) {
                            iterator.remove();
                        }
                        j++;
                        Object next = iterator.next();
                        System.out.println("Thread " + getName() + ": - " + next.toString());
                    }
                }
            }.start();
        }
    }

    public static void main(String[] args) {

        IteratorTest it = new IteratorTest();
        try {
            /* Test 1: How will the Iterator behave, 
            * when one collection is being iterated by two Threads at the same time
            * and each one is using their own iterator instances?
             */
            System.out.println("---Test 1---");
            it.test1();
            Thread.sleep(1000);

            // Test 2: Same but both Threads are using the same Iterator instance?
            System.out.println("---Test 2---");
            it.test2();
            Thread.sleep(1000);

            // Test 3: What happens if you add to the collection during iterating?
            System.out.println("---Test 3---");
            it.test3();
            Thread.sleep(1000);

            // Test 4: What happens if you add to the collection during iterating 
            // using ListIterator?
            System.out.println("---Test 4---");
            it.test4();
            Thread.sleep(1000);

            // Test 5: What happens if you remove from the collection that is iterated
            // by two Threads at the same time with the same Iterator using Iterator.remove()?
            System.out.println("---Test 5---");
            it.test5();
            Thread.sleep(1000);

            // Test 6: What happens if you remove from the collection that is iterated
            // by two Threads at the same time with different Iterators using Iterator.remove()?
            System.out.println("---Test 6---");
            it.test6();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }

    }

}
