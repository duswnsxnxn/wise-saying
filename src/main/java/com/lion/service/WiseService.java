package com.lion.service;

import com.lion.config.AppConfig;
import com.lion.dto.Wise;
import com.lion.repository.FileRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WiseService {

    private final FileRepository fileRepository;

    public WiseService() {
        fileRepository = new FileRepository();
    }

    public void write() {
        Wise wise = new Wise();
        System.out.print("명언 : ");
        wise.setWise(AppConfig.scan().nextLine());
        System.out.print("작가 : ");
        wise.setWriter(AppConfig.scan().nextLine());
        int num = fileRepository.getNum() + 1;
        wise.setNum(num);
        fileRepository.save(wise);
        System.out.println(num + "번 명언이 등록되었습니다.");
    }

    public void getList() {
        List<Wise> wiseList = fileRepository.read();
        Collections.sort(wiseList, (o1, o2) -> o2.getNum() - o1.getNum());
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        for (int i = 0; i < wiseList.size(); i++) {
            int num = wiseList.get(i).getNum();
                String writer = wiseList.get(i).getWriter();
                String wise = wiseList.get(i).getWise();
                System.out.println(num + " / " + writer + " / " + wise);
        }
    }

    public void delete(int num) {
        Wise byId = fileRepository.findById(num);
        try {
            if (byId == null) {
                System.out.println(num + "번 명언은 존재하지 않습니다.");
            } else {
                fileRepository.delete(num);
                System.out.println(num + "번 명언이 삭제되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("삭제할 번호를 정확히 입력해주세요.");
        }
    }

    public void modify(int num) {
        Wise byId = fileRepository.findById(num);
        if (byId == null) {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        } else {
            Wise wise = new Wise();
            System.out.println("명언(기존) : " + byId.getWise());
            System.out.print("명언 : ");
            wise.setWise(AppConfig.scan().nextLine());
            System.out.println("작가(기존) : " + byId.getWise());
            System.out.print("작가 : ");
            wise.setWriter(AppConfig.scan().nextLine());
            wise.setNum(num);
            fileRepository.modify(wise);
            System.out.println(num + "번 명언이 수정되었습니다.");
        }
    }
}
