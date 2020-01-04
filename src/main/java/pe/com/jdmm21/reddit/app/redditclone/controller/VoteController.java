package pe.com.jdmm21.reddit.app.redditclone.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pe.com.jdmm21.reddit.app.redditclone.model.Link;
import pe.com.jdmm21.reddit.app.redditclone.model.Vote;
import pe.com.jdmm21.reddit.app.redditclone.service.LinkService;
import pe.com.jdmm21.reddit.app.redditclone.service.VoteService;

@RestController
public class VoteController {
    private VoteService voteService;
    private LinkService linkService;

    public VoteController(VoteService voteService, LinkService linkService) {
        this.voteService = voteService;
        this.linkService = linkService;
    }

    @GetMapping("/vote/link/{linkId}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkId, @PathVariable short direction, @PathVariable int voteCount

    ) {
        Optional<Link> foundLink = linkService.findById(linkId);
        if(foundLink.isPresent()){
            Link link = new Link();
            Vote vote = new Vote();
            vote.setDirection(direction);
            vote.setLink(link);
            voteService.save(vote);

            int updateVoteCount = voteCount + direction;
            link.setVoteCount(updateVoteCount);
            linkService.save(link);
            return updateVoteCount;
        }
        return voteCount;
    }

}