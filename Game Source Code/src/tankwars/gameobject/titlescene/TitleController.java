package tankwars.gameobject.titlescene;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import tankwars.gameobject.GameObject;
import tankwars.gameobject.properties.*;
import tankwars.services.*;

public class TitleController extends GameObject implements IUpdatable {
	private final KeyboardService keyboardService;
	private final SceneManagerService sceneManager;

	public TitleController(KeyboardService keyboardService, SceneManagerService sceneManager,
			UpdateService updateService) {
		this.keyboardService = keyboardService;
		this.sceneManager = sceneManager;
		updateService.register(this);
	}

	@Override
	public void onUpdateBegin() {

	}

	@Override
	public void onUpdate() {
		if (keyboardService.check(KeyEvent.VK_ENTER)) {
			// Go to play scene
			sceneManager.goTo(SceneManagerService.PLAY_SCENE);
		}
	}

	@Override
	public void onUpdateEnd() {

	}
}
