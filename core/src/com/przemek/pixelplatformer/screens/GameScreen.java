package com.przemek.pixelplatformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.przemek.pixelplatformer.main.PixelPlatformer;
import com.przemek.pixelplatformer.managers.PhysicsManager;
import com.przemek.pixelplatformer.utils.Constants;

public class GameScreen extends ScreenAdapter
{
	private PixelPlatformer game;
	
	public GameScreen()
	{
		game = new PixelPlatformer();
	}
	
	@Override
	public void render (float delta) 
	{
		game.updatePhysics();
		Gdx.gl.glClearColor(0.54f, 0.94f, 0.95f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.mainBatch.begin();
		game.renderMapStuff();
		game.debug();
		game.mainBatch.end();
		
		update(delta);
	}

	private void update(float delta)
	{
		
	}
	
	@Override
	public void resize (int width, int height) 
	{
		
	}

	@Override
	public void pause () 
	{
		
	}

	@Override
	public void resume () 
	{
		
	}

	@Override
	public void dispose () 
	{
		
	}
}
