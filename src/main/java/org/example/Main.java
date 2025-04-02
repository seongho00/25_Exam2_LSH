package org.example;

import org.example.container.Container;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App();
        Container.close();
    }
}
