package pe.com.jdmm21.reddit.app.redditclone.service;

import org.springframework.stereotype.Service;

import pe.com.jdmm21.reddit.app.redditclone.model.Vote;
import pe.com.jdmm21.reddit.app.redditclone.repository.VoteRepository;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository){
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote){
        return voteRepository.save(vote);
    }


    
}