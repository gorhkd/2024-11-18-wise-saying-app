package org.example;

import java.util.Scanner;
// 각각의 모듈 : 컨트롤러, 서비스, 리파지토리
// 레이어드 아키텍쳐 : 유지보수, 코드를 파악 쉽다.
// 컨트롤러 (점원):
// 서비스 (요리사):
// 리파지토리 (창고):

// 도메인 = 영역

//커뮤니티 사이트 (여러 모듈로 되어있는)
// 글(글 쓰기- 글 수정),  회원(로그인 - 회원가입),  알림

// App : 고객의 명령을 받음 다른 곳으로 보내주는 역할
//



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void main(String[] args) {
        App app = new App();
        app.run();


    }

    public class App {
        public void run(){
            System.out.println("== 명언 앱 ==");
            Scanner scanner = new Scanner(System.in);


            while(true){
                int lastId = 1;

                System.out.print("명령) ");
                String cmd = scanner.nextLine().trim();

                if (cmd.equals("종료")){
                    System.out.println("종료"); break;
                }

                else if(cmd.equals("등록")){
                    System.out.println("명언: ");
                    String content = scanner.nextLine();
                    System.out.println("작가: ");
                    String author = scanner.nextLine();
                    System.out.println(lastId + "번 명언이 등록되었습니다.");

                    WiseSaying wiseSaying = new WiseSaying(lastId, content, author);

                    lastId++;
                }

                else if(cmd.equals("목록")){

                }
            }
        }
    }

    class WiseSaying {
        int id;
        String content;
        String author;

        public WiseSaying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }
    }

}
