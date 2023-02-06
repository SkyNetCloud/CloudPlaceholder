package ca.skynetcloud.cloudplaceholder.impl.party.ivs;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import org.bukkit.entity.Player;

public class PartyIvSPDefenceParser extends PartyParser {

    private final BattleStatsType stat;

    public PartyIvSPDefenceParser() {
        super(0);
        this.stat = BattleStatsType.NONE;

    }

    protected PartyIvSPDefenceParser(final int slot, final BattleStatsType stat) {
        super(slot);
        this.stat = stat;
    }

    @Override
    public String getID() {
        return "party_" + this.slot + "_iv_spd";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
                SkyExpansion.registerParser(new PartyIvSPDefenceParser(i, stat));
        }
    }

    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        return pokemon.getIVs().getStat(BattleStatsType.SPECIAL_DEFENSE);
    }
}
