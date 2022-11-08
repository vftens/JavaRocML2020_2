package fesva.com;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    default Book findByTitle(String title) {
        return null;
    }
}
//----------------------------------------------------------------}
