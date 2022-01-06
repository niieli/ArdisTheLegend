package net.nieli.ardis.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.nieli.ardis.registry.EntityRegistry;
import net.nieli.ardis.registry.ItemRegistry;
import software.bernie.example.ClientListener;

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
        entity.setOnFireFor(9);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return ClientListener.EntityPacket.createPacket(this);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ItemRegistry.ARDIS_ARROW_ITEM);
    }
}