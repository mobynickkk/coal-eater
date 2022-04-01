package net.coal.eater.listeners;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.TypedActionResult;

import java.util.function.Predicate;

public class CoalListeners {

    public static void REGISTER_COAL_RIGHT_CLICK_HANDLER() {
        Predicate<PlayerEntity> isCoal = player ->
                player.getInventory().getMainHandStack().getName().asString().equalsIgnoreCase("coal");

        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (!isCoal.test(player)) {
                return TypedActionResult.pass(ItemStack.EMPTY);
            }
            Item catSpawnEgg = new SpawnEggItem(
                    EntityType.CAT, 2171169, 9159498, new Item.Settings());
            catSpawnEgg.use(world, player, hand);
            return TypedActionResult.pass(ItemStack.EMPTY);
        });
    }
}
