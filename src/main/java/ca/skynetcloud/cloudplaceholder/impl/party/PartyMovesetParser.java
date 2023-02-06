package ca.skynetcloud.cloudplaceholder.impl.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class PartyMovesetParser extends PartyParser {

    public PartyMovesetParser() {
        super(0);
    }

    protected PartyMovesetParser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
            return "party_" + this.slot + "_moveset";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new PartyMovesetParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon pokemon, String[] p2) {
        if (pokemon.getMoveset().isEmpty()) {
            return "N/A";
        }

        return Arrays.stream(pokemon.getMoveset().attacks).toArray();


    }
}
