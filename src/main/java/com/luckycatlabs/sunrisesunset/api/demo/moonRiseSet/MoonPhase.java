package com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet;

import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.param.Builder;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.param.TimeParameter;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.param.TimeResultParameter;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.util.*;

import java.util.Date;

import static com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.util.ExtendedMath.PI2;
import static java.lang.Math.PI;
import static java.lang.Math.toRadians;

public class MoonPhase {
    private final Date time;

    private MoonPhase(Date time) {
        this.time = time;
    }

    /**
     * Starts the computation of {@link MoonPhase}.
     *
     * @return {@link Parameters} to set.
     */
    public static Parameters compute() {
        return new MoonPhaseBuilder();
    }

    /**
     * Collects all parameters for {@link MoonPhase}.
     *
     * @since 2.3
     */
    public interface Parameters extends
            TimeParameter<Parameters>,
            TimeResultParameter<Parameters>,
            Builder<MoonPhase> {

        /**
         * Sets the desired {@link Phase}.
         * <p>
         * Defaults to {@link Phase#NEW_MOON}.
         *
         * @param phase {@link Phase} to be used.
         * @return itself
         */
        Parameters phase(Phase phase);

        /**
         * Sets a free phase to be used.
         *
         * @param phase Desired phase, in degrees. 0 = new moon, 90 = first quarter, 180 =
         *              full moon, 270 = third quarter.
         * @return itself
         */
        Parameters phase(double phase);
    }

    /**
     * Enumeration of moon phases.
     *
     * @since 2.3
     */
    public enum Phase {

        /**
         * New moon.
         */
        NEW_MOON(0.0),

        /**
         * Waxing half moon.
         */
        FIRST_QUARTER(90.0),

        /**
         * Full moon.
         */
        FULL_MOON(180.0),

        /**
         * Waning half moon.
         */
        LAST_QUARTER(270.0);

        private final double angle;
        private final double angleRad;

        Phase(double angle) {
            this.angle = angle;
            this.angleRad = toRadians(angle);
        }

        /**
         * Returns the moons's angle in reference to the sun, in degrees.
         */
        public double getAngle() {
            return angle;
        }

        /**
         * Returns the moons's angle in reference to the sun, in radians.
         */
        public double getAngleRad() {
            return angleRad;
        }
    }

    /**
     * Builder for {@link MoonPhase}. Performs the computations based on the parameters,
     * and creates a {@link MoonPhase} object that holds the result.
     */
    private static class MoonPhaseBuilder extends BaseBuilder<Parameters> implements Parameters {
        private static final double SUN_LIGHT_TIME_TAU = 8.32 / (1440.0 * 36525.0);

        private double newMoonPhase = Phase.NEW_MOON.getAngleRad();
        private double fullMoonPhase = Phase.FULL_MOON.getAngleRad();
        private double firstQuarterPhase = Phase.FIRST_QUARTER.getAngleRad();
        private double lastQuarterPhase = Phase.LAST_QUARTER.getAngleRad();

        @Override
        public Parameters phase(Phase phase) {
            this.newMoonPhase = phase.getAngleRad();
            this.fullMoonPhase = phase.getAngleRad();
            this.firstQuarterPhase = phase.getAngleRad();
            this.lastQuarterPhase = phase.getAngleRad();

            return this;
        }

        @Override
        public Parameters phase(double phase) {
            this.newMoonPhase = toRadians(phase);
            this.fullMoonPhase = toRadians(phase);
            this.firstQuarterPhase = toRadians(phase);
            this.lastQuarterPhase = toRadians(phase);

            return this;
        }

        @Override
        public MoonPhase execute() {
            final JulianDate jd = getJulianDate();

            double dT = 7.0 / 36525.0;                      // step rate: 1 week
            double accuracy = (0.5 / 1440.0) / 36525.0;     // accuracy: 30 seconds

            double t0 = jd.getJulianCentury();
            double t1 = t0 + dT;

            double d0 = moonphase(jd, t0);
            double d1 = moonphase(jd, t1);

            while (d0 * d1 > 0.0 || d1 < d0) {
                t0 = t1;
                d0 = d1;
                t1 += dT;
                d1 = moonphase(jd, t1);
            }

            double tphase = Pegasus.calculate(t0, t1, accuracy, new Pegasus.Function() {
                @Override
                public double apply(double x) {
                    return moonphase(jd, x);
                }
            });

            return new MoonPhase(jd.atJulianCentury(tphase).getDateTruncated(getTruncatedTo()));
        }

        /**
         * Calculates the position of the moon at the given phase.
         *
         * @param jd Base Julian date
         * @param t  Ephemeris time
         * @return difference angle of the sun's and moon's position
         */
        private double moonphase(JulianDate jd, double t) {
            Vector sun = Sun.positionEquatorial(jd.atJulianCentury(t - SUN_LIGHT_TIME_TAU));
            Vector moon = Moon.positionEquatorial(jd.atJulianCentury(t));
            double diff = moon.getPhi() - sun.getPhi() - newMoonPhase; //NOSONAR: false positive
            double v = moon.getPhi() - sun.getPhi() - fullMoonPhase;
            while (diff < 0.0 || diff < 0.0) {
                diff += PI2;
            }
            return ((diff + PI) % PI2) - PI;
        }

    }

    /**
     * Date and time of the desired moon phase. The time is rounded to full minutes.
     */
    public Date getTime() {
        return new Date(time.getTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoonPhase[time=").append(time);
        sb.append(']');
        return sb.toString();
    }

}
