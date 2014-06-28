/*
 * Copyright (C) 2014 S&I Co.,Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Copyright (C) 2001-2014 OpenDolphin Lab., Life Sciences Computing, Corp.
 * 825 Sylk BLDG., 1-Yamashita-Cho, Naka-Ku, Kanagawa-Ken, Yokohama-City, JAPAN.
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation; either version 3 
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
 * 02111-1307 USA.
 * 
 * (R)OpenDolphin version 2.4, Copyright (C) 2001-2014 OpenDolphin Lab., Life Sciences Computing, Corp. 
 * (R)OpenDolphin comes with ABSOLUTELY NO WARRANTY; for details see the GNU General 
 * Public License, version 3 (GPLv3) This is free software, and you are welcome to redistribute 
 * it under certain conditions; see the GPLv3 for details.
 */
package open.dolphin.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Utilities to handel String.
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class StringTool {

    private static final char[] komoji = {'ぁ', 'ぃ', 'ぅ', 'ぇ', 'ぉ', 'っ', 'ゃ',
        'ゅ', 'ょ', 'ゎ', 'ァ', 'ィ', 'ゥ', 'ェ', 'ォ', 'ッ', 'ャ', 'ュ', 'ョ', 'ヮ'};

    private static final char FIRST_HIRAGANA = 'ぁ';
    private static final char LAST_HIRAGANA = 'ん';
    private static final char FIRST_KATAKANA = 'ァ';
    private static final char LAST_KATAKANA = 'ヶ';

    private static final Character[] ZENKAKU_UPPER = {new Character('Ａ'), new Character('Ｚ')};

    private static final Character[] ZENKAKU_LOWER = {new Character('ａ'), new Character('ｚ')};

    private static final Character[] HANKAKU_UPPER = {new Character('A'), new Character('Z')};

    private static final Character[] HANKAKU_LOWER = {new Character('a'), new Character('z')};

    /**
     * Creates new StringTool
     */
    public StringTool() {
    }

    public static Object[] tokenToArray(String line, String delim) {

        StringTokenizer st = new StringTokenizer(line, delim, true);
        ArrayList<String> list = new ArrayList<String>(10);
        int state = 0;
        String token;

        while (st.hasMoreTokens()) {

            token = st.nextToken();
            switch (state) {
                case 0:
                    // VALUE_STATE
                    if (token.equals(",")) {
                        token = null;
                    } else {
                        state = 1;
                    }
                    list.add(token);
                    break;

                case 1:
                    // DELIM_STATE
                    state = 0;
                    break;
            }
        }

        return list.toArray();
    }

    public static String trimSpace(String text) {

        int start = 0;
        int len = text.length();

        while (start < len) {
            if (text.charAt(start) > 32) {
                break;
            }
            start++;
        }
        int end = len - 1;
        while (end > start) {
            if (text.charAt(end) > 32) {
                break;
            }
            end--;
        }

        return end != 0 ? text.substring(start, end + 1) : null;
    }

    public static boolean startsWithKatakana(String s) {
        return isKatakana(s.charAt(0));
    }

    public static boolean startsWithHiragana(String s) {
        return isHiragana(s.charAt(0));
    }

    public static boolean isKatakana(char c) {
        return (c >= FIRST_KATAKANA && c <= LAST_KATAKANA) ? true : false;
    }

    public static boolean isHiragana(char c) {
        return (c >= FIRST_HIRAGANA && c <= LAST_HIRAGANA) ? true : false;
    }

    private static char toKatakana(char c) {
        return (char) ((int) FIRST_KATAKANA + (int) c - (int) FIRST_HIRAGANA);
    }

    public static String hiraganaToKatakana(String s) {

        int len = s.length();
        char[] src = new char[len];
        s.getChars(0, s.length(), src, 0);

        char[] dst = new char[len];
        for (int i = 0; i < len; i++) {
            if (isHiragana(src[i])) {
                dst[i] = toKatakana(src[i]);
            } else {
                dst[i] = src[i];
            }
        }
        return new String(dst);
    }

    public static boolean isAllDigit(String str) {

        boolean ret = true;
        int len = str.length();

        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);

            if (!Character.isDigit(c)) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static boolean isAllKana(String str) {

        boolean ret = true;
        int len = str.length();

        for (int i = 0; i < len; i++) {

            char c = str.charAt(i);

            if (isKatakana(c) || isHiragana(c)) {
                continue;
            } else {
                ret = false;
                break;
            }
        }
        return ret;
    }

    /**
     * Convert to Zenkaku
     */
    public static String toZenkaku(String s) {

        if (s != null) {
            for (int i = 0; i < komoji.length; i++) {
                // s = s.replace(komoji[i], ohomoji[i]);
                s = s.replace(komoji[i], '.');
            }
        }

        return s;
    }

    public static String toKatakana(String text, boolean b) {
        if (b) {
            text = toZenkaku(text);
        }
        return hiraganaToKatakana(text);
    }

    public static boolean isZenkakuUpper(char c) {
        Character test = new Character(c);
        return (test.compareTo(ZENKAKU_UPPER[0]) >= 0 && test.compareTo(ZENKAKU_UPPER[1]) <= 0) ? true : false;
    }

    public static boolean isZenkakuLower(char c) {
        Character test = new Character(c);
        return (test.compareTo(ZENKAKU_LOWER[0]) >= 0 && test.compareTo(ZENKAKU_LOWER[1]) <= 0) ? true : false;
    }

    public static boolean isHankakuUpper(char c) {
        Character test = new Character(c);
        return (test.compareTo(HANKAKU_UPPER[0]) >= 0 && test.compareTo(HANKAKU_UPPER[1]) <= 0) ? true : false;
    }

    public static boolean isHanakuLower(char c) {
        Character test = new Character(c);
        return (test.compareTo(HANKAKU_LOWER[0]) >= 0 && test.compareTo(HANKAKU_LOWER[1]) <= 0) ? true : false;
    }

    public static String toZenkakuUpperLower(String s) {
        int len = s.length();
        char[] src = new char[len];
        s.getChars(0, s.length(), src, 0);

        StringBuilder sb = new StringBuilder();
        for (char c : src) {
            if (isHankakuUpper(c) || isHanakuLower(c)) {
                sb.append((char) ((int) c + 65248));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
