package xyz.hooy.detail.remote.client;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.api.remote.CommentRemote;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class CommentRemoteClient implements CommentRemote {

    private final RestTemplate commentRemote;

    public CommentRemoteClient(@Qualifier("commentRemote") RestTemplate commentRemote) {
        this.commentRemote = commentRemote;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRemote.getForObject("http://comment-service/remote/comment/getCommentById/" + id, Comment.class);
    }

    @Override
    public List<Comment> getCommentsByDetailId(Long detailId) {
        Comment[] comments = commentRemote.getForObject("http://comment-service/remote/comment/getCommentsByDetailId/" + detailId, Comment[].class);
        return Objects.nonNull(comments) ? Arrays.asList(comments) : Collections.emptyList();
    }

    @Override
    public List<String> getCommentNamesByDetailId(Long detailId) {
        String[] commentNames = commentRemote.getForObject("http://comment-service/remote/comment/getCommentNamesByDetailId/" + detailId, String[].class);
        return Objects.nonNull(commentNames) ? Arrays.asList(commentNames) : Collections.emptyList();
    }

    @Override
    public List<String> getCommentContentsByDetailId(Long detailId) {
        String[] commentContents = commentRemote.getForObject("http://comment-service/remote/comment/getCommentContentsByDetailId/" + detailId, String[].class);
        return Objects.nonNull(commentContents) ? Arrays.asList(commentContents) : Collections.emptyList();
    }
}
