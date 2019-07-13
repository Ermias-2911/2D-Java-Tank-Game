package tankwars.gameobject.playscene;

import tankwars.builder.ServicePack;
import tankwars.gameobject.properties.IUpdatable;
import tankwars.services.SoundService;
import tankwars.services.UpdateService;

public class MusicPlayer implements IUpdatable {
	SoundService soundService;
	
	public MusicPlayer(SoundService soundService, UpdateService updateService) {
		updateService.register(this);
		this.soundService = soundService;
	}
	
	@Override
	public void onUpdateBegin() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}
	

	private int delay = 5;
	private boolean isPlaying = false;
	@Override
	public void onUpdateEnd() {
		if (!isPlaying) {
			delay--;
			if (delay<0) {
				soundService.playSound("Music.wav");
				isPlaying = true;
			}	
		}	
	}
}
