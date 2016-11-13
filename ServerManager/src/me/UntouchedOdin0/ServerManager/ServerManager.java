package me.UntouchedOdin0.ServerManager;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.vk2gpz.tokenenchant.TokenEnchant;

public class ServerManager extends JavaPlugin implements Listener{

	public void onEnable()
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
	}
	
    public TokenEnchant getTokenEnchant() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TokenEnchant");
        if ((plugin == null) || (!(plugin instanceof TokenEnchant))) {
            return null;
           }
        return (TokenEnchant)plugin;
    }

	
	TokenEnchant te = getTokenEnchant();
	Player pl;
	
	public void openGUI(Player p) 
	{
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.BLACK + "ServerManager Settings");
	    
		ItemStack tps = new ItemStack(Material.SKULL);
	    ItemMeta tpsName = tps.getItemMeta();
	    tpsName.setDisplayName(ChatColor.GREEN + "Player count: " + Bukkit.getOnlinePlayers().size() + ChatColor.YELLOW + " ");
	    tps.setItemMeta(tpsName);
	    
	    ItemStack firstPlayed = new ItemStack(Material.PAPER);
	    ItemMeta firstPlayedName = firstPlayed.getItemMeta();
	    firstPlayedName.setDisplayName(ChatColor.GREEN + "Join Date: " + ChatColor.YELLOW + p.getFirstPlayed() + "");
	    
	    inv.addItem(tps);
	    inv.addItem(firstPlayed);
	    
	    p.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory() != null && e.getInventory().getType() == InventoryType.CHEST){
			e.setCancelled(true);
		}
			}
		
		   
	
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if ((cmd.getName().equalsIgnoreCase("servermanager"))) {
	      openGUI((Player)sender); 
	      
	      if((cmd.getName().equalsIgnoreCase("sm"))) {
	    	  openGUI((Player)sender);
	      }
	    }
	    return true;
	  }
}