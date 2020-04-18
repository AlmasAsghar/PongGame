
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Almas Asghar
 */
public class Paddle {
    public int paddleNum;

	public int x, y, width = 50, height = 250;

	public int score;

	public Paddle(pong png, int paddleNumber)
	{
		this.paddleNum = paddleNumber;

		if (paddleNumber == 1)
		{
			this.x = 0;
		}

		if (paddleNum == 2)
		{
			this.x = png.width - width;
		}

		this.y = png.height / 2 - this.height / 2;
	}
        public void PaddleView(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
        
        public void move(boolean up)
	{
		int speed = 15;

		if (up)
		{
			if (y - speed > 0)
			{
				y -= speed;
			}
			else
			{
				y = 0;
			}
		}
		else
		{
			if (y + height + speed < pong.png.height)
			{
				y += speed;
			}
			else
			{
				y = pong.png.height - height;
			}
		}
        }
}
