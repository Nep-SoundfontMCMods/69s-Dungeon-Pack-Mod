package soundfont.nep.dungeonsixnine.procedure;

import soundfont.nep.dungeonsixnine.ElementsDungeon69Mod;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import java.util.Map;

@ElementsDungeon69Mod.ModElement.Tag
public class ProcedureApplyTimer extends ElementsDungeon69Mod.ModElement {
	public ProcedureApplyTimer(ElementsDungeon69Mod instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ApplyTimer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getEntityData().setBoolean("SprellCasting", (true));
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList()
						.sendMessage(new TextComponentString((("%playername% started a ") + ""
								+ ((25 - ((entity.getEntityData().getDouble("Difficulty")) + (entity.getEntityData().getDouble("Handicap"))))) + ""
								+ (" minute dungeon speedrun! !") + "" + ("The Dungeon level is: ") + ""
								+ ((entity.getEntityData().getDouble("Difficulty"))))));
		}
	}
}
