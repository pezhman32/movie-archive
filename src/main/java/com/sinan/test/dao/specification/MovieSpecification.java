package com.sinan.test.dao.specification;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.entity.RateEntity;
import com.sinan.test.dao.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * JPA Specification to search through movies
 *
 * @author Pezhman Jahanmard
 */
public class MovieSpecification {

	/**
     * Given a userId, return all movies that user has watched and the total count, as well as the rating for that movie.
     */
    public static Specification<MovieEntity> userMovies(Integer userId) {
        return (root, query, cb) -> {
            Join<MovieEntity, RateEntity> rateJoin = root.join("rateEntities", JoinType.INNER);
            Join<RateEntity, UserEntity> userJoin = rateJoin.join("userEntity", JoinType.INNER);
            Predicate predicate = cb.equal(userJoin.<Integer>get("id"), userId);

            return predicate;
        };
    }
}
