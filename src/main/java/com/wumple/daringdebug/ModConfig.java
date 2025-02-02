package com.wumple.daringdebug;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModConfig
{
	@Name("TileEntity on debug screen")
	@Config.Comment("Show TileEntity name on debug screen for block under cursor")
	public static boolean tileEntityDebug = true;
	
	@Name("Entity on debug screen")
	@Config.Comment("Show Entity name on debug screen for entity under cursor")
	public static boolean entityDebug = true;

	@Name("OreDict debugging")
	@Config.Comment("Show OreDict entries on advanced tooltips and debug screen for thing under cursor")
	public static boolean oreDictDebug = true;
	
	@Name("Capabilities debugging")
	@Config.Comment("Show capabilities on advanced tooltips and debug screen for thing under cursor")
	public static boolean capabilitiesDebug = false;

	
    @Name("Mod debugging")
    @Config.Comment("Mod debugging options")
    public static Debugging zdebugging = new Debugging();

    public static class Debugging
    {
        @Name("Debug mode")
        @Config.Comment("Enable debug features on this menu, display extra debug information.")
        public boolean debug = false;
    }
    
    
    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    private static class EventHandler
    { 
        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event)
	{
            if (event.getModID().equals(Reference.MOD_ID))
	    {
                ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
