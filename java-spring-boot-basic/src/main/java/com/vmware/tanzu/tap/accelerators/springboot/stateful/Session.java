package com.vmware.tanzu.tap.accelerators.springboot.stateful;

interface Session {
    String getValue();

    void setValue(String value);
}
