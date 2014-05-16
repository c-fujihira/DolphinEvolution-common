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
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * UserModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_users")
//@TransactionManagement(TransactionManagementType.BEAN)
//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserModel extends InfoModel implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * composite businnes key
     */
    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    private String sirName;

    private String givenName;

    @Column(nullable = false)
    private String commonName;

    @Embedded
    private LicenseModel licenseModel;

    @Embedded
    private DepartmentModel departmentValue;

    @Column(nullable = false)
    private String memberType;

    private String memo;

    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date registeredDate;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private FacilityModel facility;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RoleModel> roles;

    private String orcaId;

    /**
     * 麻薬施用者免許証番号
     */
    // @001 2009/09/10 仕様追加：処方せん備考欄に麻薬施用者を表記する必要があるため、ユーザ登録の項目として麻薬施用者免許証番号を追加
    private String useDrugId;

    /**
     * UserModelオブジェクトを生成する。
     */
    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 施設IDを除いたIDを返す。
     *
     * @return 施設IDを除いたID
     */
    public String idAsLocal() {
        int index = userId.indexOf(COMPOSITE_KEY_MAKER);
        return userId.substring(index + 1);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public LicenseModel getLicenseModel() {
        return licenseModel;
    }

    public void setLicenseModel(LicenseModel licenseValue) {
        this.licenseModel = licenseValue;
    }

    public FacilityModel getFacilityModel() {
        return facility;
    }

    public void setFacilityModel(FacilityModel facility) {
        this.facility = facility;
    }

    public DepartmentModel getDepartmentModel() {
        return departmentValue;
    }

    public void setDepartmentModel(DepartmentModel departmentValue) {
        this.departmentValue = departmentValue;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    /**
     * ユーザロールを追加する。
     *
     * @param value ユーザロール
     */
    public void addRole(RoleModel value) {

        if (roles == null) {
            roles = new ArrayList<>(1);
        }
        roles.add(value);
    }

    /**
     * 簡易ユーザ情報を返す。
     *
     * @return 簡易ユーザ情報
     */
    public UserLiteModel getLiteModel() {

        UserLiteModel model = new UserLiteModel();
        model.setUserId(getUserId());
        model.setCommonName(getCommonName());
        LicenseModel lm = new LicenseModel();
        lm.setLicense(getLicenseModel().getLicense());
        lm.setLicenseDesc(getLicenseModel().getLicenseDesc());
        lm.setLicenseCodeSys(getLicenseModel().getLicenseCodeSys());
        model.setLicenseModel(lm);
        return model;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrcaId() {
        return orcaId;
    }

    public void setOrcaId(String orcaId) {
        this.orcaId = orcaId;
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
        final UserModel other = (UserModel) obj;
        return id == other.id;
    }

    /**
     * 麻薬施用者免許証番号を返す。 @001 2009/09/10
     *
     * @return 麻薬施用者免許証番号
     */
    public String getUseDrugId() {
        return useDrugId;
    }

    /**
     * 麻薬施用者免許証番号を設定する。 @001 2009/09/10
     *
     * @param useDrugId 麻薬施用者免許証番号
     */
    public void setUseDrugId(String useDrugId) {
        this.useDrugId = useDrugId;
    }

}
