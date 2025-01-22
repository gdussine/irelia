package irelia.tools;

import java.util.ArrayList;
import java.util.List;

import irelia.core.Irelia;
import irelia.data.account.Account;

public class SampleAccountProvider {

    enum SampleRiotId {
        MITSUKO("mitsuko#ema"),
        ADRY("Adry#metal"),
        GUILLAUME("Guillaume#TOP"),
        SERGE("Lukuu#EUW"),
        BOZO("Bozo le Cl0wn#EUW"),
        RAMZy("Yayalol91#EUW"),
        REDDISH("Backsh0t#sigma");

        private String riotId;

        private SampleRiotId(String riotId) {
            this.riotId = riotId;
        }

        public String getRiotId() {
            return riotId;
        }
    }

    private List<Account> samples;
    private Irelia irelia;

    public SampleAccountProvider(Irelia irelia) {
        this.irelia = irelia;
        this.load();
    }

    public void load() {
        this.samples = new ArrayList<>();
        for (SampleRiotId id : SampleRiotId.values()) {
            samples.add(this.irelia.account().byRiotId(id.getRiotId()).join());
        }
    }

    public List<Account> getSamples() {
        return samples;
    }

}
