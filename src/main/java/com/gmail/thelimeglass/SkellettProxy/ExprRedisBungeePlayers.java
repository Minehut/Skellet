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
import java.util.Set;
import java.util.UUID;

@Syntax("[(the|all)] [of] [the] redis[[ ]bungee] players")
@Config("PluginHooks.RedisBungee")
@FullConfig
@MainConfig
@PropertyType(ExpressionType.COMBINED)
public class ExprRedisBungeePlayers extends SimpleExpression<String> {

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[(the|all)] [of] [the] redis[[ ]bungee] players";
    }

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    protected String[] get(Event e) {
        Object socket = Sockets.send(new SkellettPacket(true, null, SkellettPacketType.REDISPLAYERS));
        ArrayList<String> data = new ArrayList<String>();
        for (UUID uuid : (Set<UUID>) socket) {
            data.add(uuid.toString());
        }
        return data.toArray(new String[data.size()]);
    }
}