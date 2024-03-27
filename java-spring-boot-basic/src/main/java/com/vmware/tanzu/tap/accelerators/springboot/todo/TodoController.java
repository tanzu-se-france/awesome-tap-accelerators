package com.vmware.tanzu.tap.accelerators.springboot.todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final ExternalAPIClient externalAPIClient;

    public TodoController(ExternalAPIClient externalAPIClient) {
        this.externalAPIClient = externalAPIClient;
    }

    @GetMapping("/todos")
    public ResponseEntity<String> getDataFromExternalAPI() {
        ResponseEntity<String> response = externalAPIClient.getDataFromExternalAPI();
        return response;
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<String> getTodoById(@PathVariable("id") Long id) {
        ResponseEntity<String> response = externalAPIClient.getTodoByIdFromExternalAPI(id);
        return response;
    }
}
