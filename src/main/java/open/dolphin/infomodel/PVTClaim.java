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
package open.dolphin.infomodel;

import java.util.Vector;

/**
 * PVTClaim Simple Claim Class used for PVT.
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class PVTClaim extends InfoModel {

    private static final long serialVersionUID = -8573272136025043849L;
    private String claimStatus;
    private String claimRegistTime;
    private String claimAdmitFlag;
    private String claimDeptName;
    private String claimDeptCode;
    private String assignedDoctorId;
    private String assignedDoctorName;
    private Vector claimAppName;
    private String claimAppMemo;
    private String claimItemCode;
    private String claimItemName;
    private String insuranceUid;
    private String jmariCode;

    /**
     * Creates new PVTClaim
     */
    public PVTClaim() {
        super();
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String val) {
        claimStatus = val;
    }

    public String getClaimRegistTime() {
        return claimRegistTime;
    }

    public void setClaimRegistTime(String val) {
        claimRegistTime = val;
    }

    public String getClaimAdmitFlag() {
        return claimAdmitFlag;
    }

    public void setClaimAdmitFlag(String val) {
        claimAdmitFlag = val;
    }

    public String getClaimDeptName() {
        return claimDeptName;
    }

    public void setClaimDeptName(String val) {
        claimDeptName = val;
    }

    public String getClaimDeptCode() {
        return claimDeptCode;
    }

    public void setClaimDeptCode(String val) {
        claimDeptCode = val;
    }

    public Vector getClaimAppName() {
        return claimAppName;
    }

    @SuppressWarnings("unchecked")
    public void addClaimAppName(String val) {
        if (claimAppName == null) {
            claimAppName = new Vector(3);
        }
        claimAppName.add(val);
    }

    public String getClaimAppMemo() {
        return claimAppMemo;
    }

    public void setClaimAppMemo(String val) {
        claimAppMemo = val;
    }

    public String getClaimItemCode() {
        return claimItemCode;
    }

    public void setClaimItemCode(String val) {
        claimItemCode = val;
    }

    public String getClaimItemName() {
        return claimItemName;
    }

    public void setClaimItemName(String val) {
        claimItemName = val;
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder();

        if (claimStatus != null) {
            buf.append("ClaimStatus: ");
            buf.append(claimStatus);
            buf.append("\n");
        }

        if (claimRegistTime != null) {
            buf.append("ClaimRegistTime: ");
            buf.append(claimRegistTime);
            buf.append("\n");
        }

        if (claimAdmitFlag != null) {
            buf.append("ClaimAdmitFlag: ");
            buf.append(claimAdmitFlag);
            buf.append("\n");
        }

        // Mirror-I start
        if (claimDeptName != null) {
            buf.append("claimDeptName: ");
            buf.append(claimDeptName);
            buf.append("\n");
        }
        // Mirror-I end

        if (claimAppName != null) {
            int len = claimAppName.size();
            for (int i = 0; i < len; i++) {
                buf.append("ClaimAppName: ");
                buf.append((String) claimAppName.get(i));
                buf.append("\n");
            }
        }

        if (claimAppMemo != null) {
            buf.append("ClaimAppointMemo: ");
            buf.append(claimAppMemo);
            buf.append("\n");
        }

        if (claimItemCode != null) {
            buf.append("ClaimItemCode: ");
            buf.append(claimItemCode);
            buf.append("\n");
        }

        if (claimItemName != null) {
            buf.append("ClaimItemName: ");
            buf.append(claimItemName);
            buf.append("\n");
        }

        return buf.toString();
    }

    /**
     * @param insuranceUid The insuranceUid to set.
     */
    public void setInsuranceUid(String insuranceUid) {
        this.insuranceUid = insuranceUid;
    }

    /**
     * @return Returns the insuranceUid.
     */
    public String getInsuranceUid() {
        return insuranceUid;
    }

    public String getJmariCode() {
        return jmariCode;
    }

    public void setJmariCode(String jmariCode) {
        this.jmariCode = jmariCode;
    }

    public String getAssignedDoctorName() {
        return assignedDoctorName;
    }

    public void setAssignedDoctorName(String assignedDoctorName) {
        this.assignedDoctorName = assignedDoctorName;
    }

    public String getAssignedDoctorId() {
        return assignedDoctorId;
    }

    public void setAssignedDoctorId(String assignedDoctorId) {
        this.assignedDoctorId = assignedDoctorId;
    }
}
