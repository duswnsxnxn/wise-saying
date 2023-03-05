package com.lion.controller;

import com.lion.service.WiseService;

public class WiseController {

    private final WiseService wiseService;

    public WiseController() {
        wiseService = new WiseService();
    }

    public void write() {
        wiseService.write();
    }

    public void getList() {
        wiseService.getList();
    }

    public void modify(int num) {
        wiseService.modify(num);
    }

    public void delete(int num) {
        wiseService.delete(num);
    }
}
