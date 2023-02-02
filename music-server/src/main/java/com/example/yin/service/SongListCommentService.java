package com.example.yin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.common.R;
import com.example.yin.model.domain.SongListComment;
import com.example.yin.model.request.SongListCommentRequest;

public interface SongListCommentService extends IService<SongListComment> {

    R addComment(SongListCommentRequest addSongListCommentRequest);

    R updateCommentMsg(SongListCommentRequest upSongListCommentRequest);

    R deleteComment(Integer id);

    R commentOfSongListId(Integer songListId);

}
