package tankwars.gameobject.playscene;

import tankwars.builder.ServicePack;
import tankwars.services.SoundService;

public class Loader {
	public Loader(SoundService soundService) {
		soundService.loadSound("Explosion_small.wav");
		soundService.loadSound("Explosion_large.wav");
		soundService.loadSound("Music.mp3");
		soundService.loadSound("Music.wav");
	}
}
