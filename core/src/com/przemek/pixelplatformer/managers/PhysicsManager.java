package com.przemek.pixelplatformer.managers;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public class PhysicsManager 
{
	public World world;
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
	
	public Body createShape(BodyDef.BodyType bodyType, FixtureDef fixDef, Shape shape, float x, float y)
	{
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(x, y);
		
		Body body = world.createBody(bodyDef);
	
		fixDef.shape = shape;
		
		body.createFixture(fixDef);
		return body;
	}
	
	public Body createBox(BodyDef.BodyType bodyType, FixtureDef fixDef, float x, float y, float sizeX, float sizeY, float angle)
	{
		PolygonShape box = new PolygonShape();
		box.setAsBox(sizeX / 2, sizeY / 2, new Vector2(x + (sizeX / 2), y + (sizeY / 2)), angle);
		return createShape(bodyType, fixDef, box, x, y);
	}
	
	public Body createCircle(BodyDef.BodyType bodyType, FixtureDef fixDef, float x, float y, float radius)
	{
		CircleShape shape = new CircleShape();
		shape.setRadius(radius);
		return createShape(bodyType, fixDef, shape, x, y);
	}
	
	public Body createEdge(BodyDef.BodyType bodyType, FixtureDef fixDef, float x1, float y1, float x2, float y2)
	{
		EdgeShape edge = new EdgeShape();
		edge.set(x1, y1, x2, y2);
		return createShape(bodyType, fixDef, edge, x1, y1);
	}
}
