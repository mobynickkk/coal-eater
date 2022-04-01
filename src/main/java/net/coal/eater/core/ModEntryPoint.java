package net.coal.eater.core;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coal.eater.listeners.CoalListeners;

public class ModEntryPoint implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Coal-Eater mod");

        // Initialize coal listeners
        CoalListeners.REGISTER_COAL_RIGHT_CLICK_HANDLER();
	}
}
