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
import open.dolphin.infomodel.DiagnosisSendWrapper;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.RegisteredDiagnosisModel;

/**
 * DiagnosisSendWrapperConverter
 *
 * @author Kazushi Minagawa.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class DiagnosisSendWrapperConverter implements IInfoModelConverter {

    private DiagnosisSendWrapper model;

    public boolean getSendClaim() {
        return model.getSendClaim();
    }

    public String getConfirmDate() {
        return model.getConfirmDate();
    }

    public String getTitle() {
        return model.getTitle();
    }

    public String getPurpose() {
        return model.getPurpose();
    }

    public String getGroupId() {
        return model.getGroupId();
    }

    public String getPatientId() {
        return model.getPatientId();
    }

    public String getPatientName() {
        return model.getPatientName();
    }

    public String getPatientGender() {
        return model.getPatientGender();
    }

    public String getFacilityName() {
        return model.getFacilityName();
    }

    public String getJamariCode() {
        return model.getJamariCode();
    }

    public String getDepartment() {
        return model.getDepartment();
    }

    public String getDepartmentDesc() {
        return model.getDepartmentDesc();
    }

    public String getCreatorName() {
        return model.getCreatorName();
    }

    public String getCreatorId() {
        return model.getCreatorId();
    }

    public String getCreatorLicense() {
        return model.getCreatorLicense();
    }

    public List<RegisteredDiagnosisModelConverter> getAddedDiagnosis() {
        List<RegisteredDiagnosisModel> list = model.getAddedDiagnosis();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<RegisteredDiagnosisModelConverter> ret = new ArrayList<>();
        for (RegisteredDiagnosisModel m : list) {
            RegisteredDiagnosisModelConverter con = new RegisteredDiagnosisModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<RegisteredDiagnosisModelConverter> getUpdatedDiagnosis() {
        List<RegisteredDiagnosisModel> list = model.getUpdatedDiagnosis();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<RegisteredDiagnosisModelConverter> ret = new ArrayList<>();
        for (RegisteredDiagnosisModel m : list) {
            RegisteredDiagnosisModelConverter con = new RegisteredDiagnosisModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

//minagawa^ LSC 1.4 傷病名の削除 2013/06/24
    public List<RegisteredDiagnosisModelConverter> getDeletedDiagnosis() {
        List<RegisteredDiagnosisModel> list = model.getDeletedDiagnosis();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<RegisteredDiagnosisModelConverter> ret = new ArrayList<>();
        for (RegisteredDiagnosisModel m : list) {
            RegisteredDiagnosisModelConverter con = new RegisteredDiagnosisModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }
//minagawa$

    @Override
    public void setModel(IInfoModel model) {
        this.model = (DiagnosisSendWrapper) model;
    }
}
