package me.itskazos.litebansbook.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.itskazos.litebansbook.Main;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.NBTTagString;
import net.minecraft.server.v1_8_R3.StatisticList;

public class LitebansPunish implements CommandExecutor {
	private Plugin plugin = Main.getPlugin(Main.class);
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	Player p = (Player) sender;
    	if(p.hasPermission("litebanspunish.use")) {
    		if (args.length < 0) {
    			p.sendMessage("No");
    		}
        	if (args.length == 1) {
            	Player player = Bukkit.getPlayer(args[0]);
            	if (player != null) {
			    	HumanEntity humanEntity = (HumanEntity) p;
			    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
			    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
			
			    	ItemStack book = new ItemStack(Item.getById(387));
			    	NBTTagCompound tag = new NBTTagCompound();
			    	tag.setString("author", "ItsKazos");
			    	tag.setString("title", "Hi");
			    	tag.set("display", new NBTTagCompound());
			
			    	NBTTagCompound display = tag.getCompound("display");
			    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
			    	NBTTagList lore = new NBTTagList();
			    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
			    	display.set("Lore", lore);
			    	NBTTagList pages = new NBTTagList();
			
			    	NBTTagCompound paneltitle = new NBTTagCompound();
			    	paneltitle.setString("text", "Select a punishemnt!\n");
			
			    	NBTTagCompound json = new NBTTagCompound();
			    	json.setString("text", "\n➤ " + ChatColor.RED + ChatColor.BOLD + "Ban");
			    	json.set("clickEvent", new NBTTagCompound());
			    	json.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
			    	clickEvent.setString("action", "run_command");
			    	clickEvent.setString("value", "/punish " + player.getName().toString() + " ban");
			    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
			    	hoverEvent.setString("action", "show_text");
			    	hoverEvent.set("value", new NBTTagCompound());
			    	hoverEvent.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
			    	hoverValue.setString("text", "Click this to ban " + player.getName().toString());
			
			    	NBTTagCompound json2 = new NBTTagCompound();
			    	json2.setString("text", "\n➤ " + ChatColor.BLUE + ChatColor.BOLD + "Mute");
			    	json2.set("clickEvent", new NBTTagCompound());
			    	json2.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
			    	clickEvent2.setString("action", "run_command");
			    	clickEvent2.setString("value", "/punish " + player.getName().toString() + " mute");
			    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
			    	hoverEvent2.setString("action", "show_text");
			    	hoverEvent2.set("value", new NBTTagCompound());
			    	hoverEvent2.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
			    	hoverValue2.setString("text", "Click this to ban " + player.getName().toString());
					
			    	NBTTagCompound json3 = new NBTTagCompound();
			    	json3.setString("text", "\n➤ " + ChatColor.YELLOW + ChatColor.BOLD + "Warn");
			    	json3.set("clickEvent", new NBTTagCompound());
			    	json3.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
			    	clickEvent3.setString("action", "run_command");
			    	clickEvent3.setString("value", "/punish " + player.getName().toString() + " warn");
			    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
			    	hoverEvent3.setString("action", "show_text");
			    	hoverEvent3.set("value", new NBTTagCompound());
			    	hoverEvent3.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
			    	hoverValue3.setString("text", "Click this to ban " + player.getName().toString());
			
			    	NBTTagCompound json4 = new NBTTagCompound();
			    	json4.setString("text", "\n➤ " + ChatColor.DARK_RED + ChatColor.BOLD + "Kick");
			    	json4.set("clickEvent", new NBTTagCompound());
			    	json4.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
			    	clickEvent4.setString("action", "run_command");
			    	clickEvent4.setString("value", "/punish " + player.getName().toString() + " kick");
			    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
			    	hoverEvent4.setString("action", "show_text");
			    	hoverEvent4.set("value", new NBTTagCompound());
			    	hoverEvent4.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
			    	hoverValue4.setString("text", "Click this to ban " + player.getName().toString());
			
			    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "]"));
			
			    	tag.set("pages", pages);
			    	book.setTag(tag);
			    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
			    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
			    	entityHuman.openBook(book);
			    	p.setItemInHand(hand);
			    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
            	} else {
                	OfflinePlayer player1 = Bukkit.getOfflinePlayer(args[0]);
			    	HumanEntity humanEntity = (HumanEntity) p;
			    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
			    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
			
			    	ItemStack book = new ItemStack(Item.getById(387));
			    	NBTTagCompound tag = new NBTTagCompound();
			    	tag.setString("author", "ItsKazos");
			    	tag.setString("title", "Hi");
			    	tag.set("display", new NBTTagCompound());
			
			    	NBTTagCompound display = tag.getCompound("display");
			    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
			    	NBTTagList lore = new NBTTagList();
			    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
			    	display.set("Lore", lore);
			    	NBTTagList pages = new NBTTagList();
			
			    	NBTTagCompound paneltitle = new NBTTagCompound();
			    	paneltitle.setString("text", "Select a punishemnt!\n");
			
			    	NBTTagCompound json = new NBTTagCompound();
			    	json.setString("text", "\n➤ " + ChatColor.RED + ChatColor.BOLD + "Ban");
			    	json.set("clickEvent", new NBTTagCompound());
			    	json.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
			    	clickEvent.setString("action", "run_command");
			    	clickEvent.setString("value", "/punish " + player1.getName().toString() + " ban");
			    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
			    	hoverEvent.setString("action", "show_text");
			    	hoverEvent.set("value", new NBTTagCompound());
			    	hoverEvent.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
			    	hoverValue.setString("text", "Click this to ban " + player1.getName().toString());
			
			    	NBTTagCompound json2 = new NBTTagCompound();
			    	json2.setString("text", "\n➤ " + ChatColor.BLUE + ChatColor.BOLD + "Mute");
			    	json2.set("clickEvent", new NBTTagCompound());
			    	json2.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
			    	clickEvent2.setString("action", "run_command");
			    	clickEvent2.setString("value", "/punish " + player1.getName().toString() + " mute");
			    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
			    	hoverEvent2.setString("action", "show_text");
			    	hoverEvent2.set("value", new NBTTagCompound());
			    	hoverEvent2.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
			    	hoverValue2.setString("text", "Click this to ban " + player1.getName().toString());
					
			    	NBTTagCompound json3 = new NBTTagCompound();
			    	json3.setString("text", "\n➤ " + ChatColor.YELLOW + ChatColor.BOLD + "Warn");
			    	json3.set("clickEvent", new NBTTagCompound());
			    	json3.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
			    	clickEvent3.setString("action", "run_command");
			    	clickEvent3.setString("value", "/punish " + player1.getName().toString() + " warn");
			    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
			    	hoverEvent3.setString("action", "show_text");
			    	hoverEvent3.set("value", new NBTTagCompound());
			    	hoverEvent3.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
			    	hoverValue3.setString("text", "Click this to ban " + player1.getName().toString());
			
			    	NBTTagCompound json4 = new NBTTagCompound();
			    	json4.setString("text", "\n➤ " + ChatColor.DARK_RED + ChatColor.BOLD + "Kick");
			    	json4.set("clickEvent", new NBTTagCompound());
			    	json4.set("hoverEvent", new NBTTagCompound());
			
			    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
			    	clickEvent4.setString("action", "run_command");
			    	clickEvent4.setString("value", "/punish " + player1.getName().toString() + " kick");
			    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
			    	hoverEvent4.setString("action", "show_text");
			    	hoverEvent4.set("value", new NBTTagCompound());
			    	hoverEvent4.setString("insertion", "what is this?");
			    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
			    	hoverValue4.setString("text", "Click this to ban " + player1.getName().toString());
			
			    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "]"));
			
			    	tag.set("pages", pages);
			    	book.setTag(tag);
			    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
			    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
			    	entityHuman.openBook(book);
			    	p.setItemInHand(hand);
			    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
            	}
    		} else {
        		if (args.length >= 1) {
        			if (args[1].equalsIgnoreCase("mute")) {
    	            	Player player = Bukkit.getPlayer(args[0]);
    	            	if (player != null) {
    				    	HumanEntity humanEntity = (HumanEntity) p;
    				    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
    				    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
    				
    				    	ItemStack book = new ItemStack(Item.getById(387));
    				    	NBTTagCompound tag = new NBTTagCompound();
    				    	tag.setString("author", "ItsKazos");
    				    	tag.setString("title", "Hi");
    				    	tag.set("display", new NBTTagCompound());
    				
    				    	NBTTagCompound display = tag.getCompound("display");
    				    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
    				    	NBTTagList lore = new NBTTagList();
    				    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
    				    	display.set("Lore", lore);
    				    	NBTTagList pages = new NBTTagList();
    				
    				    	NBTTagCompound paneltitle = new NBTTagCompound();
    				    	paneltitle.setString("text", "Select a punishemnt!\n");
    				
    				    	NBTTagCompound json = new NBTTagCompound();
    				    	json.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonOne"));
    				    	json.set("clickEvent", new NBTTagCompound());
    				    	json.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
    				    	clickEvent.setString("action", "run_command");
    				    	clickEvent.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationOne") + " " + plugin.getConfig().getString("MuteReasonOne"));
    				    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
    				    	hoverEvent.setString("action", "show_text");
    				    	hoverEvent.set("value", new NBTTagCompound());
    				    	hoverEvent.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
    				    	hoverValue.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json2 = new NBTTagCompound();
    				    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwo"));
    				    	json2.set("clickEvent", new NBTTagCompound());
    				    	json2.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
    				    	clickEvent2.setString("action", "run_command");
    				    	clickEvent2.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwo") + " " + plugin.getConfig().getString("MuteReasonTwo"));
    				    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
    				    	hoverEvent2.setString("action", "show_text");
    				    	hoverEvent2.set("value", new NBTTagCompound());
    				    	hoverEvent2.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
    				    	hoverValue2.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json3 = new NBTTagCompound();
    				    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonThree"));
    				    	json3.set("clickEvent", new NBTTagCompound());
    				    	json3.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
    				    	clickEvent3.setString("action", "run_command");
    				    	clickEvent3.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationThree") + " " + plugin.getConfig().getString("MuteReasonThree"));
    				    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
    				    	hoverEvent3.setString("action", "show_text");
    				    	hoverEvent3.set("value", new NBTTagCompound());
    				    	hoverEvent3.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
    				    	hoverValue3.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json4 = new NBTTagCompound();
    				    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFour"));
    				    	json4.set("clickEvent", new NBTTagCompound());
    				    	json4.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
    				    	clickEvent4.setString("action", "run_command");
    				    	clickEvent4.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFour") + " " + plugin.getConfig().getString("MuteReasonFour"));
    				    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
    				    	hoverEvent4.setString("action", "show_text");
    				    	hoverEvent4.set("value", new NBTTagCompound());
    				    	hoverEvent4.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
    				    	hoverValue4.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json5 = new NBTTagCompound();
    				    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFive"));
    				    	json5.set("clickEvent", new NBTTagCompound());
    				    	json5.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
    				    	clickEvent5.setString("action", "run_command");
    				    	clickEvent5.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFive") + " " + plugin.getConfig().getString("MuteReasonFive"));
    				    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
    				    	hoverEvent5.setString("action", "show_text");
    				    	hoverEvent5.set("value", new NBTTagCompound());
    				    	hoverEvent5.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
    				    	hoverValue5.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json6 = new NBTTagCompound();
    				    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSix"));
    				    	json6.set("clickEvent", new NBTTagCompound());
    				    	json6.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
    				    	clickEvent6.setString("action", "run_command");
    				    	clickEvent6.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSix") + " " + plugin.getConfig().getString("MuteReasonSix"));
    				    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
    				    	hoverEvent6.setString("action", "show_text");
    				    	hoverEvent6.set("value", new NBTTagCompound());
    				    	hoverEvent6.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
    				    	hoverValue6.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json7 = new NBTTagCompound();
    				    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSeven"));
    				    	json7.set("clickEvent", new NBTTagCompound());
    				    	json7.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
    				    	clickEvent7.setString("action", "run_command");
    				    	clickEvent7.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSeven") + " " + plugin.getConfig().getString("MuteReasonSeven"));
    				    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
    				    	hoverEvent7.setString("action", "show_text");
    				    	hoverEvent7.set("value", new NBTTagCompound());
    				    	hoverEvent7.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
    				    	hoverValue7.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json8 = new NBTTagCompound();
    				    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEight"));
    				    	json8.set("clickEvent", new NBTTagCompound());
    				    	json8.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
    				    	clickEvent8.setString("action", "run_command");
    				    	clickEvent8.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEight") + " " + plugin.getConfig().getString("MuteReasonEight"));
    				    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
    				    	hoverEvent8.setString("action", "show_text");
    				    	hoverEvent8.set("value", new NBTTagCompound());
    				    	hoverEvent8.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
    				    	hoverValue8.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json9 = new NBTTagCompound();
    				    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonNine"));
    				    	json9.set("clickEvent", new NBTTagCompound());
    				    	json9.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
    				    	clickEvent9.setString("action", "run_command");
    				    	clickEvent9.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationNine") + " " + plugin.getConfig().getString("MuteReasonNine"));
    				    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
    				    	hoverEvent9.setString("action", "show_text");
    				    	hoverEvent9.set("value", new NBTTagCompound());
    				    	hoverEvent9.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
    				    	hoverValue9.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json10 = new NBTTagCompound();
    				    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTen"));
    				    	json10.set("clickEvent", new NBTTagCompound());
    				    	json10.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
    				    	clickEvent10.setString("action", "run_command");
    				    	clickEvent10.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTen") + " " + plugin.getConfig().getString("MuteReasonTen"));
    				    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
    				    	hoverEvent10.setString("action", "show_text");
    				    	hoverEvent10.set("value", new NBTTagCompound());
    				    	hoverEvent10.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
    				    	hoverValue10.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json11 = new NBTTagCompound();
    				    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEleven"));
    				    	json11.set("clickEvent", new NBTTagCompound());
    				    	json11.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
    				    	clickEvent11.setString("action", "run_command");
    				    	clickEvent11.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEleven") + " " + plugin.getConfig().getString("MuteReasonEleven"));
    				    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
    				    	hoverEvent11.setString("action", "show_text");
    				    	hoverEvent11.set("value", new NBTTagCompound());
    				    	hoverEvent11.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
    				    	hoverValue11.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json12 = new NBTTagCompound();
    				    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwelve"));
    				    	json12.set("clickEvent", new NBTTagCompound());
    				    	json12.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
    				    	clickEvent12.setString("action", "run_command");
    				    	clickEvent12.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwelve") + " " + plugin.getConfig().getString("MuteReasonTwelve"));
    				    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
    				    	hoverEvent12.setString("action", "show_text");
    				    	hoverEvent12.set("value", new NBTTagCompound());
    				    	hoverEvent12.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
    				    	hoverValue12.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json13 = new NBTTagCompound();
    				    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonThirteen"));
    				    	json13.set("clickEvent", new NBTTagCompound());
    				    	json13.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
    				    	clickEvent13.setString("action", "run_command");
    				    	clickEvent13.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationThirteen") + " " + plugin.getConfig().getString("MuteReasonThirteen"));
    				    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
    				    	hoverEvent13.setString("action", "show_text");
    				    	hoverEvent13.set("value", new NBTTagCompound());
    				    	hoverEvent13.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
    				    	hoverValue13.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json14 = new NBTTagCompound();
    				    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFourteen"));
    				    	json14.set("clickEvent", new NBTTagCompound());
    				    	json14.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
    				    	clickEvent14.setString("action", "run_command");
    				    	clickEvent14.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFourteen") + " " + plugin.getConfig().getString("MuteReasonFourteen"));
    				    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
    				    	hoverEvent14.setString("action", "show_text");
    				    	hoverEvent14.set("value", new NBTTagCompound());
    				    	hoverEvent14.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
    				    	hoverValue14.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json15 = new NBTTagCompound();
    				    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFifteen"));
    				    	json15.set("clickEvent", new NBTTagCompound());
    				    	json15.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
    				    	clickEvent15.setString("action", "run_command");
    				    	clickEvent15.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFifteen") + " " + plugin.getConfig().getString("MuteReasonFifteen"));
    				    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
    				    	hoverEvent15.setString("action", "show_text");
    				    	hoverEvent15.set("value", new NBTTagCompound());
    				    	hoverEvent15.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
    				    	hoverValue15.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json16 = new NBTTagCompound();
    				    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSixteen"));
    				    	json10.set("clickEvent", new NBTTagCompound());
    				    	json10.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
    				    	clickEvent16.setString("action", "run_command");
    				    	clickEvent16.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSixteen") + " " + plugin.getConfig().getString("MuteReasonSixteen"));
    				    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
    				    	hoverEvent16.setString("action", "show_text");
    				    	hoverEvent16.set("value", new NBTTagCompound());
    				    	hoverEvent16.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
    				    	hoverValue16.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json17 = new NBTTagCompound();
    				    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSeventeen"));
    				    	json17.set("clickEvent", new NBTTagCompound());
    				    	json17.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
    				    	clickEvent17.setString("action", "run_command");
    				    	clickEvent17.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSeventeen") + " " + plugin.getConfig().getString("MuteReasonSeventeen"));
    				    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
    				    	hoverEvent17.setString("action", "show_text");
    				    	hoverEvent17.set("value", new NBTTagCompound());
    				    	hoverEvent17.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
    				    	hoverValue17.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json18 = new NBTTagCompound();
    				    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEighteen"));
    				    	json18.set("clickEvent", new NBTTagCompound());
    				    	json18.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
    				    	clickEvent18.setString("action", "run_command");
    				    	clickEvent18.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEighteen") + " " + plugin.getConfig().getString("MuteReasonEighteen"));
    				    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
    				    	hoverEvent18.setString("action", "show_text");
    				    	hoverEvent18.set("value", new NBTTagCompound());
    				    	hoverEvent18.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
    				    	hoverValue18.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json19 = new NBTTagCompound();
    				    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonNinteen"));
    				    	json19.set("clickEvent", new NBTTagCompound());
    				    	json19.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
    				    	clickEvent19.setString("action", "run_command");
    				    	clickEvent19.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationNinteen") + " " + plugin.getConfig().getString("MuteReasonNinteen"));
    				    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
    				    	hoverEvent19.setString("action", "show_text");
    				    	hoverEvent19.set("value", new NBTTagCompound());
    				    	hoverEvent19.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
    				    	hoverValue19.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	NBTTagCompound json20 = new NBTTagCompound();
    				    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwenty"));
    				    	json20.set("clickEvent", new NBTTagCompound());
    				    	json20.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
    				    	clickEvent20.setString("action", "run_command");
    				    	clickEvent20.setString("value", "/mute " + player.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwenty") + " " + plugin.getConfig().getString("MuteReasonTwenty"));
    				    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
    				    	hoverEvent20.setString("action", "show_text");
    				    	hoverEvent20.set("value", new NBTTagCompound());
    				    	hoverEvent20.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
    				    	hoverValue20.setString("text", "Click this to mute " + player.getName().toString());
    				
    				    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
    				    	
    				    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
    				
    				    	tag.set("pages", pages);
    				    	book.setTag(tag);
    				    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
    				    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
    				    	entityHuman.openBook(book);
    				    	p.setItemInHand(hand);
    				    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
    	            	} else {
    	                	OfflinePlayer player1 = Bukkit.getOfflinePlayer(args[0]);
    				    	HumanEntity humanEntity = (HumanEntity) p;
    				    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
    				    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
    				
    				    	ItemStack book = new ItemStack(Item.getById(387));
    				    	NBTTagCompound tag = new NBTTagCompound();
    				    	tag.setString("author", "ItsKazos");
    				    	tag.setString("title", "Hi");
    				    	tag.set("display", new NBTTagCompound());
    				
    				    	NBTTagCompound display = tag.getCompound("display");
    				    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
    				    	NBTTagList lore = new NBTTagList();
    				    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
    				    	display.set("Lore", lore);
    				    	NBTTagList pages = new NBTTagList();
    				
    				    	NBTTagCompound paneltitle = new NBTTagCompound();
    				    	paneltitle.setString("text", "Select a punishemnt!\n");
    				
    				    	NBTTagCompound json = new NBTTagCompound();
    				    	json.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonOne"));
    				    	json.set("clickEvent", new NBTTagCompound());
    				    	json.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
    				    	clickEvent.setString("action", "run_command");
    				    	clickEvent.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationOne") + " " + plugin.getConfig().getString("MuteReasonOne"));
    				    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
    				    	hoverEvent.setString("action", "show_text");
    				    	hoverEvent.set("value", new NBTTagCompound());
    				    	hoverEvent.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
    				    	hoverValue.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json2 = new NBTTagCompound();
    				    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwo"));
    				    	json2.set("clickEvent", new NBTTagCompound());
    				    	json2.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
    				    	clickEvent2.setString("action", "run_command");
    				    	clickEvent2.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwo") + " " + plugin.getConfig().getString("MuteReasonTwo"));
    				    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
    				    	hoverEvent2.setString("action", "show_text");
    				    	hoverEvent2.set("value", new NBTTagCompound());
    				    	hoverEvent2.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
    				    	hoverValue2.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json3 = new NBTTagCompound();
    				    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonThree"));
    				    	json3.set("clickEvent", new NBTTagCompound());
    				    	json3.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
    				    	clickEvent3.setString("action", "run_command");
    				    	clickEvent3.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationThree") + " " + plugin.getConfig().getString("MuteReasonThree"));
    				    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
    				    	hoverEvent3.setString("action", "show_text");
    				    	hoverEvent3.set("value", new NBTTagCompound());
    				    	hoverEvent3.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
    				    	hoverValue3.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json4 = new NBTTagCompound();
    				    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFour"));
    				    	json4.set("clickEvent", new NBTTagCompound());
    				    	json4.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
    				    	clickEvent4.setString("action", "run_command");
    				    	clickEvent4.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFour") + " " + plugin.getConfig().getString("MuteReasonFour"));
    				    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
    				    	hoverEvent4.setString("action", "show_text");
    				    	hoverEvent4.set("value", new NBTTagCompound());
    				    	hoverEvent4.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
    				    	hoverValue4.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json5 = new NBTTagCompound();
    				    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFive"));
    				    	json5.set("clickEvent", new NBTTagCompound());
    				    	json5.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
    				    	clickEvent5.setString("action", "run_command");
    				    	clickEvent5.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFive") + " " + plugin.getConfig().getString("MuteReasonFive"));
    				    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
    				    	hoverEvent5.setString("action", "show_text");
    				    	hoverEvent5.set("value", new NBTTagCompound());
    				    	hoverEvent5.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
    				    	hoverValue5.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json6 = new NBTTagCompound();
    				    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSix"));
    				    	json6.set("clickEvent", new NBTTagCompound());
    				    	json6.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
    				    	clickEvent6.setString("action", "run_command");
    				    	clickEvent6.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSix") + " " + plugin.getConfig().getString("MuteReasonSix"));
    				    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
    				    	hoverEvent6.setString("action", "show_text");
    				    	hoverEvent6.set("value", new NBTTagCompound());
    				    	hoverEvent6.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
    				    	hoverValue6.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json7 = new NBTTagCompound();
    				    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSeven"));
    				    	json7.set("clickEvent", new NBTTagCompound());
    				    	json7.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
    				    	clickEvent7.setString("action", "run_command");
    				    	clickEvent7.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSeven") + " " + plugin.getConfig().getString("MuteReasonSeven"));
    				    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
    				    	hoverEvent7.setString("action", "show_text");
    				    	hoverEvent7.set("value", new NBTTagCompound());
    				    	hoverEvent7.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
    				    	hoverValue7.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json8 = new NBTTagCompound();
    				    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEight"));
    				    	json8.set("clickEvent", new NBTTagCompound());
    				    	json8.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
    				    	clickEvent8.setString("action", "run_command");
    				    	clickEvent8.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEight") + " " + plugin.getConfig().getString("MuteReasonEight"));
    				    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
    				    	hoverEvent8.setString("action", "show_text");
    				    	hoverEvent8.set("value", new NBTTagCompound());
    				    	hoverEvent8.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
    				    	hoverValue8.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json9 = new NBTTagCompound();
    				    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonNine"));
    				    	json9.set("clickEvent", new NBTTagCompound());
    				    	json9.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
    				    	clickEvent9.setString("action", "run_command");
    				    	clickEvent9.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationNine") + " " + plugin.getConfig().getString("MuteReasonNine"));
    				    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
    				    	hoverEvent9.setString("action", "show_text");
    				    	hoverEvent9.set("value", new NBTTagCompound());
    				    	hoverEvent9.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
    				    	hoverValue9.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json10 = new NBTTagCompound();
    				    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTen"));
    				    	json10.set("clickEvent", new NBTTagCompound());
    				    	json10.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
    				    	clickEvent10.setString("action", "run_command");
    				    	clickEvent10.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTen") + " " + plugin.getConfig().getString("MuteReasonTen"));
    				    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
    				    	hoverEvent10.setString("action", "show_text");
    				    	hoverEvent10.set("value", new NBTTagCompound());
    				    	hoverEvent10.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
    				    	hoverValue10.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json11 = new NBTTagCompound();
    				    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEleven"));
    				    	json11.set("clickEvent", new NBTTagCompound());
    				    	json11.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
    				    	clickEvent11.setString("action", "run_command");
    				    	clickEvent11.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEleven") + " " + plugin.getConfig().getString("MuteReasonEleven"));
    				    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
    				    	hoverEvent11.setString("action", "show_text");
    				    	hoverEvent11.set("value", new NBTTagCompound());
    				    	hoverEvent11.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
    				    	hoverValue11.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json12 = new NBTTagCompound();
    				    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwelve"));
    				    	json12.set("clickEvent", new NBTTagCompound());
    				    	json12.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
    				    	clickEvent12.setString("action", "run_command");
    				    	clickEvent12.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwelve") + " " + plugin.getConfig().getString("MuteReasonTwelve"));
    				    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
    				    	hoverEvent12.setString("action", "show_text");
    				    	hoverEvent12.set("value", new NBTTagCompound());
    				    	hoverEvent12.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
    				    	hoverValue12.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json13 = new NBTTagCompound();
    				    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonThirteen"));
    				    	json13.set("clickEvent", new NBTTagCompound());
    				    	json13.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
    				    	clickEvent13.setString("action", "run_command");
    				    	clickEvent13.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationThirteen") + " " + plugin.getConfig().getString("MuteReasonThirteen"));
    				    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
    				    	hoverEvent13.setString("action", "show_text");
    				    	hoverEvent13.set("value", new NBTTagCompound());
    				    	hoverEvent13.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
    				    	hoverValue13.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json14 = new NBTTagCompound();
    				    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFourteen"));
    				    	json14.set("clickEvent", new NBTTagCompound());
    				    	json14.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
    				    	clickEvent14.setString("action", "run_command");
    				    	clickEvent14.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFourteen") + " " + plugin.getConfig().getString("MuteReasonFourteen"));
    				    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
    				    	hoverEvent14.setString("action", "show_text");
    				    	hoverEvent14.set("value", new NBTTagCompound());
    				    	hoverEvent14.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
    				    	hoverValue14.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json15 = new NBTTagCompound();
    				    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonFifteen"));
    				    	json15.set("clickEvent", new NBTTagCompound());
    				    	json15.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
    				    	clickEvent15.setString("action", "run_command");
    				    	clickEvent15.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationFifteen") + " " + plugin.getConfig().getString("MuteReasonFifteen"));
    				    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
    				    	hoverEvent15.setString("action", "show_text");
    				    	hoverEvent15.set("value", new NBTTagCompound());
    				    	hoverEvent15.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
    				    	hoverValue15.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json16 = new NBTTagCompound();
    				    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSixteen"));
    				    	json10.set("clickEvent", new NBTTagCompound());
    				    	json10.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
    				    	clickEvent16.setString("action", "run_command");
    				    	clickEvent16.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSixteen") + " " + plugin.getConfig().getString("MuteReasonSixteen"));
    				    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
    				    	hoverEvent16.setString("action", "show_text");
    				    	hoverEvent16.set("value", new NBTTagCompound());
    				    	hoverEvent16.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
    				    	hoverValue16.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json17 = new NBTTagCompound();
    				    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonSeventeen"));
    				    	json17.set("clickEvent", new NBTTagCompound());
    				    	json17.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
    				    	clickEvent17.setString("action", "run_command");
    				    	clickEvent17.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationSeventeen") + " " + plugin.getConfig().getString("MuteReasonSeventeen"));
    				    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
    				    	hoverEvent17.setString("action", "show_text");
    				    	hoverEvent17.set("value", new NBTTagCompound());
    				    	hoverEvent17.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
    				    	hoverValue17.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json18 = new NBTTagCompound();
    				    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonEighteen"));
    				    	json18.set("clickEvent", new NBTTagCompound());
    				    	json18.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
    				    	clickEvent18.setString("action", "run_command");
    				    	clickEvent18.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationEighteen") + " " + plugin.getConfig().getString("MuteReasonEighteen"));
    				    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
    				    	hoverEvent18.setString("action", "show_text");
    				    	hoverEvent18.set("value", new NBTTagCompound());
    				    	hoverEvent18.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
    				    	hoverValue18.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json19 = new NBTTagCompound();
    				    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonNinteen"));
    				    	json19.set("clickEvent", new NBTTagCompound());
    				    	json19.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
    				    	clickEvent19.setString("action", "run_command");
    				    	clickEvent19.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationNinteen") + " " + plugin.getConfig().getString("MuteReasonNinteen"));
    				    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
    				    	hoverEvent19.setString("action", "show_text");
    				    	hoverEvent19.set("value", new NBTTagCompound());
    				    	hoverEvent19.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
    				    	hoverValue19.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	NBTTagCompound json20 = new NBTTagCompound();
    				    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("MuteReasonTwenty"));
    				    	json20.set("clickEvent", new NBTTagCompound());
    				    	json20.set("hoverEvent", new NBTTagCompound());
    				
    				    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
    				    	clickEvent20.setString("action", "run_command");
    				    	clickEvent20.setString("value", "/mute " + player1.getName().toString() + " " + plugin.getConfig().getString("MuteDurationTwenty") + " " + plugin.getConfig().getString("MuteReasonTwenty"));
    				    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
    				    	hoverEvent20.setString("action", "show_text");
    				    	hoverEvent20.set("value", new NBTTagCompound());
    				    	hoverEvent20.setString("insertion", "what is this?");
    				    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
    				    	hoverValue20.setString("text", "Click this to mute " + player1.getName().toString());
    				
    				    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
    				    	
    				    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
    				
    				    	tag.set("pages", pages);
    				    	book.setTag(tag);
    				    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
    				    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
    				    	entityHuman.openBook(book);
    				    	p.setItemInHand(hand);
    				    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
    	            	}
	            	} else {
	        			if (args[1].equalsIgnoreCase("ban")) { 
    		            	Player player = Bukkit.getPlayer(args[0]);
    		            	if (player != null) {
    					    	HumanEntity humanEntity = (HumanEntity) p;
    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
    					
    					    	ItemStack book = new ItemStack(Item.getById(387));
    					    	NBTTagCompound tag = new NBTTagCompound();
    					    	tag.setString("author", "ItsKazos");
    					    	tag.setString("title", "Hi");
    					    	tag.set("display", new NBTTagCompound());
    					
    					    	NBTTagCompound display = tag.getCompound("display");
    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
    					    	NBTTagList lore = new NBTTagList();
    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
    					    	display.set("Lore", lore);
    					    	NBTTagList pages = new NBTTagList();
    					
    					    	NBTTagCompound paneltitle = new NBTTagCompound();
    					    	paneltitle.setString("text", "Select a punishemnt!\n");
    					
    					    	NBTTagCompound json = new NBTTagCompound();
    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonOne"));
    					    	json.set("clickEvent", new NBTTagCompound());
    					    	json.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
    					    	clickEvent.setString("action", "run_command");
    					    	clickEvent.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationOne") + " " + plugin.getConfig().getString("BanReasonOne"));
    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
    					    	hoverEvent.setString("action", "show_text");
    					    	hoverEvent.set("value", new NBTTagCompound());
    					    	hoverEvent.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
    					    	hoverValue.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json2 = new NBTTagCompound();
    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwo"));
    					    	json2.set("clickEvent", new NBTTagCompound());
    					    	json2.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
    					    	clickEvent2.setString("action", "run_command");
    					    	clickEvent2.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwo") + " " + plugin.getConfig().getString("BanReasonTwo"));
    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
    					    	hoverEvent2.setString("action", "show_text");
    					    	hoverEvent2.set("value", new NBTTagCompound());
    					    	hoverEvent2.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
    					    	hoverValue2.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json3 = new NBTTagCompound();
    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonThree"));
    					    	json3.set("clickEvent", new NBTTagCompound());
    					    	json3.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
    					    	clickEvent3.setString("action", "run_command");
    					    	clickEvent3.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationThree") + " " + plugin.getConfig().getString("BanReasonThree"));
    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
    					    	hoverEvent3.setString("action", "show_text");
    					    	hoverEvent3.set("value", new NBTTagCompound());
    					    	hoverEvent3.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
    					    	hoverValue3.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json4 = new NBTTagCompound();
    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFour"));
    					    	json4.set("clickEvent", new NBTTagCompound());
    					    	json4.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
    					    	clickEvent4.setString("action", "run_command");
    					    	clickEvent4.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationFour") + " " + plugin.getConfig().getString("BanReasonFour"));
    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
    					    	hoverEvent4.setString("action", "show_text");
    					    	hoverEvent4.set("value", new NBTTagCompound());
    					    	hoverEvent4.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
    					    	hoverValue4.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json5 = new NBTTagCompound();
    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFive"));
    					    	json5.set("clickEvent", new NBTTagCompound());
    					    	json5.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
    					    	clickEvent5.setString("action", "run_command");
    					    	clickEvent5.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationFive") + " " + plugin.getConfig().getString("BanReasonFive"));
    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
    					    	hoverEvent5.setString("action", "show_text");
    					    	hoverEvent5.set("value", new NBTTagCompound());
    					    	hoverEvent5.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
    					    	hoverValue5.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json6 = new NBTTagCompound();
    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSix"));
    					    	json6.set("clickEvent", new NBTTagCompound());
    					    	json6.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
    					    	clickEvent6.setString("action", "run_command");
    					    	clickEvent6.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationSix") + " " + plugin.getConfig().getString("BanReasonSix"));
    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
    					    	hoverEvent6.setString("action", "show_text");
    					    	hoverEvent6.set("value", new NBTTagCompound());
    					    	hoverEvent6.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
    					    	hoverValue6.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json7 = new NBTTagCompound();
    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSeven"));
    					    	json7.set("clickEvent", new NBTTagCompound());
    					    	json7.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
    					    	clickEvent7.setString("action", "run_command");
    					    	clickEvent7.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationSeven") + " " + plugin.getConfig().getString("BanReasonSeven"));
    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
    					    	hoverEvent7.setString("action", "show_text");
    					    	hoverEvent7.set("value", new NBTTagCompound());
    					    	hoverEvent7.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
    					    	hoverValue7.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json8 = new NBTTagCompound();
    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEight"));
    					    	json8.set("clickEvent", new NBTTagCompound());
    					    	json8.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
    					    	clickEvent8.setString("action", "run_command");
    					    	clickEvent8.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationEight") + " " + plugin.getConfig().getString("BanReasonEight"));
    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
    					    	hoverEvent8.setString("action", "show_text");
    					    	hoverEvent8.set("value", new NBTTagCompound());
    					    	hoverEvent8.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
    					    	hoverValue8.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json9 = new NBTTagCompound();
    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonNine"));
    					    	json9.set("clickEvent", new NBTTagCompound());
    					    	json9.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
    					    	clickEvent9.setString("action", "run_command");
    					    	clickEvent9.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationNine") + " " + plugin.getConfig().getString("BanReasonNine"));
    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
    					    	hoverEvent9.setString("action", "show_text");
    					    	hoverEvent9.set("value", new NBTTagCompound());
    					    	hoverEvent9.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
    					    	hoverValue9.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json10 = new NBTTagCompound();
    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTen"));
    					    	json10.set("clickEvent", new NBTTagCompound());
    					    	json10.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
    					    	clickEvent10.setString("action", "run_command");
    					    	clickEvent10.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationTen") + " " + plugin.getConfig().getString("BanReasonTen"));
    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
    					    	hoverEvent10.setString("action", "show_text");
    					    	hoverEvent10.set("value", new NBTTagCompound());
    					    	hoverEvent10.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
    					    	hoverValue10.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json11 = new NBTTagCompound();
    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEleven"));
    					    	json11.set("clickEvent", new NBTTagCompound());
    					    	json11.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
    					    	clickEvent11.setString("action", "run_command");
    					    	clickEvent11.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationEleven") + " " + plugin.getConfig().getString("BanReasonEleven"));
    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
    					    	hoverEvent11.setString("action", "show_text");
    					    	hoverEvent11.set("value", new NBTTagCompound());
    					    	hoverEvent11.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
    					    	hoverValue11.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json12 = new NBTTagCompound();
    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwelve"));
    					    	json12.set("clickEvent", new NBTTagCompound());
    					    	json12.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
    					    	clickEvent12.setString("action", "run_command");
    					    	clickEvent12.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwelve") + " " + plugin.getConfig().getString("BanReasonTwelve"));
    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
    					    	hoverEvent12.setString("action", "show_text");
    					    	hoverEvent12.set("value", new NBTTagCompound());
    					    	hoverEvent12.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
    					    	hoverValue12.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json13 = new NBTTagCompound();
    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonThirteen"));
    					    	json13.set("clickEvent", new NBTTagCompound());
    					    	json13.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
    					    	clickEvent13.setString("action", "run_command");
    					    	clickEvent13.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationThirteen") + " " + plugin.getConfig().getString("BanReasonThirteen"));
    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
    					    	hoverEvent13.setString("action", "show_text");
    					    	hoverEvent13.set("value", new NBTTagCompound());
    					    	hoverEvent13.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
    					    	hoverValue13.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json14 = new NBTTagCompound();
    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFourteen"));
    					    	json14.set("clickEvent", new NBTTagCompound());
    					    	json14.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
    					    	clickEvent14.setString("action", "run_command");
    					    	clickEvent14.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationFourteen") + " " + plugin.getConfig().getString("BanReasonFourteen"));
    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
    					    	hoverEvent14.setString("action", "show_text");
    					    	hoverEvent14.set("value", new NBTTagCompound());
    					    	hoverEvent14.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
    					    	hoverValue14.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json15 = new NBTTagCompound();
    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFifteen"));
    					    	json15.set("clickEvent", new NBTTagCompound());
    					    	json15.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
    					    	clickEvent15.setString("action", "run_command");
    					    	clickEvent15.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationFifteen") + " " + plugin.getConfig().getString("BanReasonFifteen"));
    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
    					    	hoverEvent15.setString("action", "show_text");
    					    	hoverEvent15.set("value", new NBTTagCompound());
    					    	hoverEvent15.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
    					    	hoverValue15.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json16 = new NBTTagCompound();
    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSixteen"));
    					    	json10.set("clickEvent", new NBTTagCompound());
    					    	json10.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
    					    	clickEvent16.setString("action", "run_command");
    					    	clickEvent16.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationSixteen") + " " + plugin.getConfig().getString("BanReasonSixteen"));
    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
    					    	hoverEvent16.setString("action", "show_text");
    					    	hoverEvent16.set("value", new NBTTagCompound());
    					    	hoverEvent16.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
    					    	hoverValue16.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json17 = new NBTTagCompound();
    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSeventeen"));
    					    	json17.set("clickEvent", new NBTTagCompound());
    					    	json17.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
    					    	clickEvent17.setString("action", "run_command");
    					    	clickEvent17.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationSeventeen") + " " + plugin.getConfig().getString("BanReasonSeventeen"));
    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
    					    	hoverEvent17.setString("action", "show_text");
    					    	hoverEvent17.set("value", new NBTTagCompound());
    					    	hoverEvent17.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
    					    	hoverValue17.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json18 = new NBTTagCompound();
    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEighteen"));
    					    	json18.set("clickEvent", new NBTTagCompound());
    					    	json18.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
    					    	clickEvent18.setString("action", "run_command");
    					    	clickEvent18.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationEighteen") + " " + plugin.getConfig().getString("BanReasonEighteen"));
    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
    					    	hoverEvent18.setString("action", "show_text");
    					    	hoverEvent18.set("value", new NBTTagCompound());
    					    	hoverEvent18.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
    					    	hoverValue18.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json19 = new NBTTagCompound();
    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonNinteen"));
    					    	json19.set("clickEvent", new NBTTagCompound());
    					    	json19.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
    					    	clickEvent19.setString("action", "run_command");
    					    	clickEvent19.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationNinteen") + " " + plugin.getConfig().getString("BanReasonNinteen"));
    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
    					    	hoverEvent19.setString("action", "show_text");
    					    	hoverEvent19.set("value", new NBTTagCompound());
    					    	hoverEvent19.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
    					    	hoverValue19.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	NBTTagCompound json20 = new NBTTagCompound();
    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwenty"));
    					    	json20.set("clickEvent", new NBTTagCompound());
    					    	json20.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
    					    	clickEvent20.setString("action", "run_command");
    					    	clickEvent20.setString("value", "/ban " + player.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwenty") + " " + plugin.getConfig().getString("BanReasonTwenty"));
    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
    					    	hoverEvent20.setString("action", "show_text");
    					    	hoverEvent20.set("value", new NBTTagCompound());
    					    	hoverEvent20.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
    					    	hoverValue20.setString("text", "Click this to ban " + player.getName().toString());
    					
    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
    					    	
    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
    					
    					    	tag.set("pages", pages);
    					    	book.setTag(tag);
    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
    					    	entityHuman.openBook(book);
    					    	p.setItemInHand(hand);
    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
    		            	} else {
    		                	OfflinePlayer player1 = Bukkit.getOfflinePlayer(args[0]);
    					    	HumanEntity humanEntity = (HumanEntity) p;
    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
    					
    					    	ItemStack book = new ItemStack(Item.getById(387));
    					    	NBTTagCompound tag = new NBTTagCompound();
    					    	tag.setString("author", "ItsKazos");
    					    	tag.setString("title", "Hi");
    					    	tag.set("display", new NBTTagCompound());
    					
    					    	NBTTagCompound display = tag.getCompound("display");
    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
    					    	NBTTagList lore = new NBTTagList();
    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
    					    	display.set("Lore", lore);
    					    	NBTTagList pages = new NBTTagList();
    					
    					    	NBTTagCompound paneltitle = new NBTTagCompound();
    					    	paneltitle.setString("text", "Select a punishemnt!\n");
    					
    					    	NBTTagCompound json = new NBTTagCompound();
    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonOne"));
    					    	json.set("clickEvent", new NBTTagCompound());
    					    	json.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
    					    	clickEvent.setString("action", "run_command");
    					    	clickEvent.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationOne") + " " + plugin.getConfig().getString("BanReasonOne"));
    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
    					    	hoverEvent.setString("action", "show_text");
    					    	hoverEvent.set("value", new NBTTagCompound());
    					    	hoverEvent.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
    					    	hoverValue.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json2 = new NBTTagCompound();
    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwo"));
    					    	json2.set("clickEvent", new NBTTagCompound());
    					    	json2.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
    					    	clickEvent2.setString("action", "run_command");
    					    	clickEvent2.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwo") + " " + plugin.getConfig().getString("BanReasonTwo"));
    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
    					    	hoverEvent2.setString("action", "show_text");
    					    	hoverEvent2.set("value", new NBTTagCompound());
    					    	hoverEvent2.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
    					    	hoverValue2.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json3 = new NBTTagCompound();
    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonThree"));
    					    	json3.set("clickEvent", new NBTTagCompound());
    					    	json3.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
    					    	clickEvent3.setString("action", "run_command");
    					    	clickEvent3.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationThree") + " " + plugin.getConfig().getString("BanReasonThree"));
    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
    					    	hoverEvent3.setString("action", "show_text");
    					    	hoverEvent3.set("value", new NBTTagCompound());
    					    	hoverEvent3.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
    					    	hoverValue3.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json4 = new NBTTagCompound();
    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFour"));
    					    	json4.set("clickEvent", new NBTTagCompound());
    					    	json4.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
    					    	clickEvent4.setString("action", "run_command");
    					    	clickEvent4.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationFour") + " " + plugin.getConfig().getString("BanReasonFour"));
    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
    					    	hoverEvent4.setString("action", "show_text");
    					    	hoverEvent4.set("value", new NBTTagCompound());
    					    	hoverEvent4.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
    					    	hoverValue4.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json5 = new NBTTagCompound();
    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFive"));
    					    	json5.set("clickEvent", new NBTTagCompound());
    					    	json5.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
    					    	clickEvent5.setString("action", "run_command");
    					    	clickEvent5.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationFive") + " " + plugin.getConfig().getString("BanReasonFive"));
    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
    					    	hoverEvent5.setString("action", "show_text");
    					    	hoverEvent5.set("value", new NBTTagCompound());
    					    	hoverEvent5.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
    					    	hoverValue5.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json6 = new NBTTagCompound();
    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSix"));
    					    	json6.set("clickEvent", new NBTTagCompound());
    					    	json6.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
    					    	clickEvent6.setString("action", "run_command");
    					    	clickEvent6.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationSix") + " " + plugin.getConfig().getString("BanReasonSix"));
    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
    					    	hoverEvent6.setString("action", "show_text");
    					    	hoverEvent6.set("value", new NBTTagCompound());
    					    	hoverEvent6.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
    					    	hoverValue6.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json7 = new NBTTagCompound();
    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSeven"));
    					    	json7.set("clickEvent", new NBTTagCompound());
    					    	json7.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
    					    	clickEvent7.setString("action", "run_command");
    					    	clickEvent7.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationSeven") + " " + plugin.getConfig().getString("BanReasonSeven"));
    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
    					    	hoverEvent7.setString("action", "show_text");
    					    	hoverEvent7.set("value", new NBTTagCompound());
    					    	hoverEvent7.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
    					    	hoverValue7.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json8 = new NBTTagCompound();
    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEight"));
    					    	json8.set("clickEvent", new NBTTagCompound());
    					    	json8.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
    					    	clickEvent8.setString("action", "run_command");
    					    	clickEvent8.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationEight") + " " + plugin.getConfig().getString("BanReasonEight"));
    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
    					    	hoverEvent8.setString("action", "show_text");
    					    	hoverEvent8.set("value", new NBTTagCompound());
    					    	hoverEvent8.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
    					    	hoverValue8.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json9 = new NBTTagCompound();
    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonNine"));
    					    	json9.set("clickEvent", new NBTTagCompound());
    					    	json9.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
    					    	clickEvent9.setString("action", "run_command");
    					    	clickEvent9.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationNine") + " " + plugin.getConfig().getString("BanReasonNine"));
    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
    					    	hoverEvent9.setString("action", "show_text");
    					    	hoverEvent9.set("value", new NBTTagCompound());
    					    	hoverEvent9.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
    					    	hoverValue9.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json10 = new NBTTagCompound();
    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTen"));
    					    	json10.set("clickEvent", new NBTTagCompound());
    					    	json10.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
    					    	clickEvent10.setString("action", "run_command");
    					    	clickEvent10.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationTen") + " " + plugin.getConfig().getString("BanReasonTen"));
    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
    					    	hoverEvent10.setString("action", "show_text");
    					    	hoverEvent10.set("value", new NBTTagCompound());
    					    	hoverEvent10.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
    					    	hoverValue10.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json11 = new NBTTagCompound();
    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEleven"));
    					    	json11.set("clickEvent", new NBTTagCompound());
    					    	json11.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
    					    	clickEvent11.setString("action", "run_command");
    					    	clickEvent11.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationEleven") + " " + plugin.getConfig().getString("BanReasonEleven"));
    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
    					    	hoverEvent11.setString("action", "show_text");
    					    	hoverEvent11.set("value", new NBTTagCompound());
    					    	hoverEvent11.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
    					    	hoverValue11.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json12 = new NBTTagCompound();
    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwelve"));
    					    	json12.set("clickEvent", new NBTTagCompound());
    					    	json12.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
    					    	clickEvent12.setString("action", "run_command");
    					    	clickEvent12.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwelve") + " " + plugin.getConfig().getString("BanReasonTwelve"));
    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
    					    	hoverEvent12.setString("action", "show_text");
    					    	hoverEvent12.set("value", new NBTTagCompound());
    					    	hoverEvent12.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
    					    	hoverValue12.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json13 = new NBTTagCompound();
    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonThirteen"));
    					    	json13.set("clickEvent", new NBTTagCompound());
    					    	json13.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
    					    	clickEvent13.setString("action", "run_command");
    					    	clickEvent13.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationThirteen") + " " + plugin.getConfig().getString("BanReasonThirteen"));
    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
    					    	hoverEvent13.setString("action", "show_text");
    					    	hoverEvent13.set("value", new NBTTagCompound());
    					    	hoverEvent13.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
    					    	hoverValue13.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json14 = new NBTTagCompound();
    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFourteen"));
    					    	json14.set("clickEvent", new NBTTagCompound());
    					    	json14.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
    					    	clickEvent14.setString("action", "run_command");
    					    	clickEvent14.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationFourteen") + " " + plugin.getConfig().getString("BanReasonFourteen"));
    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
    					    	hoverEvent14.setString("action", "show_text");
    					    	hoverEvent14.set("value", new NBTTagCompound());
    					    	hoverEvent14.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
    					    	hoverValue14.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json15 = new NBTTagCompound();
    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonFifteen"));
    					    	json15.set("clickEvent", new NBTTagCompound());
    					    	json15.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
    					    	clickEvent15.setString("action", "run_command");
    					    	clickEvent15.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationFifteen") + " " + plugin.getConfig().getString("BanReasonFifteen"));
    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
    					    	hoverEvent15.setString("action", "show_text");
    					    	hoverEvent15.set("value", new NBTTagCompound());
    					    	hoverEvent15.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
    					    	hoverValue15.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json16 = new NBTTagCompound();
    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSixteen"));
    					    	json10.set("clickEvent", new NBTTagCompound());
    					    	json10.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
    					    	clickEvent16.setString("action", "run_command");
    					    	clickEvent16.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationSixteen") + " " + plugin.getConfig().getString("BanReasonSixteen"));
    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
    					    	hoverEvent16.setString("action", "show_text");
    					    	hoverEvent16.set("value", new NBTTagCompound());
    					    	hoverEvent16.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
    					    	hoverValue16.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json17 = new NBTTagCompound();
    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonSeventeen"));
    					    	json17.set("clickEvent", new NBTTagCompound());
    					    	json17.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
    					    	clickEvent17.setString("action", "run_command");
    					    	clickEvent17.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationSeventeen") + " " + plugin.getConfig().getString("BanReasonSeventeen"));
    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
    					    	hoverEvent17.setString("action", "show_text");
    					    	hoverEvent17.set("value", new NBTTagCompound());
    					    	hoverEvent17.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
    					    	hoverValue17.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json18 = new NBTTagCompound();
    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonEighteen"));
    					    	json18.set("clickEvent", new NBTTagCompound());
    					    	json18.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
    					    	clickEvent18.setString("action", "run_command");
    					    	clickEvent18.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationEighteen") + " " + plugin.getConfig().getString("BanReasonEighteen"));
    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
    					    	hoverEvent18.setString("action", "show_text");
    					    	hoverEvent18.set("value", new NBTTagCompound());
    					    	hoverEvent18.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
    					    	hoverValue18.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json19 = new NBTTagCompound();
    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonNinteen"));
    					    	json19.set("clickEvent", new NBTTagCompound());
    					    	json19.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
    					    	clickEvent19.setString("action", "run_command");
    					    	clickEvent19.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationNinteen") + " " + plugin.getConfig().getString("BanReasonNinteen"));
    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
    					    	hoverEvent19.setString("action", "show_text");
    					    	hoverEvent19.set("value", new NBTTagCompound());
    					    	hoverEvent19.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
    					    	hoverValue19.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	NBTTagCompound json20 = new NBTTagCompound();
    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("BanReasonTwenty"));
    					    	json20.set("clickEvent", new NBTTagCompound());
    					    	json20.set("hoverEvent", new NBTTagCompound());
    					
    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
    					    	clickEvent20.setString("action", "run_command");
    					    	clickEvent20.setString("value", "/ban " + player1.getName().toString() + " " + plugin.getConfig().getString("BanDurationTwenty") + " " + plugin.getConfig().getString("BanReasonTwenty"));
    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
    					    	hoverEvent20.setString("action", "show_text");
    					    	hoverEvent20.set("value", new NBTTagCompound());
    					    	hoverEvent20.setString("insertion", "what is this?");
    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
    					    	hoverValue20.setString("text", "Click this to ban " + player1.getName().toString());
    					
    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
    					    	
    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
    					
    					    	tag.set("pages", pages);
    					    	book.setTag(tag);
    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
    					    	entityHuman.openBook(book);
    					    	p.setItemInHand(hand);
    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
    		            	}
    	            	} else {
		        			if (args[1].equalsIgnoreCase("warn")) { 
	    		            	Player player = Bukkit.getPlayer(args[0]);
	    		            	if (player != null) {
	    					    	HumanEntity humanEntity = (HumanEntity) p;
	    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
	    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
	    					
	    					    	ItemStack book = new ItemStack(Item.getById(387));
	    					    	NBTTagCompound tag = new NBTTagCompound();
	    					    	tag.setString("author", "ItsKazos");
	    					    	tag.setString("title", "Hi");
	    					    	tag.set("display", new NBTTagCompound());
	    					
	    					    	NBTTagCompound display = tag.getCompound("display");
	    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
	    					    	NBTTagList lore = new NBTTagList();
	    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
	    					    	display.set("Lore", lore);
	    					    	NBTTagList pages = new NBTTagList();
	    					
	    					    	NBTTagCompound paneltitle = new NBTTagCompound();
	    					    	paneltitle.setString("text", "Select a punishemnt!\n");
	    					
	    					    	NBTTagCompound json = new NBTTagCompound();
	    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonOne"));
	    					    	json.set("clickEvent", new NBTTagCompound());
	    					    	json.set("hoverEvent", new NBTTagCompound());

	    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
	    					    	clickEvent.setString("action", "run_command");
	    					    	clickEvent.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationOne") + " " + plugin.getConfig().getString("WarnReasonOne"));
	    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
	    					    	hoverEvent.setString("action", "show_text");
	    					    	hoverEvent.set("value", new NBTTagCompound());
	    					    	hoverEvent.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
	    					    	hoverValue.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json2 = new NBTTagCompound();
	    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwo"));
	    					    	json2.set("clickEvent", new NBTTagCompound());
	    					    	json2.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
	    					    	clickEvent2.setString("action", "run_command");
	    					    	clickEvent2.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwo") + " " + plugin.getConfig().getString("WarnReasonTwo"));
	    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
	    					    	hoverEvent2.setString("action", "show_text");
	    					    	hoverEvent2.set("value", new NBTTagCompound());
	    					    	hoverEvent2.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
	    					    	hoverValue2.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json3 = new NBTTagCompound();
	    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonThree"));
	    					    	json3.set("clickEvent", new NBTTagCompound());
	    					    	json3.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
	    					    	clickEvent3.setString("action", "run_command");
	    					    	clickEvent3.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationThree") + " " + plugin.getConfig().getString("WarnReasonThree"));
	    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
	    					    	hoverEvent3.setString("action", "show_text");
	    					    	hoverEvent3.set("value", new NBTTagCompound());
	    					    	hoverEvent3.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
	    					    	hoverValue3.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json4 = new NBTTagCompound();
	    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFour"));
	    					    	json4.set("clickEvent", new NBTTagCompound());
	    					    	json4.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
	    					    	clickEvent4.setString("action", "run_command");
	    					    	clickEvent4.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFour") + " " + plugin.getConfig().getString("WarnReasonFour"));
	    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
	    					    	hoverEvent4.setString("action", "show_text");
	    					    	hoverEvent4.set("value", new NBTTagCompound());
	    					    	hoverEvent4.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
	    					    	hoverValue4.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json5 = new NBTTagCompound();
	    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFive"));
	    					    	json5.set("clickEvent", new NBTTagCompound());
	    					    	json5.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
	    					    	clickEvent5.setString("action", "run_command");
	    					    	clickEvent5.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFive") + " " + plugin.getConfig().getString("WarnReasonFive"));
	    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
	    					    	hoverEvent5.setString("action", "show_text");
	    					    	hoverEvent5.set("value", new NBTTagCompound());
	    					    	hoverEvent5.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
	    					    	hoverValue5.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json6 = new NBTTagCompound();
	    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSix"));
	    					    	json6.set("clickEvent", new NBTTagCompound());
	    					    	json6.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
	    					    	clickEvent6.setString("action", "run_command");
	    					    	clickEvent6.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSix") + " " + plugin.getConfig().getString("WarnReasonSix"));
	    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
	    					    	hoverEvent6.setString("action", "show_text");
	    					    	hoverEvent6.set("value", new NBTTagCompound());
	    					    	hoverEvent6.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
	    					    	hoverValue6.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json7 = new NBTTagCompound();
	    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSeven"));
	    					    	json7.set("clickEvent", new NBTTagCompound());
	    					    	json7.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
	    					    	clickEvent7.setString("action", "run_command");
	    					    	clickEvent7.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSeven") + " " + plugin.getConfig().getString("WarnReasonSeven"));
	    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
	    					    	hoverEvent7.setString("action", "show_text");
	    					    	hoverEvent7.set("value", new NBTTagCompound());
	    					    	hoverEvent7.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
	    					    	hoverValue7.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json8 = new NBTTagCompound();
	    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEight"));
	    					    	json8.set("clickEvent", new NBTTagCompound());
	    					    	json8.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
	    					    	clickEvent8.setString("action", "run_command");
	    					    	clickEvent8.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEight") + " " + plugin.getConfig().getString("WarnReasonEight"));
	    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
	    					    	hoverEvent8.setString("action", "show_text");
	    					    	hoverEvent8.set("value", new NBTTagCompound());
	    					    	hoverEvent8.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
	    					    	hoverValue8.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json9 = new NBTTagCompound();
	    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonNine"));
	    					    	json9.set("clickEvent", new NBTTagCompound());
	    					    	json9.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
	    					    	clickEvent9.setString("action", "run_command");
	    					    	clickEvent9.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationNine") + " " + plugin.getConfig().getString("WarnReasonNine"));
	    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
	    					    	hoverEvent9.setString("action", "show_text");
	    					    	hoverEvent9.set("value", new NBTTagCompound());
	    					    	hoverEvent9.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
	    					    	hoverValue9.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json10 = new NBTTagCompound();
	    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTen"));
	    					    	json10.set("clickEvent", new NBTTagCompound());
	    					    	json10.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
	    					    	clickEvent10.setString("action", "run_command");
	    					    	clickEvent10.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTen") + " " + plugin.getConfig().getString("WarnReasonTen"));
	    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
	    					    	hoverEvent10.setString("action", "show_text");
	    					    	hoverEvent10.set("value", new NBTTagCompound());
	    					    	hoverEvent10.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
	    					    	hoverValue10.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json11 = new NBTTagCompound();
	    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEleven"));
	    					    	json11.set("clickEvent", new NBTTagCompound());
	    					    	json11.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
	    					    	clickEvent11.setString("action", "run_command");
	    					    	clickEvent11.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEleven") + " " + plugin.getConfig().getString("WarnReasonEleven"));
	    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
	    					    	hoverEvent11.setString("action", "show_text");
	    					    	hoverEvent11.set("value", new NBTTagCompound());
	    					    	hoverEvent11.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
	    					    	hoverValue11.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json12 = new NBTTagCompound();
	    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwelve"));
	    					    	json12.set("clickEvent", new NBTTagCompound());
	    					    	json12.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
	    					    	clickEvent12.setString("action", "run_command");
	    					    	clickEvent12.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwelve") + " " + plugin.getConfig().getString("WarnReasonTwelve"));
	    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
	    					    	hoverEvent12.setString("action", "show_text");
	    					    	hoverEvent12.set("value", new NBTTagCompound());
	    					    	hoverEvent12.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
	    					    	hoverValue12.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json13 = new NBTTagCompound();
	    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonThirteen"));
	    					    	json13.set("clickEvent", new NBTTagCompound());
	    					    	json13.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
	    					    	clickEvent13.setString("action", "run_command");
	    					    	clickEvent13.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationThirteen") + " " + plugin.getConfig().getString("WarnReasonThirteen"));
	    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
	    					    	hoverEvent13.setString("action", "show_text");
	    					    	hoverEvent13.set("value", new NBTTagCompound());
	    					    	hoverEvent13.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
	    					    	hoverValue13.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json14 = new NBTTagCompound();
	    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFourteen"));
	    					    	json14.set("clickEvent", new NBTTagCompound());
	    					    	json14.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
	    					    	clickEvent14.setString("action", "run_command");
	    					    	clickEvent14.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFourteen") + " " + plugin.getConfig().getString("WarnReasonFourteen"));
	    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
	    					    	hoverEvent14.setString("action", "show_text");
	    					    	hoverEvent14.set("value", new NBTTagCompound());
	    					    	hoverEvent14.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
	    					    	hoverValue14.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json15 = new NBTTagCompound();
	    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFifteen"));
	    					    	json15.set("clickEvent", new NBTTagCompound());
	    					    	json15.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
	    					    	clickEvent15.setString("action", "run_command");
	    					    	clickEvent15.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFifteen") + " " + plugin.getConfig().getString("WarnReasonFifteen"));
	    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
	    					    	hoverEvent15.setString("action", "show_text");
	    					    	hoverEvent15.set("value", new NBTTagCompound());
	    					    	hoverEvent15.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
	    					    	hoverValue15.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json16 = new NBTTagCompound();
	    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSixteen"));
	    					    	json10.set("clickEvent", new NBTTagCompound());
	    					    	json10.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
	    					    	clickEvent16.setString("action", "run_command");
	    					    	clickEvent16.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSixteen") + " " + plugin.getConfig().getString("WarnReasonSixteen"));
	    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
	    					    	hoverEvent16.setString("action", "show_text");
	    					    	hoverEvent16.set("value", new NBTTagCompound());
	    					    	hoverEvent16.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
	    					    	hoverValue16.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json17 = new NBTTagCompound();
	    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSeventeen"));
	    					    	json17.set("clickEvent", new NBTTagCompound());
	    					    	json17.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
	    					    	clickEvent17.setString("action", "run_command");
	    					    	clickEvent17.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSeventeen") + " " + plugin.getConfig().getString("WarnReasonSeventeen"));
	    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
	    					    	hoverEvent17.setString("action", "show_text");
	    					    	hoverEvent17.set("value", new NBTTagCompound());
	    					    	hoverEvent17.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
	    					    	hoverValue17.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json18 = new NBTTagCompound();
	    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEighteen"));
	    					    	json18.set("clickEvent", new NBTTagCompound());
	    					    	json18.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
	    					    	clickEvent18.setString("action", "run_command");
	    					    	clickEvent18.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEighteen") + " " + plugin.getConfig().getString("WarnReasonEighteen"));
	    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
	    					    	hoverEvent18.setString("action", "show_text");
	    					    	hoverEvent18.set("value", new NBTTagCompound());
	    					    	hoverEvent18.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
	    					    	hoverValue18.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json19 = new NBTTagCompound();
	    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonNinteen"));
	    					    	json19.set("clickEvent", new NBTTagCompound());
	    					    	json19.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
	    					    	clickEvent19.setString("action", "run_command");
	    					    	clickEvent19.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationNinteen") + " " + plugin.getConfig().getString("WarnReasonNinteen"));
	    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
	    					    	hoverEvent19.setString("action", "show_text");
	    					    	hoverEvent19.set("value", new NBTTagCompound());
	    					    	hoverEvent19.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
	    					    	hoverValue19.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	NBTTagCompound json20 = new NBTTagCompound();
	    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwenty"));
	    					    	json20.set("clickEvent", new NBTTagCompound());
	    					    	json20.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
	    					    	clickEvent20.setString("action", "run_command");
	    					    	clickEvent20.setString("value", "/warn " + player.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwenty") + " " + plugin.getConfig().getString("WarnReasonTwenty"));
	    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
	    					    	hoverEvent20.setString("action", "show_text");
	    					    	hoverEvent20.set("value", new NBTTagCompound());
	    					    	hoverEvent20.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
	    					    	hoverValue20.setString("text", "Click this to warn " + player.getName().toString());
	    					
	    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
	    					    	
	    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
	    					
	    					    	tag.set("pages", pages);
	    					    	book.setTag(tag);
	    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
	    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
	    					    	entityHuman.openBook(book);
	    					    	p.setItemInHand(hand);
	    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
	    		            	} else {
	    		                	OfflinePlayer player1 = Bukkit.getOfflinePlayer(args[0]);
	    					    	HumanEntity humanEntity = (HumanEntity) p;
	    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
	    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
	    					
	    					    	ItemStack book = new ItemStack(Item.getById(387));
	    					    	NBTTagCompound tag = new NBTTagCompound();
	    					    	tag.setString("author", "ItsKazos");
	    					    	tag.setString("title", "Hi");
	    					    	tag.set("display", new NBTTagCompound());
	    					
	    					    	NBTTagCompound display = tag.getCompound("display");
	    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
	    					    	NBTTagList lore = new NBTTagList();
	    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
	    					    	display.set("Lore", lore);
	    					    	NBTTagList pages = new NBTTagList();
	    					
	    					    	NBTTagCompound paneltitle = new NBTTagCompound();
	    					    	paneltitle.setString("text", "Select a punishemnt!\n");
	    					
	    					    	NBTTagCompound json = new NBTTagCompound();
	    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonOne"));
	    					    	json.set("clickEvent", new NBTTagCompound());
	    					    	json.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
	    					    	clickEvent.setString("action", "run_command");
	    					    	clickEvent.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationOne") + " " + plugin.getConfig().getString("WarnReasonOne"));
	    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
	    					    	hoverEvent.setString("action", "show_text");
	    					    	hoverEvent.set("value", new NBTTagCompound());
	    					    	hoverEvent.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
	    					    	hoverValue.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json2 = new NBTTagCompound();
	    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwo"));
	    					    	json2.set("clickEvent", new NBTTagCompound());
	    					    	json2.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
	    					    	clickEvent2.setString("action", "run_command");
	    					    	clickEvent2.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwo") + " " + plugin.getConfig().getString("WarnReasonTwo"));
	    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
	    					    	hoverEvent2.setString("action", "show_text");
	    					    	hoverEvent2.set("value", new NBTTagCompound());
	    					    	hoverEvent2.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
	    					    	hoverValue2.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json3 = new NBTTagCompound();
	    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonThree"));
	    					    	json3.set("clickEvent", new NBTTagCompound());
	    					    	json3.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
	    					    	clickEvent3.setString("action", "run_command");
	    					    	clickEvent3.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationThree") + " " + plugin.getConfig().getString("WarnReasonThree"));
	    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
	    					    	hoverEvent3.setString("action", "show_text");
	    					    	hoverEvent3.set("value", new NBTTagCompound());
	    					    	hoverEvent3.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
	    					    	hoverValue3.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json4 = new NBTTagCompound();
	    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFour"));
	    					    	json4.set("clickEvent", new NBTTagCompound());
	    					    	json4.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
	    					    	clickEvent4.setString("action", "run_command");
	    					    	clickEvent4.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFour") + " " + plugin.getConfig().getString("WarnReasonFour"));
	    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
	    					    	hoverEvent4.setString("action", "show_text");
	    					    	hoverEvent4.set("value", new NBTTagCompound());
	    					    	hoverEvent4.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
	    					    	hoverValue4.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json5 = new NBTTagCompound();
	    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFive"));
	    					    	json5.set("clickEvent", new NBTTagCompound());
	    					    	json5.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
	    					    	clickEvent5.setString("action", "run_command");
	    					    	clickEvent5.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFive") + " " + plugin.getConfig().getString("WarnReasonFive"));
	    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
	    					    	hoverEvent5.setString("action", "show_text");
	    					    	hoverEvent5.set("value", new NBTTagCompound());
	    					    	hoverEvent5.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
	    					    	hoverValue5.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json6 = new NBTTagCompound();
	    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSix"));
	    					    	json6.set("clickEvent", new NBTTagCompound());
	    					    	json6.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
	    					    	clickEvent6.setString("action", "run_command");
	    					    	clickEvent6.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSix") + " " + plugin.getConfig().getString("WarnReasonSix"));
	    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
	    					    	hoverEvent6.setString("action", "show_text");
	    					    	hoverEvent6.set("value", new NBTTagCompound());
	    					    	hoverEvent6.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
	    					    	hoverValue6.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json7 = new NBTTagCompound();
	    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSeven"));
	    					    	json7.set("clickEvent", new NBTTagCompound());
	    					    	json7.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
	    					    	clickEvent7.setString("action", "run_command");
	    					    	clickEvent7.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSeven") + " " + plugin.getConfig().getString("WarnReasonSeven"));
	    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
	    					    	hoverEvent7.setString("action", "show_text");
	    					    	hoverEvent7.set("value", new NBTTagCompound());
	    					    	hoverEvent7.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
	    					    	hoverValue7.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json8 = new NBTTagCompound();
	    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEight"));
	    					    	json8.set("clickEvent", new NBTTagCompound());
	    					    	json8.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
	    					    	clickEvent8.setString("action", "run_command");
	    					    	clickEvent8.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEight") + " " + plugin.getConfig().getString("WarnReasonEight"));
	    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
	    					    	hoverEvent8.setString("action", "show_text");
	    					    	hoverEvent8.set("value", new NBTTagCompound());
	    					    	hoverEvent8.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
	    					    	hoverValue8.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json9 = new NBTTagCompound();
	    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonNine"));
	    					    	json9.set("clickEvent", new NBTTagCompound());
	    					    	json9.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
	    					    	clickEvent9.setString("action", "run_command");
	    					    	clickEvent9.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationNine") + " " + plugin.getConfig().getString("WarnReasonNine"));
	    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
	    					    	hoverEvent9.setString("action", "show_text");
	    					    	hoverEvent9.set("value", new NBTTagCompound());
	    					    	hoverEvent9.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
	    					    	hoverValue9.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json10 = new NBTTagCompound();
	    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTen"));
	    					    	json10.set("clickEvent", new NBTTagCompound());
	    					    	json10.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
	    					    	clickEvent10.setString("action", "run_command");
	    					    	clickEvent10.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTen") + " " + plugin.getConfig().getString("WarnReasonTen"));
	    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
	    					    	hoverEvent10.setString("action", "show_text");
	    					    	hoverEvent10.set("value", new NBTTagCompound());
	    					    	hoverEvent10.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
	    					    	hoverValue10.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json11 = new NBTTagCompound();
	    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEleven"));
	    					    	json11.set("clickEvent", new NBTTagCompound());
	    					    	json11.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
	    					    	clickEvent11.setString("action", "run_command");
	    					    	clickEvent11.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEleven") + " " + plugin.getConfig().getString("WarnReasonEleven"));
	    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
	    					    	hoverEvent11.setString("action", "show_text");
	    					    	hoverEvent11.set("value", new NBTTagCompound());
	    					    	hoverEvent11.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
	    					    	hoverValue11.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json12 = new NBTTagCompound();
	    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwelve"));
	    					    	json12.set("clickEvent", new NBTTagCompound());
	    					    	json12.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
	    					    	clickEvent12.setString("action", "run_command");
	    					    	clickEvent12.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwelve") + " " + plugin.getConfig().getString("WarnReasonTwelve"));
	    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
	    					    	hoverEvent12.setString("action", "show_text");
	    					    	hoverEvent12.set("value", new NBTTagCompound());
	    					    	hoverEvent12.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
	    					    	hoverValue12.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json13 = new NBTTagCompound();
	    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonThirteen"));
	    					    	json13.set("clickEvent", new NBTTagCompound());
	    					    	json13.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
	    					    	clickEvent13.setString("action", "run_command");
	    					    	clickEvent13.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationThirteen") + " " + plugin.getConfig().getString("WarnReasonThirteen"));
	    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
	    					    	hoverEvent13.setString("action", "show_text");
	    					    	hoverEvent13.set("value", new NBTTagCompound());
	    					    	hoverEvent13.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
	    					    	hoverValue13.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json14 = new NBTTagCompound();
	    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFourteen"));
	    					    	json14.set("clickEvent", new NBTTagCompound());
	    					    	json14.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
	    					    	clickEvent14.setString("action", "run_command");
	    					    	clickEvent14.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFourteen") + " " + plugin.getConfig().getString("WarnReasonFourteen"));
	    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
	    					    	hoverEvent14.setString("action", "show_text");
	    					    	hoverEvent14.set("value", new NBTTagCompound());
	    					    	hoverEvent14.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
	    					    	hoverValue14.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json15 = new NBTTagCompound();
	    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonFifteen"));
	    					    	json15.set("clickEvent", new NBTTagCompound());
	    					    	json15.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
	    					    	clickEvent15.setString("action", "run_command");
	    					    	clickEvent15.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationFifteen") + " " + plugin.getConfig().getString("WarnReasonFifteen"));
	    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
	    					    	hoverEvent15.setString("action", "show_text");
	    					    	hoverEvent15.set("value", new NBTTagCompound());
	    					    	hoverEvent15.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
	    					    	hoverValue15.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json16 = new NBTTagCompound();
	    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSixteen"));
	    					    	json10.set("clickEvent", new NBTTagCompound());
	    					    	json10.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
	    					    	clickEvent16.setString("action", "run_command");
	    					    	clickEvent16.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSixteen") + " " + plugin.getConfig().getString("WarnReasonSixteen"));
	    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
	    					    	hoverEvent16.setString("action", "show_text");
	    					    	hoverEvent16.set("value", new NBTTagCompound());
	    					    	hoverEvent16.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
	    					    	hoverValue16.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json17 = new NBTTagCompound();
	    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonSeventeen"));
	    					    	json17.set("clickEvent", new NBTTagCompound());
	    					    	json17.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
	    					    	clickEvent17.setString("action", "run_command");
	    					    	clickEvent17.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationSeventeen") + " " + plugin.getConfig().getString("WarnReasonSeventeen"));
	    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
	    					    	hoverEvent17.setString("action", "show_text");
	    					    	hoverEvent17.set("value", new NBTTagCompound());
	    					    	hoverEvent17.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
	    					    	hoverValue17.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json18 = new NBTTagCompound();
	    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonEighteen"));
	    					    	json18.set("clickEvent", new NBTTagCompound());
	    					    	json18.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
	    					    	clickEvent18.setString("action", "run_command");
	    					    	clickEvent18.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationEighteen") + " " + plugin.getConfig().getString("WarnReasonEighteen"));
	    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
	    					    	hoverEvent18.setString("action", "show_text");
	    					    	hoverEvent18.set("value", new NBTTagCompound());
	    					    	hoverEvent18.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
	    					    	hoverValue18.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json19 = new NBTTagCompound();
	    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonNinteen"));
	    					    	json19.set("clickEvent", new NBTTagCompound());
	    					    	json19.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
	    					    	clickEvent19.setString("action", "run_command");
	    					    	clickEvent19.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationNinteen") + " " + plugin.getConfig().getString("WarnReasonNinteen"));
	    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
	    					    	hoverEvent19.setString("action", "show_text");
	    					    	hoverEvent19.set("value", new NBTTagCompound());
	    					    	hoverEvent19.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
	    					    	hoverValue19.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	NBTTagCompound json20 = new NBTTagCompound();
	    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("WarnReasonTwenty"));
	    					    	json20.set("clickEvent", new NBTTagCompound());
	    					    	json20.set("hoverEvent", new NBTTagCompound());
	    					
	    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
	    					    	clickEvent20.setString("action", "run_command");
	    					    	clickEvent20.setString("value", "/warn " + player1.getName().toString() + " " + plugin.getConfig().getString("WarnDurationTwenty") + " " + plugin.getConfig().getString("WarnReasonTwenty"));
	    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
	    					    	hoverEvent20.setString("action", "show_text");
	    					    	hoverEvent20.set("value", new NBTTagCompound());
	    					    	hoverEvent20.setString("insertion", "what is this?");
	    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
	    					    	hoverValue20.setString("text", "Click this to warn " + player1.getName().toString());
	    					
	    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
	    					    	
	    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
	    					
	    					    	tag.set("pages", pages);
	    					    	book.setTag(tag);
	    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
	    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
	    					    	entityHuman.openBook(book);
	    					    	p.setItemInHand(hand);
	    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
	    		            	}
    		            	} else {
			        			if (args[1].equalsIgnoreCase("kick")) { 
		    		            	Player player = Bukkit.getPlayer(args[0]);
		    		            	if (player != null) {
		    					    	HumanEntity humanEntity = (HumanEntity) p;
		    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
		    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
		    					
		    					    	ItemStack book = new ItemStack(Item.getById(387));
		    					    	NBTTagCompound tag = new NBTTagCompound();
		    					    	tag.setString("author", "ItsKazos");
		    					    	tag.setString("title", "Hi");
		    					    	tag.set("display", new NBTTagCompound());
		    					
		    					    	NBTTagCompound display = tag.getCompound("display");
		    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
		    					    	NBTTagList lore = new NBTTagList();
		    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
		    					    	display.set("Lore", lore);
		    					    	NBTTagList pages = new NBTTagList();
		    					
		    					    	NBTTagCompound paneltitle = new NBTTagCompound();
		    					    	paneltitle.setString("text", "Select a punishemnt!\n");
		    					
		    					    	NBTTagCompound json = new NBTTagCompound();
		    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonOne"));
		    					    	json.set("clickEvent", new NBTTagCompound());
		    					    	json.set("hoverEvent", new NBTTagCompound());
	
		    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
		    					    	clickEvent.setString("action", "run_command");
		    					    	clickEvent.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonOne"));
		    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
		    					    	hoverEvent.setString("action", "show_text");
		    					    	hoverEvent.set("value", new NBTTagCompound());
		    					    	hoverEvent.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
		    					    	hoverValue.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json2 = new NBTTagCompound();
		    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwo"));
		    					    	json2.set("clickEvent", new NBTTagCompound());
		    					    	json2.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
		    					    	clickEvent2.setString("action", "run_command");
		    					    	clickEvent2.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwo"));
		    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
		    					    	hoverEvent2.setString("action", "show_text");
		    					    	hoverEvent2.set("value", new NBTTagCompound());
		    					    	hoverEvent2.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
		    					    	hoverValue2.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json3 = new NBTTagCompound();
		    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonThree"));
		    					    	json3.set("clickEvent", new NBTTagCompound());
		    					    	json3.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
		    					    	clickEvent3.setString("action", "run_command");
		    					    	clickEvent3.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonThree"));
		    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
		    					    	hoverEvent3.setString("action", "show_text");
		    					    	hoverEvent3.set("value", new NBTTagCompound());
		    					    	hoverEvent3.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
		    					    	hoverValue3.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json4 = new NBTTagCompound();
		    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFour"));
		    					    	json4.set("clickEvent", new NBTTagCompound());
		    					    	json4.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
		    					    	clickEvent4.setString("action", "run_command");
		    					    	clickEvent4.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonFour"));
		    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
		    					    	hoverEvent4.setString("action", "show_text");
		    					    	hoverEvent4.set("value", new NBTTagCompound());
		    					    	hoverEvent4.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
		    					    	hoverValue4.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json5 = new NBTTagCompound();
		    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFive"));
		    					    	json5.set("clickEvent", new NBTTagCompound());
		    					    	json5.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
		    					    	clickEvent5.setString("action", "run_command");
		    					    	clickEvent5.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonFive"));
		    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
		    					    	hoverEvent5.setString("action", "show_text");
		    					    	hoverEvent5.set("value", new NBTTagCompound());
		    					    	hoverEvent5.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
		    					    	hoverValue5.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json6 = new NBTTagCompound();
		    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSix"));
		    					    	json6.set("clickEvent", new NBTTagCompound());
		    					    	json6.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
		    					    	clickEvent6.setString("action", "run_command");
		    					    	clickEvent6.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonSix"));
		    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
		    					    	hoverEvent6.setString("action", "show_text");
		    					    	hoverEvent6.set("value", new NBTTagCompound());
		    					    	hoverEvent6.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
		    					    	hoverValue6.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json7 = new NBTTagCompound();
		    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSeven"));
		    					    	json7.set("clickEvent", new NBTTagCompound());
		    					    	json7.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
		    					    	clickEvent7.setString("action", "run_command");
		    					    	clickEvent7.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonSeven"));
		    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
		    					    	hoverEvent7.setString("action", "show_text");
		    					    	hoverEvent7.set("value", new NBTTagCompound());
		    					    	hoverEvent7.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
		    					    	hoverValue7.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json8 = new NBTTagCompound();
		    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEight"));
		    					    	json8.set("clickEvent", new NBTTagCompound());
		    					    	json8.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
		    					    	clickEvent8.setString("action", "run_command");
		    					    	clickEvent8.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonEight"));
		    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
		    					    	hoverEvent8.setString("action", "show_text");
		    					    	hoverEvent8.set("value", new NBTTagCompound());
		    					    	hoverEvent8.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
		    					    	hoverValue8.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json9 = new NBTTagCompound();
		    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonNine"));
		    					    	json9.set("clickEvent", new NBTTagCompound());
		    					    	json9.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
		    					    	clickEvent9.setString("action", "run_command");
		    					    	clickEvent9.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonNine"));
		    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
		    					    	hoverEvent9.setString("action", "show_text");
		    					    	hoverEvent9.set("value", new NBTTagCompound());
		    					    	hoverEvent9.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
		    					    	hoverValue9.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json10 = new NBTTagCompound();
		    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTen"));
		    					    	json10.set("clickEvent", new NBTTagCompound());
		    					    	json10.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
		    					    	clickEvent10.setString("action", "run_command");
		    					    	clickEvent10.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonTen"));
		    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
		    					    	hoverEvent10.setString("action", "show_text");
		    					    	hoverEvent10.set("value", new NBTTagCompound());
		    					    	hoverEvent10.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
		    					    	hoverValue10.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json11 = new NBTTagCompound();
		    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEleven"));
		    					    	json11.set("clickEvent", new NBTTagCompound());
		    					    	json11.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
		    					    	clickEvent11.setString("action", "run_command");
		    					    	clickEvent11.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonEleven"));
		    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
		    					    	hoverEvent11.setString("action", "show_text");
		    					    	hoverEvent11.set("value", new NBTTagCompound());
		    					    	hoverEvent11.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
		    					    	hoverValue11.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json12 = new NBTTagCompound();
		    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwelve"));
		    					    	json12.set("clickEvent", new NBTTagCompound());
		    					    	json12.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
		    					    	clickEvent12.setString("action", "run_command");
		    					    	clickEvent12.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwelve"));
		    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
		    					    	hoverEvent12.setString("action", "show_text");
		    					    	hoverEvent12.set("value", new NBTTagCompound());
		    					    	hoverEvent12.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
		    					    	hoverValue12.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json13 = new NBTTagCompound();
		    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonThirteen"));
		    					    	json13.set("clickEvent", new NBTTagCompound());
		    					    	json13.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
		    					    	clickEvent13.setString("action", "run_command");
		    					    	clickEvent13.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonThirteen"));
		    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
		    					    	hoverEvent13.setString("action", "show_text");
		    					    	hoverEvent13.set("value", new NBTTagCompound());
		    					    	hoverEvent13.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
		    					    	hoverValue13.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json14 = new NBTTagCompound();
		    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFourteen"));
		    					    	json14.set("clickEvent", new NBTTagCompound());
		    					    	json14.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
		    					    	clickEvent14.setString("action", "run_command");
		    					    	clickEvent14.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonFourteen"));
		    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
		    					    	hoverEvent14.setString("action", "show_text");
		    					    	hoverEvent14.set("value", new NBTTagCompound());
		    					    	hoverEvent14.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
		    					    	hoverValue14.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json15 = new NBTTagCompound();
		    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFifteen"));
		    					    	json15.set("clickEvent", new NBTTagCompound());
		    					    	json15.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
		    					    	clickEvent15.setString("action", "run_command");
		    					    	clickEvent15.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonFifteen"));
		    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
		    					    	hoverEvent15.setString("action", "show_text");
		    					    	hoverEvent15.set("value", new NBTTagCompound());
		    					    	hoverEvent15.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
		    					    	hoverValue15.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json16 = new NBTTagCompound();
		    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSixteen"));
		    					    	json10.set("clickEvent", new NBTTagCompound());
		    					    	json10.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
		    					    	clickEvent16.setString("action", "run_command");
		    					    	clickEvent16.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonSixteen"));
		    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
		    					    	hoverEvent16.setString("action", "show_text");
		    					    	hoverEvent16.set("value", new NBTTagCompound());
		    					    	hoverEvent16.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
		    					    	hoverValue16.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json17 = new NBTTagCompound();
		    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSeventeen"));
		    					    	json17.set("clickEvent", new NBTTagCompound());
		    					    	json17.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
		    					    	clickEvent17.setString("action", "run_command");
		    					    	clickEvent17.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonSeventeen"));
		    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
		    					    	hoverEvent17.setString("action", "show_text");
		    					    	hoverEvent17.set("value", new NBTTagCompound());
		    					    	hoverEvent17.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
		    					    	hoverValue17.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json18 = new NBTTagCompound();
		    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEighteen"));
		    					    	json18.set("clickEvent", new NBTTagCompound());
		    					    	json18.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
		    					    	clickEvent18.setString("action", "run_command");
		    					    	clickEvent18.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonEighteen"));
		    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
		    					    	hoverEvent18.setString("action", "show_text");
		    					    	hoverEvent18.set("value", new NBTTagCompound());
		    					    	hoverEvent18.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
		    					    	hoverValue18.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json19 = new NBTTagCompound();
		    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonNinteen"));
		    					    	json19.set("clickEvent", new NBTTagCompound());
		    					    	json19.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
		    					    	clickEvent19.setString("action", "run_command");
		    					    	clickEvent19.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonNinteen"));
		    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
		    					    	hoverEvent19.setString("action", "show_text");
		    					    	hoverEvent19.set("value", new NBTTagCompound());
		    					    	hoverEvent19.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
		    					    	hoverValue19.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	NBTTagCompound json20 = new NBTTagCompound();
		    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwenty"));
		    					    	json20.set("clickEvent", new NBTTagCompound());
		    					    	json20.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
		    					    	clickEvent20.setString("action", "run_command");
		    					    	clickEvent20.setString("value", "/kick " + player.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwenty"));
		    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
		    					    	hoverEvent20.setString("action", "show_text");
		    					    	hoverEvent20.set("value", new NBTTagCompound());
		    					    	hoverEvent20.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
		    					    	hoverValue20.setString("text", "Click this to kick " + player.getName().toString());
		    					
		    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
		    					    	
		    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
		    					
		    					    	tag.set("pages", pages);
		    					    	book.setTag(tag);
		    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
		    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
		    					    	entityHuman.openBook(book);
		    					    	p.setItemInHand(hand);
		    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
		    		            	} else {
		    		                	OfflinePlayer player1 = Bukkit.getOfflinePlayer(args[0]);
		    					    	HumanEntity humanEntity = (HumanEntity) p;
		    					    	CraftHumanEntity craftHumanityEntity = (CraftHumanEntity) humanEntity;
		    					    	EntityHuman entityHuman = craftHumanityEntity.getHandle();
		    					
		    					    	ItemStack book = new ItemStack(Item.getById(387));
		    					    	NBTTagCompound tag = new NBTTagCompound();
		    					    	tag.setString("author", "ItsKazos");
		    					    	tag.setString("title", "Hi");
		    					    	tag.set("display", new NBTTagCompound());
		    					
		    					    	NBTTagCompound display = tag.getCompound("display");
		    					    	display.setString("Name", ChatColor.translateAlternateColorCodes('&', "Book GUI"));
		    					    	NBTTagList lore = new NBTTagList();
		    					    	lore.add(new NBTTagString("If you see this, please report it to an admin!"));
		    					    	display.set("Lore", lore);
		    					    	NBTTagList pages = new NBTTagList();
		    					
		    					    	NBTTagCompound paneltitle = new NBTTagCompound();
		    					    	paneltitle.setString("text", "Select a punishemnt!\n");
		    					
		    					    	NBTTagCompound json = new NBTTagCompound();
		    					    	json.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonOne"));
		    					    	json.set("clickEvent", new NBTTagCompound());
		    					    	json.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent = json.getCompound("clickEvent");
		    					    	clickEvent.setString("action", "run_command");
		    					    	clickEvent.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonOne"));
		    					    	NBTTagCompound hoverEvent = json.getCompound("hoverEvent");
		    					    	hoverEvent.setString("action", "show_text");
		    					    	hoverEvent.set("value", new NBTTagCompound());
		    					    	hoverEvent.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue = hoverEvent.getCompound("value");
		    					    	hoverValue.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json2 = new NBTTagCompound();
		    					    	json2.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwo"));
		    					    	json2.set("clickEvent", new NBTTagCompound());
		    					    	json2.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent2 = json2.getCompound("clickEvent");
		    					    	clickEvent2.setString("action", "run_command");
		    					    	clickEvent2.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwo"));
		    					    	NBTTagCompound hoverEvent2 = json2.getCompound("hoverEvent");
		    					    	hoverEvent2.setString("action", "show_text");
		    					    	hoverEvent2.set("value", new NBTTagCompound());
		    					    	hoverEvent2.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue2 = hoverEvent2.getCompound("value");
		    					    	hoverValue2.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json3 = new NBTTagCompound();
		    					    	json3.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonThree"));
		    					    	json3.set("clickEvent", new NBTTagCompound());
		    					    	json3.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent3 = json3.getCompound("clickEvent");
		    					    	clickEvent3.setString("action", "run_command");
		    					    	clickEvent3.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonThree"));
		    					    	NBTTagCompound hoverEvent3 = json3.getCompound("hoverEvent");
		    					    	hoverEvent3.setString("action", "show_text");
		    					    	hoverEvent3.set("value", new NBTTagCompound());
		    					    	hoverEvent3.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue3 = hoverEvent3.getCompound("value");
		    					    	hoverValue3.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json4 = new NBTTagCompound();
		    					    	json4.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFour"));
		    					    	json4.set("clickEvent", new NBTTagCompound());
		    					    	json4.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent4 = json4.getCompound("clickEvent");
		    					    	clickEvent4.setString("action", "run_command");
		    					    	clickEvent4.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonFour"));
		    					    	NBTTagCompound hoverEvent4 = json4.getCompound("hoverEvent");
		    					    	hoverEvent4.setString("action", "show_text");
		    					    	hoverEvent4.set("value", new NBTTagCompound());
		    					    	hoverEvent4.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue4 = hoverEvent4.getCompound("value");
		    					    	hoverValue4.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json5 = new NBTTagCompound();
		    					    	json5.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFive"));
		    					    	json5.set("clickEvent", new NBTTagCompound());
		    					    	json5.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent5 = json5.getCompound("clickEvent");
		    					    	clickEvent5.setString("action", "run_command");
		    					    	clickEvent5.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonFive"));
		    					    	NBTTagCompound hoverEvent5 = json5.getCompound("hoverEvent");
		    					    	hoverEvent5.setString("action", "show_text");
		    					    	hoverEvent5.set("value", new NBTTagCompound());
		    					    	hoverEvent5.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue5 = hoverEvent5.getCompound("value");
		    					    	hoverValue5.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json6 = new NBTTagCompound();
		    					    	json6.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSix"));
		    					    	json6.set("clickEvent", new NBTTagCompound());
		    					    	json6.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent6 = json6.getCompound("clickEvent");
		    					    	clickEvent6.setString("action", "run_command");
		    					    	clickEvent6.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonSix"));
		    					    	NBTTagCompound hoverEvent6 = json6.getCompound("hoverEvent");
		    					    	hoverEvent6.setString("action", "show_text");
		    					    	hoverEvent6.set("value", new NBTTagCompound());
		    					    	hoverEvent6.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue6 = hoverEvent6.getCompound("value");
		    					    	hoverValue6.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json7 = new NBTTagCompound();
		    					    	json7.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSeven"));
		    					    	json7.set("clickEvent", new NBTTagCompound());
		    					    	json7.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent7 = json7.getCompound("clickEvent");
		    					    	clickEvent7.setString("action", "run_command");
		    					    	clickEvent7.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonSeven"));
		    					    	NBTTagCompound hoverEvent7 = json7.getCompound("hoverEvent");
		    					    	hoverEvent7.setString("action", "show_text");
		    					    	hoverEvent7.set("value", new NBTTagCompound());
		    					    	hoverEvent7.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue7 = hoverEvent7.getCompound("value");
		    					    	hoverValue7.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json8 = new NBTTagCompound();
		    					    	json8.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEight"));
		    					    	json8.set("clickEvent", new NBTTagCompound());
		    					    	json8.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent8 = json8.getCompound("clickEvent");
		    					    	clickEvent8.setString("action", "run_command");
		    					    	clickEvent8.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonEight"));
		    					    	NBTTagCompound hoverEvent8 = json8.getCompound("hoverEvent");
		    					    	hoverEvent8.setString("action", "show_text");
		    					    	hoverEvent8.set("value", new NBTTagCompound());
		    					    	hoverEvent8.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue8 = hoverEvent8.getCompound("value");
		    					    	hoverValue8.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json9 = new NBTTagCompound();
		    					    	json9.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonNine"));
		    					    	json9.set("clickEvent", new NBTTagCompound());
		    					    	json9.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent9 = json9.getCompound("clickEvent");
		    					    	clickEvent9.setString("action", "run_command");
		    					    	clickEvent9.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonNine"));
		    					    	NBTTagCompound hoverEvent9 = json9.getCompound("hoverEvent");
		    					    	hoverEvent9.setString("action", "show_text");
		    					    	hoverEvent9.set("value", new NBTTagCompound());
		    					    	hoverEvent9.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue9 = hoverEvent9.getCompound("value");
		    					    	hoverValue9.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json10 = new NBTTagCompound();
		    					    	json10.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTen"));
		    					    	json10.set("clickEvent", new NBTTagCompound());
		    					    	json10.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent10 = json10.getCompound("clickEvent");
		    					    	clickEvent10.setString("action", "run_command");
		    					    	clickEvent10.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonTen"));
		    					    	NBTTagCompound hoverEvent10 = json10.getCompound("hoverEvent");
		    					    	hoverEvent10.setString("action", "show_text");
		    					    	hoverEvent10.set("value", new NBTTagCompound());
		    					    	hoverEvent10.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue10 = hoverEvent10.getCompound("value");
		    					    	hoverValue10.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json11 = new NBTTagCompound();
		    					    	json11.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEleven"));
		    					    	json11.set("clickEvent", new NBTTagCompound());
		    					    	json11.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent11 = json11.getCompound("clickEvent");
		    					    	clickEvent11.setString("action", "run_command");
		    					    	clickEvent11.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonEleven"));
		    					    	NBTTagCompound hoverEvent11 = json11.getCompound("hoverEvent");
		    					    	hoverEvent11.setString("action", "show_text");
		    					    	hoverEvent11.set("value", new NBTTagCompound());
		    					    	hoverEvent11.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue11 = hoverEvent11.getCompound("value");
		    					    	hoverValue11.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json12 = new NBTTagCompound();
		    					    	json12.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwelve"));
		    					    	json12.set("clickEvent", new NBTTagCompound());
		    					    	json12.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent12 = json12.getCompound("clickEvent");
		    					    	clickEvent12.setString("action", "run_command");
		    					    	clickEvent12.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwelve"));
		    					    	NBTTagCompound hoverEvent12 = json12.getCompound("hoverEvent");
		    					    	hoverEvent12.setString("action", "show_text");
		    					    	hoverEvent12.set("value", new NBTTagCompound());
		    					    	hoverEvent12.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue12 = hoverEvent12.getCompound("value");
		    					    	hoverValue12.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json13 = new NBTTagCompound();
		    					    	json13.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonThirteen"));
		    					    	json13.set("clickEvent", new NBTTagCompound());
		    					    	json13.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent13 = json13.getCompound("clickEvent");
		    					    	clickEvent13.setString("action", "run_command");
		    					    	clickEvent13.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonThirteen"));
		    					    	NBTTagCompound hoverEvent13 = json13.getCompound("hoverEvent");
		    					    	hoverEvent13.setString("action", "show_text");
		    					    	hoverEvent13.set("value", new NBTTagCompound());
		    					    	hoverEvent13.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue13 = hoverEvent13.getCompound("value");
		    					    	hoverValue13.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json14 = new NBTTagCompound();
		    					    	json14.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFourteen"));
		    					    	json14.set("clickEvent", new NBTTagCompound());
		    					    	json14.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent14 = json14.getCompound("clickEvent");
		    					    	clickEvent14.setString("action", "run_command");
		    					    	clickEvent14.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonFourteen"));
		    					    	NBTTagCompound hoverEvent14 = json14.getCompound("hoverEvent");
		    					    	hoverEvent14.setString("action", "show_text");
		    					    	hoverEvent14.set("value", new NBTTagCompound());
		    					    	hoverEvent14.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue14 = hoverEvent14.getCompound("value");
		    					    	hoverValue14.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json15 = new NBTTagCompound();
		    					    	json15.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonFifteen"));
		    					    	json15.set("clickEvent", new NBTTagCompound());
		    					    	json15.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent15 = json15.getCompound("clickEvent");
		    					    	clickEvent15.setString("action", "run_command");
		    					    	clickEvent15.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonFifteen"));
		    					    	NBTTagCompound hoverEvent15 = json15.getCompound("hoverEvent");
		    					    	hoverEvent15.setString("action", "show_text");
		    					    	hoverEvent15.set("value", new NBTTagCompound());
		    					    	hoverEvent15.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue15 = hoverEvent15.getCompound("value");
		    					    	hoverValue15.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json16 = new NBTTagCompound();
		    					    	json16.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSixteen"));
		    					    	json10.set("clickEvent", new NBTTagCompound());
		    					    	json10.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent16 = json16.getCompound("clickEvent");
		    					    	clickEvent16.setString("action", "run_command");
		    					    	clickEvent16.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonSixteen"));
		    					    	NBTTagCompound hoverEvent16 = json16.getCompound("hoverEvent");
		    					    	hoverEvent16.setString("action", "show_text");
		    					    	hoverEvent16.set("value", new NBTTagCompound());
		    					    	hoverEvent16.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue16 = hoverEvent16.getCompound("value");
		    					    	hoverValue16.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json17 = new NBTTagCompound();
		    					    	json17.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonSeventeen"));
		    					    	json17.set("clickEvent", new NBTTagCompound());
		    					    	json17.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent17 = json17.getCompound("clickEvent");
		    					    	clickEvent17.setString("action", "run_command");
		    					    	clickEvent17.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonSeventeen"));
		    					    	NBTTagCompound hoverEvent17 = json17.getCompound("hoverEvent");
		    					    	hoverEvent17.setString("action", "show_text");
		    					    	hoverEvent17.set("value", new NBTTagCompound());
		    					    	hoverEvent17.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue17 = hoverEvent17.getCompound("value");
		    					    	hoverValue17.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json18 = new NBTTagCompound();
		    					    	json18.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonEighteen"));
		    					    	json18.set("clickEvent", new NBTTagCompound());
		    					    	json18.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent18 = json18.getCompound("clickEvent");
		    					    	clickEvent18.setString("action", "run_command");
		    					    	clickEvent18.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonEighteen"));
		    					    	NBTTagCompound hoverEvent18 = json18.getCompound("hoverEvent");
		    					    	hoverEvent18.setString("action", "show_text");
		    					    	hoverEvent18.set("value", new NBTTagCompound());
		    					    	hoverEvent18.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue18 = hoverEvent18.getCompound("value");
		    					    	hoverValue18.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json19 = new NBTTagCompound();
		    					    	json19.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonNinteen"));
		    					    	json19.set("clickEvent", new NBTTagCompound());
		    					    	json19.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent19 = json19.getCompound("clickEvent");
		    					    	clickEvent19.setString("action", "run_command");
		    					    	clickEvent19.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonNinteen"));
		    					    	NBTTagCompound hoverEvent19 = json19.getCompound("hoverEvent");
		    					    	hoverEvent19.setString("action", "show_text");
		    					    	hoverEvent19.set("value", new NBTTagCompound());
		    					    	hoverEvent19.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue19 = hoverEvent19.getCompound("value");
		    					    	hoverValue19.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	NBTTagCompound json20 = new NBTTagCompound();
		    					    	json20.setString("text", "\n➤ " + plugin.getConfig().getString("KickReasonTwenty"));
		    					    	json20.set("clickEvent", new NBTTagCompound());
		    					    	json20.set("hoverEvent", new NBTTagCompound());
		    					
		    					    	NBTTagCompound clickEvent20 = json20.getCompound("clickEvent");
		    					    	clickEvent20.setString("action", "run_command");
		    					    	clickEvent20.setString("value", "/kick " + player1.getName().toString() + " " + plugin.getConfig().getString("KickReasonTwenty"));
		    					    	NBTTagCompound hoverEvent20 = json20.getCompound("hoverEvent");
		    					    	hoverEvent20.setString("action", "show_text");
		    					    	hoverEvent20.set("value", new NBTTagCompound());
		    					    	hoverEvent20.setString("insertion", "what is this?");
		    					    	NBTTagCompound hoverValue20 = hoverEvent20.getCompound("value");
		    					    	hoverValue20.setString("text", "Click this to kick " + player1.getName().toString());
		    					
		    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json.toString() + "," + json2.toString() + "," + json3.toString() + "," + json4.toString() + "," + json5.toString() + "," + json6.toString() + "," + json7.toString() + "," + json8.toString() + "," + json9.toString() + "," + json10.toString() + "]"));
		    					    	
		    					    	pages.add(new NBTTagString("[" + paneltitle.toString() + "," + json11.toString() + "," + json12.toString() + "," + json13.toString() + "," + json14.toString() + "," + json15.toString() + "," + json16.toString() + "," + json17.toString() + "," + json18.toString() + "," + json19.toString() + "," + json20.toString() + "]"));
		    					
		    					    	tag.set("pages", pages);
		    					    	book.setTag(tag);
		    					    	org.bukkit.inventory.ItemStack hand = p.getItemInHand();
		    					    	p.setItemInHand(CraftItemStack.asBukkitCopy(book));
		    					    	entityHuman.openBook(book);
		    					    	p.setItemInHand(hand);
		    					    	entityHuman.b(StatisticList.USE_ITEM_COUNT[387]);
		    		            	}
			        			}
    		            	}
    	            	}
        			}
        		}
        	}
    	}
		return false;
	}
}


