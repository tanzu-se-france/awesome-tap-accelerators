package com.vmware.tanzu.tap.accelerators.springboot.calc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalcController {
    @GetMapping("/calc/add")
    Result add(@RequestParam("a") int a, @RequestParam("b") int b) {
        return new Result(a + b);
    }

    record Result(
            int value
    ) {
    }
}
