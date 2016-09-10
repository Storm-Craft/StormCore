package org.stormcraft.stormcore;

import org.bukkit.plugin.java.JavaPlugin;

import org.stormcraft.stormcore.cmd.StormCommand;

public class StormPlugin extends JavaPlugin {

	protected static StormPlugin i;

	public static StormPlugin get() {
		return i;
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	protected void registerCommand(StormCommand command) {
		getCommand(command.getName()).setExecutor(command);
	}
}
