package com.insane.simpleachievements;

import com.insane.simpleachievements.data.DataManager;
import com.insane.simpleachievements.networking.PacketHandlerSA;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.network.Player;

/**
 * Created by Michael on 28/07/2014.
 */
public class PlayerTracker implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
	    if (player!=null && !player.worldObj.isRemote) {
            DataManager.instance().checkMap(player.username);
            PacketHandlerSA.sendToClient((Player) player, DataManager.instance().getAchievementsFor(player.username));
        }
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{

	}
}
