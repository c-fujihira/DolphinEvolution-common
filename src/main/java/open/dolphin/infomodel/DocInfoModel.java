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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 文書履歴のレコード及びCLAIM送信のコンテナとして使用するクラス
 *
 * @author Minagawa,Kazushi. Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class DocInfoModel extends InfoModel
        implements Comparable, java.io.Serializable {

    // = DocumentModel.id
    @Transient
    private long docPk;

    // = 親DocumentModel.id
    @Transient
    private long parentPk;

    // 32bit GUID (MML ouput)
    @Column(nullable = false, length = 32)
    private String docId;

    // 文書種別(Dolphin固有）
    @Column(nullable = false)
    private String docType;

    // タイトル
    @Column(nullable = false)
    private String title;

    // 生成目的 MML
    @Column(nullable = false)
    private String purpose;

    // 生成目的説明 MML
    @Transient
    private String purposeDesc;

    // 生成目的コード体系 MML
    @Transient
    private String purposeCodeSys;

    // = DocumentModel.started（最初の確定日）
    @Transient
    private Date firstConfirmDate;

    // 確定日
    @Transient
    private Date confirmDate;

    // 診療科
    private String department;

    // 診療科説明
    // 診療科名、コード、担当医名、担当医コード、JMARIコード（カンマ連結）
    private String departmentDesc;

    // 診療科コード体系
    @Transient
    private String departmentCodeSys;

    // 健康保険
    private String healthInsurance;

    // 健康保険説明（名称）
    private String healthInsuranceDesc;

    // 健康保険コード体系
    @Transient
    private String healthInsuranceCodeSys;

    // 健康保険GUID （ORCAからの受付受信時に設定されている）
    private String healthInsuranceGUID;

    // 注意フラグ
    private boolean hasMark;

    // イメージ（シェーマ）フラグ
    private boolean hasImage;

    //　RPフラグ
    private boolean hasRp;

    // 処置フラグ
    private boolean hasTreatment;

    // 検体検査フラグ
    private boolean hasLaboTest;

    // 文書のバージョン番号（修正時++）
    private String versionNumber;

    // バージョン説明
    @Transient
    private String versionNotes;

    // 親文書 32bit ID
    private String parentId;

    // 親文書との関係
    private String parentIdRelation;

    // 親文書との説明
    @Transient
    private String parentIdDesc;

    // 親文書との関係コード体系
    @Transient
    private String parentIdCodeSys;

    // アクセス権
    @Transient
    private Collection<AccessRightModel> accessRights;

    // ステータス = DocumentModel.status
    @Transient
    private String status;

    // この文書を表示するクラス（紹介状等で使用）
    @Transient
    private String handleClass;

    // Flag and param for senders
    // 検体検査オーダー番号
    private String labtestOrderNumber;

    // 検体検査オーダー送信フラグ
    @Transient
    private boolean sendLabtest;

    // CLAIM送信フラグ
    @Transient
    private boolean sendClaim;

    // MML送信フラグ
    @Transient
    private boolean sendMml;

    // 処方せん出力
    @Transient
    private boolean priscriptionOutput;

    // Claim Sender for JMS+MDB
    // 診断に適用した健康保険
    @Transient
    private PVTHealthInsuranceModel pVTHealthInsuranceModel;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "admission_id", nullable = true)
    private AdmissionModel admission;

    public AdmissionModel getAdmissionModel() {
        return admission;
    }

    public void setAdmissionModel(AdmissionModel admission) {
        this.admission = admission;
    }

    public DocInfoModel() {
    }

    // 施設（病院）名
    @Transient
    private String facilityName;

    // 医療資格
    @Transient
    private String createrLisence;

    // 患者ID
    @Transient
    private String patientId;

    // 患者氏名
    @Transient
    private String patientName;

    // 患者性別
    @Transient
    private String patientGender;
    
