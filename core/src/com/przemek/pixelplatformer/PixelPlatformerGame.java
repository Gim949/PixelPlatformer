package com.przemek.pixelplatformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.przemek.pixelplatformer.screens.GameScreen;

public class PixelPlatformerGame extends Game 
{
	private GameScreen gameScreen;
	
	@Override
	public void create ()
	{
		gameScreen = new GameScreen();
	}

	@Override
	public void render () 
	{
		super.render();	
		super.setScreen(gameScreen);
	}
	
	@Override
	public void dispose () 
	{
		super.dispose();
	}
}
