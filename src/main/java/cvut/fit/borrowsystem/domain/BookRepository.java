package cvut.fit.borrowsystem.domain;

import cvut.fit.borrowsystem.domain.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Item repository.
 * Created by Jakub Tuček on 2.4.2016.
 */

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(@Param("isbn") int isbn);

    Book findByItemName(@Param("itemName") String itemName);

}
