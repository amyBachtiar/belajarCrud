package com.eksad.dam.master.data.common.object.stereotype;

import java.io.Serializable;

/**
 *
 * @author bayutridewanto
 */
public interface AggregateObject<T> extends Serializable {

    boolean sameIdentityAs(T other);
}
