package ganymedes01.iridiummod;

import ganymedes01.iridiummod.configuration.ConfigHandler;
import ganymedes01.iridiummod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class IridiumMod {

	@Instance(Reference.MOD_ID)
	public static IridiumMod instance;

	public static final Block iridiumOre = new BlockOre().setStepSound(Block.soundTypePiston).setBlockName(Reference.MOD_ID + ".oreIridium").setBlockTextureName(Reference.MOD_ID + ":iridium_ore");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(iridiumOre, "iridiumOre");
		OreDictionary.registerOre("oreIridium", iridiumOre);

		ConfigHandler.INSTANCE.preInit(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
	}
}