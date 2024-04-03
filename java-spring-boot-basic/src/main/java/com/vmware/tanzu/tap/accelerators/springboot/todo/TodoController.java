package com.vmware.tanzu.tap.accelerators.springboot.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
class TodoController {
    private final String todosApiUrl;

    TodoController(@Value("${app.services.todos}") String todosApiUrl) {
        this.todosApiUrl = todosApiUrl;
    }

    @GetMapping("/todos")
    String call() {
        return RestClient.create().get().uri(todosApiUrl).retrieve().body(String.class);
    }

    @GetMapping("/todos/{id}")
    String callById(@PathVariable("id") long id) {
        final var args = Map.of("id", id);
        return RestClient.create().get().uri(todosApiUrl + "/{id}", args).retrieve().body(String.class);
    }
}
