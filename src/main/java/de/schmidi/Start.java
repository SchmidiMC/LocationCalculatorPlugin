package de.schmidi;

import static de.schmidi.utils.ChatUtil.sendMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import de.schmidi.service.LocationService;
import de.schmidimc.mc.common.annotation.ApiVersion;
import de.schmidimc.mc.common.annotation.plugin.Plugin;

@Plugin(apiVersion = ApiVersion.VERSION_1_16, author = "Schmidi", main = "de.schmidi.Start", name = Start.pluginName)

public class Start extends JavaPlugin {

	public final static String pluginName = "LocationCalculcator";

	private LocationService locationService;
	
	@Override
	public void onEnable() {
		CommandSender console = Bukkit.getConsoleSender();

		sendMessage(console, "started loading process!");
		this.locationService = new LocationService();
		sendMessage(console, "completed loading!");
		PluginInitializer.init(this);
	}

	public LocationService getLocationService() {
		return locationService;
	}
}
