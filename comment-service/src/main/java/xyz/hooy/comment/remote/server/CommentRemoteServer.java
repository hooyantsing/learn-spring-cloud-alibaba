package xyz.hooy.comment.remote.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.comment.api.remote.CommentRemote;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/remote/comment")
public class CommentRemoteServer implements CommentRemote {

    private final CommentService commentService;

    @Override
    @GetMapping("/getCommentById/{id}")
    public Comment getCommentById(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @Override
    @GetMapping("/getCommentsByDetailId/{detailId}")
    public List<Comment> getCommentsByDetailId(@PathVariable("detailId") Long detailId) {
        return commentService.getCommentsByDetailId(detailId);
    }

    @Override
    @GetMapping("/getCommentNamesByDetailId/{detailId}")
    public List<String> getCommentNamesByDetailId(@PathVariable("detailId") Long detailId) {
        return commentService.getCommentNamesByDetailId(detailId);
    }

    @Override
    @GetMapping("/getCommentContentsByDetailId/{detailId}")
    public List<String> getCommentContentsByDetailId(@PathVariable("detailId") Long detailId) {
        return commentService.getCommentContentsByDetailId(detailId);
    }
}
