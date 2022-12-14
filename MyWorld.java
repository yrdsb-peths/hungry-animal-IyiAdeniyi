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
    public static int highscore;
    
    Label scoreLabel;
    Label highscoreLabel;
    
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
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
        addObject(scoreLabel, 40, 45 );
        Label scoreTitle = new Label("Current score", 22);
        addObject(scoreTitle, 58, 10);
        
        //create highscore label
        highscoreLabel = new Label(highscore, 80);
        addObject(highscoreLabel, 500, 40);
        Label highscoreTitle = new Label("High score", 22);
        addObject(highscoreTitle, 500, 10);
        
        createApple();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            TitleScreen a = new TitleScreen();
            Greenfoot.setWorld(a);
        }
        
        if(Greenfoot.isKeyDown("esc"))
        {
            System.exit(0);
        }
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game over", 100);
        addObject(gameOverLabel, 300, 100);
        
        Label resetGame = new Label("press enter to play again", 50);
        addObject(resetGame, 300, 200);
        
        Label exit = new Label("press esc to exit game", 50);
        addObject(exit, 300, 150);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level +=1;
        }
    }
    
    /**
     * set highscore
     */
    public void setHighScore()
    {
        if(score>=highscore)
        {
            highscore = score;
            highscoreLabel.setValue(highscore);
        }
    }
    
    /**
     * Create a new apple at random location at top of screen.
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x,y);
    }
}
