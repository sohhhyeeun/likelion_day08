package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Saying> arr = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        int num = 1;
        while(true) {
            System.out.print("명령) ");
            String regist = sc.nextLine();

            if(regist.equals("등록")) {
                System.out.print("명언 : ");
                String famSaying = sc.nextLine();
                System.out.print("작가 : ");
                String writer = sc.nextLine();
                System.out.println(num + "번 명언이 등록되었습니다.");
                arr.add(new Saying(num, famSaying, writer));
                num++;
            }

            else if(regist.equals("목록")) {
                arr = arr
                        .stream()
                        .sorted((e2, e1) -> e1.getNum() - e2.getNum())
                        .collect(Collectors.toList());

                System.out.println("번호 / 작가/ 명언");
                System.out.println("--------------------");
                for (Saying saying : arr) {
                    System.out.printf("%d / %s / %s\n", saying.getNum(), saying.getFamSaying(), saying.getWriter());
                }
            }

            else if(regist.contains("삭제") == true) {
                int m = regist.charAt(6) - '0';
                try {
                    arr.remove(m-1);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", m);
                } catch (IndexOutOfBoundsException e) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", m);
                }
            }

            else if(regist.contains("수정") == true) {
                int m = regist.charAt(6) - '0';

                System.out.printf("명언(기존) : %s\n", arr.get(m-1).getFamSaying());
                System.out.print("명언 : ");
                String famSaying = sc.nextLine();
                System.out.printf("작가(기존) : %s\n", arr.get(m-1).getWriter());
                System.out.print("작가 : ");
                String writer = sc.nextLine();
                arr.set(m-1, new Saying(m, famSaying, writer));
            }

            else {
                break;
            }
        }
    }
}

class Saying {
    private int num;
    private String famSaying;
    private String writer;

    public Saying(int num, String famSaying, String writer) {
        this.num = num;
        this.famSaying = famSaying;
        this.writer = writer;
    }

    public int getNum() {
        return num;
    }

    public String getFamSaying() {
        return famSaying;
    }

    public String getWriter() {
        return writer;
    }

    public void setFamSaying(String famSaying) {
        this.famSaying = famSaying;
    }
}