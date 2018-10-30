package com.gmail.thelimeglass.SkellettProxy;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.gmail.thelimeglass.SkellettPacket;
import com.gmail.thelimeglass.SkellettPacketType;
import com.gmail.thelimeglass.Sockets;
import com.gmail.thelimeglass.Utils.Annotations.*;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.ArrayList;

@Syntax("[(the|all)] [of] [the] whitelisted players (for|of|on) (skellett[ ][(cord|proxy)]|bungee[ ][cord]) server %string%")
@Config("SkellettProxy")
@FullConfig
@SkellettProxy
@PropertyType(ExpressionType.COMBINED)
public class ExprBungeeWhitelistedPlayers extends SimpleExpression<String> {

    private Expression<String> server;

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
        server = (Expression<String>) e[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[(the|all)] [of] [the] whitelisted players (for|of|on) (skellett[ ][(cord|proxy)]|bungee[ ][cord]) server %string%";
    }

    @Override
    @Nullable
    protected String[] get(Event e) {
        @SuppressWarnings("unchecked")
        ArrayList<String> whitelisted = (ArrayList<String>) Sockets.send(new SkellettPacket(true, server.getSingle(e), SkellettPacketType.WHITELISTED));
        if (whitelisted != null) {
            return whitelisted.toArray(new String[whitelisted.size()]);
        }
        return null;
    }
}