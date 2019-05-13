package us.vchain.jvcn;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.addAll;

class Util {
    private Util() {

    }

    @SafeVarargs
    static <T> Set<T> newSet(final T... ts) {
        final Set<T> set = new HashSet<>();
        addAll(set, ts);
        return set;
    }
}
