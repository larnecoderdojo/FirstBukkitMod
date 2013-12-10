package com.bund.bukkit.fbe;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BundPlugin extends JavaPlugin implements Listener {

	@Override
	public void onDisable() {
		getLogger().info("Bund has been unloaded");
	}

	@Override
	public void onEnable() {
		getLogger().info("Bund has been loaded");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		boolean result = false;
		
		if (command.getName().equalsIgnoreCase("nom"))
		{
			sender.sendMessage("Bund says hello!");
			result = true;
		} 
		else if (command.getName().equalsIgnoreCase("nomcube"))
		{
			final String playerName = sender.getName();
			final Player player = getServer().getPlayer(playerName);
			generateCube(player.getLocation(), 50);
		}
		
		return result;
	}
		
	private void generateCube(final Location loc, int length)
	{
		final int x1 = loc.getBlockX();
		final int y1 = loc.getBlockY();
		final int z1 = loc.getBlockZ();
		
		final int x2 = x1 + length;
		final int y2 = y1 + length;
		final int z2 = z1 + length;
		
		final World world = loc.getWorld();
		
		for (int xPoint = x1; xPoint <= x2; xPoint++) {
			for (int yPoint = y1; yPoint <= y2; yPoint++) {
				for (int zPoint = z1; zPoint <= z2; zPoint++) {
					final Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
					currentBlock.setTypeId(57);
				}
			}
		}
	}
}
