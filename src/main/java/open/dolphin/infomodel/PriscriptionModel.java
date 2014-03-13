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

import java.util.Date;
import java.util.List;

/**
 * PriscriptionModel
 *
 * @author kazushi Minagawa
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class PriscriptionModel extends InfoModel {

    // 患者ID
    private String patientId;

    // 患者氏名
    private String patientName;

    // 患者カナ
    private String patientKana;

    // 患者性別(男｜女)
    private String patientSex;

    // 患者生年月日 yyyy-MM-dd
    private String patientBirthday;

    // 患者郵便番号
    private String patientZipcode;

    // 患者住所
    private String patientAddress;

    // 患者電話
    private String patientTelephone;

    // 処方リスト
    private List<BundleMed> priscriptionList;

    // 適用保険
    private PVTHealthInsuranceModel applyedInsurance;

    // 責任医師
    private String physicianName;

    // 麻薬免許
    private String drugLicenseNumber;

    // 医療機関名
    private String institutionName;

    // 医療機関郵便番号
    private String institutionZipcode;

    // 医療機関住所
    private String institutionAddress;

    // 医療機関電話番号
    private String institutionTelephone;

    // 保険医療機関番号
    private String InstitutionNumber;

    // 交付日
    private Date issuanceDate;

    // 使用期間
    private Date period;

    // 備考欄患者住所、氏名転記フラグ
    private boolean chkPatientInfo;

    // 備考欄患者麻薬施用者転記フラグ
    private boolean chkUseDrugInfo;

    // 備考欄に「在宅」を記載するかどうかのフラグ
    private boolean chkHomeMedical;

    private boolean useGeneraklName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientKana() {
        return patientKana;
    }

    public void setPatientKana(String patientKana) {
        this.patientKana = patientKana;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientZipcode() {
        return patientZipcode;
    }

    public void setPatientZipcode(String patientZipcode) {
        this.patientZipcode = patientZipcode;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientTelephone() {
        return patientTelephone;
    }

    public void setPatientTelephone(String patientTelephone) {
        this.patientTelephone = patientTelephone;
    }

    public List<BundleMed> getPriscriptionList() {
        return priscriptionList;
    }

    public void setPriscriptionList(List<BundleMed> priscriptionList) {
        this.priscriptionList = priscriptionList;
    }

    public PVTHealthInsuranceModel getApplyedInsurance() {
        return applyedInsurance;
    }

    public void setApplyedInsurance(PVTHealthInsuranceModel applyedInsurance) {
        this.applyedInsurance = applyedInsurance;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public String getDrugLicenseNumber() {
        return drugLicenseNumber;
    }

    public void setDrugLicenseNumber(String drugLicenseNumber) {
        this.drugLicenseNumber = drugLicenseNumber;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionZipcode() {
        return institutionZipcode;
    }

    public void setInstitutionZipcode(String institutionZipcode) {
        this.institutionZipcode = institutionZipcode;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionTelephone() {
        return institutionTelephone;
    }

    public void setInstitutionTelephone(String institutionTelephone) {
        this.institutionTelephone = institutionTelephone;
    }

    public String getInstitutionNumber() {
        return InstitutionNumber;
    }

    public void setInstitutionNumber(String InstitutionNumber) {
        this.InstitutionNumber = InstitutionNumber;
    }

    public Date getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(Date issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public boolean isChkPatientInfo() {
        return chkPatientInfo;
    }

    public void setChkPatientInfo(boolean chkPatientInfo) {
        this.chkPatientInfo = chkPatientInfo;
    }

    public boolean isChkUseDrugInfo() {
        return chkUseDrugInfo;
    }

    public void setChkUseDrugInfo(boolean chkUseDrugInfo) {
        this.chkUseDrugInfo = chkUseDrugInfo;
    }

    public boolean isChkHomeMedical() {
        return chkHomeMedical;
    }

    public void setChkHomeMedical(boolean chkHomeMedical) {
        this.chkHomeMedical = chkHomeMedical;
    }

    public boolean isUseGeneraklName() {
        return useGeneraklName;
    }

    public void setUseGeneraklName(boolean useGeneraklName) {
        this.useGeneraklName = useGeneraklName;
    }
}
