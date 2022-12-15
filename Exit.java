import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to exit the game
 * 
 * @author Iyi Adeniyi
 * @version 2022 - 12 - 14
 */
public class Exit extends Actor
{
    /**
     * Act - do whatever the exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(Exit.this))
        {
            System.exit(0);
        }
    }
}
