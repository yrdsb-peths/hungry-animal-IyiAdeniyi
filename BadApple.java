import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * If the elephant touches the bad apple then game over.
 * 
 * @author Iyi Adeniyi
 * @version 2022 - 12 - 14
 */
public class BadApple extends Actor
{
    /**
     * Act - do whatever the BadApple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int zoom = 1;
    public void act()
    {
        //apple falls downwards
        int x = getX();
        int y = getY() + zoom;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        Apple apple = new Apple();
        
        //if the elephant touches the bad apple game over
        if(isTouching(Elephant.class))
        {
            world.gameOver();
            world.removeObject(this);

        }

    }
    
    public void setZoom(int spd)
    {
        zoom = spd;
    }
}
