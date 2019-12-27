package pe.com.jdmm21.reddit.app.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.jdmm21.reddit.app.redditclone.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
    
}