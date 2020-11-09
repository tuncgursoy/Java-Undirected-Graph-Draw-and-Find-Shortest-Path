//-----------------------------------------------------
// Title: PrintMaze
// User: Tunç Gürsoy
// ID: 64528127274
// Section: 1
// Assignment: 2
// Description: Main class for printing path of  the Given input file graph.
//-----------------------------------------------------
package Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindPathMain {


    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            String[] data = readString(file);
            String[][] locations = allocate(data[0], 3);
            String[][] connections = allocate(data[1], 2);
            Graph graph = new Graph(connections, locations.length);
            String[] path = findPath(graph,locations,0,locations.length-1);
            System.out.print("Path : ");
            for (int i = 0 ; i< path.length;i++){
                if (i+1==path.length){
                    System.out.println(path[i]);
                }else{
                    System.out.print(path[i]+"->");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }


    }

    public static String[] findPath(Graph graph,String[][] locations,int sourceLocation, int finalLocation)
    //--------------------------------------------------------
    // Summary: Returns the path as string array
    // graph,locations,sourceLocation,finalLocation is given.
    // Precondition: graph is Graph,locations is 2-d array, sourceLocation and final location is integer
    // Postcondition: Return the path of given nodes in undirected graph
    //--------------------------------------------------------
    {
        BreadthFirstPaths depthFirstSearch = new BreadthFirstPaths(graph,sourceLocation);
        Iterable<Integer> i =depthFirstSearch.pathTo(finalLocation);
        int a = 0 ;
        for (int ignored : i){
            a++;
        }
        String[] temp = new String[a];
        a=0;
        for (int s : i){
                temp[a]=locations[s][0];
                a++;
        }
        return temp;
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
                    data.append(temp).append("\n"); }else { } }
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
