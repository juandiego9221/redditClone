package pe.com.jdmm21.reddit.app.redditclone.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pe.com.jdmm21.reddit.app.redditclone.model.Link;
import pe.com.jdmm21.reddit.app.redditclone.model.Vote;
import pe.com.jdmm21.reddit.app.redditclone.repository.LinkRepository;
import pe.com.jdmm21.reddit.app.redditclone.repository.VoteRepository;

@RestController
public class VoteController {

    private VoteRepository voteRepository;
    private LinkRepository linkRepository;

    public VoteController(VoteRepository voteRepository, LinkRepository linkRepository) {
        this.voteRepository = voteRepository;
        this.linkRepository = linkRepository;
    }

    @GetMapping("/vote/link/{linkId}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkId, @PathVariable short direction, @PathVariable int voteCount

    ) {
        Optional<Link> foundLink = linkRepository.findById(linkId);
        if(foundLink.isPresent()){
            Link link = new Link();
            Vote vote = new Vote();
            vote.setDirection(direction);
            vote.setLink(link);
            voteRepository.save(vote);

            int updateVoteCount = voteCount + direction;
            link.setVoteCount(updateVoteCount);
            linkRepository.save(link);
            return updateVoteCount;
        }
        return voteCount;
    }

}