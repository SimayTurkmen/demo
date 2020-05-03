package com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet;

import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.param.Builder;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.param.TimeParameter;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.util.*;

import static java.lang.Math.*;

public class MoonIllumination {

    private final double fraction;
    private final double phase;
    private final double angle;

    private MoonIllumination(double fraction, double phase, double angle) {
        this.fraction = fraction;
        this.phase = phase;
        this.angle = angle;
    }

    /**
     * Starts the computation of {@link MoonIllumination}.
     *
     * @return {@link Parameters} to set.
     */
    public static Parameters compute() {
        return new MoonIlluminationBuilder();
    }

    /**
     * Collects all parameters for {@link MoonIllumination}.
     */
    public interface Parameters extends
            TimeParameter<Parameters>,
            Builder<MoonIllumination> {
    }

    /**
     * Builder for {@link MoonIllumination}. Performs the computations based on the
     * parameters, and creates a {@link MoonIllumination} object that holds the result.
     */
    private static class MoonIlluminationBuilder extends BaseBuilder<Parameters> implements Parameters {
        @Override
        public MoonIllumination execute() {
            JulianDate t = getJulianDate();
            Vector s = Sun.position(t);
            Vector m = Moon.position(t);

            double phi = acos(sin(s.getTheta()) * sin(m.getTheta()) + cos(s.getTheta()) * cos(m.getTheta()) * cos(s.getPhi() - m.getPhi()));
            double inc = atan2(s.getR() * sin(phi), m.getR() - s.getR() * cos(phi));
            double angle = atan2(cos(s.getTheta()) * sin(s.getPhi() - m.getPhi()), sin(s.getTheta()) * cos(m.getTheta()) -
                    cos(s.getTheta()) * sin(m.getTheta()) * cos(s.getPhi() - m.getPhi()));

            return new MoonIllumination(
                    (1 + cos(inc)) / 2,
                    360.0 * (0.5 * inc * signum(angle) / PI),
                    toDegrees(angle));
        }
    }

    /**
     * Illuminated fraction. {@code 0.0} indicates new moon, {@code 1.0} indicates full
     * moon.
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * Moon phase. Starts at {@code -180.0} (new moon, waxing), passes {@code 0.0} (full
     * moon) and moves toward {@code 180.0} (waning, new moon).
     */
    public double getPhase() {
        return phase;
    }

    /**
     * Midpoint angle in degrees of the illuminated limb of the moon reckoned eastward
     * from the north point of the disk; the moon is waxing if the angle is negative, and
     * waning if positive.
     * <p>
     * By subtracting  from {@link #getAngle()},
     * one can get the zenith angle of the moons bright limb (anticlockwise). The zenith
     * angle can be used do draw the moon shape from the observers perspective (e.g. moon
     * lying on its back).
     */
    public double getAngle() {
        return angle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoonIllumination[fraction=").append(fraction);
        sb.append(", phase=").append(phase);
        sb.append("°, angle=").append(angle);
        sb.append("°]");
        return sb.toString();
    }
}

