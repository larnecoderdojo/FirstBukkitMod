package com.bund.bukkit.fbe;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BundListener implements Listener
{
	@EventHandler
	public void onPlayerLogin(final PlayerLoginEvent evt)
	{
		
	}
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent evt)
	{
		final Location loc = evt.getPlayer().getLocation();
		loc.setY(loc.getY() + 5);
		final World world = loc.getWorld();
		final Block block = world.getBlockAt(loc);
	}
}
