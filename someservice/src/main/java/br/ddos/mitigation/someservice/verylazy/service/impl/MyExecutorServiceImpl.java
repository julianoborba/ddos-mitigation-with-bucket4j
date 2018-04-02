package br.ddos.mitigation.someservice.verylazy.service.impl;

import br.ddos.mitigation.someservice.verylazy.service.MyExecutorService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MyExecutorServiceImpl implements MyExecutorService {

    public void execute() {

        final int runablesQuantity = 15;
        final int threadPoolSize = 15;

        final ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        final MyRunnable[] runnables = new MyRunnable[runablesQuantity];
        for (int runnableId = 0; runnableId < runablesQuantity; runnableId++) {

            runnables[runnableId] = new MyRunnable(runnableId);
            executorService.execute(runnables[runnableId]);
        }

        executorService.shutdown();
    }

    class MyRunnable implements Runnable {

        private final int runnableId;

        MyRunnable(final int runnableId) {

            this.runnableId = runnableId;
        }

        public void run() {

            for (int i = 0; i <= 100; i += 20) {

                System.out.println("Runnable ID: " + runnableId + ", percent complete: " + i);
                try {

                    try {

                        ClassLoader.getSystemClassLoader().loadClass("br.ddos.mitigation.someservice.verylazy.model.BigByte");
                    } catch (final ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    Thread.sleep(30000);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
