package com.vmware.tanzu.tap.accelerators.springboot.cat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
class CatController {
    @GetMapping("/cat")
    String call() {
        return RestClient.create().get().uri("https://cataas.com/cat?json=true").retrieve().body(String.class);
    }
}
