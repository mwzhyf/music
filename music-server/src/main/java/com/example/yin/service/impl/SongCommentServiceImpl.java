package com.example.yin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.common.R;
import com.example.yin.mapper.SongCommentMapper;
import com.example.yin.model.domain.SongComment;
import com.example.yin.model.request.SongCommentRequest;
import com.example.yin.service.SongCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SongCommentServiceImpl extends ServiceImpl<SongCommentMapper, SongComment> implements SongCommentService {
    @Autowired
    private SongCommentMapper songCommentMapper;

    @Override
    public R addComment(SongCommentRequest addSongCommentRequest) {
        SongComment songComment = new SongComment();
        BeanUtils.copyProperties(addSongCommentRequest, songComment);
        songComment.setType(addSongCommentRequest.getNowType());
        if (songCommentMapper.insert(songComment) > 0) {
            return R.success("评论成功");
        } else {
            return R.error("评论失败");
        }
    }

    @Override
    public R updateCommentMsg(SongCommentRequest addSongCommentRequest) {
        SongComment songComment = new SongComment();
        BeanUtils.copyProperties(addSongCommentRequest, songComment);
        if (songCommentMapper.updateById(songComment) > 0) {
            return R.success("点赞成功");
        } else {
            return R.error("点赞失败");
        }
    }

    //    删除评论
    @Override
    public R deleteComment(Integer id) {
        if (songCommentMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R commentOfSongId(Integer songId) {
        QueryWrapper<SongComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("song_id",songId);
        return R.success(null, songCommentMapper.selectList(queryWrapper));
    }
}

