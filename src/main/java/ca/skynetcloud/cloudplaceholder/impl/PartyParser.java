package ca.skynetcloud.cloudplaceholder.impl;

import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import org.bukkit.entity.Player;

import java.util.Arrays;

public abstract class PartyParser implements Parser {
    protected final int slot;
    protected  static final String PARTY_PREFIX = "party_";

    protected PartyParser(final int slot){
        this.slot = slot;
    }
    @Override
    public Object parse(final Player player, final String[] args){
        final Pokemon pokemon = this.getPokemon(player, this.slot);
        final String[] trimmed = (args.length >= 3) ? Arrays.copyOfRange(args, 2, args.length) : new String[0];
        if (pokemon == null)  {
            return "";
        }
        return this.parse(player,pokemon,trimmed);
    }
    public abstract Object parse(final Player p0, final Pokemon p1, final String[] p2);
}
