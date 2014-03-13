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
import open.dolphin.infomodel.HealthInsuranceModel;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.PatientModel;

/**
 * PatientModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class PatientModelConverter implements IInfoModelConverter {

    private PatientModel model;

    public PatientModelConverter() {
    }

    public long getId() {
        return model.getId();
    }

    public String getFacilityId() {
        return model.getFacilityId();
    }

    public String getPatientId() {
        return model.getPatientId();
    }

    public String getFullName() {
        return model.getFullName();
    }

    public String getKanaName() {
        return model.getKanaName();
    }

    public String getRomanName() {
        return model.getRomanName();
    }

    public String getGender() {
        return model.getGender();
    }

    public String getGenderDesc() {
        return model.getGenderDesc();
    }

    public String getBirthday() {
        return model.getBirthday();
    }

    public String getNationality() {
        return model.getNationality();
    }

    public String getNationalityDesc() {
        return model.getNationalityDesc();
    }

    public String getMaritalStatus() {
        return model.getMaritalStatus();
    }

    public byte[] getJpegPhoto() {
        return model.getJpegPhoto();
    }

    public String getMemo() {
        return model.getMemo();
    }

    public SimpleAddressModelConverter getSimpleAddressModel() {
        if (model.getSimpleAddressModel() != null) {
            SimpleAddressModelConverter con = new SimpleAddressModelConverter();
            con.setModel(model.getSimpleAddressModel());
            return con;
        }
        return null;
    }

    public String getTelephone() {
        return model.getTelephone();
    }

    public String getMobilePhone() {
        return model.getMobilePhone();
    }

    public String getEmail() {
        return model.getEmail();
    }

    public List<HealthInsuranceModelConverter> getHealthInsurances() {
        List<HealthInsuranceModel> list = model.getHealthInsurances();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<HealthInsuranceModelConverter> ret = new ArrayList<>();
        for (HealthInsuranceModel m : list) {
            HealthInsuranceModelConverter con = new HealthInsuranceModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }
//masuda^    
    public String getPvtDate() {
        return model.getPvtDate();
    }
//masuda$    
    
    public String getRelations() {
        return model.getRelations();
    }
//minagawa^    
    public String getOwnerUUID() {
        return model.getOwnerUUID();
    }
//minagawa$    

    @Override
    public void setModel(IInfoModel model) {
        this.model = (PatientModel) model;
    }
}
