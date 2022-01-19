package net.nieli.ardis.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.nieli.ardis.entities.ArdisArrowEntity;
import net.nieli.ardis.registry.ItemsRegistry;

import java.util.List;
import java.util.function.Predicate;

public class ArdisBow extends BowItem {
    public ArdisBow(Settings settings) {
        super(settings);
    }
    public static final Predicate<ItemStack> BOW_PROJECTILES = (stack) -> stack.isOf(ItemsRegistry.ARDIS_ARROW_ITEM);

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.ardis-the-legend.ardis_bow.tooltip").formatted(Formatting.RED));
    }
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemStack = playerEntity.getArrowType(stack);
            if (!itemStack.isEmpty() || bl) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(ItemsRegistry.ARDIS_ARROW_ITEM);
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1D)) {
                    boolean bl2 = bl && itemStack.isOf(ItemsRegistry.ARDIS_ARROW_ITEM);
                    if (!world.isClient) {
                        ArdisArrowItem ardisArrowItem = (ArdisArrowItem) (itemStack.getItem() instanceof ArdisArrowItem ? itemStack.getItem() : ItemsRegistry.ARDIS_ARROW_ITEM);
                        ArdisArrowEntity persistentProjectileEntity = (ArdisArrowEntity) ardisArrowItem.createArrow(world, itemStack, playerEntity);
                        ArdisArrowEntity persistentProjectileEntity2 = (ArdisArrowEntity) ardisArrowItem.createArrow(world, itemStack, playerEntity);
                        ArdisArrowEntity persistentProjectileEntity3 = (ArdisArrowEntity) ardisArrowItem.createArrow(world, itemStack, playerEntity);
                        persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 5.0F, 1.0F);
                        persistentProjectileEntity2.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 4.2F, 6.0F);
                        persistentProjectileEntity3.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 4.2F, -4.0F);
                        if (f == 1.0F) {
                            persistentProjectileEntity3.setCritical(true);
                            persistentProjectileEntity2.setCritical(true);
                            persistentProjectileEntity.setCritical(true);
                        }

                        int j = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
                        if (j > 0) {
                            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double)j * 1.5D + 1.5D);
                        }

                        int k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
                        if (k > 0) {
                            persistentProjectileEntity.setPunch(k);
                            persistentProjectileEntity2.setPunch(k);
                            persistentProjectileEntity3.setPunch(k);
                        }

                        stack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
                        persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                        persistentProjectileEntity2.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                        persistentProjectileEntity3.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;

                        world.spawnEntity(persistentProjectileEntity);
                        world.spawnEntity(persistentProjectileEntity2);
                        world.spawnEntity(persistentProjectileEntity3);
                    }

                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!bl2 && !playerEntity.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            playerEntity.getInventory().removeOne(itemStack);
                        }
                    }

                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl = !user.getArrowType(itemStack).isEmpty();
        if (!user.getAbilities().creativeMode && !bl) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    public int getRange() {
        return 20;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}


