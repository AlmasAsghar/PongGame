
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Almas Asghar
 */
public class pong implements ActionListener, KeyListener{
    public static pong png;
    public BallView bv;
    public Random rand;
    public  int width = 650,height = 700;
    public Paddle plyr1,plyr2;
    public int gameStatus = 0, scoreLimit = 7, playerWon;
    public Ball ball;
    public int botDifficulty, botMoves, botCooldown = 0;
    public boolean left, right, up, down;
    public pong()
    {
        Timer timer = new Timer(20, this);
        rand=new Random();
        
        JFrame fr = new JFrame("Pong");
        bv = new BallView();

	fr.setSize(height,width);
	fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(bv);
        fr.addKeyListener(this);
        
        timer.start();
	
    }
    public void start()
	{
            
		gameStatus = 2;
		plyr1 = new Paddle(this, 1);
		plyr2 = new Paddle(this, 2);
		ball = new Ball(this);
	}
    public void Update()
    {
        if (plyr1.score >= scoreLimit)
		{
			playerWon = 1;
			gameStatus = 3;
		}

		if (plyr2.score >= scoreLimit)
		{
			gameStatus = 3;
			playerWon = 2;
		}

		if (left)
		{
			plyr1.move(true);
		}
		if (right)
		{
			plyr1.move(false);
		}

		//if (!bot)
		{
			if (up)
			{
				plyr2.move(true);
			}
			if (down)
			{
				plyr2.move(false);
			}
		}
		//else
		{
			if (botCooldown > 0)
			{
				botCooldown--;

				if (botCooldown == 0)
				{
					botMoves = 0;
				}
			}

			if (botMoves < 10)
			{
				if (plyr2.y + plyr2.height / 2 < ball.y)
				{
					plyr2.move(false);
					botMoves++;
				}

				if (plyr2.y + plyr2.height / 2 > ball.y)
				{
					plyr2.move(true);
					botMoves++;
				}

				if (botDifficulty == 0)
				{
					botCooldown = 20;
				}
				if (botDifficulty == 1)
				{
					botCooldown = 15;
				}
				if (botDifficulty == 2)
				{
					botCooldown = 10;
				}
			}
		}
        ball.update(plyr1, plyr2);
    }
    @Override
	public void actionPerformed(ActionEvent e)
	{
		//if (gameStatus == 2)
		{
			Update();
		}

		bv.repaint();
	}
    void ballView(Graphics2D graphics2D) {
       
    }
    public void View(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		//g.fillRect(0, 0, width, height);
                
                plyr1.PaddleView(g);
                plyr2.PaddleView(g);
        }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
