package com.armourcy.dice;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by armour on 9/5/15.
 */

public class DiceTab extends CreativeTabs {
    private Item icon;

    public DiceTab(String label) {
       super(label);
    }

    public void setTabItemIcon(Item item) {
        icon = item;
    }

    @Override
    public Item getTabIconItem() {
        return icon;
    }
}
