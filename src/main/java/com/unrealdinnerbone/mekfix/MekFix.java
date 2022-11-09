package com.unrealdinnerbone.mekfix;

import mekanism.common.CommonWorldTickHandler;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(MekFix.MOD_ID)
public class MekFix
{
    public static final String MOD_ID = "mekfix";

    public MekFix() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onServerStarting(EntityJoinWorldEvent event) {
        if (CommonWorldTickHandler.monitoringCardboardBox) {
            if (event.getEntity() instanceof ItemEntity || event.getEntity() instanceof ExperienceOrb) {
                event.getEntity().discard();
                event.setCanceled(true);
            }
        }
    }

}
