package ca.skynetcloud.cloudplaceholder.impl.pixelmon.party;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.impl.pixelmon.PartyParser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.util.helpers.SpriteItemHelper;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PartyNbtParser extends PartyParser {

    public PartyNbtParser() {
        super(0);
    }

    protected PartyNbtParser(final int slot) {
        super(slot);
    }
    @Override
    public String getID() {
        return "party_" + this.slot + "_nbt";
    }
    @Override
    public void register() {
        for (int i = 1; i <= 6; ++i) {
            SkyExpansion.registerParser(new PartyNbtParser(i));
        }
    }

    @Override
    public Object parse(Player p0, Pokemon p1, String[] p2) {
        return Objects.requireNonNull(SpriteItemHelper.getPhoto(p1).getTag()).toString();
    }
}
