package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party.movesets;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class PartyMoveset3Parser extends PartyParser {

    public PartyMoveset3Parser() {
        super(0);
    }

    protected PartyMoveset3Parser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_" + this.slot + "_three" + "_moveset";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new PartyMoveset3Parser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {
        if (pokemon == null || pokemon.getMoveset().isEmpty() || pokemon.getMoveset().attacks[2] == null) {
            return "N/A";
        }
        return pokemon.getMoveset().attacks[2].getMove().getAttackName();
    }
}
