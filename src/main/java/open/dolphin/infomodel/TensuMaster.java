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

import java.io.Serializable;

/**
 * TensuMaster
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class TensuMaster extends InfoModel implements Serializable {

    private Integer hospnum;

    private String srycd;

    private String yukostymd;

    private String yukoedymd;

    private String name;

    private String kananame;

    private String taniname;

    private String tensikibetu;

    private String ten;

    private String ykzkbn;

    private String yakkakjncd;

    private String nyugaitekkbn;

    private String routekkbn;

    private String srysyukbn;

    private String hospsrykbn;

    /**
     * @return the hospnum
     */
    public Integer getHospnum() {
        return hospnum;
    }

    /**
     * @param hospnum the hospnum to set
     */
    public void setHospnum(Integer hospnum) {
        this.hospnum = hospnum;
    }

    /**
     * @return the srycd
     */
    public String getSrycd() {
        return srycd;
    }

    /**
     * @param srycd the srycd to set
     */
    public void setSrycd(String srycd) {
        this.srycd = srycd;
    }

    /**
     * @return the yukostymd
     */
    public String getYukostymd() {
        return yukostymd;
    }

    /**
     * @param yukostymd the yukostymd to set
     */
    public void setYukostymd(String yukostymd) {
        this.yukostymd = yukostymd;
    }

    /**
     * @return the yukoedymd
     */
    public String getYukoedymd() {
        return yukoedymd;
    }

    /**
     * @param yukoedymd the yukoedymd to set
     */
    public void setYukoedymd(String yukoedymd) {
        this.yukoedymd = yukoedymd;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the kananame
     */
    public String getKananame() {
        return kananame;
    }

    /**
     * @param kananame the kananame to set
     */
    public void setKananame(String kananame) {
        this.kananame = kananame;
    }

    /**
     * @return the taniname
     */
    public String getTaniname() {
        return taniname;
    }

    /**
     * @param taniname the taniname to set
     */
    public void setTaniname(String taniname) {
        this.taniname = taniname;
    }

    /**
     * @return the tensikibetu
     */
    public String getTensikibetu() {
        return tensikibetu;
    }

    /**
     * @param tensikibetu the tensikibetu to set
     */
    public void setTensikibetu(String tensikibetu) {
        this.tensikibetu = tensikibetu;
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the ykzkbn
     */
    public String getYkzkbn() {
        return ykzkbn;
    }

    /**
     * @param ykzkbn the ykzkbn to set
     */
    public void setYkzkbn(String ykzkbn) {
        this.ykzkbn = ykzkbn;
    }

    /**
     * @return the yakkakjncd
     */
    public String getYakkakjncd() {
        return yakkakjncd;
    }

    /**
     * @param yakkakjncd the yakkakjncd to set
     */
    public void setYakkakjncd(String yakkakjncd) {
        this.yakkakjncd = yakkakjncd;
    }

    /**
     * @return the nyugaitekkbn
     */
    public String getNyugaitekkbn() {
        return nyugaitekkbn;
    }

    /**
     * @param nyugaitekkbn the nyugaitekkbn to set
     */
    public void setNyugaitekkbn(String nyugaitekkbn) {
        this.nyugaitekkbn = nyugaitekkbn;
    }

    /**
     * @return the routekkbn
     */
    public String getRoutekkbn() {
        return routekkbn;
    }

    /**
     * @param routekkbn the routekkbn to set
     */
    public void setRoutekkbn(String routekkbn) {
        this.routekkbn = routekkbn;
    }

    /**
     * @return the srysyukbn
     */
    public String getSrysyukbn() {
        return srysyukbn;
    }

    /**
     * @param srysyukbn the srysyukbn to set
     */
    public void setSrysyukbn(String srysyukbn) {
        this.srysyukbn = srysyukbn;
    }

    /**
     * @return the hospsrykbn
     */
    public String getHospsrykbn() {
        return hospsrykbn;
    }

    /**
     * @param hospsrykbn the hospsrykbn to set
     */
    public void setHospsrykbn(String hospsrykbn) {
        this.hospsrykbn = hospsrykbn;
    }

    public String getSlot() {

        if (srycd == null) {
            return null;
        }

        String ret;

        if (srycd.startsWith(ClaimConst.SYUGI_CODE_START)) {
            ret = ClaimConst.SLOT_SYUGI;

        } else if (srycd.startsWith(ClaimConst.YAKUZAI_CODE_START)) {
            //内用1、外用6、注射薬4
            switch (ykzkbn) {
                case ClaimConst.YKZ_KBN_NAIYO:
                    ret = ClaimConst.SLOT_NAIYO_YAKU;
                    break;
                case ClaimConst.YKZ_KBN_INJECTION:
                    ret = ClaimConst.SLOT_TYUSHYA_YAKU;
                    break;
                case ClaimConst.YKZ_KBN_GAIYO:
                    ret = ClaimConst.SLOT_GAIYO_YAKU;
                    break;
                default:
                    ret = ClaimConst.SLOT_YAKUZAI;
                    break;
            }

        } else if (srycd.startsWith(ClaimConst.ZAIRYO_CODE_START)) {
            ret = ClaimConst.SLOT_ZAIRYO;

        } else if (srycd.startsWith(ClaimConst.ADMIN_CODE_START)) {
            ret = ClaimConst.SLOT_YOHO;

        } else if (srycd.startsWith(ClaimConst.RBUI_CODE_START)) {
            ret = ClaimConst.SLOT_BUI;

        } else {
            ret = ClaimConst.SLOT_OTHER;
        }

        return ret;
    }
}
