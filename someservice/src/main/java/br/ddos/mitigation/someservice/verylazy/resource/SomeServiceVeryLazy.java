package br.ddos.mitigation.someservice.verylazy.resource;

import br.ddos.mitigation.someservice.verylazy.service.MyExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verylazy")
public class SomeServiceVeryLazy {

    private final MyExecutorService myExecutorService;

    @Autowired
    public SomeServiceVeryLazy(final MyExecutorService myExecutorService) {

        this.myExecutorService = myExecutorService;
    }

    @GetMapping
    public String get() throws Exception {

        System.out.println("Very lazy service reached...");

        myExecutorService.execute();

        return "Very lazy service returning...";
    }
}

