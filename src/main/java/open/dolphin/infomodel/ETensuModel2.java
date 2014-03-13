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
 * ETensuModel2 包括・被包括テーブルモデル
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ETensuModel2 {

    public static final String ETENSU2 = "tbl_etensu_2";
    public static final String ETENSU2JMA = "tbl_etensu_2_jma";
    public static final String ETENSU2OFF = "tbl_etensu_2_off";
    public static final String ETENSU2SAMPLE = "tbl_etensu_2_sample";

    private String h_group;     // 包括・被包括グループごとに設定した番号を表す。
    private String srycd;       // 診療行為コード
    private String yukostymd;   // 有効開始日
    private String yukoedymd;   // 有効終了日
    private String chgymd;      // 変更年月日

    // tbl_etensu_2_off
    private String hospnum;     // 医療機関を識別するための番号を表す。
    private String termid;      // 当該行の操作を行った端末ＩＤを表す（未使用）。
    private String opid;        // 当該行の操作を行ったオペレータＩＤを表す。
    private String creymd;      // 当該行を作成した日付を表す。
    private String upymd;       // 当該行を更新した日付を表す。
    private String uphms;       // 当該行を更新した時刻を表す。

    // tbl_etensu_2_sample
    private int rennum;         // 連番
    private String samplecd;    // 検体コメントコードを表す。

    // ETensuModel1のh_tani
    private int h_tani;

    public ETensuModel2() {
    }

    public String getH_group() {
        return h_group;
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

    public String getChgymd() {
        return chgymd;
    }

    public String getHospnum() {
        return hospnum;
    }

    public String getTermid() {
        return termid;
    }

    public String getOpid() {
        return opid;
    }

    public String getCreymd() {
        return creymd;
    }

    public String getUpymd() {
        return upymd;
    }

    public String getUphms() {
        return uphms;
    }

    public int getRennum() {
        return rennum;
    }

    public String getSamplecd() {
        return samplecd;
    }

    public int getH_tani() {
        return h_tani;
    }

    public void setH_group(String h_group) {
        this.h_group = h_group;
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

    public void setChgymd(String chgymd) {
        this.chgymd = chgymd;
    }

    public void setHospnum(String hospnum) {
        this.hospnum = hospnum;
    }

    public void setTermid(String termid) {
        this.termid = termid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public void setCreymd(String creymd) {
        this.creymd = creymd;
    }

    public void setUpymd(String upymd) {
        this.upymd = upymd;
    }

    public void setUphms(String uphms) {
        this.uphms = uphms;
    }

    public void setRennum(int rennum) {
        this.rennum = rennum;
    }

    public void setSamplecd(String samplecd) {
        this.samplecd = samplecd;
    }

    public void setH_tani(int h_tani) {
        this.h_tani = h_tani;
    }
}
