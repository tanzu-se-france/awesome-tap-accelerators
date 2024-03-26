package com.vmware.tanzu.tap.accelerators.springboot.stateful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BController {
    private final Session session;

    BController(Session session) {
        this.session = session;
    }

    @GetMapping("/stateful")
    String retrieve() {
        return session.getValue();
    }
}
