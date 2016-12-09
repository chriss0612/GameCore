package com.company;

import java.awt.*;

/**
 * Created by Christian on 02.12.2016.
 */
public abstract class GameObjekt {
    protected double x,y;
    protected ID id;
    protected double velX, velY;
    protected int sizeX, sizeY;
    public GameObjekt(double x, double y, double velX, double velY, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
        this.velX=velX;
        this.velY=velY;
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,sizeX,sizeY);
    }
    public GameObjekt(double x, double y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
        velX=0;
        velY=0;
    }
    public void tick(){
        x+=velX;
        y+=velY;
        if(x<-10)
        {
            Game.getGame().handeler.removeObject(this);
        }
    }
    public abstract void render(Graphics g);
    public boolean onGround()
    {
        return y>=ground();
    }
    public int ground()
    {
        return 500-sizeY+30;
    }
    public static int ground(int size)
    {
        return 500-size+30;
    }
//Getters
    public double getX(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velX;
    }
    public ID getID() {
        return id;
    }

//Seters
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public void setVelX(double velX){
        this.velX=velX;
    }
    public void setVelY(double velY){
        this.velY=velY;
    }
    public void SetID(ID id){
        this.id=id;
    }
}
