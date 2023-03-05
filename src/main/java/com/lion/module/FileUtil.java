package com.lion.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lion.dto.Wise;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    private String path;

    public FileUtil() {
        this.path = "C:\\Users\\duswn\\Desktop\\wiseApp\\src\\main\\java\\com\\lion\\repository\\";
    }

    public void save(Wise wise) {
        try {
            FileWriter fileWriter = new FileWriter(path + "repository.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(wise);
            bufferedWriter.write(jsonStr);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Wise> read() {
        List<Wise> wiseList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path + "repository.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(path + "repository.txt");
            List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            for (int i = 0; i < list.size(); i++) {
                Wise wise = mapper.readValue(list.get(i), Wise.class);
                wiseList.add(wise);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wiseList;
    }

    public Wise findById(int num) {
        Wise wise = null;
        try {
            FileReader fileReader = new FileReader(path + "repository.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(path + "repository.txt");
            List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset())
                    .stream().filter(line -> line.contains("\"num\":" + num))
                    .collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                wise = mapper.readValue(list.get(i), Wise.class);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wise;
    }

    public void delete(int num) {
        try {
            FileReader fileReader = new FileReader(path + "repository.txt");
            File file = new File(path + "repository.txt");
                List<String> out = Files.lines(file.toPath())
                        .filter(line -> !line.contains("\"num\":" + num))
                        .collect(Collectors.toList());
                Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modify(Wise wise) {
        delete(wise.getNum());
        save(wise);
    }

    public int wiseNum() {

        int num = 0;
        try {
            FileReader fileReader = new FileReader(path + "repository.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            File file = new File(path + "repository.txt");
            num = (int) Files.lines(file.toPath())
                    .count();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}
