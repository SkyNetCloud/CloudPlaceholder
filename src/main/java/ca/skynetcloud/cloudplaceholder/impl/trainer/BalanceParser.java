

package ca.skynetcloud.cloudplaceholder.impl.trainer;

import ca.skynetcloud.cloudplaceholder.SkyExpansion;
import ca.skynetcloud.cloudplaceholder.api.Parser;
import com.pixelmonmod.pixelmon.api.economy.BankAccount;
import com.pixelmonmod.pixelmon.api.economy.BankAccountProxy;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public class BalanceParser implements Parser
{
    private static final String ID = "trainer_balance";
    
    @Override
    public String getID() {
        return "trainer_balance";
    }
    
    @Override
    public void register() {
        SkyExpansion.registerParser(this);
    }

    @Override
    public Object parse(final Player player, final String[] args) {
        final Optional<? extends BankAccount> bankAccount = BankAccountProxy.getBankAccount(player.getUniqueId());
        return bankAccount.map((Function<? super BankAccount, ? extends BigDecimal>)BankAccount::getBalance);
    }
}
