package com.przemek.pixelplatformer.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.przemek.pixelplatformer.managers.PhysicsManager;
import com.przemek.pixelplatformer.utils.Constants;

public class PixelPlatformer 
{
	public static final String GAME_NAME = "Pixel Platformer v1";
	public static final boolean debug = true; 
	
	public SpriteBatch mainBatch;
	public OrthographicCamera cam;
	
	private PhysicsManager physics;
	private BitmapFont font;
	
	public PixelPlatformer()
	{
		mainBatch = new SpriteBatch();
		cam = new OrthographicCamera();
		physics = new PhysicsManager();
		
		// DEBUG
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}
	
	public void initGame()
	{
		cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
	}
	
	public void updatePhysics()
	{
		physics.world.step(1/60f, 6, 2);
	}
	
	public void debug()
	{
		if(debug)
		{
			physics.debugRender(cam.combined);
			font.draw(mainBatch, GAME_NAME, 1, 11);
			font.draw(mainBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 1, 21);
		}
	}
}
