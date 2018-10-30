package com.gmail.thelimeglass.Expressions;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.ExpressionType;
import com.gmail.thelimeglass.Utils.Annotations.Config;
import com.gmail.thelimeglass.Utils.Annotations.FullConfig;
import com.gmail.thelimeglass.Utils.Annotations.PropertyType;
import com.gmail.thelimeglass.Utils.Annotations.Syntax;
import org.bukkit.World;

import javax.annotation.Nullable;

@Syntax("world folder of %world%")
@FullConfig
@Config("Syntax.Effects.World")
@PropertyType(ExpressionType.PROPERTY)
public class ExprWorldFolder extends SimplePropertyExpression<World, String> {

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    protected String getPropertyName() {
        return "world folder";
    }

    @Override
    @Nullable
    public String convert(World world) {
        return world.getWorldFolder().toPath().toString();
    }
}