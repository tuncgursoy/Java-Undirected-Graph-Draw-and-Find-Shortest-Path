//-----------------------------------------------------
// Title: PrintMaze
// User: Tunç Gürsoy
// ID: 64528127274
// Section: 1
// Assignment: 2
// Description: Main class for printing the Given input file graph.
//-----------------------------------------------------
package Part1;

import javax.swing.*;
import java.awt.*;
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
            Frame frame = new Frame();
            frame.setSizeX(MaxX*100);
            frame.setSizeY(MaxY*100);
            frame.setLocations(locations);
            frame.setConnections(connections);
            JFrame jFrame = new JFrame("HW2 Part 1");
            JScrollPane scrollPane=new JScrollPane(frame,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
            jFrame.add(scrollPane, BorderLayout.CENTER);
            jFrame.pack();
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    public static int getMax(String[][] locations,boolean isitX)
    //--------------------------------------------------------
    // Summary: returns the max +1 Value of given graph location
    // locations and isitX is given.
    // Precondition: locations is 2-d String array, isitX is boolen
    // Postcondition: returns the max Value x if isitx true else returns  of  the max Value y of given graph location
    //--------------------------------------------------------
    {
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
       return max+1;
    }


    public static String[] readString(File file)
    //--------------------------------------------------------
    // Summary: Reads the file and returns to lines of locations and connection as array
    // file is given.
    // Precondition: file is File
    // Postcondition: return line of file in type of string array
    //--------------------------------------------------------
    {
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
                        System.out.println("Error : File is not found");
        }
        return null;
    }
    public static String[][] allocate(String str,int size)
    //--------------------------------------------------------
    // Summary: change line format to array format of lines to calculate location and connections
    // str and size is given.
    // Precondition: str is String array, size is integer
    // Postcondition: returns the 2d array of the given lines
    //--------------------------------------------------------
    {
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
