package Part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintMaze {


    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            String[] data = readString(file);
            String[][] locations = allocate(data[0], 3);
            String[][] connections = allocate(data[1], 2);
            Graph graph = new Graph(connections, locations.length);
            int MaxY = getMax(locations,false);
            int MaxX = getMax(locations,true);


            System.out.println(graph.toString());
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }

    }
    public static int getMax(String[][] locations,boolean isitX){
        int max =-999;
        if (isitX){
            for (String[] a : locations){
                int temp =Integer.parseInt(a[1]);
                if (temp>max){
                    max = temp ;
                }
            }
        }else{
            for (String[] a : locations){
                int temp =Integer.parseInt(a[2]);
                if (temp>max){
                    max = temp ;
                }
            }
        }
       return max;
    }/*
    public static String[][] AtLocationaty(int y,String[][] locations){
        int size = 0 ;
        for (String[] a : locations){
            if (Integer.parseInt(a[2])==y)
            {
                size++;
            }
        }
        if (size== 0)
            return null;
        else{
            int i =0 ;
        String[][] temp = new String[size][3];
        for (String[] a : locations){
            if (Integer.parseInt(a[2])==y)
            {
                temp[i]= a ;
            }
        }
        int[] Arrx = new int[size] ;
        i = 0 ;
            for (String[] a : temp){
                if (Integer.parseInt(a[2])==y)
                {
                    Arrx[i]= Integer.parseInt(a[1]) ;
                }
            }
            int[] sortedX = bubbleSort(Arrx);


    }
     }*/
    static int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        }
        return arr;
    }
    /*
    public static  String[][] Get(int x ,  int y,String[][] locations){
        int totalLinex= (x+1)*37;
        int totalLineY= (y+1)*37;
        String[][] temp

    }
*/
    public static String[][]getSquare(String a ){
        String[][] temp;
        if (a.length()==1){
            temp = new String[][]{{"*", "*", "*", "*", "*"}, {"*", " ", a, " ", "*"}, {"*", "*", "*", "*", "*"}};
        }else if(a.length()==2) {
            temp = new String[][]{{"*", "*", "*", "*", "*"}, {"*",a, " ", "*"}, {"*", "*", "*", "*", "*"}};

        }else {
            temp = new String[][]{{"*", "*", "*", "*", "*"}, {"*", a, "*"}, {"*", "*", "*", "*", "*"}};

        }
                    return temp;

                }

                public static String[] readString(File file){
                    try {
                        Scanner scanner = new Scanner(file);
                        int size = Integer.parseInt(scanner.nextLine());
                        StringBuilder data = new StringBuilder();
                        int i = 0;
                        while (scanner.hasNext()&&size !=i){
                            String temp = scanner.nextLine();
                            if (!temp.trim().equals("\n")&&!temp.trim().equals("\n\r")&&!temp.trim().equals("")){
                                i++;
                                data.append(temp).append("\n");
                }else {
                }
            }
            StringBuilder data1 = new StringBuilder();

            while (scanner.hasNext()){
                String temp = scanner.nextLine();
                if (!temp.trim().equals("\n")&&!temp.trim().equals("\n\r")&&!temp.equals("")){

                    data1.append(temp).append("\n");
                }else {
                }

            }
            return new String[]{data.toString(),data1.toString()};


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String[][] allocate(String str,int size) {
        String[] temp = str.split("\n");
        String[][] data;
        if (size==2){
            int a = 0 ;
            for (String s :temp){
                if (s.trim().equals("-1 -1")){
                    break;
                }
                a++;
            }
            data = new String[a][size];

        }else{
           data = new String[temp.length][size];

        }
        int s = 0;
        for (String i : temp){
            String[] temp1 = i.split(" ");
            if (temp1[0].equals("-1")&&temp1[1].equals("-1")){
                break;
            }else{
                data[s] = temp1;
                s++;
            }

    }
        return data;
    }



}
