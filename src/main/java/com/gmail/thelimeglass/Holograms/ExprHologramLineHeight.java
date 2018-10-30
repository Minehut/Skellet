package com.gmail.thelimeglass.Holograms;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.gmail.thelimeglass.Utils.Annotations.*;
import com.sainttx.holograms.api.line.HologramLine;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Syntax("[the] [skellett] height of holo[gram] line %hologramline%")
@Config("PluginHooks.Holograms")
@FullConfig
@MainConfig
@PropertyType(ExpressionType.COMBINED)
public class ExprHologramLineHeight extends SimpleExpression<Number> {

    private Expression<HologramLine> hologramline;

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] e, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        hologramline = (Expression<HologramLine>) e[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[the] [skellett] height of holo[gram] line %hologramline%";
    }

    @Override
    @Nullable
    protected Number[] get(Event e) {
        if (hologramline != null) {
            return new Number[]{hologramline.getSingle(e).getHeight()};
        }
        return null;
    }
}