//minagawa^ 会計上送信日を変更(予定カルテ対応)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date claimDate;
//minagawa$    

    // 処方せん出力に必要な情報
    // 担当医情報: Document->creatorから検索
    // 患者情報; Document->karteIdから検索
    // 交付日
    @Transient
    private Date issuanceDate;

    // 保険医療機関番号
    @Transient
    private String InstitutionNumber;

    // 使用期間
    @Transient
    private Date period;

    // 備考欄患者住所、氏名転記フラグ
    @Transient
    private boolean chkPatientInfo;

    // 備考欄患者麻薬施用者転記フラグ
    @Transient
    private boolean chkUseDrugInfo;

    // 備考欄に「在宅」を記載するかどうかのフラグ
    @Transient
    private boolean chkHomeMedical;

    // 一般名を使用するかどうか
    @Transient
    private boolean useGeneralName;

    public long getDocPk() {
        return docPk;
    }

    /**
     * Document の Database Primary Key を設定する
     *
     * @param docPk Database Primary Key
     */
    public void setDocPk(long docPk) {
        this.docPk = docPk;
    }

    /**
     * 親分文書のPrimaryKeyを返す
     *
     * @return 親分文書のPrimaryKey
     */
    public long getParentPk() {
        return parentPk;
    }

    /**
     * 親分文書のPrimaryKeyを設定する
     *
     * @param parentPk 親分文書のPrimaryKey
     */
    public void setParentPk(long parentPk) {
        this.parentPk = parentPk;
    }

    /**
     * 文書IDを設定する
     *
     * @param docId 文書ID
     */
    public void setDocId(String docId) {
        this.docId = docId;
    }

    /**
     * 文書IDを返す
     *
     * @return 文書ID
     */
    public String getDocId() {
        return docId;
    }

    /**
     * 文書タイプを設定する
     *
     * @param docType 文書タイプ
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
     * 文書タイプを返す
     *
     * @return 文書タイプ
     */
    public String getDocType() {
        return docType;
    }

    /**
     * タイトルを設定する
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * タイトルを返す
     *
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * 生成目的を設定する
     *
     * @param purpose 生成目的
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * 生成目的を返す
     *
     * @return 生成目的
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 生成目的説明を設定する
     *
     * @param purposeDesc 生成目的説明
     */
    public void setPurposeDesc(String purposeDesc) {
        this.purposeDesc = purposeDesc;
    }

    /**
     * 生成目的説明を返す
     *
     * @return 生成目的説明
     */
    public String getPurposeDesc() {
        return purposeDesc;
    }

    /**
     * 生成目的コード体系を設定する
     *
     * @param purposeCodeSys 生成目的コード体系
     */
    public void setPurposeCodeSys(String purposeCodeSys) {
        this.purposeCodeSys = purposeCodeSys;
    }

    /**
     * 生成目的コード体系を返す
     *
     * @return 生成目的コード体系
     */
    public String getPurposeCodeSys() {
        return purposeCodeSys;
    }

    /**
     * 最初の確定日を設定する
     *
     * @param firstConfirmDate 最初の確定日
     */
    public void setFirstConfirmDate(Date firstConfirmDate) {
        this.firstConfirmDate = firstConfirmDate;
    }

    /**
     * 最初の確定日を返す
     *
     * @return 最初の確定日
     */
    public Date getFirstConfirmDate() {
        return firstConfirmDate;
    }

    /**
     * 最初の確定日の日付部分を返す。
     *
     * @return 最初の確定日の日付部分
     */
    public String getFirstConfirmDateTrimTime() {
        return ModelUtils.getDateAsString(getFirstConfirmDate());
    }

    /**
     * 最初の確定日の日付時刻を返す。
     *
     * @return 最初の確定日の日付時刻
     */
    public String getFirstConfirmDateTime() {
        return ModelUtils.getDateAsFormatString(getFirstConfirmDate(), ISO_DF_FORMAT);
    }

    /**
     * 確定日を設定する
     *
     * @param confirmDate 確定日
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * 確定日を返す
     *
     * @return 確定日
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * 確定日の日付部分を返す
     *
     * @return 確定日の日付部分
     */
    public String getConfirmDateTrimTime() {
        return ModelUtils.getDateAsString(getConfirmDate());
    }

    /**
     * 確定日の日付時刻を返す。
     *
     * @return 確定日の日付時刻
     */
    public String getConfirmDateTime() {
        return ModelUtils.getDateAsFormatString(getConfirmDate(), ISO_DF_FORMAT);
    }

    /**
     * 診療科を設定する
     *
     * @param department 診療科
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 診療科を返す
     *
     * @return 診療科
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 診療科説明を設定する
     *
     * @param departmentDesc 診療科説明
     */
    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    /**
     * 診療科説明を返す
     *
     * @return 診療科説明
     */
    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public String getDepartmentName() {
        String[] tokens = tokenizeDept(departmentDesc);
        return tokens[0];
    }

    public String getDepartmentCode() {
        String[] tokens = tokenizeDept(departmentDesc);
        if (tokens[1] != null) {
            return tokens[1];
        }
        return getDepartment();
    }

    public String getAssignedDoctorName() {
        String[] tokens = tokenizeDept(departmentDesc);
        return tokens[2];
    }

    public String getAssignedDoctorId() {
        String[] tokens = tokenizeDept(departmentDesc);
        return tokens[3];
    }

    public String getJMARICode() {
        String[] tokens = tokenizeDept(departmentDesc);
        return tokens[4];
    }

    private String[] tokenizeDept(String dept) {

        // 診療科名、コード、担当医名、担当医コード、JMARI コード
        // を格納する配列を生成する
        String[] ret = new String[5];
        Arrays.fill(ret, null);

        if (dept != null) {
            try {
                String[] params = dept.split("\\s*,\\s*");
                System.arraycopy(params, 0, ret, 0, params.length);

            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }

        return ret;
    }

    /**
     * 診療科体系を設定する
     *
     * @param departmentCodeSys 診療科体系
     */
    public void setDepartmentCodeSys(String departmentCodeSys) {
        this.departmentCodeSys = departmentCodeSys;
    }

    /**
     * 診療科体系を返す
     *
     * @return 診療科体系
     */
    public String getDepartmentCodeSys() {
        return departmentCodeSys;
    }

    /**
     * 健康保険を設定する
     *
     * @param healthInsurance
     */
    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    /**
     * 健康保険を返す
     *
     * @return 健康保険
     */
    public String getHealthInsurance() {
        return healthInsurance;
    }

    /**
     * 健康保険説明を設定する
     *
     * @param healthInsuranceDesc 健康保険説明
     */
    public void setHealthInsuranceDesc(String healthInsuranceDesc) {
        this.healthInsuranceDesc = healthInsuranceDesc;
    }

    /**
     * 健康保険説明を返す
     *
     * @return 健康保険説明
     */
    public String getHealthInsuranceDesc() {
        return healthInsuranceDesc;
    }

    /**
     * 健康保険体系を設定する
     *
     * @param healthInsuranceCodeSys 健康保険体系
     */
    public void setHealthInsuranceCodeSys(String healthInsuranceCodeSys) {
        this.healthInsuranceCodeSys = healthInsuranceCodeSys;
    }

    /**
     * 健康保険体系を返す
     *
     * @return 健康保険体系
     */
    public String getHealthInsuranceCodeSys() {
        return healthInsuranceCodeSys;
    }

    /**
     * 健康保険GUIDを設定する
     *
     * @param healthInsuranceGUID 健康保険UUID
     */
    public void setHealthInsuranceGUID(String healthInsuranceGUID) {
        this.healthInsuranceGUID = healthInsuranceGUID;
    }

    /**
     * 健康保険GUIDを返す
     *
     * @return 健康保険UUID
     */
    public String getHealthInsuranceGUID() {
        return healthInsuranceGUID;
    }

    /**
     * 注記があるかどうかを設定する
     *
     * @param hasMark 注記がある時 true
     */
    public void setHasMark(boolean hasMark) {
        this.hasMark = hasMark;
    }

    /**
     * 注記があるかどうかを返す
     *
     * @return 注記がある時 true
     */
    public boolean isHasMark() {
        return hasMark;
    }

    public Boolean isHasMarkBoolean() {
        return hasMark;
    }

    /**
     * 画像があるかどうかを設定する
     *
     * @param hasImage 画像がある時 true
     */
    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    /**
     * 画像があるかどうかを返す
     *
     * @return 画像がある時 true
     */
    public boolean isHasImage() {
        return hasImage;
    }

    public Boolean isHasImageBoolean() {
        return hasImage;
    }

    /**
     * 処方があるかどうかを設定する
     *
     * @param hasRp 処方がある時 true
     */
    public void setHasRp(boolean hasRp) {
        this.hasRp = hasRp;
    }

    /**
     * 処方があるかどうかを返す
     *
     * @return 処方がある時 true
     */
    public boolean isHasRp() {
        return hasRp;
    }

    public Boolean isHasRpBoolean() {
        return hasRp;
    }

    /**
     * 処置があるかどうかを設定する
     *
     * @param hasTreatment 処置がある時 true
     */
    public void setHasTreatment(boolean hasTreatment) {
        this.hasTreatment = hasTreatment;
    }

    /**
     * 処置があるかどうかを返す
     *
     * @return 処置がある時 true
     */
    public boolean isHasTreatment() {
        return hasTreatment;
    }

    public Boolean isHasTreatmentBoolean() {
        return hasTreatment;
    }

    /**
     * ラボテストがあるかどうかを設定する
     *
     * @param hasLaboTest ラボテストがある時 true
     */
    public void setHasLaboTest(boolean hasLaboTest) {
        this.hasLaboTest = hasLaboTest;
    }

    public boolean isHasLaboTest() {
        return hasLaboTest;
    }

    /**
     * ラボテストがあるかどうかを返す
     *
     * @return ラボテストがある時 true
     */
    public Boolean isHasLaboTestBoolean() {
        return hasLaboTest;
    }

    /**
     * バージョン番号を設定する
     *
     * @param version バージョン番号
     */
    public void setVersionNumber(String version) {
        this.versionNumber = version;
    }

    /**
     * バージョン番号を返す
     *
     * @return バージョン番号
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * バージョンノートを設定する
     *
     * @param versionNotes バージョンノート
     */
    public void setVersionNotes(String versionNotes) {
        this.versionNotes = versionNotes;
    }

    /**
     * バージョンノートを返す
     *
     * @return バージョンノート
     */
    public String getVersionNotes() {
        return versionNotes;
    }

    /**
     * 親文書IDを設定する
     *
     * @param parentId 親文書ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 親文書IDを返す
     *
     * @return 親文書ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 親文書との関係を設定する
     *
     * @param parentIdRelation 親文書との関係
     */
    public void setParentIdRelation(String parentIdRelation) {
        this.parentIdRelation = parentIdRelation;
    }

    /**
     * 親文書との関係を返す
     *
     * @return 親文書との関係
     */
    public String getParentIdRelation() {
        return parentIdRelation;
    }

    /**
     * 親文書との関係説明を設定する
     *
     * @param relationDesc 親文書との関係説明
     */
    public void setParentIdDesc(String relationDesc) {
        this.parentIdDesc = relationDesc;
    }

    /**
     * 親文書との関係説明を返す
     *
     * @return 親文書との関係説明
     */
    public String getParentIdDesc() {
        return parentIdDesc;
    }

    /**
     * 親文書との関係体系を設定する
     *
     * @param relationCodeSys 親文書との関係体系を設定する。
     */
    public void setParentIdCodeSys(String relationCodeSys) {
        this.parentIdCodeSys = relationCodeSys;
    }

    /**
     * 親文書との関係体系を返す
     *
     * @return 親文書との関係体系
     */
    public String getParentIdCodeSys() {
        return parentIdCodeSys;
    }

    /**
     * アクセス権を返す
     *
     * @return AccessRightModelのコレクション
     */
    public Collection<AccessRightModel> getAccessRights() {
        return accessRights;
    }

    /**
     * アクセス権を設定する
     *
     * @param accessRights
     */
    public void setAccessRights(Collection<AccessRightModel> accessRights) {
        this.accessRights = accessRights;
    }

    /**
     * アクセス権を追加する
     *
     * @param accessRight 追加するアクセス権
     */
    public void addAccessRight(AccessRightModel accessRight) {
        if (accessRights == null) {
            setAccessRights(new ArrayList<AccessRightModel>(3));
        }
        accessRights.add(accessRight);
    }

    /**
     * この文書のステータスを設定する
     *
     * @param status この文書のステータス
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * この文書のステータスを返す
     *
     * @return この文書のステータス
     */
    public String getStatus() {
        return status;
    }

    public String getHandleClass() {
        return handleClass;
    }

    public void setHandleClass(String handleClass) {
        this.handleClass = handleClass;
    }

    /**
     * ハッシュ値を返す
     */
    @Override
    public int hashCode() {
        return docId.hashCode() + 11;
    }

    /**
     * 文書IDで eqaul かどうかを返す
     *
     * @param other
     * @return equal の時 true
     */
    @Override
    public boolean equals(Object other) {
        if (other != null && getClass() == other.getClass()) {
            return getDocId().equals(((DocInfoModel) other).getDocId());
        }
        return false;
    }

    /**
     * 最初の確定日及び確定日で比較する。
     *
     * @param other
     * @return 比較値
     */
    @Override
    public int compareTo(Object other) {
        if (other != null && getClass() == other.getClass()) {
            Date val1 = getFirstConfirmDate();
            Date val2 = ((DocInfoModel) other).getFirstConfirmDate();
            int result = (val1 != null && val2 != null) ? val1.compareTo(val2) : 0;
            if (result == 0) {
                val1 = getConfirmDate();
                val2 = ((DocInfoModel) other).getConfirmDate();
                result = (val1 != null && val2 != null) ? val1.compareTo(val2) : 0;
            }
            return result;
        }
        return -1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        DocInfoModel ret = new DocInfoModel();
//        ret.setAccessRights(this.getAccessRights());
        ret.setConfirmDate(this.getConfirmDate());
        ret.setDepartment(this.getDepartment());
        ret.setDepartmentCodeSys(this.getDepartmentCodeSys());
        ret.setDepartmentDesc(this.getDepartmentDesc());
//        ret.setDocPk(this.getDocPk());
//        ret.setDocId(this.getDocId());  //
        ret.setDocType(this.getDocType());
        ret.setFirstConfirmDate(this.getFirstConfirmDate());
        ret.setHandleClass(this.getHandleClass());
        ret.setHasImage(this.isHasImage());
        ret.setHasLaboTest(this.isHasLaboTest());
        ret.setHasMark(this.isHasMark());
        ret.setHasRp(this.isHasRp());
        ret.setHasTreatment(this.isHasTreatment());
        ret.setHealthInsurance(this.getHealthInsurance());
        ret.setHealthInsuranceCodeSys(this.getHealthInsuranceCodeSys());
        ret.setHealthInsuranceDesc(this.getHealthInsuranceDesc());
        ret.setHealthInsuranceGUID(this.getHealthInsuranceGUID());
//        ret.setParentId(this.getParentId());
//        ret.setParentIdCodeSys(this.getParentIdCodeSys());
//        ret.setParentIdDesc(this.getParentIdDesc());
//        ret.setParentIdRelation(this.getParentIdRelation());
//        ret.setParentPk(this.getParentPk()); //
        ret.setPurpose(this.getPurpose());
        ret.setPurposeCodeSys(this.getPurposeCodeSys());
        ret.setPurposeDesc(this.getPurposeDesc());
        ret.setStatus(this.getStatus());
        ret.setTitle(this.getTitle());
        ret.setVersionNotes(this.getVersionNotes());
        ret.setVersionNumber(this.getVersionNumber());
        return ret;

        // ret.setDocPk(this.getDocPk());
        // ret.setDocId(this.getDocId());
        // ret.setParentPk(this.getParentPk());
    }

    public String getLabtestOrderNumber() {
        return labtestOrderNumber;
    }

    public void setLabtestOrderNumber(String labtestOrderNumber) {
        this.labtestOrderNumber = labtestOrderNumber;
    }

    public boolean isSendClaim() {
        return sendClaim;
    }

    public void setSendClaim(boolean sendClaim) {
        this.sendClaim = sendClaim;
    }

    public boolean isSendLabtest() {
        return sendLabtest;
    }

    public void setSendLabtest(boolean sendLabtest) {
        this.sendLabtest = sendLabtest;
    }

    public boolean isSendMml() {
        return sendMml;
    }

    public void setSendMml(boolean sendMml) {
        this.sendMml = sendMml;
    }

    public String getFirstConfirmDateWithMark() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstConfirmDateTrimTime());
        if (IInfoModel.STATUS_TMP.equals(status)) {
            sb.append("仮");
        }
        if (IInfoModel.DOCTYPE_SUMMARY.equals(docType)) {
            sb.append("サ");
        }
        if (admission != null) {
            sb.append("入");
        }
        if (hasRp) {
            sb.append("薬");
        }
        return sb.toString();
    }

    public boolean isKarte() {
        boolean ret = IInfoModel.DOCTYPE_KARTE.equals(docType)
                || IInfoModel.DOCTYPE_S_KARTE.equals(docType);
        return ret;
    }

    public PVTHealthInsuranceModel getPVTHealthInsuranceModel() {
        return getpVTHealthInsuranceModel();
    }

    public void setPVTHealthInsuranceModel(PVTHealthInsuranceModel selectedInsurance) {
        this.setpVTHealthInsuranceModel(selectedInsurance);
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getCreaterLisence() {
        return createrLisence;
    }

    public void setCreaterLisence(String createrLisence) {
        this.createrLisence = createrLisence;
    }

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

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }
    
