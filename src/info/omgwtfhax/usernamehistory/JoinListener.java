package info.omgwtfhax.usernamehistory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	BukkitPlugin plugin;
	FileConfiguration config;
	
	public JoinListener(BukkitPlugin instance)
	{
		this.plugin = instance;
		this.config = instance.getConfig();
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		System.out.println("Player joined");
		String uuid = e.getPlayer().getUniqueId().toString();
	
		String player = e.getPlayer().getDisplayName();
		List<String> playerHistory = config.getStringList(uuid);
		
		if(playerHistory == null)
			playerHistory = new ArrayList<String>();
		
		if(!playerHistory.contains(player))
		{
			playerHistory.add(player);
			config.set(uuid, playerHistory);
			plugin.saveConfig();
		}
	}

}
