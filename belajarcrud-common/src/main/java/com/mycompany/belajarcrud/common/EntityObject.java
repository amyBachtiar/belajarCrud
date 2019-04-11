package com.mycompany.belajarcrud.common;

import java.io.Serializable;

/**
 * An entity, as explained in the DDD model
 *  
 */
public interface EntityObject<T> extends Serializable {

  boolean sameIdentityAs(T other);

}
