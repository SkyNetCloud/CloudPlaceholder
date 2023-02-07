package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import org.bukkit.entity.Player;

import java.util.List;

public class PreEvoParser extends PartyParser  {

    public PreEvoParser() {
        super(0);
    }

    protected PreEvoParser(final int slot) {
        super(slot);
    }


    @Override
    public String getID() {
        return "party_" + this.slot + "_pre_evo";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new PreEvoParser(i));
        }
    }


    @Override
    public Object parse(final Player player, final Pokemon pokemon, final String[] args) {
        List<Species> species = Lists.newArrayList();
        return  species.stream().map(n-> pokemon.getSpecies().getDefaultForm().getPreEvolutions()).toArray();
    }

}
