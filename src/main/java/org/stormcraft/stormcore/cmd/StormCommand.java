package org.stormcraft.stormcore.cmd;

import org.bukkit.command.*;

import java.util.ArrayList;
import java.util.List;

public abstract class StormCommand implements CommandExecutor {

	protected String name;

	protected List<String> aliases = new ArrayList<String>();

	protected List<Parameter<?>> parameters = new ArrayList<Parameter<?>>();

	/**
	 * A list of subcommands
	 */
	protected List<StormCommand> subCommands = new ArrayList<StormCommand>();

	public StormCommand() {
		//
	}

	public StormCommand(String name, List<Parameter<?>> parameters, List<StormCommand> subCommands) {
		this.name = name;

		this.parameters = parameters;

		this.subCommands = subCommands;
	}

	public StormCommand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void run(CommandSender commandSender, List<Parameter<?>> parameters);

	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		//
		return false;
	}

	protected boolean matches(String command) {
		for(String alias : aliases)
			if(alias.equalsIgnoreCase(command))
				return true;

		if(name.equalsIgnoreCase(command))
			return true;

		return false;
	}

	protected void addCommand(StormCommand cmd) {
		subCommands.add(cmd);
	}

	protected StormCommand findSubCommand(String cmd) {
		for(StormCommand sub : subCommands)
			if(sub.matches(cmd))
				return sub;

		return null;
	}
}
