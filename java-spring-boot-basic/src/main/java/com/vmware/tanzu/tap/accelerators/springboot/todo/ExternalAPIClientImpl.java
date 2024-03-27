package com.vmware.tanzu.tap.accelerators.springboot.todo;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalAPIClientImpl implements ExternalAPIClient {

    private final RestTemplate restTemplate;

    public ExternalAPIClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> getDataFromExternalAPI() {
        String url = "https://jsonplaceholder.typicode.com/todos";
        HttpHeaders headers = new HttpHeaders();
        // Set headers if needed
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
    }
    @Override
    public ResponseEntity<String> getTodoByIdFromExternalAPI(Long id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        HttpHeaders headers = new HttpHeaders();
        // Set headers if needed
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
    }
}

