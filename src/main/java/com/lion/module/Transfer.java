package com.lion.module;

import java.util.stream.Collectors;

public class Transfer {

    private String actionCode;
    private int num;

    public void transfer(String command) {
        if (command.length() > 2) {
            String collect = command.chars()
                    .filter((ch) -> (48 <= ch && ch <= 57))
                    .mapToObj(ch -> (char) ch)
                    .map(Object::toString)
                    .collect(Collectors.joining());
            this.num = Integer.parseInt(collect);
        } else {
            if (command.length() > 1) {
                this.actionCode = command.substring(0, 2);
            } else {
                System.out.println("정확한 명령을 주십시오");
            }
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public int getNum() {
        return num;
    }

}
