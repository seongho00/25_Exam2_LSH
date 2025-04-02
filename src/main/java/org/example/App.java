package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    ArticleController articleController;

    public App() {
        articleController = new ArticleController();
        action();
    }

    public void action() {
        System.out.println("== 명언 앱 실행 ==");

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = Container.getSc().nextLine();

            if (cmd.equals("종료")) {
                System.out.println("== 명언 앱 종료 ==");
                break;
            }

            if (cmd.equals("등록")) {
                articleController.doWrite();
            } else if (cmd.equals("목록")) {
                articleController.showList();
            } else if (cmd.startsWith("수정")) {
                articleController.doModify(cmd);
            } else if (cmd.startsWith("상세보기")) {
                articleController.showDetail(cmd);
            } else if (cmd.startsWith("삭제")) {
                articleController.doDelete(cmd);
            }
        }

    }
}
