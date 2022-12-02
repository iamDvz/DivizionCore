package ru.iamdvz.core.api.effectlib.effect;

import ru.iamdvz.core.api.effectlib.Effect;
import ru.iamdvz.core.api.effectlib.EffectManager;
import ru.iamdvz.core.api.effectlib.EffectType;
import ru.iamdvz.core.api.effectlib.util.CustomSound;

public class SoundEffect extends Effect {

    /**
     * Sound effect to play
     */
    public CustomSound sound;

    public SoundEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 1;
        iterations = 1;
    }

    @Override
    public void onRun() {
        if (sound != null) {
            sound.play(effectManager.getOwningPlugin(), effectManager.getLogger(), getLocation());
        }
    }
}
