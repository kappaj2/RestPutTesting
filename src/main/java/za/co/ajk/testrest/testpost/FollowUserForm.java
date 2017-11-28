package za.co.ajk.testrest.testpost;

import java.io.Serializable;


public class FollowUserForm implements Serializable {
    private long followId;
    private boolean follow;
    
    public long getFollowId() {
        return followId;
    }
    
    public void setFollowId(long followId) {
        this.followId = followId;
    }
    
    public boolean isFollow() {
        return follow;
    }
    
    public void setFollow(boolean follow) {
        this.follow = follow;
    }
    
    @Override
    public String toString() {
        return "FollowUserForm{" +
                "followId=" + followId +
                ", follow=" + follow +
                '}';
    }
}
