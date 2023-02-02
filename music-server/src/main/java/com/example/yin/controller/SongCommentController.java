package com.example.yin.controller;

import com.example.yin.common.R;
import com.example.yin.model.request.SongCommentRequest;
import com.example.yin.service.SongCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongCommentController {
    @Autowired
    private SongCommentService songCommentService;


    // 提交评论
    @PostMapping("/song_comment/add")
    public R addComment(@RequestBody SongCommentRequest addSongCommentRequest) {
        return songCommentService.addComment(addSongCommentRequest);
    }

    // 删除评论
    @GetMapping("/song_comment/delete")
    public R deleteComment(@RequestParam Integer id) {
        return songCommentService.deleteComment(id);
    }

    // 获得指定歌曲 ID 的评论列表
    @GetMapping("/song_comment/song/detail")
    public R commentOfSongId(@RequestParam Integer songId) {
        return songCommentService.commentOfSongId(songId);
    }

    // 点赞
    @PostMapping("/song_comment/like")
    public R commentOfLike(@RequestBody SongCommentRequest upSongCommentRequest) {
        return songCommentService.updateCommentMsg(upSongCommentRequest);
    }
}
