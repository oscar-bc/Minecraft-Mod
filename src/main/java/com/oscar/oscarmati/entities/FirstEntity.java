package com.oscar.oscarmati.entities;

import com.oscar.oscarmati.init.ItemInit;
import com.oscar.oscarmati.init.ModEntityTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class FirstEntity extends AnimalEntity {

    private EatGrassGoal eatGrassGoal;
    private int timer;

    public FirstEntity(EntityType<? extends AnimalEntity> type, World worldIn){
        super(type, worldIn);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack.getItem() == ItemInit.DILLIUM.get();
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        FirstEntity entity = new FirstEntity(ModEntityTypes.FIRST_ENTITY.get(), this.world);
        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
        return entity;
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25d));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0d));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.4d, Ingredient.fromItems(ItemInit.DILLIUM.get()), false));
        this.goalSelector.addGoal(4, this.eatGrassGoal);
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1d));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.25d));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateAITasks(){
        this.timer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if(this.world.isRemote){
            this.timer = Math.max(0, this.timer - 1);
        }
        super.livingTick();
    }

    @Override
    protected void registerAttributes(){
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40d);
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.timer <= 0) {
            return 0.0F;
        } else if (this.timer >= 4 && this.timer <= 36) {
            return 1.0F;
        } else {
            return this.timer < 4 ? ((float) this.timer - p_70894_1_) / 4.0F
                    : -((float) (this.timer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.timer > 4 && this.timer <= 36) {
            float f = ((float) (this.timer - 4) - p_70890_1_) / 32.0F;
            return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.timer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
        }
    }
}
