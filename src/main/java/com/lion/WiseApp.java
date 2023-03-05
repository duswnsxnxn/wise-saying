package com.lion;

import com.lion.config.AppConfig;
import com.lion.controller.WiseController;
import com.lion.module.Transfer;

public class WiseApp {

    private final WiseController wiseController;

    public WiseApp() {
        wiseController = new WiseController();
    }

    public static void run(WiseApp wiseApp) {
        System.out.println(" == 명언 앱 == ");
        while (true) {
            Transfer transfer = new Transfer();
            System.out.print("명령) ");
            transfer.transfer(AppConfig.scan().nextLine());
            String command = transfer.getActionCode();
            if (command == null) {
                continue;
            }
            switch (command) {
                case "종료" -> {
                    return;
                }
                case "등록" -> wiseApp.wiseController.write();
                case "목록" -> wiseApp.wiseController.getList();
                case "삭제" -> wiseApp.wiseController.delete(transfer.getNum());
                case "수정" -> wiseApp.wiseController.modify(transfer.getNum());
            }

        }
    }
}