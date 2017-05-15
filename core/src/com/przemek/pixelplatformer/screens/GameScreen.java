package com.przemek.pixelplatformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.przemek.pixelplatformer.managers.PhysicsManager;
import com.przemek.pixelplatformer.utils.Constants;

public class GameScreen extends ScreenAdapter
{
	OrthographicCamera cam;
	PhysicsManager physics;
	
	public GameScreen()
	{
		physics = new PhysicsManager();
		cam = new OrthographicCamera(Constants.WIDTH, Constants.HEIGHT);
		cam.setToOrtho(false);
		
		FixtureDef fixDef = new FixtureDef();
		fixDef.density = 1.0f;
		Body body = physics.createBox(BodyDef.BodyType.StaticBody, 100, 100, 20, 20, 0.0f);
	}
	
	@Override
	public void render (float delta) 
	{
		physics.updateWorld(1/60f);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		physics.debugRender(cam.combined);
		
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
