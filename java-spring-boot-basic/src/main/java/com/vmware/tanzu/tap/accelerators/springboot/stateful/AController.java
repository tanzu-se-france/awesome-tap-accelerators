package com.vmware.tanzu.tap.accelerators.springboot.stateful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AController {
    private final Session session;

    AController(Session session) {
        this.session = session;
    }

    @PostMapping("/stateful")
    String store(@RequestBody Form form) {
        session.setValue(form.value);
        return form.value;
    }

    record Form(
            String value
    ) {
    }
}
