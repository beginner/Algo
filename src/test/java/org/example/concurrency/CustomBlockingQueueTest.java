package org.example.concurrency;

import org.junit.jupiter.api.Test;


public class CustomBlockingQueueTest {

    @Test
    public void testDequeIsBlocked() {
        CustomBlockingQueue q = new CustomBlockingQueue(1);
        Thread t1 = new Thread(() -> {
            try {
                q.dequeue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                q.enqueu(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
    }


}
