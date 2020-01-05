package pe.com.jdmm21.reddit.app.redditclone.service;

import org.springframework.stereotype.Service;

import pe.com.jdmm21.reddit.app.redditclone.model.Role;
import pe.com.jdmm21.reddit.app.redditclone.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
    
}