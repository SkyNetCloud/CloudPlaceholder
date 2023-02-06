package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;

public class HpParser extends PartyParser {

    private final boolean isEv;

    public HpParser() {
        super(0);
        this.isEv = false;

    }

    protected HpParser(final int slot, final boolean isEv) {
        super(slot);
        this.isEv = isEv;
    }
    @Override
    public String getID() {
        return "party_" + this.slot + "_" + (this.isEv ? "ev" : "iv") + "_hp";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                SkyExpansion.registerParser(new HpParser(i, true));
                SkyExpansion.registerParser(new HpParser(i, false));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {

        return pokemon.getEVs().getStat(BattleStatsType.HP) + "";
    }
}
