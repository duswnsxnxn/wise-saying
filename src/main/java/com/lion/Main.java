package com.lion;

import com.lion.config.AppConfig;

public class Main {

    public static void main(String[] args) {
        WiseApp wiseApp = new WiseApp();
        WiseApp.run(wiseApp);
        AppConfig.scan().close();
    }
}

