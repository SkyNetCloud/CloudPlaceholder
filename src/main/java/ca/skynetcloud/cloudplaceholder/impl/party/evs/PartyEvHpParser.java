package ca.skynetcloud.cloudplaceholder.impl.party.evs;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;

public class PartyEvHpParser extends PartyParser {

    private final BattleStatsType stat;

    public PartyEvHpParser() {
        super(0);
        this.stat = BattleStatsType.NONE;

    }

    protected PartyEvHpParser(final int slot, final BattleStatsType stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_ev_hp";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            for (final BattleStatsType stat : BattleStatsType.getAllBattleStatValues()) {
                SkyExpansion.registerParser(new PartyEvHpParser(i, stat));
            }
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getEVs().getStat(BattleStatsType.HP);
    }
}

