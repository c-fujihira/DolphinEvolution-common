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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * PatientModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified by masuda, Masuda Naika
 * @author modified by Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_patient")
public class PatientModel extends InfoModel implements java.io.Serializable {

    private static final long DAY_IN_MILLISEC = 1000 * 60 * 60 * 24;

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // 施設ID
    @Column(nullable = false)
    private String facilityId;

    // 施設内の患者ID 
    @Column(nullable = false)
    private String patientId;

    // 姓
    private String familyName;

    // 名
    private String givenName;

    // 姓名
    @Column(nullable = false)
    private String fullName;

    // 姓カナ
    private String kanaFamilyName;

    // 名カナ
    private String kanaGivenName;

    // 姓名カナ
    private String kanaName;

    // ローマ字姓
    private String romanFamilyName;

    // ローマ字名
    private String romanGivenName;

    // ローマ字姓名
    private String romanName;

    // 性別コード値
    @Column(nullable = false)
    private String gender;

    // 性別表記
    private String genderDesc;

    // 性別コード体系
    @Transient
    private String genderCodeSys;

    // 生年月日 yyyy-MM-dd
    private String birthday;

    // 国籍コード値
    private String nationality;

    // 国籍表記
    @Transient
    private String nationalityDesc;

    // 国籍コード体系
    @Transient
    private String nationalityCodeSys;

    // 婚姻状況コード値
    private String maritalStatus;

    // 婚姻状況表記
    @Transient
    private String maritalStatusDesc;

    // 婚姻状況コード体系
    @Transient
    private String maritalStatusCodeSys;

    // JPEG形式写真データ
    @Lob
    private byte[] jpegPhoto;

    // メモ
    private String memo;

    // 連絡先住所
    @Embedded
    private SimpleAddressModel address;

    // 電話番号
    private String telephone;

    // 携帯番号
    private String mobilePhone;

    // 電子メールアドレス
    private String email;

    // 家族等
    private String relations;

    // 健康保険 DBへへ保存されているPVTHealthInsuranceModel
    @JsonDeserialize(contentAs = HealthInsuranceModel.class)
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<HealthInsuranceModel> healthInsurances;

    // 健康保険 クライント等が使用
    @Transient
    private List<PVTHealthInsuranceModel> pvtHealthInsurances;

    // 住所
    @Transient
    private Collection<AddressModel> addresses;

    // 電話番号
    @Transient
    private Collection<TelephoneModel> telephones;

//masuda^    
    @JsonDeserialize(contentAs = Long.class)
    @Transient
    private List<Long> docPkList;
    @Transient
    private String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Long> getDocPkList() {
        return docPkList;
    }

    public void setDocPkList(List<Long> docPkList) {
        this.docPkList = docPkList;
    }

    // 受診日。患者検索で使用
    @Transient
    private String pvtDate;

    @Transient
    private Date pvtDate2;

    public String getPvtDate() {
        return pvtDate;
    }

    public void setPvtDate(String pvtDate) {
        this.pvtDate = pvtDate;
        pvtDate2 = ModelUtils.getDateAsObject(pvtDate);
    }

    public Date getPvtDate2() {
        return pvtDate2;
    }

    public int getElapsedDay() {
        long now = System.currentTimeMillis();
        int ret = (int) ((now - pvtDate2.getTime()) / DAY_IN_MILLISEC);
        return ret;
    }

    public String getPvtDateTrimTime() {
        return ModelUtils.trimTime(pvtDate);
    }

    public String getPvtDateTrimDate() {
        return ModelUtils.trimDate(pvtDate);
    }

    // 算定情報
    @Embedded
    private SanteiInfoModel santeiInfo;

    public SanteiInfoModel getSanteiInfoModel() {
        return santeiInfo;
    }

    public void setSanteiInfoModel(SanteiInfoModel info) {
        santeiInfo = info;
    }

//masuda^ 排他処理関連
    private String ownerUUID;   // 現在の所有者UUID

