package net.machinemuse.utils

import net.minecraft.client.renderer.{RenderEngine, RenderBlocks}
import net.minecraft.item.ItemStack
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.item.EntityItem
import net.minecraft.world.storage.MapData
import net.minecraft.entity.player.EntityPlayer

/**
 * Author: MachineMuse (Claire Semple)
 * Created: 8:03 PM, 6/28/13
 */
trait MuseItemRenderer {
  // Implicit delegate; allows use of a MuseItemRenderer in the place of an IItemRenderer
  val delegator = new ItemRenderDelegator(this)
  implicit def delegate(m:MuseItemRenderer) = m.delegator

  // Item alone as an entity e.g. dropped
  def renderEntity(item: ItemStack, renderBlocks: RenderBlocks, entity: EntityItem)

  // Inventory screen / toolbar
  def renderInventory(item: ItemStack, renderBlocks: RenderBlocks)

  // Maps only e.g. thaumometer
  def renderFirstPersonMap(item: ItemStack, entity: EntityPlayer, engine: RenderEngine, data: MapData)

  // First person fist
  def renderFirstPerson(item: ItemStack, renderBlocks: RenderBlocks, entity: EntityLiving)

  // Entity equipped in the world
  def renderEquipped(item: ItemStack, renderBlocks: RenderBlocks, entity: EntityLiving)
}