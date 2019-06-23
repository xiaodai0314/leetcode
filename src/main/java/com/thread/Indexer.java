package com.thread;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
//                indexFile(queue.take());
            }
        } catch ( Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
