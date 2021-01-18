package de.schmidi;

import static de.schmidi.utils.ChatUtil.sendMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import de.schmidi.service.LocationService;
import de.schmidimc.mc.common.annotation.ApiVersion;
import de.schmidimc.mc.common.annotation.plugin.Plugin;

@Plugin(apiVersion = ApiVersion.VERSION_1_16, author = "Schmidi", main = "de.schmidi.Start", name = Start.pluginName, version = "1.0", description = "Can calculate the distance of two points using a slime ball.")

public class Start extends JavaPlugin {

	public final static String pluginName = "LocationCalculcator";

	private LocationService locationService;

	@Override
	public void onEnable() {

		try {
			CommandSender console = Bukkit.getConsoleSender();

			this.locationService = new LocationService();

			sendMessage(console, "loaded up!");
			PluginInitializer.init(this);
		} catch (Exception e) {
			System.out.println("An error eccoured:\n" + e.getMessage());
		}

	}

	public LocationService getLocationService() {
		return locationService;
	}
}
