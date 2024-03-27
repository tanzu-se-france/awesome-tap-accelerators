package com.vmware.tanzu.tap.accelerators.springboot.todo;

import org.springframework.http.ResponseEntity;

public interface ExternalAPIClient {
    ResponseEntity<String> getDataFromExternalAPI();
    ResponseEntity<String> getTodoByIdFromExternalAPI(Long id);
}

