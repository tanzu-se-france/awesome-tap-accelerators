package com.vmware.tanzu.tap.accelerators.springboot.stateful;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class SessionConfig {
    @Bean
    InMemorySession session() {
        return new InMemorySession();
    }
}
