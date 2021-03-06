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

import java.util.Date;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.KarteBean;
import open.dolphin.infomodel.RegisteredDiagnosisModel;
import open.dolphin.infomodel.UserModel;

/**
 * RegisteredDiagnosisModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class RegisteredDiagnosisModelConverter implements IInfoModelConverter {

    private RegisteredDiagnosisModel model;

    public RegisteredDiagnosisModelConverter() {
    }

    public long getId() {
        return model.getId();
    }

    public Date getConfirmed() {
        return model.getConfirmed();
    }

    public Date getStarted() {
        return model.getStarted();
    }

    public Date getEnded() {
        return model.getEnded();
    }

    public Date getRecorded() {
        return model.getRecorded();
    }

    public long getLinkId() {
        return model.getLinkId();
    }

    public String getLinkRelation() {
        return model.getLinkRelation();
    }

    public String getStatus() {
        if (model.getStatus() != null) {
            return model.getStatus();
        }
        return IInfoModel.STATUS_FINAL;
        //return model.getStatus();
    }

//    public UserModel getUserModel() {
//        return model.getUserModel();
//    }
//
//    public KarteBean getKarteBean() {
//        return model.getKarteBean();
//    }
    public UserModelConverter getUserModel() {
        if (model.getUserModel() != null) {
            UserModelConverter con = new UserModelConverter();
            con.setModel(model.getUserModel());
            return con;
        }
        return null;
    }

    public KarteBeanConverter getKarteBean() {
        if (model.getKarteBean() != null) {
            KarteBeanConverter con = new KarteBeanConverter();
            con.setModel(model.getKarteBean());
            return con;
        }
        return null;
    }

    public String getDiagnosis() {
        return model.getDiagnosis();
    }

    public String getDiagnosisCode() {
        return model.getDiagnosisCode();
    }

    public String getDiagnosisCodeSystem() {
        return model.getDiagnosisCodeSystem();
    }

    public String getFirstEncounterDate() {
        return model.getFirstEncounterDate();
    }

    public String getRelatedHealthInsurance() {
        return model.getRelatedHealthInsurance();
    }

    public DiagnosisCategoryModelConverter getDiagnosisCategoryModel() {
        if (model.getDiagnosisCategoryModel() != null) {
            DiagnosisCategoryModelConverter con = new DiagnosisCategoryModelConverter();
            con.setModel(model.getDiagnosisCategoryModel());
            return con;
        }
        return null;
    }

    public DiagnosisOutcomeModelConverter getDiagnosisOutcomeModel() {
        if (model.getDiagnosisOutcomeModel() != null) {
            DiagnosisOutcomeModelConverter con = new DiagnosisOutcomeModelConverter();
            con.setModel(model.getDiagnosisOutcomeModel());
            return con;
        }
        return null;
    }

    @Override
    public void setModel(IInfoModel m) {
        this.model = (RegisteredDiagnosisModel) m;
        if (model.getKarteBean() != null) {
            KarteBean dummyKarteBean = PlistConverter.createDuumyKarteBean(model.getKarteBean().getId());
            model.setKarteBean(dummyKarteBean);
        }
        if (model.getUserModel() != null) {
            UserModel dummyUser = PlistConverter.createDummyUserModel(model.getUserModel().getId());
            model.setUserModel(dummyUser);
        }
    }
}
