package cvut.fit.borrowsystem.domain;

import cvut.fit.borrowsystem.domain.entity.Borrow;
import cvut.fit.borrowsystem.domain.entity.Item;
import cvut.fit.borrowsystem.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jakub Tuček on 2.4.2016.
 */

@Repository
public interface BorrowRepository extends MongoRepository<Borrow, String> {
    List<Borrow> findByUser(@Param("user") User user);

    List<Borrow> findByReturned(@Param("returned") boolean returned);

    List<Borrow> findByItemAndReturned(@Param("item") Item item, @Param("returned") boolean returned);

    Long countBorrowedByItemAndReturned(@Param("item") Item item, @Param("returned") boolean returned);

}
