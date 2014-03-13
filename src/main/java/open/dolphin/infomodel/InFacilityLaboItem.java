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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 施設内検査項目
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "msd_facilityLabo")
public class InFacilityLaboItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int itemIndex;

    // Labo コード
    private String laboCode;    // facilityId

    // グループコード
    private String groupCode;

    // グループ名称
    private String groupName;

    // 検査項目コード・親
    private String parentCode;

    // MEDIS コード
    private String medisCode;

    // 検査項目名
    private String itemName;

    // 基準値
    private String normalValue;

    // 単位
    private String unit;

    // 検査材料コード
    private String specimenCode;

    // 検査材料名
    private String specimenName;

    // 値・性別などTransientなもの
    @JsonIgnore
    @Transient
    private String itemValue;

    public void setItemValue(String value) {
        itemValue = value;
    }

    public String getItemValue() {
        return itemValue;
    }

    @Transient
    private String abnormalFlg;

    public void setAbnormalFlg(String flg) {
        abnormalFlg = flg;
    }

    public String getAbnormalFlg() {
        return abnormalFlg;
    }

    // coustructor
    public InFacilityLaboItem() {
    }

    public InFacilityLaboItem(
            String medisCode,
            String itemName,
            String parentCode,
            String groupCode,
            String groupName,
            String specimenCode,
            String specimenName,
            String normalValue,
            String unit) {
        this.medisCode = medisCode;
        this.itemName = itemName;
        this.parentCode = parentCode;
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.specimenCode = specimenCode;
        this.specimenName = specimenName;
        this.normalValue = normalValue;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public String getLaboCode() {
        return laboCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String getMedisCode() {
        return medisCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getNormalValue() {
        return normalValue;
    }

    public String getUnit() {
        return unit;
    }

    public String getSpecimenCode() {
        return specimenCode;
    }

    public String getSpecimenName() {
        return specimenName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItemIndex(int index) {
        this.itemIndex = index;
    }

    public void setLaboCode(String laboCode) {
        this.laboCode = laboCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public void setMedisCode(String medisCode) {
        this.medisCode = medisCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setNormalValue(String normalValue) {
        this.normalValue = normalValue;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setSpecimenCode(String specimenCode) {
        this.specimenCode = specimenCode;
    }

    public void setSpecimenName(String specimenName) {
        this.specimenName = specimenName;
    }
}
