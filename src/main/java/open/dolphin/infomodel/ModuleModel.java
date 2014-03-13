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

import javax.persistence.*;

/**
 * ModuleModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_module")
public class ModuleModel extends KarteEntryBean
        implements Stamp, java.io.Serializable, java.lang.Cloneable {

    @Embedded
    private ModuleInfoBean moduleInfo;

    @Transient
    private IInfoModel model;

    @Lob
    @Column(nullable = false)
    private byte[] beanBytes;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private DocumentModel document;

    /**
     * ModuleModel オブジェクトを生成する
     */
    public ModuleModel() {
        moduleInfo = new ModuleInfoBean();
    }

    public DocumentModel getDocumentModel() {
        return document;
    }

    public void setDocumentModel(DocumentModel document) {
        this.document = document;
    }

    /**
     * setModuleInfoBean モジュール情報を設定する 
     *
     * @param moduleInfo モジュール情報
     */
    public void setModuleInfoBean(ModuleInfoBean moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    /**
     * getModuleInfoBean モジュール情報を返す
     *
     * @return モジュール情報
     */
    public ModuleInfoBean getModuleInfoBean() {
        return moduleInfo;
    }

    /**
     * setModel モジュールの情報モデル（実体のPOJO)を設定する
     *
     * @param model モデル
     */
    public void setModel(IInfoModel model) {
        this.model = model;
    }

    /**
     * getModel モジュールの情報モデル（実体のPOJO)を返す
     *
     * @return モデル
     */
    public IInfoModel getModel() {
        return model;
    }

    /**
     * getBeanBytes モジュールの永続化バイト配列を返す
     *
     * @return モジュールの永続化バイト配列
     */
    public byte[] getBeanBytes() {
        return beanBytes;
    }

    /**
     * setBeanBytes モジュールの永続化バイト配列を設定する
     *
     * @param beanBytes モジュールの永続化バイト配列
     */
    public void setBeanBytes(byte[] beanBytes) {
        this.beanBytes = beanBytes;
    }

    /**
     * compareTo ドキュメントに現れる順番で比較する
     *
     * @param other
     * @return 比較値
     */
    @Override
    public int compareTo(Object other) {
        if (other != null && getClass() == other.getClass()) {
            ModuleInfoBean moduleInfo1 = getModuleInfoBean();
            ModuleInfoBean moduleInfo2 = ((ModuleModel) other).getModuleInfoBean();
            return moduleInfo1.compareTo(moduleInfo2);
        }
        return -1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        ModuleModel ret = new ModuleModel();
        ret.setConfirmed(this.getConfirmed());
        ret.setEnded(this.getEnded());
        ret.setFirstConfirmed(this.getConfirmed());
        ret.setLinkId(this.getLinkId());
        ret.setLinkRelation(this.getLinkRelation());
        ret.setModuleInfoBean((ModuleInfoBean) this.getModuleInfoBean().clone());
        ret.setRecorded(this.getRecorded());
        ret.setStarted(this.getStarted());
        ret.setStatus(this.getStatus());

        byte[] bytes = this.getBeanBytes();
        if (bytes != null) {
            byte[] dest = new byte[bytes.length];
            System.arraycopy(bytes, 0, dest, 0, bytes.length);
            ret.setBeanBytes(dest);
        }

        if (model != null) {
            if (model instanceof BundleDolphin) {
                BundleDolphin m = (BundleDolphin) model;
                ret.setModel((BundleDolphin) m.clone());
            } else if (model instanceof BundleMed) {
                BundleMed m = (BundleMed) model;
                ret.setModel((BundleMed) m.clone());
            } else if (model instanceof ProgressCourse) {
                ProgressCourse m = (ProgressCourse) model;
                ret.setModel((ProgressCourse) m.clone());
            } else {
                throw new CloneNotSupportedException();
            }
        }

        // 下記は利用側で再設定する
        //ret.setKarteBean(this.getKarteBean());
        //ret.setUserModel(this.getUserModel());
        //ret.setDocumentModel(this.getDocumentModel());

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
        sb.append("stampName=").append(this.getModuleInfoBean().getStampName()).append("\n");
        sb.append("stampRole=").append(this.getModuleInfoBean().getStampRole()).append("\n");
        sb.append("entity=").append(this.getModuleInfoBean().getEntity()).append("\n");
        sb.append("stampNumber=").append(this.getModuleInfoBean().getStampNumber()).append("\n");
        if (this.getModel() instanceof BundleDolphin) {
            BundleDolphin cb = (BundleDolphin) this.getModel();
            sb.append(cb.toString());
        }
        return sb.toString();
    }
}
