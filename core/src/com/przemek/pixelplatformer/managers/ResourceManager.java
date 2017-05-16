package com.przemek.pixelplatformer.managers;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceManager
{
	public String sampleMap = "./Maps/sample.tmx";
	
	public Texture playerTex;
	public TextureRegion playerStanding, playerJumping;
	public HashMap<String, Animation> animations;
	
	public ResourceManager()
	{
		animations = new HashMap<String, Animation>();
		
		// Sprite: 96x96
		playerTex = new Texture("./Tilesheet/player.png");
		
		TextureRegion[][] regions = TextureRegion.split(playerTex, 96, 96);
		playerStanding = regions[0][0];
		playerJumping = regions[0][1];
		animations.put("Walking", new Animation(1f, regions[0][2], regions[0][3]));
		animations.put("Climbing", new Animation(1f, regions[1][0], regions[1][1]));
		animations.put("Landing", new Animation(1f, regions[1][2], regions[0][0]));
	}
	
	
}
