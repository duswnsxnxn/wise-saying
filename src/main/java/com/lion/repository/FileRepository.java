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
        return FileUtil.read(fileUtil);
    }

    public void modify(int num) {

    }

    public void delete(int num) {

    }

    public int getNum() {
        return fileUtil.wiseNum();
    }

}
