package com.alibaba.ttl;

/**
 * Disable inheritable feature by {@link InheritableThreadLocal} to prevent potential leaking problem.
 *
 * @author Yang Fang (snoop dot fy at gmail dot com)
 * @since 2.2.2
 */
public class NoInheritableTTL<T> extends TransmittableThreadLocal<T> {

    @Override
    protected T childValue(T parentValue) {
        return null;
    }
}
