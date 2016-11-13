package me.UntouchedOdin0.ServerManager.hooks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;



public class TokenEnchant {

	public TokenEnchant getTokenEnchant() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TokenEnchant");
		if ((plugin == null) || (!(plugin instanceof TokenEnchant))) {
			return null;
		}
		return (TokenEnchant)plugin;
	}
	
	public TokenEnchant te = getTokenEnchant();
	
	
}