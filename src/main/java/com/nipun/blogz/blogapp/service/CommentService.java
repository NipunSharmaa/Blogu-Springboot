package com.nipun.blogz.blogapp.service;

import com.nipun.blogz.blogapp.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);
}
