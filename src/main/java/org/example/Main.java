package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.info;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("== 명령 앱 ==");

        Scanner scanner = new Scanner(System.in);
        List<Information> quotes = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            System.out.println("입력된 명령어 : %s".formatted(cmd));

            if (cmd.equals("종료")) {
                System.out.println("== 명령 앱 종료 ==");
                break;
            }

            else if (cmd.equals("등록")) {
                System.out.println("명언 : ");
                String wise_saying = scanner.nextLine().trim();

                System.out.println("작가 : ");
                String author = scanner.nextLine().trim();

                Information info = new Information(nextId, wise_saying, author);
                quotes.add(info);
                System.out.println(nextId + "번 명언이 등록되었습니다.");

                nextId++;
            }

            else if (cmd.equals("목록")) {
                if (quotes.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    for (Information quote : quotes) {
                        System.out.println(quote);
                    }
                }
            }

            else if (cmd.equals("삭제")) {
                System.out.println("삭제 할 번호를 알려주세요.");
                int delete_id = scanner.nextInt();
                scanner.nextLine();

                boolean found = false;

                Iterator<Information> iterator = quotes.iterator();

                while (iterator.hasNext()){
                    Information quote = iterator.next();
                    if (quote.id == delete_id) {
                        iterator.remove();
                        System.out.println(delete_id + "번 명언이 삭제되었습니다.");
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println(delete_id + "번 명언은 존재 하지 않습니다.");
                }
                }


               else {
                System.out.println("알 수 없는 명령어입니다.");
            }

        }

        scanner.close();
    }



    public static class Information{
        int id;
        String author;
        String wise_saying;

        Information(int id, String author, String wise_saying){
            this.id = id;
            this.author = author;
            this.wise_saying = wise_saying;
        }

        @Override
        public String toString() {
            return
                    "번호 : " + id + '\'' +
                    "작가 : " + author + '\'' +
                    "명언 : " + wise_saying;
        }


    }




}
