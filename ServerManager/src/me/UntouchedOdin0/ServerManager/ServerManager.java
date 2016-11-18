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
		
		if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			Bukkit.getServer().getLogger().log(null, "PlaceholderAPI has been found!");
			Bukkit.getServer().getLogger().log(null, "hooking into it for Placeholders!");
		}
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
		Inventory inv = Bukkit.createInventory(null, 36, this.getConfig().getString(ChatColor.stripColor("title-name")));
		Inventory inv2 = Bukkit.createInventory(null, 36, this.getConfig().getString(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes(""));
	    ItemStack firstPlayed = new ItemStack(Material.PAPER);
	    ItemMeta firstPlayedName = firstPlayed.getItemMeta();
	    firstPlayedName.setDisplayName("" + ChatColor.GREEN + "Plugins: " + Bukkit.getPluginManager().getPlugins().length + " ");
	    
	    ItemStack test = new ItemStack(Material.DAYLIGHT_DETECTOR);
	    ItemMeta testName = test.getItemMeta();
	    testName.setDisplayName(ChatColor.RED + "Time");
	    
	    ItemStack creators = new ItemStack(Material.SKULL);
	    ItemMeta creatorsName = creators.getItemMeta();
	    creatorsName.setDisplayName(ChatColor.YELLOW + "The founder is:" + ChatColor.GREEN + " Untouchedodin0");
	    
	    inv.setItem(0, firstPlayed);
	    inv.setItem(1, test);
	    inv.setItem(5, creators);
	    
	    p.openInventory(inv);
	    
	}
	public void openGUIc(Player p)
	{
		Inventory Creators = Bukkit.createInventory(null, 9, ChatColor.BLACK + "Developers of this plugin:");
		
		ItemStack odin = new ItemStack(Material.SKULL);
		ItemMeta odinName = odin.getItemMeta();
		odinName.setDisplayName(ChatColor.GREEN + "UntouchedOdin0");
		odinName.setLore(Arrays.asList(ChatColor.YELLOW + "UntouchedOdin0 is the creator."));
		
		p.openInventory(Creators);
	}
	
	 @EventHandler
	  public void onInventoryClickEvent(InventoryClickEvent event)
	  {
	    if (!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Chat Control")) {
	      return;
	    }
	    Player player = (Player)event.getWhoClicked();
	    event.setCancelled(true);
	    if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR) || (!event.getCurrentItem().hasItemMeta()))
	    {
	      player.closeInventory();
	      return;
	    }
	    switch (event.getCurrentItem().getType())
	    {
	    case PAPER: 
	      player.sendMessage(ChatColor.YELLOW + "That's you right?");
	      event.setCancelled(true);
	      player.closeInventory();
	      break;
		default:
			break;
	    }
	  }
	
		
		   
	
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if ((cmd.getName().equalsIgnoreCase("servermanager"))) {
	      openGUI((Player)sender); 
	    }
	    return true;
	  }
}