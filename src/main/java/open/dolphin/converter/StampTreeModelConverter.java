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
import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.StampTreeModel;

/**
 * StampTreeModelConverter
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class StampTreeModelConverter implements IInfoModelConverter {

    private StampTreeModel model;

    public StampTreeModelConverter() {
    }

    public long getId() {
        return model.getId();
    }

    public UserModelConverter getUserModel() {
        if (model.getUserModel() != null) {
            UserModelConverter con = new UserModelConverter();
            con.setModel(model.getUserModel());
            return con;
        }
        return null;
    }

    public String getName() {
        return model.getName();
    }

    public String getPublishType() {
        return model.getPublishType();
    }

    public String getCategory() {
        return model.getCategory();
    }

    public String getPartyName() {
        return model.getPartyName();
    }

    public String getUrl() {
        return model.getUrl();
    }

    public String getDescription() {
        return model.getDescription();
    }

    public Date getPublishedDate() {
        return model.getPublishedDate();
    }

    public Date getLastUpdated() {
        return model.getLastUpdated();
    }

    public String getPublished() {
        return model.getPublished();
    }

    public byte[] getTreeBytes() {
        return model.getTreeBytes();
    }

    public String getVersionNumber() {
        return model.getVersionNumber();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (StampTreeModel) model;
    }
}
