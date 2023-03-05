package com.lion.repository;

import com.lion.dto.Wise;
import com.lion.module.FileUtil;

import java.util.List;

public class FileRepository {

    private final FileUtil fileUtil;

    public FileRepository() {
        fileUtil = new FileUtil();
    }

    public void save(Wise wise){
        fileUtil.save(wise);
    }

    public List<Wise> read() {
        return fileUtil.read();
    }

    public void modify(Wise wise) {
        fileUtil.modify(wise);
    }

    public void delete(int num) {
        fileUtil.delete(num);
    }

    public int getNum() {
        return fileUtil.wiseNum();
    }

    public Wise findById(int num) {
        return fileUtil.findById(num);
    }

}
