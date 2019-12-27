package pe.com.jdmm21.reddit.app.redditclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote extends Auditable{
    @Id
    @GeneratedValue
    private Long id;
    private int vote;

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
     * @return int return the vote
     */
    public int getVote() {
        return vote;
    }

    /**
     * @param vote the vote to set
     */
    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Vote [id=" + id + ", vote=" + vote + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + vote;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vote other = (Vote) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (vote != other.vote)
            return false;
        return true;
    }

}