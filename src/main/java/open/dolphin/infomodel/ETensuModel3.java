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
package open.dolphin.infomodel;

/**
 * ETensuModel3 背反関連テーブルモデル
 *
 * @author masuda, Mauda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ETensuModel3 {

    public static final int R_DAY = 1;
    public static final int R_MONTH = 2;
    public static final int R_SAME = 3;
    public static final int R_WEEK = 4;

    public static final int HAIHAN_1 = 1;   //１：診療行為コード１を算定する。
    public static final int HAIHAN_2 = 2;   //２：診療行為コード２を算定する。
    public static final int HAIHAN_3 = 3;   //３：何れか一方を算定する。

    //背反条件に特別な条件があるか否かを表す。
    public static final int NOT_CONDITIONAL = 0;    //０；条件なし
    public static final int CONDITIONAL = 1;        //１：条件あり

    private String srycd1;      // 診療行為コード１
    private String srycd2;      // 診療行為コード２
    private String yukostymd;   // 有効開始日
    private String yukoedymd;   // 有効終了日
    private int haihan;         // 背反区分
    private int tokurei;        // 特定条件
    private String chgymd;      // 変更年月日

    // ETensuModel1の背反識別
    private int r_haihan;

    // constructor
    public ETensuModel3() {
    }

    // getter
    public String getSrycd1() {
        return srycd1;
    }

    public String getSrycd2() {
        return srycd2;
    }

    public String getYukostymd() {
        return yukostymd;
    }

    public String getYukoedymd() {
        return yukoedymd;
    }

    public int getHaihan() {
        return haihan;
    }

    public int getTokurei() {
        return tokurei;
    }

    public String getChgymd() {
        return chgymd;
    }

    public int getR_haihan() {
        return r_haihan;
    }

    public void setSrycd1(String srycd1) {
        this.srycd1 = srycd1;
    }

    public void setSrycd2(String srycd2) {
        this.srycd2 = srycd2;
    }

    public void setYukostymd(String yukostymd) {
        this.yukostymd = yukostymd;
    }

    public void setYukoedymd(String yukoedymd) {
        this.yukoedymd = yukoedymd;
    }

    public void setHaihan(int haihan) {
        this.haihan = haihan;
    }

    public void setTokurei(int tokurei) {
        this.tokurei = tokurei;
    }

    public void setChgymd(String chgymd) {
        this.chgymd = chgymd;
    }

    public void setR_haihan(int r_haihan) {
        this.r_haihan = r_haihan;
    }

}
