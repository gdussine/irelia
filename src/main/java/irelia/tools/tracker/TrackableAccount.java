package irelia.tools.tracker;

import irelia.data.account.Account;

public class TrackableAccount implements Trackable {

    private Account account;
    private long gameId;

    public TrackableAccount(Account account) {
        this.account = account;
    }

    @Override
    public String getPuuid() {
        return account.getPuuid();
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return account.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
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
        TrackableAccount other = (TrackableAccount) obj;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        return true;
    }


    
    

    

}
