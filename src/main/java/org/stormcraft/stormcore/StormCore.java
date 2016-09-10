package org.stormcraft.stormcore;

import org.stormcraft.stormcore.cmd.*;

public class StormCore extends StormPlugin {

	protected String version;

	protected static StormCore i;

	@Override
	public void onEnable() {
		super.onEnable();

		this.version = getDescription().getVersion();

		registerCommand(new StormCoreCommand());

		i = this;
	}

	public static StormCore get() {
		return i;
	}

	public String getVersion() {
		return version;
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

}
