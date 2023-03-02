package com.lion;

import java.util.List;
import java.util.Scanner;

public class WiseApp {

    private Scanner sc;
    private List<Wise> wiseList;


    public WiseApp(Scanner sc, List<Wise> wiseList) {
        this.sc = sc;
        this.wiseList = wiseList;
    }

    public static void run(WiseApp wiseApp) {
        int num = 0;
        System.out.println(" == 명언 앱 == ");
        while (true) {
            System.out.print("명령) ");
            String command = wiseApp.sc.nextLine().trim();
            switch (command) {
                case "종료" -> {
                    return;
                }
                case "등록" -> wiseApp.write(++num);
                case "목록" -> wiseApp.getWiseList();
                case "삭제" -> {
                    wiseApp.deleteWise(wiseApp.sc.nextInt());
                }
            }

        }
    }

    private void write(int num) {
        Wise wise = new Wise();
        wise.setNum(num);
        System.out.print("명언 : ");
        wise.setWise(sc.nextLine());
        System.out.print("작가 : ");
        wise.setWriter(sc.nextLine());
        wiseList.add(wise);
        System.out.println(num + "번 명언이 등록되었습니다.");
    }

    private void getWiseList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        for (int i = wiseList.size() - 1; i >= 0; i--) {
            int num = wiseList.get(i).getNum();
            String writer = wiseList.get(i).getWriter();
            String wise = wiseList.get(i).getWise();
            System.out.println(num + " / " + writer + " / " + wise);
        }
    }

    private void deleteWise(int num) {
        int index = num -1;
        if (wiseList.get(index) == null) {
            System.out.println(index + "번 명언은 존재하지 않습니다.");
        } else {
            wiseList.remove(index);
            System.out.println(num + "번 명언이 삭제되었습니다.");
        }
    }

}