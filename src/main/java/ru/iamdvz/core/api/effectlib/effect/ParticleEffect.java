package ru.iamdvz.core.api.effectlib.effect;

import org.bukkit.Particle;

import ru.iamdvz.core.api.effectlib.Effect;
import ru.iamdvz.core.api.effectlib.EffectManager;
import ru.iamdvz.core.api.effectlib.EffectType;

public class ParticleEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public Particle particle = Particle.VILLAGER_ANGRY;

    public ParticleEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 1;
        iterations = 1;
    }

    @Override
    public void onRun() {
        display(particle, getLocation());
    }
}
