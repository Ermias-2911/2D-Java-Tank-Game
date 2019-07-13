/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankwars.gameobject.playscene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tankwars.builder.ServicePack;
import tankwars.datastructures.Position;
import tankwars.gameobject.GameObject;
import tankwars.gameobject.properties.IDestructible;
import tankwars.gameobject.properties.IDrawable;
import tankwars.gameobject.properties.ITransform;
import tankwars.services.AnimationService;
import tankwars.services.CameraDrawingService;
import tankwars.services.SoundService;

/**
 *
 * @author vu.cu
 */
public class BigExplosion extends GameObject implements IDrawable, IDestructible, ITransform {
	private final AnimationService animationService;
	private final SoundService soundService = ServicePack.services().soundService;
	
	public BigExplosion(AnimationService animationService, CameraDrawingService camera, Position position) {
		this.animationService = animationService;
		animationService.register(this, "big_explosion_%d.png", 7, 20);
		camera.drawOnAllCameras(this);

		soundService.playSound("Explosion_large.wav");
		this.setPosition(position);
	}

	@Override
	public void onDraw(Graphics g) {
		BufferedImage image = animationService.getCurrentImage(this);
		if (image == null) {
			this.destroy();
			return;
		}

		Position position = this.getPosition();
		g.drawImage(image, position.x - image.getWidth() / 2, position.y - image.getHeight() / 2, null);
	}

	@Override
	public int getDepth() {
		return -10;
	}

	private boolean destroyed = false;

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public void destroy() {
		destroyed = true;
	}

	private Position position;

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}
}