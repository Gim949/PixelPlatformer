package com.przemek.pixelplatformer.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.przemek.pixelplatformer.managers.PhysicsManager;
import com.przemek.pixelplatformer.utils.Constants;

public class PixelPlatformer 
{
	public SpriteBatch mainBatch;
	public OrthographicCamera cam;
	public PhysicsManager physics;
	
	
	public PixelPlatformer()
	{
		mainBatch = new SpriteBatch();
		cam = new OrthographicCamera();
		physics = new PhysicsManager();
	}
	
	public void initGame()
	{
		cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
	}
	
	
}
