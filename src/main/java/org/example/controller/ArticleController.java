package org.example.controller;

import org.example.container.Container;
import org.example.Motivation;
import org.example.util.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private int lastMotivationId;
    List<Motivation> motivations;

    public ArticleController() {
        motivations = new ArrayList<>();
        lastMotivationId = 0;
    }

    public void doWrite() {
        int id = lastMotivationId + 1;
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);

        Motivation motivation = new Motivation(id, formattedDate, content, author);

        motivations.add(motivation);

        System.out.println(id + "번 명언이 등록되었습니다.");
        lastMotivationId++;
    }


    public void showList() {
        System.out.println("번호  /  작가  /  명언");
        System.out.println("=".repeat(30));

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);
            System.out.printf("%d  /  %s  /  %s  \n", motivation.getId(), motivation.getContent(), motivation.getAuthor());
        }
    }

    public void doModify(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1].trim());

        Motivation foundMotivation = Util.foundMotivationById(cmd, motivations);


        if (foundMotivation == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + foundMotivation.getContent());
        System.out.println("작가(기존) : " + foundMotivation.getAuthor());

        System.out.print("명언 : ");
        String newContent = Container.getSc().nextLine();
        System.out.print("작기 : ");
        String newAuthor = Container.getSc().nextLine();

        foundMotivation.setContent(newContent);
        foundMotivation.setAuthor(newAuthor);

        System.out.println(id + "번 명언이 수정되었습니다.");
    }

    public void showDetail(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1].trim());

        Motivation foundMotivation = Util.foundMotivationById(cmd, motivations);

        if (foundMotivation == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("번호 : " + foundMotivation.getId());
        System.out.println("날짜 : " + foundMotivation.getRegDate());
        System.out.println("작가 : " + foundMotivation.getContent());
        System.out.println("내용 : " + foundMotivation.getAuthor());
    }


    public void doDelete(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1].trim());

        Motivation foundMotivation = Util.foundMotivationById(cmd, motivations);

        if (foundMotivation == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        motivations.remove(foundMotivation);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
}
