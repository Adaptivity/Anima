package net.machinemuse.anima

import cpw.mods.fml.client.registry.RenderingRegistry
import net.machinemuse.anima.block.plants.{PlantBlock, PlantRenderer}
import net.minecraftforge.client.MinecraftForgeClient

/**
 * Author: MachineMuse (Claire Semple)
 * Created: 7:50 PM, 6/28/13
 */
class CommonProxy {
  def PreInit() {}

  def Init() {}

  def PostInit() {}
}

class ClientProxy extends CommonProxy {
  override def Init() {
    RenderingRegistry.registerBlockHandler(PlantRenderer)
    MinecraftForgeClient.registerItemRenderer(PlantBlock.item.itemID, PlantRenderer)
  }
}

class ServerProxy extends CommonProxy {

}