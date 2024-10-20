package main.java.com.ssss.algo.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskI {

    private static List<Character> chars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String allTeams = scanner.nextLine();
        for (int i = 0; i < allTeams.length(); i++) {
            chars.add(allTeams.charAt(i));
        }
        int i = 0;
        while (chars.contains('S') && chars.contains('K')) {
            Character now = chars.get(i);
            if(!now.equals(' ')){
                removeTeamMember(now);
            }
            i++;
            if(i==chars.size()){
                i=0;
            }
        }

        System.out.println(chars.contains('S')?"SAKAYANAGI":"KATSURAGI");
    }

    private static void removeTeamMember(Character team) {
        for (int i = 0; i < chars.size(); i++) {
            Character now = chars.get(i);
            if (!now.equals(team) && !now.equals(' ')) {
                chars.set(i, ' ');
                break;
            }
        }
    }
}