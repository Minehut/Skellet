package com.gmail.thelimeglass.Disguises;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.gmail.thelimeglass.Utils.Annotations.*;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Syntax("[skellett] [[Libs]Disguises] [(the|all)] [of] [the] client [viewed] disguise[[']s] [of] %entity%")
@Config("PluginHooks.LibsDisguises")
@FullConfig
@MainConfig
@PropertyType(ExpressionType.COMBINED)
public class ExprClientDisguises extends SimpleExpression<Disguise> {

    private Expression<Entity> entity;

    public Class<? extends Disguise> getReturnType() {
        return Disguise.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] e, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        entity = (Expression<Entity>) e[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[(the|all)] [of] [the] [client] [viewed] disguise[[']s] [of] %entity%";
    }

    @Override
    @Nullable
    protected Disguise[] get(Event e) {
        if (DisguiseAPI.getDisguises(entity.getSingle(e)) != null) {
            return DisguiseAPI.getDisguises(entity.getSingle(e));
        }
        return null;
    }
}