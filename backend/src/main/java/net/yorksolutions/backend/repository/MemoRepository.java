package net.yorksolutions.backend.repository;

import net.yorksolutions.backend.entity.Memo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends CrudRepository<Memo, Long> {
    public Iterable<Memo> findByTextContaining(String text);
}
