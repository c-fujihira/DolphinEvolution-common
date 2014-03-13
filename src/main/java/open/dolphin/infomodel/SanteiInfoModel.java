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
import javax.persistence.Embeddable;

/**
 * 算定情報モデル
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Embeddable
public class SanteiInfoModel implements Serializable {

    // Ｃ管理
    private Boolean cancerCare = false;

    // 在宅時医学総合管理料・特定施設入居時医学総合管理料
    private Boolean zaitakuSougouKanri = false;

    // 在宅
    private Boolean homeMedicalCare = false;

    // 特定施設
    private Boolean nursingHomeMedicalCare = false;

    public SanteiInfoModel() {
    }

    public boolean isCancerCare() {
        return cancerCare;
    }

    public void setCancerCare(boolean b) {
        cancerCare = b;
    }

    public boolean isZaitakuSougouKanri() {
        return zaitakuSougouKanri;
    }

    public void setZaitakuSougouKanri(boolean b) {
        zaitakuSougouKanri = b;
    }

    public boolean isHomeMedicalCare() {
        return homeMedicalCare;
    }

    public void setHomeMedicalCare(boolean b) {
        homeMedicalCare = b;
    }

    public boolean isNursingHomeMedicalCare() {
        return nursingHomeMedicalCare;
    }

    public void setNursingHomeMedicalCare(boolean b) {
        nursingHomeMedicalCare = b;
    }
}
