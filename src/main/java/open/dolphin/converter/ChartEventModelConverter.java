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

import open.dolphin.infomodel.ChartEventModel;
import open.dolphin.infomodel.IInfoModel;

/**
 * ChartEventModelConverter
 *
 * @author kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ChartEventModelConverter implements IInfoModelConverter {

    private ChartEventModel model;

    public int getEventType() {
        return model.getEventType();
    }

    public long getPvtPk() {
        return model.getPvtPk();
    }

    public int getState() {
        return model.getState();
    }

    public int getByomeiCount() {
        return model.getByomeiCount();
    }

    public int getByomeiCountToday() {
        return model.getByomeiCountToday();
    }

    public String getIssuerUUID() {
        return model.getIssuerUUID();
    }

    public String getOwnerUUID() {
        return model.getOwnerUUID();
    }

    public PatientVisitModelConverter getPatientVisitModel() {
        if (model.getPatientVisitModel() != null) {
            PatientVisitModelConverter con = new PatientVisitModelConverter();
            con.setModel(model.getPatientVisitModel());
            return con;
        }
        return null;
    }

    public long getPtPk() {
        return model.getPtPk();
    }

    public PatientModelConverter getPatientModel() {
        if (model.getPatientModel() != null) {
            PatientModelConverter con = new PatientModelConverter();
            con.setModel(model.getPatientModel());
            return con;
        }
        return null;
    }

    public String getMemo() {
        return model.getMemo();
    }

    public String getFacilityId() {
        return model.getFacilityId();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (ChartEventModel) model;
    }
}
