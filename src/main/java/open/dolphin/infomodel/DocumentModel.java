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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
//import org.hibernate.search.annotations.FullTextFilterDef;
//import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * DocumentModel
 *
 * @author Minagawa,Kazushi. Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Indexed(index = "document")
//@FullTextFilterDefs({
//    @FullTextFilterDef(name = "karteId", impl = KearteIdFilterFactory.class),
//    @FullTextFilterDef(name = "facilityPk", impl = FacilityPkFilterFactory.class)
//})
@Entity
@Table(name = "d_document")
public class DocumentModel extends KarteEntryBean
        implements java.io.Serializable, java.lang.Cloneable {

    @Embedded
    private DocInfoModel docInfo;

    @JsonManagedReference   // bi-directional references
    @JsonDeserialize(contentAs = ModuleModel.class)
    @IndexedEmbedded        // hibernate search
    @OneToMany(mappedBy = "document", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ModuleModel> modules;

    @JsonManagedReference   // bi-directional references
    @JsonDeserialize(contentAs = SchemaModel.class)
    @OneToMany(mappedBy = "document", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SchemaModel> schema;

    @OneToMany(mappedBy = "document", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AttachmentModel> attachment;

    /**
     * DocumentModelを生成する
     */
    public DocumentModel() {
        docInfo = new DocInfoModel();
        docInfo.setDocType(DOCTYPE_KARTE);
    }

    /**
     * toDetuch
     */
    public void toDetuch() {
        docInfo.setDocPk(getId());
        docInfo.setParentPk(getLinkId());
        docInfo.setConfirmDate(getConfirmed());
        docInfo.setFirstConfirmDate(getStarted());
        docInfo.setStatus(getStatus());
        docInfo.setPurpose(getUserModel().getCommonName());
    }

    /**
     * toPersist
     */
    public void toPersist() {
        setLinkId(docInfo.getParentPk());
        setLinkRelation(docInfo.getParentIdRelation());
        setConfirmed(docInfo.getConfirmDate());
        setFirstConfirmed(docInfo.getFirstConfirmDate());
        setStatus(docInfo.getStatus());
    }

    /**
     * getDocInfoModel 文書情報を返す
     *
     * @return 文書情報
     */
    public DocInfoModel getDocInfoModel() {
        return docInfo;
    }

    /**
     * setDocInfoModel 文書情報を設定する
     *
     * @param docInfo 文書情報
     */
    public void setDocInfoModel(DocInfoModel docInfo) {
        this.docInfo = docInfo;
    }

    /**
     * getSchema シェーマを返す
     *
     * @return シェーマ
     */
    public List<SchemaModel> getSchema() {
        return schema;
    }

    /**
     * setSchema シェーマを設定する
     *
     * @param images シェーマ
     */
    public void setSchema(List<SchemaModel> images) {
        this.schema = images;
    }

    /**
     * addSchema シェーマを追加する
     *
     * @param model シェーマ
     */
    public void addSchema(SchemaModel model) {
        if (this.schema == null) {
            this.schema = new ArrayList<>();
        }
        this.schema.add(model);
    }

    /**
     * clearSchema シェーマコレクションをクリアする
     */
    public void clearSchema() {
        if (schema != null && schema.size() > 0) {
            schema.clear();
        }
    }

    /**
     * getSchema
     *
     * @param index
     * @return
     */
    public SchemaModel getSchema(int index) {
        if (schema != null && schema.size() > 0) {
            int cnt = 0;
            for (SchemaModel bean : schema) {
                if (index == cnt) {
                    return bean;
                }
                cnt++;
            }
        }
        return null;
    }

    /**
     * getAttachment アタッチメントを返す
     *
     * @return アタッチメント
     */
    public List<AttachmentModel> getAttachment() {
        return attachment;
    }

    /**
     * setAttachment アタッチメント
     *
     * @param att
     */
    public void setAttachment(List<AttachmentModel> att) {
        this.attachment = att;
    }

    /**
     * addAttachment アタッチメントを追加する
     *
     * @param model アタッチメント
     */
    public void addAttachment(AttachmentModel model) {
        if (this.attachment == null) {
            this.attachment = new ArrayList<>();
        }
        this.attachment.add(model);
    }

    /**
     * clearAttachment アタッチメントコレクションをクリアする
     */
    public void clearAttachment() {
        if (attachment != null && attachment.size() > 0) {
            attachment.clear();
        }
    }

    /**
     * AttachmentModel
     *
     * @param index
     * @return
     */
    public AttachmentModel getAttachment(int index) {
        if (attachment != null && attachment.size() > 0) {
            int cnt = 0;
            for (AttachmentModel bean : attachment) {
                if (index == cnt) {
                    return bean;
                }
                cnt++;
            }
        }
        return null;
    }

    /**
     * getModules モジュールを返す
     *
     * @return モジュール
     */
    public List<ModuleModel> getModules() {
        return modules;
    }

    /**
     * モジュールを設定する
     *
     * @param modules モジュール
     */
    public void setModules(List<ModuleModel> modules) {
        this.modules = modules;
    }

    /**
     * モジュールモデルの配列を追加する
     *
     * @param addArray
     */
    public void addModule(ModuleModel[] addArray) {
        if (modules == null) {
            modules = new ArrayList<>(addArray.length);
        }
        modules.addAll(Arrays.asList(addArray));
    }

    /**
     * モジュールモデルを追加する
     *
     * @param addModule
     */
    public void addModule(ModuleModel addModule) {
        if (modules == null) {
            modules = new ArrayList<>();
        }
        modules.add(addModule);
    }

    /**
     * モジュールをクリアする
     */
    public void clearModules() {
        if (modules != null && modules.size() > 0) {
            modules.clear();
        }
    }

    /**
     * 引数のエンティティを持つモジュールモデルを返す。
     *
     * @param entityName エンティティの名前
     * @return 該当するモジュールモデル
     */
    public ModuleModel getModule(String entityName) {

        if (modules != null) {

            ModuleModel ret = null;

            for (ModuleModel model : modules) {
                if (model.getModuleInfoBean().getEntity().equals(entityName)) {
                    ret = model;
                    break;
                }
            }
            return ret;
        }

        return null;
    }

    /**
     * 引数のエンティティ名を持つモジュール情報を返す。
     *
     * @param entityName エンティティの名前
     * @return モジュール情報
     */
    public ModuleInfoBean[] getModuleInfo(String entityName) {

        if (modules != null) {

            ArrayList<ModuleInfoBean> list = new ArrayList<>(2);

            for (ModuleModel model : modules) {

                if (model.getModuleInfoBean().getEntity().equals(entityName)) {
                    list.add(model.getModuleInfoBean());
                }
            }

            if (list.size() > 0) {
                return (ModuleInfoBean[]) list.toArray(new ModuleInfoBean[list.size()]);
            }
        }

        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        DocumentModel ret = new DocumentModel();
        ret.setConfirmed(this.getConfirmed());
        ret.setDocInfoModel((DocInfoModel) this.getDocInfoModel().clone());
        ret.setEnded(this.getEnded());
        ret.setFirstConfirmed(this.getFirstConfirmed());
        ret.setLinkId(this.getLinkId());
        ret.setLinkRelation(this.getLinkRelation());
        ret.setRecorded(this.getRecorded());
        ret.setStarted(this.getStarted());
        ret.setStatus(this.getStatus());

        if (modules != null && modules.size() > 0) {
            for (ModuleModel module : modules) {
                ModuleModel m = (ModuleModel) module.clone();
                m.setDocumentModel(ret);
                ret.addModule(m);
            }
        }

        if (schema != null && schema.size() > 0) {
            for (SchemaModel sm : schema) {
                SchemaModel m = (SchemaModel) sm.clone();
                m.setDocumentModel(ret);
                ret.addSchema(m);
            }
        }

        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("confirmed=").append(this.getConfirmed()).append("\n");
        sb.append("started=").append(this.getStarted()).append("\n");
        sb.append("recorded=").append(this.getRecorded()).append("\n");
        sb.append("status=").append(this.getStatus()).append("\n");
        sb.append("userModel PK=").append(this.getUserModel().getId()).append("\n");
        sb.append("karteBean PK=").append(this.getKarteBean().getId()).append("\n");
        sb.append("docId=").append(this.getDocInfoModel().getDocId()).append("\n");
        sb.append("docType=").append(this.getDocInfoModel().getDocType()).append("\n");
        sb.append("title=").append(this.getDocInfoModel().getTitle()).append("\n");
        sb.append("purpose=").append(this.getDocInfoModel().getPurpose()).append("\n");
        sb.append("department=").append(this.getDocInfoModel().getDepartment()).append("\n");
        sb.append("departmentDesc=").append(this.getDocInfoModel().getDepartmentDesc()).append("\n");
        sb.append("healthInsurance=").append(this.getDocInfoModel().getHealthInsurance()).append("\n");
        sb.append("healthInsuranceDesc=").append(this.getDocInfoModel().getHealthInsuranceDesc()).append("\n");
        sb.append("healthInsuranceGUID=").append(this.getDocInfoModel().getHealthInsuranceGUID()).append("\n");
        sb.append("num modules=").append(this.getModules().size()).append("\n");
        if (this.getSchema() != null && this.getSchema().size() > 0) {
            for (SchemaModel s : schema) {
                sb.append("---------------------------------").append("\n");
                sb.append(s.toString());
            }
        }
        if (this.getModules() != null && this.getModules().size() > 0) {
            for (ModuleModel m : modules) {
                sb.append("---------------------------------").append("\n");
                sb.append(m.toString());
            }
        }
        return sb.toString();
    }

    // (予定カルテ対応)
    public DocumentModel rpClone() {

        try {
            DocumentModel ret = new DocumentModel();
            if (modules != null && modules.size() > 0) {
                for (ModuleModel module : modules) {
                    // 処方のみ
                    if (module.getModuleInfoBean().getEntity().equals(IInfoModel.ENTITY_MED_ORDER)) {
                        ModuleModel m = (ModuleModel) module.clone();
                        //reset properties^
                        m.setStarted(null);
                        m.setConfirmed(null);
                        m.setEnded(null);
                        m.setStatus(null);
                        m.setLinkId(0L);
                        m.setLinkRelation(null);
                        //reset properties$ 
                        ret.addModule(m);
                    }
                }
            }

            // 適用する処方がない時
            boolean hasRp = (ret.getModules() != null && !ret.getModules().isEmpty());

            // DocInfo 基本属性
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            ret.getDocInfoModel().setDocId(uuid);
            ret.getDocInfoModel().setDocType(this.getDocInfoModel().getDocType());
            ret.getDocInfoModel().setTitle("予定");
            ret.getDocInfoModel().setPurpose(this.getDocInfoModel().getPurpose());
            ret.getDocInfoModel().setHasRp(hasRp);
            ret.getDocInfoModel().setVersionNumber("1.0");
            
            // 下記は利用側で再設定する
            //ret.setKarteBean(this.getKarteBean());
            //ret.setUserModel(this.getUserModel());
            //ret.setDocumentModel(this.getDocumentModel());
            
            return ret;

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    // (予定カルテ対応)
    public DocumentModel claimClone() {
        if (modules == null && modules.isEmpty()) {
            return null;
        }
        DocumentModel ret = new DocumentModel();
        for (ModuleModel module : modules) {
            if (module.getModuleInfoBean().getStampRole().equals(IInfoModel.ROLE_P)) {
                ModuleModel m;
                try {
                    m = (ModuleModel) module.clone();
                    ret.addModule(m);
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
        if (ret.getModules() == null && ret.getModules().isEmpty()) {
            return null;
        }
        ret.getDocInfoModel().setDocId(this.getDocInfoModel().getDocId());
        ret.getDocInfoModel().setDocType(this.getDocInfoModel().getDocType());
        ret.getDocInfoModel().setTitle(this.getDocInfoModel().getTitle());
        ret.getDocInfoModel().setPurpose(this.getDocInfoModel().getPurpose());
        ret.getDocInfoModel().setVersionNumber("1.0");
        ret.getDocInfoModel().setDepartmentDesc(this.getDocInfoModel().getDepartmentDesc());
        ret.getDocInfoModel().setDepartment(this.getDocInfoModel().getDepartment());
        ret.getDocInfoModel().setHealthInsuranceDesc(this.getDocInfoModel().getHealthInsuranceDesc());
        ret.getDocInfoModel().setHealthInsurance(this.getDocInfoModel().getHealthInsurance());
        ret.getDocInfoModel().setHealthInsuranceGUID(this.getDocInfoModel().getHealthInsuranceGUID());
        ret.getDocInfoModel().setDocPk(getId());
        ret.getDocInfoModel().setParentPk(getLinkId());
        ret.getDocInfoModel().setConfirmDate(getConfirmed());
        ret.getDocInfoModel().setFirstConfirmDate(getStarted());
        ret.getDocInfoModel().setStatus(getStatus());
        ret.getDocInfoModel().setClaimDate(this.getDocInfoModel().getClaimDate());
        return ret;
    }
}
