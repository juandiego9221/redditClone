package pe.com.jdmm21.reddit.app.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.jdmm21.reddit.app.redditclone.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long>{

    Link findByTitle(String title);
    
}