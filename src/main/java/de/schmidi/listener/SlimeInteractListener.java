package de.schmidi.listener;

import static de.schmidi.utils.ChatUtil.sendMessage;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import de.schmidi.Start;
import de.schmidi.service.LocationService;
import de.schmidi.utils.ChatUtil;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

@de.schmidimc.mc.common.annotation.Listener
public class SlimeInteractListener implements Listener {

	private LocationService service;
	private final String permission = "locationCalculator.admin";

	public SlimeInteractListener(Start plugin) {
		this.service = plugin.getLocationService();
	}

	@EventHandler
	public void onSlimeInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getInventory().getItemInMainHand().getType() != Material.SLIME_BALL)
			return;
		if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.AIR)
			return;

		if (event.getHand() == EquipmentSlot.OFF_HAND)
			return;

		if (!p.hasPermission(this.permission))
			return;
		
		if(p.getGameMode() != GameMode.CREATIVE)
			return;

		if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			event.setCancelled(true);
		}

		Location loc = event.getClickedBlock().getLocation();

		if (this.service.addMarkedLocation(p, loc)) {

			Location loc1 = this.service.getMarkedLocations().get(p)[0];

			Location loc2 = this.service.getMarkedLocations().get(p)[1];
			TextComponent message = new TextComponent();
			message.setText(ChatUtil.getPrefix() + "Distance: " + this.service.calculateDistance(loc1, loc2));
			message.setClickEvent(
					new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, this.service.calculateDistance(loc1, loc2)));

			message.setHoverEvent(
					new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Copy the relative coordinates.")));
			p.spigot().sendMessage(message);
			this.service.removeMarkedPoints(p);
		} else {
			sendMessage(p, "First location marked.");
		}

	}

}
