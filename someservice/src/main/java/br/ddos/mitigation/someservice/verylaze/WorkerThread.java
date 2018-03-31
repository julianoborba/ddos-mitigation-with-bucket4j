package br.ddos.mitigation.someservice.verylaze;

public class WorkerThread implements Runnable {

    private final int workerNumber;

    WorkerThread(final int number) {

        workerNumber = number;
    }

    public void run() {

        for (int i = 0; i <= 100; i += 20) {

            // Perform some work ...
            System.out.println("Worker number: " + workerNumber + ", percent complete: " + i);
            try {
                try {
                    ClassLoader.getSystemClassLoader().loadClass("br.ddos.mitigation.someservice.verylaze.BigByte");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
