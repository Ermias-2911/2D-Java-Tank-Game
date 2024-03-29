package tankwars.services;

import tankwars.builder.Builder;

public class SceneManagerService {
	public static final int TITLE_SCENE = 0;
	public static final int PLAY_SCENE = 1;

	boolean transition = false;
	boolean enable = true;
	int scene = -1;

	public void goTo(int scene) {
		transition = true;
		this.scene = scene;
	}

	public void update() {
		if (transition && enable) {
			enable = false;

			switch (scene) {
			case TITLE_SCENE:
				Builder.buildTitleScene();
				break;

			case PLAY_SCENE:
				Builder.buildPlayScene();
				break;
			default:
				// Player just enter an invalid scene, nothing will change
				System.out.println("Invalid scene!");
				transition = false;
				enable = true;
			}
		}
	}
}
