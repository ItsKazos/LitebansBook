package me.itskazos.litebansbook;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.itskazos.litebansbook.commands.LitebansBook;
import me.itskazos.litebansbook.commands.LitebansPunish;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		this.getCommand("litebansbookreload").setExecutor(new LitebansBook());
		this.getCommand("punish").setExecutor(new LitebansPunish());
		createFiles();
		plugin = this;
	}
	public void onDisable() {
		
	}
	
	private File configf;
	private FileConfiguration config;
	
	private void createFiles() {
		configf = new File(getDataFolder(), "config.yml");
		
		if (!configf.exists()) {
			configf.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}
		config = new YamlConfiguration();
		
		try {
			config.load(configf);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
}
