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
import open.dolphin.infomodel.*;

/**
 * KarteBeanConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class KarteBeanConverter implements IInfoModelConverter {

    private KarteBean model;

    public KarteBeanConverter() {
    }

    public long getId() {
        return model.getId();
    }

//    public PatientModel getPatientModel() {
//        return model.getPatientModel();
//    }

    public Date getCreated() {
        return model.getCreated();
    }

    public List<AllergyModelConverter> getAllergies() {
        List<AllergyModel> list = model.getAllergies();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<AllergyModelConverter> ret = new ArrayList<>();
        for (AllergyModel m : list) {
            AllergyModelConverter con = new AllergyModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<PhysicalModelConverter> getHeights() {
        List<PhysicalModel> list = model.getHeights();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<PhysicalModelConverter> ret = new ArrayList<>();
        for (PhysicalModel m : list) {
            PhysicalModelConverter con = new PhysicalModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<PhysicalModelConverter> getWeights() {
        List<PhysicalModel> list = model.getWeights();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<PhysicalModelConverter> ret = new ArrayList<>();
        for (PhysicalModel m : list) {
            PhysicalModelConverter con = new PhysicalModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<String> getPatientVisits() {
        return model.getPatientVisits();
    }

    public List<DocInfoModelConverter> getDocInfoList() {
        List<DocInfoModel> list = model.getDocInfoList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<DocInfoModelConverter> ret = new ArrayList<>();
        for (DocInfoModel m : list) {
            DocInfoModelConverter con = new DocInfoModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<PatientMemoModelConverter> getMemoList() {
        List<PatientMemoModel> list = model.getMemoList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<PatientMemoModelConverter> ret = new ArrayList<>();
        for (PatientMemoModel m : list) {
            PatientMemoModelConverter con = new PatientMemoModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }
    
//masuda^
    public Date getLastDocDate() {
        return model.getLastDocDate();
    }
    
//masua$    

    @Override
    public void setModel(IInfoModel m) {
        this.model = (KarteBean) m;
    }
}
