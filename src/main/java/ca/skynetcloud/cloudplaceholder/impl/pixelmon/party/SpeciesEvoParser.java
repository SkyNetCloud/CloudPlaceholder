package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

public class SpeciesEvoParser extends PartyParser  {

    public SpeciesEvoParser() {
        super(0);
    }

    protected SpeciesEvoParser(final int slot) {
        super(slot);
    }


    @Override
    public String getID() {
        return "party_" + this.slot + "_specisoevo";
    }

    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new SpeciesEvoParser(i));
        }
    }


    @Override
    public Object parse(final Player player, final Pokemon species, final String[] args) {
        return species.getSpecies().getDefaultForm().getPreEvolutions().listIterator().toString();
    }

}
