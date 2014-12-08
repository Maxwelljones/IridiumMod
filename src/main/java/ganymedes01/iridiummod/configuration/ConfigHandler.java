package ganymedes01.iridiummod.configuration;

import ganymedes01.iridiummod.IridiumMod;
import ganymedes01.iridiummod.lib.Reference;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;
	public Set<String> usedCategories = new HashSet<String>();

	public void preInit(File file) {
		configFile = new Configuration(file, true);

		preInit();
		usedCategories.add(Configuration.CATEGORY_GENERAL);
	}

	private void preInit() {
		IridiumMod.iridiumOre.setHarvestLevel("pickaxe", configFile.get(Configuration.CATEGORY_GENERAL, "mining_level", 3).getInt(3));
		IridiumMod.iridiumOre.setHardness((float) configFile.get(Configuration.CATEGORY_GENERAL, "hardness", 3.0F).getDouble(3.0F));
		IridiumMod.iridiumOre.setResistance((float) configFile.get(Configuration.CATEGORY_GENERAL, "blast_resistance", 5.0F).getDouble(5.0F));

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID)) {
			configFile.load();

			preInit();
		}
	}
}