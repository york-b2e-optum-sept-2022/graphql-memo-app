package net.yorksolutions.backend.service;

import net.yorksolutions.backend.dto.MemoFilter;
import net.yorksolutions.backend.entity.Foo;
import net.yorksolutions.backend.entity.Memo;
import net.yorksolutions.backend.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MemoService {

    private MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo create(String text) {
        Random rand = new Random();

        Memo memo = new Memo(text);
        Foo foo = new Foo(rand.nextInt());
        memo.getFooList().add(foo);

        return memoRepository.save(memo);
    }

    public Iterable<Memo> getAll() {
        return memoRepository.findAll();
    }

    public Iterable<Memo> getAll(MemoFilter memoFilter) {
        return memoRepository.findByTextContaining(
                memoFilter.getText()
        );
    }

}
