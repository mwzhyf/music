package com.example.yin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.common.R;
import com.example.yin.model.domain.SongComment;
import com.example.yin.model.request.SongCommentRequest;

public interface SongCommentService extends IService<SongComment> {

    R addComment(SongCommentRequest addSongCommentRequest);

    R updateCommentMsg(SongCommentRequest upSongCommentRequest);

    R deleteComment(Integer id);

    R commentOfSongId(Integer songId);


}
