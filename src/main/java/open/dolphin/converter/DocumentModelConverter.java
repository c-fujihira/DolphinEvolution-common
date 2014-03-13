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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import open.dolphin.infomodel.*;

/**
 * DocumentModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class DocumentModelConverter implements IInfoModelConverter {

    private DocumentModel model;

    public DocumentModelConverter() {
    }

    public long getId() {
        return model.getId();
    }

    public Date getConfirmed() {
        return model.getConfirmed();
    }

    public Date getStarted() {
        return model.getStarted();
    }

    public Date getEnded() {
        return model.getEnded();
    }

    public Date getRecorded() {
        return model.getRecorded();
    }

    public long getLinkId() {
        return model.getLinkId();
    }

    public String getLinkRelation() {
        return model.getLinkRelation();
    }

    public String getStatus() {
        return model.getStatus();
    }

//    // @ManyToOne 外部制約
//    public UserModel getUserModel() {
//        return model.getUserModel();
//    }
//
//    // @ManyToOne 外部制約
//    public KarteBean getKarteBean() {
//        return model.getKarteBean();
//    }

    public UserModelConverter getUserModel() {
        if (model.getUserModel() != null) {
            UserModelConverter con = new UserModelConverter();
            con.setModel(model.getUserModel());
            return con;
        }
        return null;
    }

    public KarteBeanConverter getKarteBean() {
        if (model.getKarteBean() != null) {
            KarteBeanConverter con = new KarteBeanConverter();
            con.setModel(model.getKarteBean());
            return con;
        }
        return null;
    }

    public DocInfoModelConverter getDocInfoModel() {
        if (model.getDocInfoModel() != null) {
            DocInfoModelConverter con = new DocInfoModelConverter();
            con.setModel(model.getDocInfoModel());
            return con;
        }
        return null;
    }

    public List<ModuleModelConverter> getModules() {
        List<ModuleModel> list = model.getModules();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<ModuleModelConverter> ret = new ArrayList<>();
        for (ModuleModel m : list) {
            ModuleModelConverter con = new ModuleModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<SchemaModelConverter> getSchema() {
        List<SchemaModel> list = model.getSchema();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<SchemaModelConverter> ret = new ArrayList<>();
        for (SchemaModel m : list) {
            SchemaModelConverter con = new SchemaModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    public List<AttachmentModelConverter> getAttachment() {
        List<AttachmentModel> list = model.getAttachment();
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<AttachmentModelConverter> ret = new ArrayList<>();
        for (AttachmentModel m : list) {
            AttachmentModelConverter con = new AttachmentModelConverter();
            con.setModel(m);
            ret.add(con);
        }
        return ret;
    }

    @Override
    public void setModel(IInfoModel m) {
        this.model = (DocumentModel) m;

        // 外部制約先の全ての情報は必要ないためPK以外の属性はnullにしたダミーモデルを設定する
        KarteBean dummyKarteBean = PlistConverter.createDuumyKarteBean(model.getKarteBean().getId());
        UserModel dummyUser = PlistConverter.createDummyUserModel(model.getUserModel().getId());
        dummyUser.setCommonName(model.getUserModel().getCommonName());
        model.setKarteBean(dummyKarteBean);
        model.setUserModel(dummyUser);
    }
}
