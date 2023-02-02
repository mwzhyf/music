package com.example.yin.controller;

import com.example.yin.common.R;
import com.example.yin.model.request.SongListCommentRequest;
import com.example.yin.service.SongListCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongListCommentController {
    @Autowired
    private SongListCommentService songListCommentService;


    // 提交评论
    @PostMapping("/comment/add")
    public R addComment(@RequestBody SongListCommentRequest addSongListCommentRequest) {
        return songListCommentService.addComment(addSongListCommentRequest);
    }

    // 删除评论
    @GetMapping("/comment/delete")
    public R deleteComment(@RequestParam Integer id) {
        return songListCommentService.deleteComment(id);
    }

    // 获得指定歌单 ID 的评论列表
    @GetMapping("/comment/songList/detail")
    public R commentOfSongListId(@RequestParam Integer songListId) {
        return songListCommentService.commentOfSongListId(songListId);
    }

    // 点赞
    @PostMapping("/comment/like")
    public R commentOfLike(@RequestBody SongListCommentRequest upSongListCommentRequest) {
        return songListCommentService.updateCommentMsg(upSongListCommentRequest);
    }
}
