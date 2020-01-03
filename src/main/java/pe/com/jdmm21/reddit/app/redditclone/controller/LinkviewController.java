package pe.com.jdmm21.reddit.app.redditclone.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.jdmm21.reddit.app.redditclone.model.Comment;
import pe.com.jdmm21.reddit.app.redditclone.model.Link;
import pe.com.jdmm21.reddit.app.redditclone.repository.CommentRepository;
import pe.com.jdmm21.reddit.app.redditclone.repository.LinkRepository;

@Controller
public class LinkviewController {

    public static final Logger LOGGER = LoggerFactory.getLogger(LinkviewController.class);

    private LinkRepository linkRepository;
    private CommentRepository commentRepository;


    public LinkviewController(LinkRepository linkRepository, CommentRepository commentRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }

    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {
        // Optional<Link> foundLink = linkRepository.findById(id);
        // if (foundLink.isPresent()) {

        // }
        Optional<Link> linkFound = linkRepository.findById(id);
        if (linkFound.isPresent()) {
            Link currentLink = linkFound.get();
            Comment comment = new Comment();
            comment.setLink(currentLink);
            model.addAttribute("comment", comment);

            model.addAttribute("link", linkFound.get());
            model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link", new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            LOGGER.info("validation errors were found");
            model.addAttribute("link", link);
            return "link/submit";
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            link.setCreationDate(localDateTime);
            link.setLastModifiedDate(localDateTime);
            linkRepository.save(link);
            LOGGER.info("new link were sucessusfully saved with id: " + link.getId());
            model.addAttribute("id", link.getId()).addAttribute("success", true);
            return "redirect:/link/" + link.getId();
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/link/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            LOGGER.info("There was a problem adding new comment");
        }else{
            commentRepository.save(comment);
            LOGGER.info("comment was saved");
        }
        return "redirect:/link/"+comment.getLink().getId();
    }

}