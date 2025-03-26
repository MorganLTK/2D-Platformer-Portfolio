package main;

import javax.swing.JPanel;


import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;


public class GamePanel extends JPanel{
    
	
    public final int ORIGINAL_TILE_SIZE = 64;
    final int SCALE = 2;

    public final int TILE_SIZE = SCALE * ORIGINAL_TILE_SIZE;
    public final int MAX_SCREEN_COL = 10;
    public final int MAX_SCREEN_ROW = 6;
    public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
    
  
    public final int MAX_WORLD_COL = 20;
    public final int MAX_WORLD_ROW = 10;
    public final int WORLD_WIDTH = MAX_WORLD_COL * TILE_SIZE;
    public final int WORLD_HEIGHT = MAX_WORLD_ROW * TILE_SIZE;
    
 
    
    
   
    
    private MouseInputs mouseInputs;
    private Game game;
    
    
    
    public GamePanel(Game game){
    	this.game = game;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    
    private void setPanelSize() {
    	Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);   	
    	setPreferredSize(size);
    	System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
	}
    
    public Game getGame() {
    	return game;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        game.render(g);        
        
    }
}


