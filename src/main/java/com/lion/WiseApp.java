package com.lion;

import java.util.Scanner;

public class WiseApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();
            if (command.equals("종료")) {
                return;
            }
        }
    }
}

class Wise {

    private String wise;
    private String writer;

    public String getWise() {
        return wise;
    }

    public void setWise(String wise) {
        this.wise = wise;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
