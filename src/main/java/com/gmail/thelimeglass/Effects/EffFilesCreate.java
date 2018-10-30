package com.gmail.thelimeglass.Effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.thelimeglass.Utils.Annotations.Config;
import com.gmail.thelimeglass.Utils.Annotations.FullConfig;
import com.gmail.thelimeglass.Utils.Annotations.Syntax;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Syntax("[skellett] c[reate][ ][f][ile] %string%")
@Config("Main.Files")
@FullConfig
public class EffFilesCreate extends Effect {

    private Expression<String> file;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
        file = (Expression<String>) e[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event paramEvent, boolean paramBoolean) {
        return "[skellett] c[reate][ ][f][ile] %string%";
    }

    @Override
    protected void execute(Event e) {
        throw new UnsupportedOperationException("create file not supported");

    }
}
