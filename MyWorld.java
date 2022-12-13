import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Iyi Adeniyi
 * @version 2022 - 12 - 12
 */
public class MyWorld extends World
{
    public static int score = 0;
    public boolean gameOver = false;
    public boolean store;

    Label scoreLabel;
    
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 269);
        
        //create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 40, 40 );
        
        createApple();
    }
    
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game over", 100);
        addObject(gameOverLabel, 300, 100);
        Label resetGame = new Label("press space bar to play again", 50);
        addObject(resetGame, 300, 200);
        boolean gameOver = true;
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            TitleScreen a = new TitleScreen();
            Greenfoot.setWorld(a);
        }
    }
    
    public static void setScore(int latestScore)
    {
        score = latestScore;
        if (score > MyWorld.getScore())
       {
         MyWorld.setScore(score);
       }
    }

    public static int getScore()
    {
        return score;
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
        
        
    }
    

    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x,y);
    }
}
