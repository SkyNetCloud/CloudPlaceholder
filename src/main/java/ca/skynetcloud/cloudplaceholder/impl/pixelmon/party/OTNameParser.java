package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class OTNameParser extends PartyParser {

    public OTNameParser() {
        super(0);
    }

    protected OTNameParser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_ot_" + this.slot + "_name";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new OTNameParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {
        return p1.getOriginalTrainer();
    }
}