    public void setOwnerUUID(String uuid) {
        ownerUUID = uuid;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    // 入院モデル
    @Transient
    private AdmissionModel admission;

    public void setAdmissionModel(AdmissionModel model) {
        admission = model;
    }

    public boolean isOpened() {
        return ownerUUID != null;
    }
//masuda$   
    public AdmissionModel getAdmissionModel() {
        return admission;
    }

//minagawa^ 新患検索用に初診日=(カルテ作成日）を追加 for ios7 対応
//PC用コンバータでは不要    
    @Transient
    private Date firstVisited;
    
    public Date getFirstVisited() {
        return firstVisited;
    }

    public void setFirstVisited(Date firstVisited) {
        this.firstVisited = firstVisited;
    }
//minagawa$    

    /**
     * 患者オブジェクトを生成する。
     */
    public PatientModel() {
        santeiInfo = new SanteiInfoModel();
    }

    /**
     * Database Pk を返す。
     *
     * @return Database Pk
     */
    public long getId() {
        return id;
    }

    /**
     * Database Pk を設定する。
     *
     * @param id Database Pk
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 施設IDを返す。
     *
     * @return 施設ID
     */
    public String getFacilityId() {
        return facilityId;
    }

    /**
     * 施設IDを設定する。
     *
     * @param facilityId 施設ID
     */
    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    /**
     * 患者IDを設定する。
     *
     * @param patientId 患者ID
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * 患者IDを返す。
     *
     * @return 患者ID
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * 姓名を設定する。
     *
     * @param sirName 姓名
     */
    public void setFamilyName(String sirName) {
        this.familyName = sirName;
    }

    /**
     * 姓名を返す。
     *
     * @return 姓名
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 名前を設定する。
     *
     * @param givenName 名前
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 名前を返す。
     *
     * @return 名前
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * フルネームを設定する。
     *
     * @param name フルネーム
     */
    public void setFullName(String name) {
        this.fullName = name;
    }

    /**
     * フルネームを返す。
     *
     * @return フルネーム
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * カナ家族名を設定する。
     *
     * @param kanaSirName カナ家族名
     */
    public void setKanaFamilyName(String kanaSirName) {
        this.kanaFamilyName = kanaSirName;
    }

    /**
     * カナ家族名を返す。
     *
     * @return カナ家族名
     */
    public String getKanaFamilyName() {
        return kanaFamilyName;
    }

    /**
     * カナGivenName を設定する。
     *
     * @param kanaGivenName カナGivenName
     */
    public void setKanaGivenName(String kanaGivenName) {
        this.kanaGivenName = kanaGivenName;
    }

    /**
     * カナGivenName を返す。
     *
     * @return カナGivenName
     */
    public String getKanaGivenName() {
        return kanaGivenName;
    }

    /**
     * カナフルネームを設定する。
     *
     * @param kanaName カナフルネーム
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * カナフルネームを返す。
     *
     * @return カナフルネーム
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * ローマ字名字を設定する。
     *
     * @param romanSirName ローマ字名字
     */
    public void setRomanFamilyName(String romanSirName) {
        this.romanFamilyName = romanSirName;
    }

    /**
     * ローマ字名字を返す。
     *
     * @return ローマ字名
     */
    public String getRomanFamilyName() {
        return romanFamilyName;
    }

    /**
     * ローマ字名を設定する。
     *
     * @param romanGivenName ローマ字名
     */
    public void setRomanGivenName(String romanGivenName) {
        this.romanGivenName = romanGivenName;
    }

    /**
     * ローマ字名を返す。
     *
     * @return ローマ字名
     */
    public String getRomanGivenName() {
        return romanGivenName;
    }

    /**
     * ローマ字フルネームを設定する。
     *
     * @param romanName ローマ字フルネーム
     */
    public void setRomanName(String romanName) {
        this.romanName = romanName;
    }

    /**
     * ローマ字フルネームを返す。
     *
     * @return ローマ字フルネーム
     */
    public String getRomanName() {
        return romanName;
    }

    /**
     * 性別を設定する。
     *
     * @param gender 性別
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 性別を返す。
     *
     * @return 性別
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性別説明を設定する。
     *
     * @param genderDesc 性別説明
     */
    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    /**
     * 性別説明を返す。
     *
     * @return 性別説明
     */
    public String getGenderDesc() {
        return genderDesc != null
                ? genderDesc
                : ModelUtils.getGenderDesc(gender);
    }

    /**
     * 性別説明体系を設定する。
     *
     * @param genderCodeSys 性別説明体系
     */
    public void setGenderCodeSys(String genderCodeSys) {
        this.genderCodeSys = genderCodeSys;
    }

    /**
     * 性別説明体系を返す。
     *
     * @return 性別説明体系
     */
    public String getGenderCodeSys() {
        return genderCodeSys;
    }

    /**
     * 生年月日を設定する。
     *
     * @param birthday 生年月日 yyyy-MM-dd
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 生年月日を返す。
     *
     * @return 生年月日 yyyy-MM-dd
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 年齢と生年月日を返す。
     *
     * @return age(yyyy-MM-dd)
     */
    public String getAgeBirthday() {
        return ModelUtils.getAgeBirthday(birthday);
    }

    /**
     * 国籍を設定する。
     *
     * @param nationality 国籍
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 国籍を返す。
     *
     * @return 国籍
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 国籍説明を設定する。
     *
     * @param nationalityDesc 国籍説明
     */
    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    /**
     * 国籍説明を返す。
     *
     * @return 国籍説明
     */
    public String getNationalityDesc() {
        return nationalityDesc;
    }

    /**
     * 国籍体系を設定する。
     *
     * @param nationalityCodeSys 国籍体系
     */
    public void setNationalityCodeSys(String nationalityCodeSys) {
        this.nationalityCodeSys = nationalityCodeSys;
    }

    /**
     * 国籍体系を返す。
     *
     * @return 国籍体系
     */
    public String getNationalityCodeSys() {
        return nationalityCodeSys;
    }

    /**
     * 婚姻状況を設定する。
     *
     * @param maritalStatus 婚姻状況
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 婚姻状況を返す。
     *
     * @return 婚姻状況
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 婚姻状況説明を設定する。
     *
     * @param maritalStatusDesc 婚姻状況説明を設定する。
     */
    public void setMaritalStatusDesc(String maritalStatusDesc) {
        this.maritalStatusDesc = maritalStatusDesc;
    }

    /**
     * 婚姻状況説明を返す。
     *
     * @return 婚姻状況説明
     */
    public String getMaritalStatusDesc() {
        return maritalStatusDesc;
    }

    /**
     * 婚姻状況体系を設定する
     *
     * @param maritalStatusCodeSys 婚姻状況体系
     */
    public void setMaritalStatusCodeSys(String maritalStatusCodeSys) {
        this.maritalStatusCodeSys = maritalStatusCodeSys;
    }

    /**
     * 婚姻状況体系を返す。
     *
     * @return 婚姻状況体系
     */
    public String getMaritalStatusCodeSys() {
        return maritalStatusCodeSys;
    }

    /**
     * 写真を設定する。
     *
     * @param jpegPhoto JPEG 画像のバイト配列
     */
    public void setJpegPhoto(byte[] jpegPhoto) {
        this.jpegPhoto = jpegPhoto;
    }

    /**
     * 写真を返す。
     *
     * @return JPEG 画像のバイト配列
     */
    public byte[] getJpegPhoto() {
        return jpegPhoto;
    }

    /**
     * 患者メモを設定する。
     *
     * @param memo 患者メモ
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 患者メモを返す。
     *
     * @return 患者メモ
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 住所モデルを返す。
     *
     * @return 住所モエル
     */
    public SimpleAddressModel getSimpleAddressModel() {
        return address;
    }

    /**
     * 住所モデルを設定する。
     *
     * @param address 住所モデル
     */
    public void setSimpleAddressModel(SimpleAddressModel address) {
        this.address = address;
    }

    /**
     * 郵便番号を返す。
     *
     * @return 郵便番号
     */
    public String contactZipCode() {
        return (address != null) ? address.getZipCode() : null;
    }

    /**
     * 住所を返す。
     *
     * @return 住所
     */
    public String contactAddress() {
        return (address != null) ? address.getAddress() : null;
    }

    /**
     * 足場コード
     *
     * @return 住所
     */
    public String getHomeAddress() {
        return (address != null) ? address.getAddress() : null;
    }

    /**
     * 電話番号を返す。
     *
     * @return 電話番号
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 電話番号を設定する。
     *
     * @param telephone 電話番号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 携帯電話の番号を返す。
     *
     * @return 携帯電話の番号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 携帯電話の番号を設定する。
     *
     * @param mobilePhone 携帯電話の番号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 電子メールアドレスを返す。
     *
     * @return 電子メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * 電子メールアドレスを設定する。
     *
     * @param email 電子メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 健康保険を設定する。
     *
     * @param healthInsurances 健康保険
     */
    public void setHealthInsurances(
            List<HealthInsuranceModel> healthInsurances) {
        this.healthInsurances = healthInsurances;
    }

    /**
     * 健康保険を返す。
     *
     * @return 健康保険
     */
    public List<HealthInsuranceModel> getHealthInsurances() {
        return healthInsurances;
    }

    /**
     * 健康保険を追加する。
     *
     * @param value 健康保険
     */
    public void addHealthInsurance(HealthInsuranceModel value) {
        if (healthInsurances == null) {
            healthInsurances = new ArrayList<>(2);
        }
        healthInsurances.add(value);
    }

    public List<PVTHealthInsuranceModel> getPvtHealthInsurances() {
        return pvtHealthInsurances;
    }

    public void setPvtHealthInsurances(
            List<PVTHealthInsuranceModel> pvtHealthInsurances) {
        this.pvtHealthInsurances = pvtHealthInsurances;
    }

    public void addPvtHealthInsurance(PVTHealthInsuranceModel model) {
        if (pvtHealthInsurances == null) {
            pvtHealthInsurances = new ArrayList<>(2);
        }
        pvtHealthInsurances.add(model);
    }

    public Collection<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(AddressModel address) {
        if (addresses == null) {
            addresses = new ArrayList<>(1);
        }
        addresses.add(address);
    }

    public Collection<TelephoneModel> getTelephones() {
        return telephones;
    }

    public void setTelephones(Collection<TelephoneModel> telephones) {
        this.telephones = telephones;
    }

    public void addTelephone(TelephoneModel telephone) {
        if (telephones == null) {
            telephones = new ArrayList<>(1);
        }
        telephones.add(telephone);
    }

    /**
     * 患者簡易情報を返す。
     *
     * @return 患者簡易情報
     */
    public PatientLiteModel patientAsLiteModel() {
        PatientLiteModel model = new PatientLiteModel();
        model.setPatientId(getPatientId());
        model.setFullName(getFullName());
        model.setKanaName(getKanaName());
        model.setGender(getGender());
        model.setGenderDesc(getGenderDesc());
        model.setBirthday(getBirthday());
        return model;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PatientModel other = (PatientModel) obj;
        return id == other.id;
    }

    public SimpleAddressModel getAddress() {
        return getSimpleAddressModel();
    }

    public void setAddress(SimpleAddressModel address) {
        setSimpleAddressModel(address);
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getAgeBirthday2() {
        return ModelUtils.getAgeBirthday2(birthday);
    }

    public String getAge() {
        return ModelUtils.getAge(birthday);
    }

    public String getRoom() {
        return (admission != null) ? admission.getRoom() : null;
    }

    public String getDeptName() {
        return (admission != null) ? admission.getDepartment() : null;
    }

    public String getAdmissionDate() {
        if (admission != null) {
            SimpleDateFormat frmt = new SimpleDateFormat(DATE_WITHOUT_TIME);
            return frmt.format(admission.getStarted());
        }
        return null;
    }

    public String getDoctorName() {
        return (admission != null) ? admission.getDoctorName() : null;
    }

}
