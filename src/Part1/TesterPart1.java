//-----------------------------------------------------
// Title: TesterPart1
// User: Tunç Gürsoy
// ID: 64528127274
// Section: 1
// Assignment: 2
// Description: Part 1 tester Class Automated
// *!Note test result in the console output
//-----------------------------------------------------
package Part1;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TesterPart1 {
    public static void main(String[] args) {
        try {
            File file = new File("Test-Maze.txt");
            // To test readString method test
            String[] data = PrintMaze.readString(file);
            String[] testData= new String[2];
            testData[0] = "A 7 2\n" +
                    "B 6 3\n" +
                    "C 7 4\n" +
                    "D 5 5\n" +
                    "E 2 3\n" +
                    "F 2 6\n" +
                    "G 6 6\n" +
                    "H 4 8\n";
            testData[1] = "0 1\n" +
                    "1 2\n" +
                    "1 3\n" +
                    "3 6\n" +
                    "3 4\n" +
                    "4 5\n" +
                    "7 5\n" +
                    "7 6\n" +
                    "-1 -1\n";
            if (testData[0].equals(data[0])&&testData[1].equals(data[1]))
                {
                    System.out.println("readString method Test Passed");
                }else{
                    System.out.println("readString method Test Failed");
                }
            //to test allocate method
            boolean problemExists = false;
            String[][] testlocations = new String[8][3];
            testlocations[0][0]="A";testlocations[0][1]="7";testlocations[0][2]="2";
            testlocations[1][0]="B";testlocations[1][1]="6";testlocations[1][2]="3";
            testlocations[2][0]="C";testlocations[2][1]="7";testlocations[2][2]="4";
            testlocations[3][0]="D";testlocations[3][1]="5";testlocations[3][2]="5";
            testlocations[4][0]="E";testlocations[4][1]="2";testlocations[4][2]="3";
            testlocations[5][0]="F";testlocations[5][1]="2";testlocations[5][2]="6";
            testlocations[6][0]="G";testlocations[6][1]="6";testlocations[6][2]="6";
            testlocations[7][0]="H";testlocations[7][1]="4";testlocations[7][2]="8";
            String[][] testConnections = new String[8][2];
            testConnections[0][0]="0";testConnections[0][1]="1";
            testConnections[1][0]="1";testConnections[1][1]="2";
            testConnections[2][0]="1";testConnections[2][1]="3";
            testConnections[3][0]="3";testConnections[3][1]="6";
            testConnections[4][0]="3";testConnections[4][1]="4";
            testConnections[5][0]="4";testConnections[5][1]="5";
            testConnections[6][0]="7";testConnections[6][1]="5";
            testConnections[7][0]="7";testConnections[7][1]="6";

            String[][] locations = PrintMaze.allocate(data[0], 3);
            String[][] connections = PrintMaze.allocate(data[1], 2);
            for (int i =0 ; i<8;i++){
                for (int a = 0 ; a<3;a++)
                {
                    if (!testlocations[i][a].equals(locations[i][a]))
                    {
                        problemExists=true;
                    }
                }
                for (int a = 0 ; a<2;a++)
                {
                    if (!testConnections[i][a].equals(connections[i][a]))
                    {
                        problemExists= true;
                    }
                }
            }
            if (!problemExists)
            {
                System.out.println("allocate method Test Passed");
            }else{
                System.out.println("allocate method Test Failed");
            }
            Graph graph = new Graph(connections, locations.length);
            //To test finding Max Value
            int MaxY = PrintMaze.getMax(locations,false);
            if (MaxY==9){
                System.out.println("Max Y Value Test Passed");
            }else{
                System.out.println("Max Y Value Test Failed");
            }
            int MaxX = PrintMaze.getMax(locations,true);
            if (MaxX==8){
                System.out.println("Max X Value Test Passed");
            }else{
                System.out.println("Max X Value Test Failed");
            }
            Frame frame = new Frame();
            Frame testframe = new Frame();
            testframe.setSizeX(800);
            testframe.setSizeY(900);
            testframe.setLocations(testlocations);
            testframe.setConnections(testConnections);
            frame.setSizeX(MaxX*100);
            frame.setSizeY(MaxY*100);
            frame.setLocations(locations);
            frame.setConnections(connections);
            if (frame.equals(testframe)){
                System.out.println("Frame Test Passed");
            }else{
                System.out.println("Frame Test Failed");
            }
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
}
