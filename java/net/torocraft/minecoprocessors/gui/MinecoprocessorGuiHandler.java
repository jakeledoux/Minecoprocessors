package net.torocraft.minecoprocessors.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.torocraft.minecoprocessors.Minecoprocessors;
import net.torocraft.minecoprocessors.blocks.ContainerMinecoprocessor;
import net.torocraft.minecoprocessors.blocks.TileEntityMinecoprocessor;

public class MinecoprocessorGuiHandler implements IGuiHandler {

  public static final int MINECOPROCESSOR_ENTITY_GUI = 0;

  public static void init() {
    NetworkRegistry.INSTANCE
        .registerGuiHandler(Minecoprocessors.INSTANCE, new MinecoprocessorGuiHandler());
  }

  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    if (ID == MINECOPROCESSOR_ENTITY_GUI) {
      return new ContainerMinecoprocessor(player.inventory,
          (TileEntityMinecoprocessor) world.getTileEntity(new BlockPos(x, y, z)));
    }
    return null;
  }

  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    if (ID == MINECOPROCESSOR_ENTITY_GUI) {
      return new GuiMinecoprocessor(player.inventory,
          (TileEntityMinecoprocessor) world.getTileEntity(new BlockPos(x, y, z)));
    }
    return null;
  }
}
