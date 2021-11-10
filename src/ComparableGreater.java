public interface ComparableGreater<T> extends Comparable<T> {
    default boolean isGreaterThan(T that) {
        return compareTo(that) > 0;
    }
}
