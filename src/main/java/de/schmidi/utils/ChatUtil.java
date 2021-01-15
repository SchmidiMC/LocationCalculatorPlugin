package de.schmidi.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import de.schmidi.Start;

public class ChatUtil {
	private static String prefix = "";

	private static void setPrefix(String prefix) {
		ChatUtil.prefix = prefix;
	}

	private static void say(CommandSender sender, String msg) {
		sender.sendMessage(prefix + msg);
	}

	public static String getPrefix() {
		setPrefix(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + Start.pluginName
				+ ChatColor.DARK_GREEN + "]" + ChatColor.BLUE + " >>> ");
		return prefix;
	}
	
	public static void sendMessage(CommandSender sender, String text) {
		setPrefix(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + Start.pluginName
				+ ChatColor.DARK_GREEN + "]" + ChatColor.BLUE + " >>> ");
		say(sender, text);
	}

	public static void sendErrorMessage(CommandSender sender, String text) {
		setPrefix(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + Start.pluginName
				+ ChatColor.DARK_GREEN + "]" + ChatColor.RED + " >>> ");
		say(sender, text);
	}

}