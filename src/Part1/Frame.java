//-----------------------------------------------------
// Title: Frame
// Author: Tunç Gürsoy
// ID: 64528127274
// Section: 1
// Assignment: 1
// Description: JPanel class for drawing graph
//-----------------------------------------------------
package Part1;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public  class Frame extends JPanel {
    public  int sizeX  = 0 ;
    public  int sizeY  = 0 ;

    public String[][] getConnections()
    //--------------------------------------------------------
    // Summary: Gets connections and returns it
    // Postcondition: returns 2d string array which holds connections
    //--------------------------------------------------------
    {
        return Connections;
    }

    public void setConnections(String[][] connections)
    //--------------------------------------------------------
    // Summary: Gets 2d string array and  set it
    // connections is given.
    // Precondition: connections is 2d string array
    // Postcondition: Sets the given array to connection of class
    //--------------------------------------------------------
    {
        Connections = connections;
    }

    public String[][] Connections;
    public String[][] getLocations()
    //--------------------------------------------------------
    // Summary: Gets Locations and returns it
    // Postcondition: returns 2d string array which holds Locations
    //--------------------------------------------------------
    {
        return locations;
    }

    public void setLocations(String[][] locations)
    //--------------------------------------------------------
    // Summary: Gets 2d string array and  set it
    // locations is given.
    // Precondition: locations is 2d string array
    // Postcondition: Sets the given array to locations of class
    //--------------------------------------------------------
    {
        this.locations = locations;
    }

    public String[][] locations ;

    public  int getSizeX()
    //--------------------------------------------------------
    // Summary: Gets SizeX and returns it
    // Postcondition: returns integer which is SizeX
    //--------------------------------------------------------
    {
        return sizeX;
    }

    public  void setSizeX(int sizeX)
    //--------------------------------------------------------
    // Summary: Integer and  sets to SizeX
    // sizeX is given.
    // Precondition: sizeX is Integer
    // Postcondition: Sets the given Integer to sizeX of class
    //--------------------------------------------------------
    {
        this.sizeX = sizeX;
    }

    public  int getSizeY()
    //--------------------------------------------------------
    // Summary: Gets SizeY and returns it
    // Postcondition: returns integer which is SizeY
    //--------------------------------------------------------
    {
        return sizeY;
    }
    public  void setSizeY(int sizeY)
    //--------------------------------------------------------
    // Summary: Integer and  sets to SizeY
    // sizeY is given.
    // Precondition: sizeY is Integer
    // Postcondition: Sets the given Integer to sizeY of class
    //--------------------------------------------------------
    {
        this.sizeY = sizeY;
    }

    public  int formula(int x )
    //--------------------------------------------------------
    // Summary: For calculate node location in frame
    // x is given.
    // Precondition: x is Integer
    // Postcondition: Gets the given Integer And calculates the node location
    //--------------------------------------------------------
    {
        return 20+80*x;
    }


    public int original0Y()
    //--------------------------------------------------------
    // Summary: To take origin of the graph
    // Postcondition: returns the new origin
    //--------------------------------------------------------
    {
        return (getSizeY()/100)-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return sizeX == frame.sizeX &&
                sizeY == frame.sizeY &&
                Arrays.equals(Connections[5], frame.Connections[5]) &&
                Arrays.equals(locations[5], frame.locations[5]);
    }

    @Override
    public void paint(Graphics g)
    //--------------------------------------------------------
    // Summary: For printing the graph
    // Postcondition: Prints the graph
    //--------------------------------------------------------
    {

        setSize(getSizeX(),getSizeY());

        for (String[] location :getLocations()){
            char[] a = location[0].toCharArray();
            g.drawChars(a,0,a.length,formula(abs(Integer.parseInt(location[1])))+30,formula( abs(original0Y()-Integer.parseInt(location[2])))+30);
            g.drawOval(formula(abs(Integer.parseInt(location[1]))),formula( abs(original0Y()-Integer.parseInt(location[2]))),60,60);
        }
        for (String[] connection : Connections){
           int x1 = formula(abs(Integer.parseInt(locations[Integer.parseInt(connection[0])][1])));
           int y1 = formula(abs(original0Y()-Integer.parseInt(locations[Integer.parseInt(connection[0])][2])));
           int x2 = formula(abs(Integer.parseInt(locations[Integer.parseInt(connection[1])][1])));
           int y2 = formula(abs(original0Y()-Integer.parseInt(locations[Integer.parseInt(connection[1])][2])));
           if (x1==x2){
               if (y2<y1)
                   g.drawLine(x1+30,y1,x2+30,y2+60);
               else
                   g.drawLine(x1+30,y1+60,x2+30,y2);
           }else if(y1==y2){
               if (x2<x1)
                   g.drawLine(x1,y1+30,x2+60,y2+30);
              else
                   g.drawLine(x1+60,y1+30,x2,y2+30);
           }else if (y1>y2){
               if (x2<x1)

                   g.drawLine(x1+9,y1+9,x2+51,y2+51);
              else
                   g.drawLine(x1+51,y1+9,x2+9,y2+51);
           }else{
               if (x2<x1)
                   g.drawLine(x1+9,y1+51,x2+51,y2+9);
               else
                   g.drawLine(x1+51,y1+51,x2+9,y2+9);
           }

        }


    }
    @Override
    public Dimension getPreferredSize()
    //--------------------------------------------------------
    // Summary: Sets dimension of panel
    // Postcondition: Dimensions sets
    //--------------------------------------------------------
    {
        return new Dimension(getSizeX(), getSizeY());
    }

    public  int abs(int x)
    //--------------------------------------------------------
    // Summary: For calculate absolute value of given integer
    // x is given.
    // Precondition: x is Integer
    // Postcondition: returns absolute value of given integer
    //--------------------------------------------------------
    {
        if (x>=0){
            return x;
        }else{
            return -x;
        }
    }

}
