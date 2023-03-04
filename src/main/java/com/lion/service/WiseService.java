package com.lion.service;

import com.lion.config.AppConfig;
import com.lion.dto.Wise;
import com.lion.repository.FileRepository;

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

//    public void modify(int num) {
//        int index = num - 1;
//        Wise wise = wiseList.get(index);
//        if (wise == null || wise.isCheck() == true) {
//            System.out.println(num + "번 명언은 존재하지 않습니다.");
//        }
//        System.out.println("명언(기존) : " + wise.getWise());
//        System.out.print("명언 : ");
//        wise.setWise(sc.nextLine());
//        System.out.println("작가(기존) : " + wise.getWriter());
//        System.out.print("작가 : ");
//        wise.setWriter(sc.nextLine());
//    }

    public void delete(int num) {
        fileRepository.delete(num);
//        try {
//            if (wiseList.get(index).isCheck() == true) {
//                System.out.println(num + "번 명언은 존재하지 않습니다.");
//            } else {
//                wiseList.get(index).setCheck(true);
//                System.out.println(num + "번 명언이 삭제되었습니다.");
//            }
//        } catch (Exception e) {
//            System.out.println("삭제할 번호를 정확히 입력해주세요.");
//        }
    }

}
