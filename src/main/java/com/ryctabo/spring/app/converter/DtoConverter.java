package com.ryctabo.spring.app.converter;

import java.io.Serializable;

/**
 * The <strong>DtoConverter</strong> interface contains all methods to convert the entities to data
 * transfer objects and vice versa.
 *
 * @param <E> the entity class
 * @param <Q> the data transfer object to request
 * @param <S> the data transfer object ot respond
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public interface DtoConverter<E extends Serializable, Q, S> {

    /**
     * Convert the data transfer object of the request to an entity.
     *
     * @param data the data transfer object
     * @return entity
     */
    E convertToEntity(Q data);

    /**
     * Convert the entity to a data transfer object of the respond.
     *
     * @param entity the entity
     * @return data transfer object
     */
    S convertToDto(E entity);
}
