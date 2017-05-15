package com.przemek.pixelplatformer.managers;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class PhysicsManager 
{
	private World world;
	private Box2DDebugRenderer debugRenderer;

	public PhysicsManager() 
	{
		world = new World(new Vector2(0, -9.8f), false);
		debugRenderer = new Box2DDebugRenderer();
	}

	public void debugRender(Matrix4 mat4)
	{
		debugRenderer.render(world, mat4);
	}

	public void updateWorld(float timeStep)
	{
		world.step(timeStep, 6, 2);
	}

	public Body createBox(BodyDef.BodyType bodyType, float x, float y, float sizeX, float sizeY, float angle)
	{
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(x, y);

		Body body = world.createBody(bodyDef);

		PolygonShape box = new PolygonShape();
		box.setAsBox(sizeX / 2, sizeY / 2, new Vector2(x - (sizeX / 2), y - (sizeY / 2)), angle);

		FixtureDef fixDef = new FixtureDef();
		fixDef.density = 1.0f;
		fixDef.shape = box;
		body.createFixture(fixDef);
		box.dispose();

		return body;
	}
}
