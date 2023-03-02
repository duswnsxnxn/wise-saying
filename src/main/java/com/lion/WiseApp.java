package com.lion;

import com.lion.module.Transfer;

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
            Transfer transfer = new Transfer();
            System.out.print("명령) ");
            transfer.transfer(wiseApp.sc.nextLine());
            String command = transfer.getActionCode();
            if (command == null) {
                continue;
            }
            switch (command) {
                case "종료" -> {
                    return;
                }
                case "등록" -> wiseApp.write(++num);
                case "목록" -> wiseApp.getWiseList();
                case "삭제" -> wiseApp.deleteWise(transfer.getNum());
                case "수정" -> wiseApp.modify(transfer.getNum());
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
            if (wiseList.get(i).isCheck() == false) {
                String writer = wiseList.get(i).getWriter();
                String wise = wiseList.get(i).getWise();
                System.out.println(num + " / " + writer + " / " + wise);
            }
        }
    }

    private void deleteWise(int num) {
        int index = num - 1;
        try {
            if (wiseList.get(index).isCheck() == true) {
                System.out.println(num + "번 명언은 존재하지 않습니다.");
            } else {
                wiseList.get(index).setCheck(true);
                System.out.println(num + "번 명언이 삭제되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제할 번호를 정확히 입력해주세요.");
        }
    }

    private void modify(int num) {
        int index = num - 1;
        Wise wise = wiseList.get(index);
        if (wise == null || wise.isCheck() == true) {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        }
        System.out.println("명언(기존) : " + wise.getWise());
        System.out.print("명언 : ");
        wise.setWise(sc.nextLine());
        System.out.println("작가(기존) : " + wise.getWriter());
        System.out.print("작가 : ");
        wise.setWriter(sc.nextLine());
    }


}