//minagawa^ CLAIM送信    (予定カルテ対応)
    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date date) {
        claimDate = date;
    }
//minagawa$    

    public boolean isPriscriptionOutput() {
        return priscriptionOutput;
    }

    public void setPriscriptionOutput(boolean priscriptionOutput) {
        this.priscriptionOutput = priscriptionOutput;
    }

    public PVTHealthInsuranceModel getpVTHealthInsuranceModel() {
        return pVTHealthInsuranceModel;
    }

    public void setpVTHealthInsuranceModel(PVTHealthInsuranceModel pVTHealthInsuranceModel) {
        this.pVTHealthInsuranceModel = pVTHealthInsuranceModel;
    }

    public Date getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(Date issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public String getInstitutionNumber() {
        return InstitutionNumber;
    }

    public void setInstitutionNumber(String InstitutionNumber) {
        this.InstitutionNumber = InstitutionNumber;
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

    public boolean isUseGeneralName() {
        return useGeneralName;
    }

    public void setUseGeneralName(boolean useGeneralName) {
        this.useGeneralName = useGeneralName;
    }

//minagawa^ 予定カルテ(予定カルテ対応)
    public boolean isScheduled() {
        boolean ret = (this.status != null
                && this.status.equals(IInfoModel.STATUS_TMP)
                && this.getFirstConfirmDate() != null
                && this.getConfirmDate() != null
                && this.getFirstConfirmDate().after(this.getConfirmDate()));
        return ret;
    }
//minagawa$    
}
