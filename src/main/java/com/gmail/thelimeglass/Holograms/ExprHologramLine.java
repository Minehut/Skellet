package com.gmail.thelimeglass.Holograms;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.gmail.thelimeglass.Utils.Annotations.*;
import com.sainttx.holograms.api.Hologram;
import com.sainttx.holograms.api.line.HologramLine;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Syntax("[the] [skellett] holo[gram] line %number% (in|from|of) %hologram%")
@Config("PluginHooks.Holograms")
@FullConfig
@MainConfig
@PropertyType(ExpressionType.COMBINED)
@RegisterSimpleEnum(ExprClass = HologramLine.class, value = "hologramline")
public class ExprHologramLine extends SimpleExpression<HologramLine> {

    private Expression<Number> line;
    private Expression<Hologram> hologram;

    @Override
    public Class<? extends HologramLine> getReturnType() {
        return HologramLine.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] e, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        line = (Expression<Number>) e[0];
        hologram = (Expression<Hologram>) e[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[the] [skellett] holo[gram] line %number% (in|from|of) %hologram%";
    }

    @Override
    @Nullable
    protected HologramLine[] get(Event e) {
        if (hologram != null || line != null) {
            HologramLine hololine = hologram.getSingle(e).getLine(line.getSingle(e).intValue());
            if (hololine != null) {
                return new HologramLine[]{hologram.getSingle(e).getLine(line.getSingle(e).intValue())};
            }
        }
        return null;
    }
}