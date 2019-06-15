
package com.unit;

import java.util.List;

public class Tower {

	private List<Flyable> observers;

	public void register(Flyable flyable) {

		if (!observers.contains(flyable))
			observers.add(flyable);
	}

	public void unregister(Flyable flyable) {

		observers.remove(flyable);
	}

	protected void conditionsChanged() {

		for (Flyable flyable : observers)
			flyable.updateConditions();
	}
}
