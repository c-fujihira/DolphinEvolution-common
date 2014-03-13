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

/*
 * AllergyItem.java
 * Copyright (C) 2002 Dolphin Project. All rights reserved.
 * Copyright (C) 2003,2004 Digital Globe, Inc. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package open.dolphin.infomodel;

/**
 * PhysicalModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class PhysicalModel extends InfoModel implements Comparable {

    private long heightId;
    private long weightId;

    // 身長
    private String height;

    // 体重
    private String weight;

    // BMI
    private int bmi;

    // 同定日
    private String identifiedDate;

    // メモ
    private String memo;

    /**
     * デフォルトコンストラクタ
     */
    public PhysicalModel() {
    }

    public long getHeightId() {
        return heightId;
    }

    public void setHeightId(long heightId) {
        this.heightId = heightId;
    }

    public long getWeightId() {
        return weightId;
    }

    public void setWeightId(long weightId) {
        this.weightId = weightId;
    }

    // factor
    public String getHeight() {
        return height;
    }

    public void setHeight(String value) {
        height = value;
    }

    // identifiedDate
    public String getIdentifiedDate() {
        return identifiedDate;
    }

    public void setIdentifiedDate(String value) {
        identifiedDate = value;
    }

    // memo
    public String getMemo() {
        return memo;
    }

    public void setMemo(String value) {
        memo = value;
    }

    public void setWeight(String severity) {
        this.weight = severity;
    }

    public String getWeight() {
        return weight;
    }

    public String getBmi() {
//        if (bmi == null) {
//            bmi = calcBmi();
//        }
//        return bmi;
        return calcBmi();
    }

    /**
     * @return Returns the bmi.
     */
    public String calcBmi() {
        if (height != null && weight != null) {
            try {
                float fw = new Float(weight).floatValue();
                float fh = new Float(height).floatValue();
                float bmif = (10000f * fw) / (fh * fh);
                String bmiS = String.valueOf(bmif);
                int index = bmiS.indexOf('.');
                int len = bmiS.length();
                if (index > 0 && (index + 2 < len)) {
                    bmiS = bmiS.substring(0, index + 2);
                }
                return bmiS;
            } catch (Exception ex) {
                return null;    // add funabashi (身長体重が数値でない場合の対応：try-catchを追加) ステータス連携
            }
        }
        return null;
    }

    public String getStandardWeight() {
        if (getHeight() == null) {
            return null;
        }
        try {
            float h = Float.parseFloat(getHeight());
            h /= 100.0f;
            float stW = 22.0f * (h * h);
            String stWS = String.valueOf(stW);
            int index = stWS.indexOf('.');
            if (index > 0) {
                stWS = stWS.substring(0, index + 2);
            }
            return stWS;

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public int compareTo(Object other) {
        if (other != null && getClass() == other.getClass()) {
            String val1 = getIdentifiedDate();
            String val2 = ((PhysicalModel) other).getIdentifiedDate();
            return val1.compareTo(val2);
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.getHeight() != null) {
            sb.append(this.getHeight()).append("cm").append(",");
        }
        if (this.getWeight() != null) {
            sb.append(this.getWeight()).append("Kg").append(",");
        }
        if (this.getIdentifiedDate() != null) {
            sb.append(this.getIdentifiedDate()).append(",");
        }
        if (this.getHeight() != null && this.getWeight() != null) {
            sb.append(this.calcBmi()).append("Kg/m^2");
        }
        return sb.toString();
    }
}
