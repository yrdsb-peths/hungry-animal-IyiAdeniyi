import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Iyi Adeniyi
 * @version 2022- 12 - 13
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idleRight[] = new GreenfootImage[8];
    GreenfootImage idleLeft[] = new GreenfootImage[8];


    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle"+ i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle"+ i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);  
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        //changes the direction the elephant is facing
        if(facing.equals("right"))
        {
        setImage(idleRight[imageIndex]);
        imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
        setImage(idleLeft[imageIndex]);
        imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        //when left key is pressed moves the elephant left
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        }
        //when right key is pressed moves the elephant right

        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
        }
        eat();
        
        //Animate the elphant
        animateElephant();
    }
    //executes when the elephant touches "eats" the apple
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            world.setHighScore();
            elephantSound.play();
        }
    }
}
