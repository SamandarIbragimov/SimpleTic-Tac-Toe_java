package tictactoe;

import java.util.Scanner;

public class Main {

    public static void printGrid(char[] a){
        System.out.println("---------");
        System.out.println("| " + a[0] + " " + a[1] + " " + a[2] + " |");
        System.out.println("| " + a[3] + " " + a[4] + " " + a[5] + " |");
        System.out.println("| " + a[6] + " " + a[7] + " " + a[8] + " |");
        System.out.println("---------");
    }

    public static String checkWinner(char[] a, int xs, int os){
        if((a[0] + a[1] + a[2]) == 264 || (a[3] + a[4] + a[5]) == 264 ||(a[6] + a[7] + a[8]) == 264 || (a[0] + a[3] + a[6]) == 264 ||
                (a[1] + a[4] + a[7]) == 264 || (a[2] + a[5] + a[8]) == 264|| (a[0] + a[4] + a[8]) == 264 ||(a[2] + a[4] + a[6]) == 264){
            return "X wins";
        } else if((a[0] + a[1] + a[2]) == 237 || (a[3] + a[4] + a[5]) == 237 ||(a[6] + a[7] + a[8]) == 237 || (a[0] + a[3] + a[6]) == 237 ||
                (a[1] + a[4] + a[7]) == 237 || (a[2] + a[5] + a[8]) == 237|| (a[0] + a[4] + a[8]) == 237 ||(a[2] + a[4] + a[6]) == 237){
            return "O wins";
        } else if(xs+os==9){
            return "Draw";
        } else{
            return "Not finished";
        }
    }

    public static void main(String[] args) {
        //create Scanner object
        Scanner sc = new Scanner(System.in);

        //reading input
        char[] a = {' ',' ',' ',' ',' ',' ',' ',' ',' '};

        printGrid(a);

        int xs=0,os=0,m=0, n=0;
        char player = 'X';


        while(checkWinner(a,xs,os).equals("Not finished")){

            while (true) {
                String c1 = sc.next();
                String c2 = sc.next();
                try {
                    m = Integer.parseInt(c1);
                    n = Integer.parseInt(c2);

                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    break;
                }

                if (m > 0 && m < 4 && n > 0 && n < 4) {
                    if (a[(m - 1) * 3 + n - 1] == ' ') {
                        a[(m - 1) * 3 + n - 1] = player; printGrid(a);  if(player=='X') {xs++;player = 'O';}else {os++; player = 'X';} break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
        }
        System.out.println(checkWinner(a,xs,os));

    }
}
