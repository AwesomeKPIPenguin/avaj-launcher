
package com.unit;

import java.util.ArrayList;
import java.util.List;

public class Tower {

	private List<Flyable> observers;
	private List<Flyable> observersToRemove;

	public Tower() {

		observers = new ArrayList<>();
		observersToRemove = new ArrayList<>();
	}

	public void register(Flyable flyable) {

		if (!observers.contains(flyable))
			observers.add(flyable);
	}

	public void unregister(Flyable flyable) {

		observersToRemove.add(flyable);
	}

	protected void conditionsChanged() {

		for (Flyable flyable : observers)
			flyable.updateConditions();
		if (!observersToRemove.isEmpty()) {
			for (Flyable flyable : observersToRemove)
				observers.remove(flyable);
			observersToRemove.clear();
		}
	}
}
