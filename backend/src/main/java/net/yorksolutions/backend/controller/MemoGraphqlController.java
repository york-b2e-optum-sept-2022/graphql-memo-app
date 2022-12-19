package net.yorksolutions.backend.controller;

import net.yorksolutions.backend.dto.MemoFilter;
import net.yorksolutions.backend.dto.NewMemo;
import net.yorksolutions.backend.entity.Memo;
import net.yorksolutions.backend.service.MemoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MemoGraphqlController {

    MemoService memoService;

    public MemoGraphqlController(MemoService memoService) {
        this.memoService = memoService;
    }

    @QueryMapping
    public Iterable<Memo> memoList(@Argument MemoFilter filter) {
        if (filter != null) {
            return memoService.getAll(filter);
        }

        return memoService.getAll();
    }

    @MutationMapping
    public Memo createMemo(@Argument NewMemo memo) {
        return memoService.create(memo.getText());
    }
}
