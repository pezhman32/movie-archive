package com.sinan.test.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/**
 * JPA Specification to search through movies
 *
 * @author Pezhman Jahanmard
 */
public abstract class BaseSpecification {

    protected static Predicate updatePredicate(CriteriaBuilder cb, Predicate predicate, Predicate openPredicate) {
        predicate = cb.and(predicate, openPredicate);
        return predicate;
    }
}
