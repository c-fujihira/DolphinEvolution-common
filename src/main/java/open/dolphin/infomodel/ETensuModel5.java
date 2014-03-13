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
 * ETensuModel5 算定回数テーブルモデル
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ETensuModel5 {

    // 要りそう
    public static final int UNIT_DAY = 121;
    public static final int UNIT_WEEK = 138;
    public static final int UNIT_MONTH = 131;

    // とりあえずあとで
    public static final int UNIT_2M = 143;
    public static final int UNIT_3M = 144;
    public static final int UNIT_4M = 145;
    public static final int UNIT_6M = 146;
    public static final int UNIT_12M = 147;
    public static final int UNIT_5Y = 148;

    // 使うかも
    public static final int UNIT_PART = 109;    // 部位 細胞診など
    public static final int UNIT_UNIT = 28;     // 単位
    public static final int UNIT_PATIENT = 53;  // 患者当たり
    public static final int UNIT_ORGAN = 107;
    public static final int UNIT_FIRST = 135;
    public static final int UNIT_TEST = 150;
    public static final int UNIT_DISEASE = 151;

    // 使わん
    public static final int UNIT_NUMBER = 10;   // 線源使用加算（前立腺癌に対する永久挿入療法）
    public static final int UNIT_OPERATION = 56;
    public static final int UNIT_EXTREMITY = 110;
    public static final int UNIT_SECTION = 111;
    public static final int UNIT_ITEM = 112;
    public static final int UNIT_LATERAL = 119;
    public static final int UNIT_INTERVERTIEBRAL = 122;
    public static final int UNIT_POINT = 126;
    public static final int UNIT_1STDAY_ADMISSION = 132;
    public static final int UNIT_DURING_ADMISSION = 133;
    public static final int UNIT_ON_ENTLASSEN = 134;
    public static final int UNIT_NERVE = 140;
    public static final int UNIT_SERIES = 141;
    public static final int UNIT_PREGNANCY = 149;

    // 特例条件
    public static final int NOT_CONDITIONAL = 0;    //０；条件なし
    public static final int CONDITIONAL = 1;        //１：条件あり

    private String srycd;       // 診療行為コード
    private String yukostymd;   // 有効開始日
    private String yukoedymd;   // 有効終了日
    private int tanicd;         // 算定単位コード
    private String taniname;    // 算定単位名称
    private int kaisu;          // 算定回数
    private int tokurei;        // 特例条件
    private String chgymd;      // 変更年月日

    public ETensuModel5() {
    }

    public String getSrycd() {
        return srycd;
    }

    public String getYukostymd() {
        return yukostymd;
    }

    public String getYukoedymd() {
        return yukoedymd;
    }

    public int getTanicd() {
        return tanicd;
    }

    public String getTaniname() {
        return taniname;
    }

    public int getKaisu() {
        return kaisu;
    }

    public int getTokurei() {
        return tokurei;
    }

    public String getChgymd() {
        return chgymd;
    }

    public void setSrycd(String srycd) {
        this.srycd = srycd;
    }

    public void setYukostymd(String yukostymd) {
        this.yukostymd = yukostymd;
    }

    public void setYukoedymd(String yukoedymd) {
        this.yukoedymd = yukoedymd;
    }

    public void setTanicd(int tanicd) {
        this.tanicd = tanicd;
    }

    public void setTaniname(String taniname) {
        this.taniname = taniname;
    }

    public void setKaisu(int kaisu) {
        this.kaisu = kaisu;
    }

    public void setTokurei(int tokurei) {
        this.tokurei = tokurei;
    }

    public void setChgymd(String chgymd) {
        this.chgymd = chgymd;
    }
}
