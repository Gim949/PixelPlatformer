package com.przemek.pixelplatformer.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.przemek.pixelplatformer.managers.PhysicsManager;
import com.przemek.pixelplatformer.managers.ResourceManager;
import com.przemek.pixelplatformer.utils.Constants;

public class PixelPlatformer 
{
	public static final String GAME_NAME = "Pixel Platformer v1";
	public static final boolean debug = true; 
	
	public SpriteBatch mainBatch;
	public OrthographicCamera cam;
	public TiledMap map;
	
	private ResourceManager assets;
	private PhysicsManager physics;
	private OrthogonalTiledMapRenderer mapRenderer;
	private BitmapFont font;
	
	public PixelPlatformer()
	{
		mainBatch = new SpriteBatch();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
		
		physics = new PhysicsManager();
		assets = new ResourceManager();
		map = new TmxMapLoader().load(assets.sampleMap);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		// DEBUG
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}
	
	public void renderMapStuff()
	{
		mapRenderer.setView(cam);
		mapRenderer.render();
	}
	
	public void updatePhysics()
	{
		physics.world.step(1/60f, 6, 2);
	}
	
	public void cameraControls()
	{
		
	}
	
	public void debug()
	{
		if(debug)
		{
			physics.debugRender(cam.view.cpy().scl(100f));
			font.draw(mainBatch, GAME_NAME, 1, 11);
			font.draw(mainBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 1, 21);
		}
	}
}
