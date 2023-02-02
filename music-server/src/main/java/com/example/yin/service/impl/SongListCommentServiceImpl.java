package com.example.yin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.common.R;
import com.example.yin.mapper.SongListCommentMapper;
import com.example.yin.model.domain.SongListComment;
import com.example.yin.model.request.SongListCommentRequest;
import com.example.yin.service.SongListCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongListCommentServiceImpl extends ServiceImpl<SongListCommentMapper, SongListComment> implements SongListCommentService {
    @Autowired
    private SongListCommentMapper songListCommentMapper;

    @Override
    public R addComment(SongListCommentRequest addSongListCommentRequest) {
        SongListComment songListComment = new SongListComment();
        BeanUtils.copyProperties(addSongListCommentRequest, songListComment);
        songListComment.setType(addSongListCommentRequest.getNowType());
        if (songListCommentMapper.insert(songListComment) > 0) {
            return R.success("评论成功");
        } else {
            return R.error("评论失败");
        }
    }

    @Override
    public R updateCommentMsg(SongListCommentRequest addSongListCommentRequest) {
        SongListComment songListComment = new SongListComment();
        BeanUtils.copyProperties(addSongListCommentRequest, songListComment);
        if (songListCommentMapper.updateById(songListComment) > 0) {
            return R.success("点赞成功");
        } else {
            return R.error("点赞失败");
        }
    }

    //    删除评论
    @Override
    public R deleteComment(Integer id) {
        if (songListCommentMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R commentOfSongListId(Integer songListId) {
        QueryWrapper<SongListComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("song_list_id",songListId);
        return R.success(null, songListCommentMapper.selectList(queryWrapper));
    }
}
