package org.example.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {

    private final int _capacity;
    private final int[] _queue;
    private final ReentrantLock _lock = new ReentrantLock();
    private final Condition empty = _lock.newCondition();
    private final Condition full = _lock.newCondition();
    private int size;
    private int d = 0, e = 0;

    public CustomBlockingQueue(final int capacity) {
        _capacity = capacity;
        _queue = new int[capacity];
    }

    public void enqueu(int element) throws Exception {
        _lock.lock();
        try {
            while (size == _capacity) {
                full.await();
            }
            _queue[e] = element;
            e = (e + 1) % _capacity;
            size++;
            empty.signal();
        } finally {
            _lock.unlock();
        }
    }

    public int dequeue() throws Exception {
        _lock.lock();
        try {
            while (size == 0) {
                empty.await();
            }
            int element = _queue[d];
            d = (d + 1) % _capacity;
            full.signal();
            return element;
        } finally {
            _lock.unlock();
        }
    }

}
