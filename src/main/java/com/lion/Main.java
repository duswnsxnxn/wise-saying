package com.lion;

import com.lion.dto.Wise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Wise> wiseList = new ArrayList<>();
        WiseApp wiseApp = new WiseApp(scanner, wiseList);
        WiseApp.run(wiseApp);
        scanner.close();
    }
}
