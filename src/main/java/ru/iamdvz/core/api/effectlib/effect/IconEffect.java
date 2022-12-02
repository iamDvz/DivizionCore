package ru.iamdvz.core.api.effectlib.effect;

import ru.iamdvz.core.api.effectlib.Effect;
import ru.iamdvz.core.api.effectlib.EffectManager;
import ru.iamdvz.core.api.effectlib.EffectType;
import org.bukkit.Particle;
import org.bukkit.Location;

public class IconEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public Particle particle = Particle.VILLAGER_ANGRY;

    public int yOffset = 2;

    public IconEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 4;
        iterations = 25;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        location.add(0, yOffset, 0);
        display(particle, location);
    }
}
