package pe.com.jdmm21.reddit.app.redditclone.service;

import org.springframework.stereotype.Service;

import pe.com.jdmm21.reddit.app.redditclone.model.Comment;
import pe.com.jdmm21.reddit.app.redditclone.repository.CommentRepository;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

}