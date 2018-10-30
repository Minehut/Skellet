package com.gmail.thelimeglass.Npcs;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import com.gmail.thelimeglass.Utils.Annotations.*;
import net.citizensnpcs.api.event.NPCCombustEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Syntax("[the] (citizen|npc) [event[(-| )]](combust[ion]|ignition) time")
@Config("PluginHooks.Npc")
@FullConfig
@MainConfig
@PropertyType(ExpressionType.SIMPLE)
public class ExprEventNpcCombustTime extends SimpleExpression<Number> {

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public boolean init(Expression<?>[] e, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1) {
        return "[the] (citizen|npc) [event[(-| )]](combust[ion]|ignition) time";
    }

    @Override
    @Nullable
    protected Number[] get(Event e) {
        if (NPCCombustEvent.class.isAssignableFrom(e.getClass())) {
            return new Number[]{((NPCCombustEvent) e).getDuration()};
        }
        return null;
    }

    @Override
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        if (mode == ChangeMode.SET) {
            if (NPCCombustEvent.class.isAssignableFrom(e.getClass())) {
                Number time = (Number) delta[0];
                ((NPCCombustEvent) e).setDuration(time.intValue());
            }
        }
    }

    @Override
    public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
        if (mode == ChangeMode.SET) {
            return CollectionUtils.array(Number.class);
        }
        return null;
    }
}