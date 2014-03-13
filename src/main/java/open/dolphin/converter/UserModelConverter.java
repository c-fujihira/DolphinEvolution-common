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
import java.util.Date;
import java.util.List;
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.RoleModel;
import open.dolphin.infomodel.UserModel;

/**
 * UserModel
 *
 * @author Minagawa,Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class UserModelConverter implements IInfoModelConverter {

    private UserModel model;

    public UserModelConverter() {
    }

    public long getId() {
        return model.getId();
    }

    public String getUserId() {
        return model.getUserId();
    }

    public String getPassword() {
        return model.getPassword();
    }

    public String getSirName() {
        return model.getSirName();
    }

    public String getGivenName() {
        return model.getGivenName();
    }

    public String getCommonName() {
        return model.getCommonName();
    }

    public LicenseModelConverter getLicenseModel() {
        if (model.getLicenseModel() != null) {
            LicenseModelConverter con = new LicenseModelConverter();
            con.setModel(model.getLicenseModel());
            return con;
        }
        return null;
    }

    public DepartmentModelConverter getDepartmentModel() {
        if (model.getDepartmentModel() != null) {
            DepartmentModelConverter con = new DepartmentModelConverter();
            con.setModel(model.getDepartmentModel());
            return con;
        }
        return null;
    }

    public FacilityModelConverter getFacilityModel() {
        if (model.getFacilityModel() != null) {
            FacilityModelConverter con = new FacilityModelConverter();
            con.setModel(model.getFacilityModel());
            return con;
        }
        return null;
    }

    public List<RoleModelConverter> getRoles() {
        List<RoleModel> list = model.getRoles();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<RoleModelConverter> ret = new ArrayList<>();
        for (RoleModel m : list) {
            RoleModelConverter con = new RoleModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public String getMemberType() {
        return model.getMemberType();
    }

    public String getMemo() {
        return model.getMemo();
    }

    public Date getRegisteredDate() {
        return model.getRegisteredDate();
    }

    public String getEmail() {
        return model.getEmail();
    }

    public String getOrcaId() {
        return model.getOrcaId();
    }

    public String getUseDrugId() {
        return model.getUseDrugId();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (UserModel) model;
    }
}
