package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Christian on 02.12.2016.
 */
public class Handler {
    LinkedList<GameObjekt> objekts = new LinkedList<GameObjekt>();

    public void tick(){
        for(int i=0;i<objekts.size();i++)
        {
            GameObjekt tempGameObjekt = objekts.get(i);
            tempGameObjekt.tick();
        }
    }

    public void render(Graphics g){
        for(int i=0;i<objekts.size();i++)
        {
            GameObjekt tempGameObjekt = objekts.get(i);
            tempGameObjekt.render(g);
        }
    }

    public void addObject(GameObjekt obj){
        this.objekts.add(obj);
    }
    public void removeObject(GameObjekt obj){
        this.objekts.remove(obj);
    }
}
