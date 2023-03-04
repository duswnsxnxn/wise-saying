package com.lion;

import com.lion.config.AppConfig;
import com.lion.controller.WiseController;
import com.lion.dto.Wise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WiseApp wiseApp = new WiseApp();
        WiseApp.run(wiseApp);
        AppConfig.scan().close();
    }
}
