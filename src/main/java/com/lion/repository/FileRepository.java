package com.lion.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lion.dto.Wise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileRepository {

    public void save(List<Wise> list){
        String path = "C:\\Users\\duswn\\Desktop\\wiseApp\\src\\main\\java\\com\\lion\\repository\\";
        try {
            FileWriter fileWriter = new FileWriter(path + "repository.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(list);
            bufferedWriter.write(jsonStr);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Wise> read() {
        return null;
    }

    public void modify(int num) {

    }

    public void delete(int num) {

    }

}
