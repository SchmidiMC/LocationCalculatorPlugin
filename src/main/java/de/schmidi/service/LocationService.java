package de.schmidi.service;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationService {

	private Map<Player, Location[]> markedLocations;

	public LocationService() {
		this.markedLocations = new HashMap<Player, Location[]>();
	}

	public boolean playerHasLocationMarked(Player p) {
		if (this.markedLocations.containsKey(p)) {
			if (markedLocations.get(p)[0] != null) {
				return true;
			}
		}
		return false;
	}

	public Map<Player, Location[]> getMarkedLocations() {
		return markedLocations;
	}

	/***
	 * 
	 * @param p
	 * @param loc
	 * @return true if both locations are marked
	 */
	public boolean addMarkedLocation(Player p, Location loc) {
		Location[] markedLocations = this.markedLocations.get(p);
		if (markedLocations == null || !this.markedLocations.containsKey(p)) {
			this.markedLocations.put(p, new Location[2]);
			markedLocations = this.markedLocations.get(p);
		}
		if (markedLocations[0] == null) {
			markedLocations[0] = loc;
		} else {
			markedLocations[1] = loc;
			return true;
		}
		return false;

	}

	public void removeMarkedPoints(Player p) {
		this.markedLocations.remove(p);
	}

	public String calculateDistance(Location loc1, Location loc2) {

		double x = loc1.getX() - loc2.getX();
		double y = loc1.getY() - loc2.getY();
		double z = loc1.getZ() - loc2.getZ();

		return "~" + x + " ~" + y + " ~" + z;

	}

}
