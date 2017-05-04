/*
 * Project Name: Program 5
 * Name: Tychell Nichols
 * Date: May 3, 2017
 * Description: This class draws an animated dog.
 * Acknowledgements: I received help from previous labs and programming consultants.
 */
package csc220.program5.nicholt2020;

import csc220.list.List;
import csc220.program5.GameCharacter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Dog extends GameCharacter{

    public Dog(int over, int down, int width, int height, int moveInterval) {
        super(over, down, width, height, moveInterval, new List<Point>());
        this.animationPath.add(new Point(over, down));
        this.animationPath.add(new Point(over + 100, down + 30));
        this.animationPath.add(new Point(over + 150, down));
        this.animationPath.add(new Point(over + 200, down - 30));
        this.animationPath.add(new Point(over + 250, down));
        this.animationPath.add(new Point(over + 300, down + 30));
        this.animationPath.add(new Point(over + 350, down - 30)); 
    }

    @Override
    public void draw(Graphics g) {
        //body
        g.setColor(new Color(156, 93, 82));
        g.fillOval(getOver(), getDown() + getWidth() - 5, getWidth(), getHeight() - 10); 
        g.setColor(Color.black);
        g.drawOval(getOver(), getDown() + getWidth() - 5, getWidth(), getHeight() - 10); 
        //head
        g.setColor(new Color(156, 93, 82));
        g.fillOval(getOver(), getDown(), getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawOval(getOver(), getDown(), getWidth(), getHeight());
        //eyes
        g.setColor(Color.white);
        g.fillOval(getOver() + 15, getDown() + 15, getWidth()/5, getHeight()/5);
        g.fillOval(getOver() + 35, getDown() + 15, getWidth()/5, getHeight()/5);
        g.setColor(Color.black);
        g.drawOval(getOver() + 15, getDown() + 15, getWidth()/5, getHeight()/5);
        g.drawOval(getOver() + 35, getDown() + 15, getWidth()/5, getHeight()/5);
        //eye pupils
        g.setColor(Color.blue);
        g.fillOval(getOver() + 17, getDown() + 20, getWidth()/8, getHeight()/8);
        g.fillOval(getOver() + 37, getDown() + 20, getWidth()/8, getHeight()/8);
        //nose
        g.setColor(Color.black);
        Point p1 = new Point(getOver() + 30, getDown() + 37);
        Point p2 = new Point(getOver() + 25, getDown() + 30);
        Point p3 = new Point(getOver() + 35, getDown() + 30);
        Polygon nose = new Polygon();
        nose.addPoint(p1.x, p1.y);
        nose.addPoint(p2.x, p2.y);
        nose.addPoint(p3.x, p3.y);
        g.fillPolygon(nose);
        //smile
        g.drawLine(getOver() + 30, p1.y, getOver() + 30, getDown() + 48);
        g.drawArc(getOver()+ 18, getDown()+ 30, 2*getWidth()/5, 3*getWidth()/10, 190, 160);
        //ears
        g.setColor(new Color(156, 93, 82));
        Point p4 = new Point(getOver() + 17, getDown() - 3);
        Point p5 = new Point(getOver() - 8, getDown() + 15);
        Point p6 = new Point(getOver() + 10, getDown() + 30);
        Polygon leftEar = new Polygon();
        leftEar.addPoint(p4.x, p4.y);
        leftEar.addPoint(p5.x, p5.y);
        leftEar.addPoint(p6.x, p6.y);
        g.fillPolygon(leftEar);
        g.setColor(Color.black);
        g.drawPolygon(leftEar);
        g.setColor(new Color(156, 93, 82));
        Point p7 = new Point(getOver() + 45, getDown() - 3);
        Point p8 = new Point(getOver() + 70, getDown() + 15);
        Point p9 = new Point(getOver() + 50, getDown() + 30);
        Polygon rightEar = new Polygon();
        rightEar.addPoint(p7.x, p7.y);
        rightEar.addPoint(p8.x, p8.y);
        rightEar.addPoint(p9.x, p9.y);
        g.fillPolygon(rightEar);
        g.setColor(Color.black);
        g.drawPolygon(rightEar);
        //left arm
        g.setColor(Color.black);
        g.drawLine(getOver() + 15, getDown() + 70, getOver() + 15, getDown() + 90);
        g.drawLine(getOver() + 15, getDown() + 90, getOver() + 25, getDown() + 90);
        g.drawLine(getOver() + 25, getDown() + 90, getOver() + 25, getDown() + 70);
        //right arm
        g.setColor(Color.black);
        g.drawLine(getOver() + 35, getDown() + 70, getOver() + 35, getDown() + 90);
        g.drawLine(getOver() + 35, getDown() + 90, getOver() + 45, getDown() + 90);
        g.drawLine(getOver() + 45, getDown() + 90, getOver() + 45, getDown() + 70);
        //left leg
        g.setColor(new Color(156, 93, 82));
        g.fillRect(getOver() + 13, getDown() + 95, 13, 13);
        g.setColor(Color.black);
        g.drawRect(getOver() + 13, getDown() + 95, 13, 13);
        //right leg
        g.setColor(new Color(156, 93, 82));
        g.fillRect(getOver() + 35, getDown() + 95, 13, 13);
        g.setColor(Color.black);
        g.drawRect(getOver() + 35, getDown() + 95, 13, 13);
    }
}
