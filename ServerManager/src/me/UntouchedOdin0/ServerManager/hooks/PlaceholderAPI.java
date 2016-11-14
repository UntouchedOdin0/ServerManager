package me.UntouchedOdin0.ServerManager.hooks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PlaceholderAPI {

	public PlaceholderAPI getTokenEnchant() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI");
		if ((plugin == null) || (!(plugin instanceof PlaceholderAPI))) {
			return null;
		}
		return (PlaceholderAPI)plugin;
	}
	
}