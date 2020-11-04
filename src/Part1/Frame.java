package Part1;

import javax.swing.*;
import java.awt.*;

public  class Frame extends JScrollPane {
    public  int sizeX  = 0 ;
    public  int sizeY  = 0 ;

    public String[][] getLocations() {
        return locations;
    }

    public void setLocations(String[][] locations) {
        this.locations = locations;
    }

    public String[][] locations ;

    public  int getSizeX() {
        return sizeX;
    }

    public  void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public  int getSizeY() {
        return sizeY;
    }

    public  void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    @Override
    public void paint(Graphics g) {
        setSize(1024,800);
       g.drawOval(100,100,60,60);
       g.drawOval(0,0,60,60);
       g.drawOval(30,30,60,60);
       char[] a = {'A','L','I'};
       g.drawChars(a,0,a.length,130,130);
    }


    public static void main(String[] args) {
        JFrame a = new JFrame();
        a.setSize(1250,810);
        Frame frame = new Frame();
        a.add(frame);
        a.setVisible(true);
    }
}
