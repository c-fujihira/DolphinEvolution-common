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

import java.util.Date;
import open.dolphin.infomodel.DocInfoModel;
import open.dolphin.infomodel.IInfoModel;

/**
 * DocInfoModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class DocInfoModelConverter implements IInfoModelConverter {

    private DocInfoModel model;

    public DocInfoModelConverter() {
    }

    // DocumentModel.id
    public long getDocPk() {
        return model.getDocPk();
    }

    // Parent DocumentModel.id
    public long getParentPk() {
        return model.getParentPk();
    }

    // 32-bit 文書ID MML
    public String getDocId() {
        return model.getDocId();
    }

    // 文書タイプ
    public String getDocType() {
        return model.getDocType();
    }

    // タイトル
    public String getTitle() {
        return model.getTitle();
    }

    // 生成目的
    public String getPurpose() {
        return model.getPurpose();
    }

    // 生成目的名称
    public String getPurposeDesc() {
        return model.getPurposeDesc();
    }

    // 生成目的コード体系
    public String getPurposeCodeSys() {
        return model.getPurposeCodeSys();
    }

    // 最初の確定日 = started
    public Date getFirstConfirmDate() {
        return model.getFirstConfirmDate();
    }

    // 確定日
    public Date getConfirmDate() {
        return model.getConfirmDate();
    }

    // 診療科
    public String getDepartment() {
        return model.getDepartment();
    }

    // 診療科名称（カンマ区切り）
    public String getDepartmentDesc() {
        return model.getDepartmentDesc();
    }

    // 診療科コード体系
    public String getDepartmentCodeSys() {
        return model.getDepartmentCodeSys();
    }

    // 健康保険
    public String getHealthInsurance() {
        return model.getHealthInsurance();
    }

    // 健康保険名称
    public String getHealthInsuranceDesc() {
        return model.getHealthInsuranceDesc();
    }

    // 健康保険コード体系
    public String getHealthInsuranceCodeSys() {
        return model.getHealthInsuranceCodeSys();
    }

    // 健康保険 GUID
    public String getHealthInsuranceGUID() {
        return model.getHealthInsuranceGUID();
    }

    // 注意フラグ
    public boolean getHasMark() {
        return model.isHasMark();
    }

    // イメージフラグ
    public boolean getHasImage() {
        return model.isHasImage();
    }

    // RPフラグ
    public boolean getHasRp() {
        return model.isHasRp();
    }

    // 処置フラグ
    public boolean getHasTreatment() {
        return model.isHasTreatment();
    }

    // 検体検査フラグ
    public boolean getHasLaboTest() {
        return model.isHasLaboTest();
    }

    // バージョン番号
    public String getVersionNumber() {
        return model.getVersionNumber();
    }

    // バージョンノート
    public String getVersionNotes() {
        return model.getVersionNotes();
    }

    // 親文書 32-bit ID
    public String getParentId() {
        return model.getParentId();
    }

    // 親文書との関係
    public String getParentIdRelation() {
        return model.getParentIdRelation();
    }

    // 親文書との関係名称
    public String getParentIdDesc() {
        return model.getParentIdDesc();
    }

    // 親文書との関係コード体系
    public String getParentIdCodeSys() {
        return model.getParentIdCodeSys();
    }

    // ステータス
    public String getStatus() {
        return model.getStatus();
    }

    // 検体検査オーダー番号
    public String getLabtestOrderNumber() {
        return model.getLabtestOrderNumber();
    }

    // JMS+MDB CLAIM送信パラメータの運び屋としての属性
    // 施設名
    public String getFacilityName() {
        return model.getFacilityName();
    }

    // 医療資格
    public String getCreaterLisence() {
        return model.getCreaterLisence();
    }

    public PVTHealthInsuranceModelConverter getPVTHealthInsuranceModel() {
        if (model.getPVTHealthInsuranceModel() != null) {
            PVTHealthInsuranceModelConverter con = new PVTHealthInsuranceModelConverter();
            con.setModel(model.getPVTHealthInsuranceModel());
            return con;
        }
        return null;
    }

    // 患者氏名
    public String getPatientName() {
        return model.getPatientName();
    }

    // 患者ID
    public String getPatientId() {
        return model.getPatientId();
    }

    // 患者性別
    public String getPatientGender() {
        return model.getPatientGender();
    }

//minagawa^ CLAIM送信(予定カルテ対応)
    public Date getClaimDate() {
        return model.getClaimDate();
    }
//minagawa$

    // CLAIM送信フラグ
    public boolean getSendClaim() {
        return model.isSendClaim();
    }

    // 検体検査送信フラグ
    public boolean getSendLabtest() {
        return model.isSendLabtest();
    }

    // MML送信フラグ
    public boolean getSendMml() {
        return model.isSendMml();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (DocInfoModel) model;
    }
}
