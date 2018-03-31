package br.ddos.mitigation.someservice.verylaze;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/verylazy")
public class SomeServiceVeryLazy {

    @GetMapping
    public String get() throws Exception {

        System.out.println("Very lazy service reached...");

        final int numWorkers = 15;
        final int threadPoolSize = 15;
        final ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        final WorkerThread[] workers = new WorkerThread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new WorkerThread(i);
            executorService.execute(workers[i]);
        }
        executorService.shutdown();

        return "Very lazy service returning...";
    }
}

