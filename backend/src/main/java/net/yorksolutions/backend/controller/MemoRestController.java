package net.yorksolutions.backend.controller;

import net.yorksolutions.backend.entity.Memo;
import net.yorksolutions.backend.service.MemoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memo")
@CrossOrigin
public class MemoRestController {

    private MemoService memoService;

    public MemoRestController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public Memo create(@RequestBody Memo memo) {
        return memoService.create(memo.getText());
    }
}
