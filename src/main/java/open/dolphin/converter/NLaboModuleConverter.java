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
import java.util.List;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.NLaboItem;
import open.dolphin.infomodel.NLaboModule;

/**
 * NLaboModuleConverter
 *
 * @author kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class NLaboModuleConverter implements IInfoModelConverter {

    private NLaboModule model;

    public NLaboModuleConverter() {
    }

    public Long getId() {
        return model.getId();
    }

    public String getPatientId() {
        return model.getPatientId();
    }

    public String getPatientName() {
        return model.getPatientName();
    }

    public String getPatientSex() {
        return model.getPatientSex();
    }

    public String getSampleDate() {
        return model.getSampleDate();
    }

    public String getNumOfItems() {
        return model.getNumOfItems();
    }

    public List<NLaboItemConverter> getItems() {
        List<NLaboItem> list = model.getItems();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<NLaboItemConverter> ret = new ArrayList<>();
        for (NLaboItem m : list) {
            NLaboItemConverter con = new NLaboItemConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public Boolean getProgressState() {
        return model.getProgressState();
    }

    public void setProgressState(Boolean progressState) {
        model.setProgressState(progressState);
    }

    public String getLaboCenterCode() {
        return model.getLaboCenterCode();
    }

    public String getModuleKey() {
        return model.getModuleKey();
    }

    public String getReportFormat() {
        return model.getReportFormat();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (NLaboModule) model;
    }
}
