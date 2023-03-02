package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Saying> arr = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        int i = 1;
        while(true) {
            System.out.print("명령) ");
            String regist = sc.next();

            if(regist.equals("등록")) {
                System.out.print("명언 : ");
                String famSaying = sc.nextLine();
                sc.nextLine();
                System.out.print("작가 : ");
                String writer = sc.next();
                arr.add(new Saying(famSaying, writer));

                System.out.println(i + "번 명언이 등록되었습니다.");
                i++;
            }

            else {
                break;
            }
        }
    }
}

class Saying {
    String famSaying;
    String writer;

    public Saying(String famSaying, String writer) {
        this.famSaying = famSaying;
        this.writer = writer;
    }
}