package org.wyldmods.simpleachievements.common;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntityEnchantmentTable;

/**
 * Created by Michael on 13/08/2014.
 */
public class TileEntityAchievementStand extends TileEntityEnchantmentTable {

    public int page;

    @Override
    public void writeToNBT(NBTTagCompound par1) {
        par1.setInteger("sa:page",page);
        super.writeToNBT(par1);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1) {
        par1.getInteger("sa:page");
        super.readFromNBT(par1);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        System.out.println("[SA]: "+tag.getInteger("sa:page"));
        return new Packet132TileEntityData(xCoord,yCoord,zCoord, 0, tag);
    }

    @Override
    public void onDataPacket(INetworkManager networkManager, Packet132TileEntityData packet) {
        readFromNBT(packet.data);
    }

    public void setPage(int par1) {
        page=par1;
    }
}
