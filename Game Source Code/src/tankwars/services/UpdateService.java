package tankwars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tankwars.gameobject.GameObject;
import tankwars.gameobject.properties.IUpdatable;
import tankwars.maincomponents.*;
import tankwars.services.delegates.Remover;

public class UpdateService {
	private final Remover remover;
	private List<IUpdatable> objects;

	public UpdateService(Remover remover) {
		this.remover = remover;
		objects = new CopyOnWriteArrayList<>();
	}

	public void register(IUpdatable object) {
		objects.add(object);
	}

	public void updateBegin() {
		for (IUpdatable object : objects) {
			object.onUpdateBegin();
		}
	}

	public void update() {
		for (IUpdatable object : objects) {
			object.onUpdate();
		}
	}

	public void updateEnd() {
		for (IUpdatable object : objects) {
			object.onUpdateEnd();
		}

		// Remove destroyed objects
		remover.removeIfDestroyed(objects);
	}
}
