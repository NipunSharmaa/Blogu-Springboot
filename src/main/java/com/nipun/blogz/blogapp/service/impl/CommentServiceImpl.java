package com.nipun.blogz.blogapp.service.impl;

import com.nipun.blogz.blogapp.entity.Comment;
import com.nipun.blogz.blogapp.entity.Post;
import com.nipun.blogz.blogapp.exceptions.ResourceNotFoundException;
import com.nipun.blogz.blogapp.payload.CommentDto;
import com.nipun.blogz.blogapp.repository.CommentRepo;
import com.nipun.blogz.blogapp.repository.PostRepo;
import com.nipun.blogz.blogapp.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
   private PostRepo postRepo;
   @Autowired
    private CommentRepo commentRepo;

   @Autowired
   private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
        Comment comment= this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);
        Comment savedComment= this.commentRepo.save(comment);
        return this.modelMapper.map(commentDto, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment=this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment id", commentId));
        this.commentRepo.delete(comment);
    }
}
