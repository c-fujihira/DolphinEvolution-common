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

/**
 * Chart event通知用のモデル
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ChartEventModel extends InfoModel implements java.io.Serializable {

    public static final int PVT_STATE = 0;
    public static final int PVT_ADD = 1;
    public static final int PVT_DELETE = 2;
    public static final int PVT_RENEW = 3;
    public static final int PVT_MERGE = 4;
    public static final int PM_MERGE = 5;

    private String issuerUUID;
    private int eventType;

    private long pvtPk;
    private int state;
    private String memo;
    private int byomeiCount;
    private int byomeiCountToday;
    private String ownerUUID;
    private String facilityId;

    private PatientVisitModel pvt;

    private long ptPk;
    private PatientModel patient;

    //public static enum EVENT {PVT_STATE, PVT_ADD, PVT_DELETE, PVT_RENEW, PVT_MERGE, PM_MERGE};
    public ChartEventModel() {
    }

    public ChartEventModel(String issuerUUID) {
        this.issuerUUID = issuerUUID;
    }

    public void setParamFromPvt(PatientVisitModel pvt) {

        if (pvt == null) {
            return;
        }

        this.pvtPk = pvt.getId();
        this.state = pvt.getState();

        this.byomeiCount = pvt.getByomeiCount();
        this.byomeiCountToday = pvt.getByomeiCountToday();

        this.memo = pvt.getMemo();
        this.ownerUUID = pvt.getPatientModel().getOwnerUUID();
        this.facilityId = pvt.getFacilityId();
        this.ptPk = pvt.getPatientModel().getId();
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public void setPvtPk(long pk) {
        pvtPk = pk;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setByomeiCount(int count) {
        byomeiCount = count;
    }

    public void setByomeiCountToday(int count) {
        byomeiCountToday = count;
    }

    public void setIssuerUUID(String issuer) {
        issuerUUID = issuer;
    }

    public void setOwnerUUID(String owner) {
        ownerUUID = owner;
    }

    public void setPatientVisitModel(PatientVisitModel pvt) {
        this.pvt = pvt;
    }

    public void setPtPk(long ptPk) {
        this.ptPk = ptPk;
    }

    public void setPatientModel(PatientModel patient) {
        this.patient = patient;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setFacilityId(String fid) {
        facilityId = fid;
    }

    public int getEventType() {
        return eventType;
    }

    public long getPvtPk() {
        return pvtPk;
    }

    public int getState() {
        return state;
    }

    public int getByomeiCount() {
        return byomeiCount;
    }

    public int getByomeiCountToday() {
        return byomeiCountToday;
    }

    public String getIssuerUUID() {
        return issuerUUID;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public PatientVisitModel getPatientVisitModel() {
        return pvt;
    }

    public long getPtPk() {
        return ptPk;
    }

    public PatientModel getPatientModel() {
        return patient;
    }

    public String getMemo() {
        return memo;
    }

    public String getFacilityId() {
        return facilityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("issuerUUID=").append(this.getIssuerUUID()).append("\n");
        sb.append("eventType=").append(this.getEventType()).append("\n");
        sb.append("pvtPK=").append(this.getPvtPk()).append("\n");
        sb.append("state=").append(this.getState()).append("\n");
        sb.append("ptPK=").append(this.getPtPk()).append("\n");
        sb.append("ownerUUID=").append(this.getOwnerUUID()).append("\n");
        sb.append("fid=").append(this.getFacilityId()).append("\n");
        return sb.toString();
    }
}
