package com.brs.oa.comm.fieldAuth;

import java.util.function.Function;

public interface Filterable<T> {
    void doFilter(Function <T, T> filterFunction);
}
