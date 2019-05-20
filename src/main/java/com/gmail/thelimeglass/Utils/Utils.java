package com.gmail.thelimeglass.Utils;

import com.gmail.thelimeglass.Skellett;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Utils {

    public static Object getEnum(@SuppressWarnings("rawtypes") Class clazz, String object) {
        Object value = null;
        try {
            @SuppressWarnings("unchecked") final Method method = clazz.getMethod("valueOf", String.class);
            method.setAccessible(true);
            value = method.invoke(clazz, object.replace("\"", "").trim().replace(" ", "_").toUpperCase());
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException error) {
            Bukkit.getConsoleSender().sendMessage(Skellett.cc(Skellett.prefix + "&cUnknown type " + object + " in " + clazz.getName()));
        }
        return value;
    }

    public static boolean ofRow(Integer row, Integer slot, Inventory inventory) {
        if (slot != null && row != null) {
            Integer mod = 9;
            if (inventory != null) {
                if (inventory.getType() == InventoryType.DISPENSER || inventory.getType() == InventoryType.WORKBENCH || inventory.getType() == InventoryType.DROPPER) {
                    mod = 3;
                } else if (inventory.getType() == InventoryType.CHEST || inventory.getType() == InventoryType.SHULKER_BOX || inventory.getType() == InventoryType.ENDER_CHEST || inventory.getType() == InventoryType.PLAYER) {
                    mod = 9;
                } else {
                    mod = inventory.getSize();
                }
            }
            Integer calculate = row * mod;
            return slot >= calculate - mod && slot < calculate;
        }
        return false;
    }

}
