package ru.iamdvz.core.api.effectlib.effect;

import ru.iamdvz.core.api.effectlib.Effect;
import ru.iamdvz.core.api.effectlib.EffectManager;
import ru.iamdvz.core.api.effectlib.EffectType;
import org.bukkit.Particle;
import ru.iamdvz.core.api.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * Taken from http://en.wikipedia.org/wiki/Torus
 *
 * @author Kevin
 */
public class HillEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public Particle particle = Particle.FLAME;

    /**
     * Height of the hill in blocks
     */
    public float height = 2.5f;

    /**
     * Amount of particles per row
     */
    public float particles = 30;

    /**
     * Length of the edge
     */
    public float edgeLength = 6.5f;

    /**
     * Rotation of the Hill
     */
    public double yRotation = Math.PI / 7;

    public HillEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 10;
        iterations = 20;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        Vector v = new Vector();
        for (int x = 0; x <= particles; x++) {
            double y1 = Math.sin(Math.PI * x / particles);
            for (int z = 0; z <= particles; z++) {
                double y2 = Math.sin(Math.PI * z / particles);
                v.setX(edgeLength * x / particles).setZ(edgeLength * z / particles);
                v.setY(height * y1 * y2);
                VectorUtils.rotateAroundAxisY(v, yRotation);

                display(particle, location.add(v));
                location.subtract(v);
            }
        }
    }
}
