package com.przemek.pixelplatformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.przemek.pixelplatformer.screens.GameScreen;

public class PixelPlatformerGame extends Game 
{
	/*SpriteBatch batch;
	Texture img;*/
	
	GameScreen gameScreen;
	
	@Override
	public void create ()
	{
		/*batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");*/
		gameScreen = new GameScreen();
	}

	@Override
	public void render () 
	{
		super.render();
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
		
		super.setScreen(gameScreen);
	}
	
	@Override
	public void dispose () 
	{
		super.dispose();
	}
}