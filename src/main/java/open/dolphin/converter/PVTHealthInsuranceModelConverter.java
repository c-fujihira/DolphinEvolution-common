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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.PVTHealthInsuranceModel;
import open.dolphin.infomodel.PVTPublicInsuranceItemModel;

/**
 * PVTHealthInsuranceModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class PVTHealthInsuranceModelConverter implements IInfoModelConverter {

    private PVTHealthInsuranceModel model;

    public PVTHealthInsuranceModelConverter() {
    }

    public String getGUID() {
        return model.getGUID();
    }

    public String getInsuranceClass() {
        return model.getInsuranceClass();
    }

    public String getInsuranceClassCode() {
        return model.getInsuranceClassCode();
    }

    public String getInsuranceClassCodeSys() {
        return model.getInsuranceClassCodeSys();
    }

    public String getInsuranceNumber() {
        return model.getInsuranceNumber();
    }

    public String getClientGroup() {
        return model.getClientGroup();
    }

    public String getClientNumber() {
        return model.getClientNumber();
    }

    public String getFamilyClass() {
        return model.getFamilyClass();
    }

    public String getStartDate() {
        return model.getStartDate();
    }

    public String getExpiredDate() {
        return model.getExpiredDate();
    }

    public String[] getContinuedDisease() {
        return model.getContinuedDisease();
    }

    public String getPayInRatio() {
        return model.getPayInRatio();
    }

    public String getPayOutRatio() {
        return model.getPayOutRatio();
    }

    public List<PVTPublicInsuranceItemModelConverter> getPublicItems() {
        List<PVTPublicInsuranceItemModel> list = model.getPublicItems();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<PVTPublicInsuranceItemModelConverter> ret = new ArrayList<>();
        for (PVTPublicInsuranceItemModel m : list) {
            PVTPublicInsuranceItemModelConverter con = new PVTPublicInsuranceItemModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    @Override
    public void setModel(IInfoModel m) {
        this.model = (PVTHealthInsuranceModel) m;
        PVTPublicInsuranceItemModel[] testArray = model.getPVTPublicInsuranceItem();
        if (testArray != null && testArray.length > 0) {
            List<PVTPublicInsuranceItemModel> list = new ArrayList<>();
            list.addAll(Arrays.asList(testArray));
            model.setPublicItems(list);
        }
    }
}
