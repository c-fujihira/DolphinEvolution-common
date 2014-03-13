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

/*
 * OrcaInputCd.java
 * Copyright (C) 2007 Digital Globe, Inc. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package open.dolphin.infomodel;

import java.util.ArrayList;

/**
 * ORCA の tbl_inputcd エンティティクラス
 *
 * @author Minagawa, Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class OrcaInputCd extends InfoModel {

    private String hospId;

    private String cdsyu;

    private String inputCd;

    private String sryKbn;

    private String sryCd;

    private int dspSeq;

    private String dspName;

    private String termId;

    private String opId;

    private String creYmd;

    private String upYmd;

    private String upHms;

    private ArrayList<OrcaInputSet> inputSet;

    /**
     * Creates a new instance of OrcaInputCd
     */
    public OrcaInputCd() {
    }

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId;
    }

    public String getCdsyu() {
        return cdsyu;
    }

    public void setCdsyu(String cdsyu) {
        this.cdsyu = cdsyu;
    }

    public String getInputCd() {
        return inputCd;
    }

    public void setInputCd(String inputCd) {
        this.inputCd = inputCd;
    }

    public String getSryKbn() {
        return sryKbn;
    }

    public void setSryKbn(String sryKbn) {
        this.sryKbn = sryKbn;
    }

    public String getSryCd() {
        return sryCd;
    }

    public void setSryCd(String sryCd) {
        this.sryCd = sryCd;
    }

    public int getDspSeq() {
        return dspSeq;
    }

    public void setDspSeq(int dspSeq) {
        this.dspSeq = dspSeq;
    }

    public String getDspName() {
        return dspName;
    }

    public void setDspName(String dspName) {
        this.dspName = dspName;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getCreYmd() {
        return creYmd;
    }

    public void setCreYmd(String creYmd) {
        this.creYmd = creYmd;
    }

    public String getUpYmd() {
        return upYmd;
    }

    public void setUpYmd(String upYmd) {
        this.upYmd = upYmd;
    }

    public String getUpHms() {
        return upHms;
    }

    public void setUpHms(String upHms) {
        this.upHms = upHms;
    }

    public ArrayList getInputSet() {
        return inputSet;
    }

    public void setInputSet(ArrayList<OrcaInputSet> list) {
        inputSet = list;
    }

    public void addInputSet(OrcaInputSet set) {
        if (inputSet == null) {
            inputSet = new ArrayList<>();
        }
        inputSet.add(set);
    }

    public ModuleInfoBean getStampInfo() {
        ModuleInfoBean ret = new ModuleInfoBean();
        ret.setStampName(getDspName());
        ret.setStampRole(ROLE_ORCA_SET);
        ret.setEntity(ENTITY_MED_ORDER);    // ?
        ret.setStampId(getInputCd());
        return ret;
    }

    public BundleMed getBundleMed() {

        BundleMed ret = new BundleMed();

        for (OrcaInputSet set : inputSet) {

            ret.addClaimItem(set.getClaimItem());
        }

        return ret;
    }
}
