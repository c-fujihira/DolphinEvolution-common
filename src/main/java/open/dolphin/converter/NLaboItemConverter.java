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
package open.dolphin.converter;

import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.NLaboItem;

/**
 * NLaboItemConverter
 *
 * @author kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class NLaboItemConverter implements IInfoModelConverter {

    private NLaboItem model;

    public NLaboItemConverter() {
    }

    public Long getId() {
        return model.getId();
    }

    public String getPatientId() {
        return model.getPatientId();
    }

    public String getLaboCode() {
        return model.getLaboCode();
    }

    public String getSampleDate() {
        return model.getSampleDate();
    }

    public String getLipemia() {
        return model.getLipemia();
    }

    public String getHemolysis() {
        return model.getHemolysis();
    }

    public String getDialysis() {
        return model.getDialysis();
    }

    public String getReportStatus() {
        return model.getReportStatus();
    }

    public String getGroupCode() {
        return model.getGroupCode();
    }

    public String getGroupName() {
        return model.getGroupName();
    }

    public String getParentCode() {
        return model.getParentCode();
    }

    public String getItemCode() {
        return model.getItemCode();
    }

    public String getMedisCode() {
        return model.getMedisCode();
    }

    public String getItemName() {
        return model.getItemName();
    }

    public String getAbnormalFlg() {
        return model.getAbnormalFlg();
    }

    public String getNormalValue() {
        return model.getNormalValue();
    }

    public String getValue() {
        return model.getValue();
    }

    public String getUnit() {
        return model.getUnit();
    }

    public String getSpecimenCode() {
        return model.getSpecimenCode();
    }

    public String getSpecimenName() {
        return model.getSpecimenName();
    }

    public String getCommentCode1() {
        return model.getCommentCode1();
    }

    public String getComment1() {
        return model.getComment1();
    }

    public String getCommentCode2() {
        return model.getCommentCode2();
    }

    public String getComment2() {
        return model.getComment2();
    }

    public String getSortKey() {
        return model.getSortKey();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (NLaboItem) model;
    }
}
