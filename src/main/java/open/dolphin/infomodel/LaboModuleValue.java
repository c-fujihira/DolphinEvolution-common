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

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 * LaboModuleValue
 *
 * @author Life Sciences Computing Corporation.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_labo_module")
public class LaboModuleValue extends KarteEntryBean implements java.io.Serializable {

    // MMLのUID
    @Column(nullable = false, unique = true, length = 32)
    private String docId;

    @Transient
    private String patientId;

    @Transient
    private String patientIdType;

    @Transient
    private String patientIdTypeCodeSys;

    private String registId;

    private String sampleTime;

    private String registTime;

    private String reportTime;

    private String reportStatus;

    private String reportStatusCode;

    private String reportStatusCodeId;

    private String setName;

    private String setCode;

    private String setCodeId;

    private String clientFacility;

    private String clientFacilityCode;

    private String clientFacilityCodeId;

    private String laboratoryCenter;

    private String laboratoryCenterCode;

    private String laboratoryCenterCodeId;

    //private String confirmDate;
    @OneToMany(mappedBy = "laboModule", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Collection<LaboSpecimenValue> laboSpecimens;

    public LaboModuleValue() {
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String id) {
        this.docId = id;
    }

    public String getClientFacility() {
        return clientFacility;
    }

    public void setClientFacility(String clientFacility) {
        this.clientFacility = clientFacility;
    }

    public String getClientFacilityCode() {
        return clientFacilityCode;
    }

    public void setClientFacilityCode(String clientFacilityCode) {
        this.clientFacilityCode = clientFacilityCode;
    }

    public String getClientFacilityCodeId() {
        return clientFacilityCodeId;
    }

    public void setClientFacilityCodeId(String clientFacilityCodeId) {
        this.clientFacilityCodeId = clientFacilityCodeId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientIdType() {
        return patientIdType;
    }

    public void setPatientIdType(String patientIdType) {
        this.patientIdType = patientIdType;
    }

    public String getPatientIdTypeCodeSys() {
        return patientIdTypeCodeSys;
    }

    public void setPatientIdTypeCodeSys(String patientIdTypeCodeSys) {
        this.patientIdTypeCodeSys = patientIdTypeCodeSys;
    }

//    public String getConfirmDate() {
//        return confirmDate;
//    }
//    
//    public void setConfirmDate(String confirmDate) {
//        this.confirmDate = confirmDate;
//    }
    public String getLaboratoryCenter() {
        return laboratoryCenter;
    }

    public void setLaboratoryCenter(String laboratoryCenter) {
        this.laboratoryCenter = laboratoryCenter;
    }

    public String getLaboratoryCenterCode() {
        return laboratoryCenterCode;
    }

    public void setLaboratoryCenterCode(String laboratoryCenterCode) {
        this.laboratoryCenterCode = laboratoryCenterCode;
    }

    public String getLaboratoryCenterCodeId() {
        return laboratoryCenterCodeId;
    }

    public void setLaboratoryCenterCodeId(String laboratoryCenterCodeId) {
        this.laboratoryCenterCodeId = laboratoryCenterCodeId;
    }

    public Collection<LaboSpecimenValue> getLaboSpecimens() {
        return laboSpecimens;
    }

    public void setLaboSpecimens(Collection<LaboSpecimenValue> laboSpecimens) {
        this.laboSpecimens = laboSpecimens;
    }

    public void addLaboSpecimen(LaboSpecimenValue specimen) {
        if (laboSpecimens == null) {
            laboSpecimens = new ArrayList<>();
        }
        laboSpecimens.add(specimen);
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportStatusCode() {
        return reportStatusCode;
    }

    public void setReportStatusCode(String reportStatusCode) {
        this.reportStatusCode = reportStatusCode;
    }

    public String getReportStatusCodeId() {
        return reportStatusCodeId;
    }

    public void setReportStatusCodeId(String reportStatusCodeId) {
        this.reportStatusCodeId = reportStatusCodeId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getSetCodeId() {
        return setCodeId;
    }

    public void setSetCodeId(String setCodeId) {
        this.setCodeId = setCodeId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * サンプルタイムで比較する。
     *
     * @return 比較値
     */
    @Override
    public int compareTo(Object other) {
        if (other != null && getClass() == other.getClass()) {
            String sampleTime1 = getSampleTime();
            String sampleTime2 = ((LaboModuleValue) other).getSampleTime();
            if (sampleTime1 != null && sampleTime2 != null) {
                return sampleTime1.compareTo(sampleTime2);
            } else {
                String cf1 = getConfirmDate();
                String cf2 = ((LaboModuleValue) other).getConfirmDate();
                return cf1.compareTo(cf2);
            }
        }
        return -1;
    }
}
