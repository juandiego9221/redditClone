package pe.com.jdmm21.reddit.app.redditclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    private short direction;
    @ManyToOne
    private Link link;

    public Vote() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Link return the link
     */
    public Link getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(Link link) {
        this.link = link;
    }

    /**
     * @return short return the direction
     */
    public short getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(short direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Vote [direction=" + direction + ", id=" + id + ", link=" + link + "]";
    }

}