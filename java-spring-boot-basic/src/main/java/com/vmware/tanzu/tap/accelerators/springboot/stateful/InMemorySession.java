package com.vmware.tanzu.tap.accelerators.springboot.stateful;

class InMemorySession implements Session {
    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
