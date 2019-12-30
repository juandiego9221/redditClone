package pe.com.jdmm21.reddit.app.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.jdmm21.reddit.app.redditclone.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    
}