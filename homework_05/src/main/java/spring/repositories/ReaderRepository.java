package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.models.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
