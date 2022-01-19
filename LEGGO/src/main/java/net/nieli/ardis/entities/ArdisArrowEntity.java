package net.nieli.ardis.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.registry.EntityRegistry;
import net.nieli.ardis.registry.ItemsRegistry;

public class ArdisArrowEntity extends PersistentProjectileEntity {
    public ArdisArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public ArdisArrowEntity(World world, LivingEntity owner) {
        super(EntityRegistry.ARDISARROW, owner, world);
    }

    protected ArdisArrowEntity(EntityType<? extends ArdisArrowEntity> type, double x, double y, double z, World world) {
        this(type, world);
    }

    protected ArdisArrowEntity(EntityType<? extends ArdisArrowEntity> type, LivingEntity owner, World world) {
        this(type, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
        this.setOwner(owner);
        if (owner instanceof PlayerEntity) {
            this.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.world.addParticle(ArdisTheLegendMod.RAINBOW_FLAME, this.getX(),this.getY(),this.getZ(),0.0D,0.0D,0.0D); // Spawns Particles, also neat to remember
        entity.setOnFireFor(3);
        entity.damage(DamageSource.arrow(this, this.getOwner()), 23F);

        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 3, 0))); // applies a status effect
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2))); // applies a status effect
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 1))); // applies a status effect
            //livingEntity.playSound(SoundEvents.AMBIENT_CAVE, 2F, 1F); // plays a sound for the entity hit only
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ItemsRegistry.ARDIS_ARROW_ITEM);
    }
}