package javakatas;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

/**
 * Created by g.bykov on 16/01/2017.
 */
public class UsingOptional {

    private final static Logger LOGGER = Logger.getLogger(Optional.class.getCanonicalName());

    private final static Map<String, String> stateCapitals;

    static {
        final Map<String, String> tempStatesToCapitals = new HashMap<>();
        tempStatesToCapitals.put("Alaska", "Juneau");
        tempStatesToCapitals.put("Arkansas", "Little Rock");
        tempStatesToCapitals.put("Colorado", "Denver");
        tempStatesToCapitals.put("Idaho", "Boise");
        tempStatesToCapitals.put("Utah", "Salt Lake City");
        tempStatesToCapitals.put("Wyoming", "Cheyenne");
        stateCapitals = Collections.unmodifiableMap(tempStatesToCapitals);
    }

    public Optional<String> getStateCapital(final String stateName) {
        return Optional.ofNullable(stateCapitals.get(stateName));
    }

    public Optional<BigDecimal> getQuotient(final BigDecimal dividend, final BigDecimal divisor) {
        BigDecimal quotient;
        try {
            quotient = dividend.divide(divisor);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Unable to divide " + dividend + " by " + divisor + "-", ex);
            quotient = null;
        }
        return Optional.ofNullable(quotient);
    }

    public static void main(final String[] arguments) {
        final UsingOptional me = new UsingOptional();

        final String wyoming = "Wyoming";
        final Optional<String> wyomingCapitalWrapper = me.getStateCapital(wyoming);
        wyomingCapitalWrapper.ifPresent(s -> out.println("Capital of " + wyoming + " is " + s));
        out.println("Capital of " + wyoming + " is " + wyomingCapitalWrapper.orElse(null));

        final String northDakota = "North Dakota";
        final Optional<String> northDakotaCapitalWrapper = me.getStateCapital(northDakota);
        out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper);
        out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper.orElse("Unspecified"));
        out.println("Capital of " + northDakota + " is " + northDakotaCapitalWrapper.orElse(null));

        final Optional<String> nullOptional = me.getStateCapital(null);
        out.println("Capital of null is " + nullOptional);


        final BigDecimal dividend = new BigDecimal("5.0");
        final BigDecimal divisor = new BigDecimal("0.0");
        final Optional<BigDecimal> quotientWrapper = me.getQuotient(dividend, divisor);
        out.println("Quotient of " + dividend + " / " + divisor + " is "
                + quotientWrapper);
    }
}
