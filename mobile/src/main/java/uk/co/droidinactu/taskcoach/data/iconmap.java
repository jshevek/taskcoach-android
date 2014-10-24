/*
Task Coach - Your friendly task manager
Copyright (C) 2004-2014 Task Coach developers <developers@taskcoach.org>

Task Coach is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Task Coach is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.co.droidinactu.taskcoach.data;

import java.util.HashMap;
import java.util.Map;

public class iconmap {
    public static Map<String, String[]> iconlist = new HashMap<String, String[]>();

    static {
        // # These icons are named after their function:
        iconlist.put("copy", new String[]{"actions", "editcopy"});
        iconlist.put("cut", new String[]{"actions", "editcut"});
        iconlist.put("delete", new String[]{"actions", "editdelete"});
        iconlist.put("edit", new String[]{"actions", "edit"});
        iconlist.put("fileopen", new String[]{"actions", "fileopen"});
        iconlist.put("fileopen_red", new String[]{"actions", "fileopen_red"});
        iconlist.put("print", new String[]{"actions", "fileprint"});
        iconlist.put("export", new String[]{"actions", "fileexport"});
        iconlist.put("exportashtml", new String[]{"mimetypes", "html"});
        iconlist.put("exportascsv", new String[]{"mimetypes", "txt"});
        iconlist.put("exportasvcal", new String[]{"mimetypes", "vcalendar"});
        iconlist.put("close", new String[]{"actions", "fileclose"});
        iconlist.put("exit", new String[]{"actions", "exit"});
        iconlist.put("markcompleted", new String[]{"apps", "korganizer_todo"});
        iconlist.put("markuncompleted", new String[]{"actions", "klipper_dock"});
        iconlist.put("markuncompleted", new String[]{"actions", "tool_clipboard"});
        iconlist.put("new", new String[]{"actions", "filenew"});
        iconlist.put("newtmpl", new String[]{"actions", "blend"});
        iconlist.put("newsub", new String[]{"actions", "new_sub"});
        iconlist.put("paste", new String[]{"actions", "editpaste"});
        iconlist.put("undo", new String[]{"actions", "undo"});
        iconlist.put("redo", new String[]{"actions", "redo"});
        iconlist.put("save", new String[]{"actions", "filesave"});
        iconlist.put("mergedisk", new String[]{"actions", "top"});
        iconlist.put("saveas", new String[]{"actions", "filesaveas"});
        iconlist.put("taskcoach", new String[]{"apps", "korganizer_todo"});
        iconlist.put("listview", new String[]{"actions", "view_detailed"});
        iconlist.put("treeview", new String[]{"actions", "view_tree"});
        iconlist.put("restore", new String[]{"apps", "kcmkwm"});
        iconlist.put("progress", new String[]{"actions", "finish"});
        iconlist.put("viewalltasks", new String[]{"apps", "kreversi"});
        iconlist.put("viewnewviewer", new String[]{"actions", "tab_new"});
        iconlist.put("squaremapviewer", new String[]{"actions", "squaremap"});
        iconlist.put("timelineviewer", new String[]{"actions", "timeline"});
        iconlist.put("activatenextviewer", new String[]{"actions", "tab_advance_next"});
        iconlist.put("activatepreviousviewer", new String[]{"actions", "tab_advance_prev"});
        iconlist.put("windows", new String[]{"apps", "window_list"});
        iconlist.put("maxpriority", new String[]{"actions", "2uparrow"});
        iconlist.put("minpriority", new String[]{"actions", "2downarrow"});
        iconlist.put("incpriority", new String[]{"actions", "1uparrow"});
        iconlist.put("decpriority", new String[]{"actions", "1downarrow"});
        iconlist.put("prev", new String[]{"actions", "1leftarrow"});
        iconlist.put("next", new String[]{"actions", "1rightarrow"});
        iconlist.put("up", new String[]{"actions", "1uparrow"});
        iconlist.put("down", new String[]{"actions", "1downarrow"});

        // # These icons are named after what they display:
        iconlist.put("arrow_up_icon", new String[]{"actions", "up"});
        iconlist.put("arrow_down_icon", new String[]{"actions", "down"});
        iconlist.put("arrow_up_with_status_icon", new String[]{"actions", "sort_ascending_with_status"});
        iconlist.put("arrow_down_with_status_icon", new String[]{"actions", "sort_descending_with_status"});
        iconlist.put("arrows_looped_blue_icon", new String[]{"actions", "kaboodleloop"});
        iconlist.put("arrows_looped_green_icon", new String[]{"actions", "reload"});
        iconlist.put("bomb_icon", new String[]{"apps", "core"});
        iconlist.put("book_icon", new String[]{"apps", "kdict"});
        iconlist.put("books_icon", new String[]{"apps", "bookcase"});
        iconlist.put("box_icon", new String[]{"apps", "kpackage"});
        iconlist.put("box_in_icon", new String[]{"filesystems", "folder_inbox"});
        iconlist.put("box_out_icon", new String[]{"filesystems", "folder_outbox"});
        iconlist.put("bug_icon", new String[]{"apps", "bug"});
        iconlist.put("cake_icon", new String[]{"apps", "cookie"});
        iconlist.put("calculator_icon", new String[]{"apps", "kcalc"});
        iconlist.put("calendar_icon", new String[]{"apps", "date"});
        iconlist.put("cat_icon", new String[]{"apps", "package_toys"});
        iconlist.put("cd_icon", new String[]{"actions", "cd"});
        iconlist.put("charts_icon", new String[]{"apps", "kchart"});
        iconlist.put("chat_icon", new String[]{"apps", "chat"});
        iconlist.put("checkmark_green_icon", new String[]{"actions", "apply"});
        iconlist.put("checkmark_green_icon_multiple", new String[]{"actions", "apply_multiple"});
        iconlist.put("clock_icon", new String[]{"apps", "clock"});
        iconlist.put("clock_alarm_icon", new String[]{"actions", "kalarm"});
        iconlist.put("clock_stopwatch_icon", new String[]{"apps", "ktimer"});
        iconlist.put("clock_stop_icon", new String[]{"actions", "history_stop"});
        iconlist.put("clock_resume_icon", new String[]{"actions", "history_resume"});
        iconlist.put("clock_menu_icon", new String[]{"actions", "historymenu"});
        iconlist.put("cogwheel_icon", new String[]{"actions", "misc"});
        iconlist.put("cogwheels_icon", new String[]{"apps", "kcmsystem"});
        iconlist.put("computer_desktop_icon", new String[]{"apps", "mycomputer"});
        iconlist.put("computer_handheld_icon", new String[]{"devices", "pda"});
        iconlist.put("computer_laptop_icon", new String[]{"apps", "laptop_pcmcia"});
        iconlist.put("cross_red_icon", new String[]{"actions", "cancel"});
        iconlist.put("die_icon", new String[]{"actions", "roll"});
        iconlist.put("document_icon", new String[]{"mimetypes", "dvi"});
        iconlist.put("earth_blue_icon", new String[]{"filesystems", "www"});
        iconlist.put("earth_green_icon", new String[]{"filesystems", "ftp"});
        iconlist.put("envelope_icon", new String[]{"apps", "email"});
        iconlist.put("envelopes_icon", new String[]{"actions", "queue"});
        iconlist.put("folder_blue_icon", new String[]{"filesystems", "folder_blue"});
        iconlist.put("folder_blue_light_icon", new String[]{"filesystems", "folder_blue_light"});
        iconlist.put("folder_blue_arrow_icon", new String[]{"filesystems", "folder_download"});
        iconlist.put("folder_blue_open_icon", new String[]{"filesystems", "folder_blue_open"});
        iconlist.put("folder_blue_light_open_icon", new String[]{"filesystems", "folder_blue_light_open"});
        iconlist.put("folder_green_icon", new String[]{"filesystems", "folder_green"});
        iconlist.put("folder_green_open_icon", new String[]{"filesystems", "folder_green_open"});
        iconlist.put("folder_orange_icon", new String[]{"filesystems", "folder_orange"});
        iconlist.put("folder_orange_open_icon", new String[]{"filesystems", "folder_orange_open"});
        iconlist.put("folder_grey_icon", new String[]{"filesystems", "folder_grey"});
        iconlist.put("folder_grey_open_icon", new String[]{"filesystems", "folder_grey_open"});
        iconlist.put("folder_red_icon", new String[]{"filesystems", "folder_red"});
        iconlist.put("folder_red_open_icon", new String[]{"filesystems", "folder_red_open"});
        iconlist.put("folder_purple_icon", new String[]{"filesystems", "folder_violet"});
        iconlist.put("folder_purple_open_icon", new String[]{"filesystems", "folder_violet_open"});
        iconlist.put("folder_yellow_icon", new String[]{"filesystems", "folder_yellow"});
        iconlist.put("folder_yellow_open_icon", new String[]{"filesystems", "folder_yellow_open"});
        iconlist.put("heart_icon", new String[]{"actions", "bookmark"});
        iconlist.put("hearts_icon", new String[]{"apps", "amor"});
        iconlist.put("house_green_icon", new String[]{"actions", "gohome"});
        iconlist.put("house_red_icon", new String[]{"apps", "kfm_home"});
        iconlist.put("key_icon", new String[]{"actions", "kgpg_key1"});
        iconlist.put("keys_icon", new String[]{"actions", "kgpg_key3"});
        iconlist.put("lamp_icon", new String[]{"apps", "ktip"});
        iconlist.put("led_blue_icon", new String[]{"actions", "ledblue"});
        iconlist.put("led_blue_light_icon", new String[]{"actions", "ledlightblue"});
        iconlist.put("led_blue_questionmark_icon", new String[]{"actions", "help"});
        iconlist.put("led_blue_information_icon", new String[]{"actions", "messagebox_info"});
        iconlist.put("led_green_icon", new String[]{"actions", "ledgreen"});
        iconlist.put("led_green_light_icon", new String[]{"actions", "ledlightgreen"});
        iconlist.put("led_orange_icon", new String[]{"actions", "ledorange"});
        iconlist.put("led_grey_icon", new String[]{"actions", "ledgrey"});
        iconlist.put("led_purple_icon", new String[]{"actions", "ledpurple"});
        iconlist.put("led_red_icon", new String[]{"actions", "ledred"});
        iconlist.put("led_yellow_icon", new String[]{"actions", "ledyellow"});
        iconlist.put("life_ring_icon", new String[]{"apps", "khelpcenter"});
        iconlist.put("linux", new String[]{"apps", "linux"});
        iconlist.put("lock_locked_icon", new String[]{"actions", "encrypted"});
        iconlist.put("lock_unlocked_icon", new String[]{"actions", "decrypted"});
        iconlist.put("mac", new String[]{"apps", "mac"});
        iconlist.put("magnifier_glass_dropdown_icon", new String[]{"actions", "searchmenu"});
        iconlist.put("magnifier_glass_icon", new String[]{"actions", "viewmag"});
        iconlist.put("music_piano_icon", new String[]{"actions", "piano"});
        iconlist.put("music_note_icon", new String[]{"actions", "playsound"});
        iconlist.put("note_icon", new String[]{"apps", "knotes"});
        iconlist.put("palette_icon", new String[]{"actions", "colorize"});
        iconlist.put("paperclip_icon", new String[]{"actions", "attach"});
        iconlist.put("pencil_icon", new String[]{"actions", "pencil"});
        iconlist.put("person_talking_icon", new String[]{"apps", "edu_languages"});
        iconlist.put("person_id_icon", new String[]{"actions", "identity"});
        iconlist.put("person_icon", new String[]{"apps", "personal"});
        iconlist.put("person_photo_icon", new String[]{"actions", "kgpg_photo"});
        iconlist.put("persons_icon", new String[]{"apps", "kdmconfig"});
        iconlist.put("sign_warning_icon", new String[]{"actions", "messagebox_warning"});
        iconlist.put("symbol_plus_icon", new String[]{"actions", "edit_add"});
        iconlist.put("symbol_minus_icon", new String[]{"actions", "edit_remove"});
        iconlist.put("star_yellow_icon", new String[]{"filesystems", "services"});
        iconlist.put("star_red_icon", new String[]{"apps", "mozilla"});
        iconlist.put("trafficlight_icon", new String[]{"apps", "ksysv"});
        iconlist.put("trashcan_icon", new String[]{"actions", "edittrash"});
        iconlist.put("weather_lightning_icon", new String[]{"apps", "cache"});
        iconlist.put("weather_sunny_icon", new String[]{"apps", "kweather"});
        iconlist.put("weather_umbrella_icon", new String[]{"apps", "colors"});
        iconlist.put("wrench_icon", new String[]{"actions", "configure"});
    }
}
