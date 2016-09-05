package com.sinan.test.dao.specification;

import com.sinan.test.dao.entity.MovieEntity;
import com.sinan.test.dao.entity.RateEntity;
import com.sinan.test.dao.entity.UserEntity;
import com.sinan.test.dao.enums.GENRE;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.sql.Time;

/**
 * JPA Specification to search through movies
 *
 * @author Pezhman Jahanmard
 */
public class MovieSpecification extends BaseSpecification {

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

	/**
     * Given a parameter of "state", return the top 20 movies by average rating
     * when that movie has been watched between 6pm and midnight, EST.
     */
    public static Specification<MovieEntity> lateNightMovies() {
        return (root, query, cb) -> {
            Join<MovieEntity, RateEntity> rateJoin = root.join("rateEntities", JoinType.INNER);
            Predicate predicate = cb.greaterThanOrEqualTo(rateJoin.<Time>get("watchedTime"), new Time(18, 0, 0));
            predicate = updatePredicate(cb, predicate, cb.lessThanOrEqualTo(rateJoin.<Time>get("watchedTime"), new Time(23, 59, 59)));

            return predicate;
        };
    }

	/**
     * Given a genre such as "action" and a userId, return the top 5 movies for that genre by average rating,
     * where the rating was made by other users within 5 years (older and younger) of the user's age.
     */
    public static Specification<MovieEntity> findByGenreAndUserAge(GENRE genre, UserEntity userEntity) {
        return (root, query, cb) -> {
            java.util.Date birthdate = userEntity.getBirthdate();

            Join<MovieEntity, RateEntity> rateJoin = root.join("rateEntities", JoinType.INNER);
            Join<RateEntity, UserEntity> userJoin = rateJoin.join("userEntity", JoinType.INNER);

            //5 year older
            Predicate predicate = cb.lessThanOrEqualTo(userJoin.<Date>get("birthdate"),
                    new Date(birthdate.getYear() + 5, birthdate.getMonth(), birthdate.getDay()));
            //5 year younger
            predicate = updatePredicate(cb, predicate, cb.greaterThanOrEqualTo(userJoin.<Date>get("birthdate"),
                    new Date(birthdate.getYear() - 5, birthdate.getMonth(), birthdate.getDay())));

            //rate must not be for this user
            predicate = updatePredicate(cb, predicate, cb.notEqual(userJoin.<Integer>get("id"), userEntity.getId()));

            //find out the genre
            predicate = updatePredicate(cb, predicate, cb.equal(root.<GENRE>get("genre"), genre));

            return predicate;
        };
    }
}
