package de.schmidi;
public final class PluginInitializer {

	public static final void init(final de.schmidi.Start plugin) {
		plugin.getServer().getPluginManager().registerEvents(new de.schmidi.listener.SlimeInteractListener(plugin), plugin);
		
	}
}
