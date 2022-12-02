package ru.iamdvz.core.api.effectlib.effect;

import ru.iamdvz.core.api.effectlib.EffectManager;
import ru.iamdvz.core.api.effectlib.EffectType;
import ru.iamdvz.core.api.effectlib.util.RandomUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;

public class BleedEffect extends ru.iamdvz.core.api.effectlib.Effect {

    /**
     * Play the Hurt Effect for the Player
     */
    public boolean hurt = true;

    /**
     * Height of the blood spurt
     */
    public double height = 1.75;

    /**
     * Color of blood. Default is red (152)
     */
    public Material material = Material.REDSTONE_BLOCK;

    public BleedEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 4;
        iterations = 25;
    }

    @Override
    public void onRun() {
        // Location to spawn the blood-item.
        Location location = getLocation();
        location.add(0, RandomUtils.random.nextFloat() * height, 0);
        location.getWorld().playEffect(location, Effect.STEP_SOUND, material);

        Entity entity = getEntity();
        if (hurt && entity != null) {
            entity.playEffect(org.bukkit.EntityEffect.HURT);
        }
    }
}
