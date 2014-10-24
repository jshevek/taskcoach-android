/**
 --------------------------------------------------------------------------

 SOFTWARE FILE HEADER
 -----------------------------

 Classification : UNCLASSIFIED

 Project Name   : ASTRAEA 2 - Mobile I.P. Node

 --------------------------------------------------------------------------

 Copyright Notice
 ----------------

 The copyright in this document is the property of Cassidian
 Systems Limited.

 Without the written consent of Cassidian Systems Limited
 given by Contract or otherwise the document must not be copied, reprinted or
 reproduced in any material form, either wholly or in part, and the contents
 of the document or any method or technique available there from, must not be
 disclosed to any other person whomsoever.

 Copyright 2014 Cassidian Systems Limited.
 --------------------------------------------------------------------------

 */
package uk.co.droidinactu.taskcoach.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author aspela
 */
public class TaskIconFactory {

    private static Bitmap getBitmapFromAsset(final Context actvty, final String strName) {
        final AssetManager assetMgr = actvty.getAssets();
        InputStream istr = null;
        try {
            istr = assetMgr.open(strName);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        final Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }

    public static Bitmap getIcon(final Context actvty, final Task t) {
        if (t.icon.length() > 0) {
            final String[] iconLoc = iconmap.iconlist.get(t.icon);
            String iconName = "icons/";
            if (iconLoc.length == 2) {
                iconName = iconName + iconLoc[0] + "/" + iconLoc[1] + ".png";
                // } else {
                // if (t.icon.equalsIgnoreCase("wrench_icon")) {
                // iconName = iconName + "actions/configure.png";
                // } else if (t.icon.equalsIgnoreCase("computer_handheld_icon"))
                // {
                // iconName = iconName + "devices/pda.png";
                // } else if (t.icon.equalsIgnoreCase("computer_laptop_icon")) {
                // iconName = iconName + "apps/laptop_pcmcia.png";
                // } else if (t.icon.equalsIgnoreCase("computer_desktop_icon"))
                // {
                // iconName = iconName + "icons/apps/mycomputer.png";
                // } else if (t.icon.equalsIgnoreCase("cogwheels_icon")) {
                // iconName = iconName + "icons/apps/kcmsystem.png";
                // }
            }
            return TaskIconFactory.getBitmapFromAsset(actvty, iconName);
        }
        return null;
    }

    public static Bitmap getIcon2(final Context actvty, final Task t) {
        if (t.icon.length() > 0) {
            final AssetManager assetMgr = actvty.getAssets();
            String[] assetDirlist = {};
            String[] assetFilelist = {};
            try {
                assetDirlist = assetMgr.list("icons");
                for (final String assetDir : assetDirlist) {
                    assetFilelist = assetMgr.list("icons" + File.separator + assetDir);
                    for (final String assetFilename : assetFilelist) {
                        if (assetFilename.toLowerCase().startsWith(t.icon.toLowerCase())) {
                            return TaskIconFactory.getBitmapFromAsset(actvty, "icons" + File.separator + assetDir + File.separator + assetFilename);
                        }
                    }
                }
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
