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
import javax.persistence.*;

/**
 * Userのパーソナルツリークラス
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_stamp_tree")
public class StampTreeModel extends InfoModel implements IStampTreeModel, java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // UserPK
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    // TreeSetの名称
    @Column(name = "tree_name", nullable = false)
    private String name;

    // OID or Public
    // OID の時は施設用
    private String publishType;

    // Treeのカテゴリ
    private String category;

    // 団体名等
    private String partyName;

    // URL
    private String url;

    // 説明
    private String description;

    // 公開した日
    @Temporal(value = TemporalType.DATE)
    private Date publishedDate;

    // 最終更新日
    @Temporal(value = TemporalType.DATE)
    private Date lastUpdated;

    // 公開しているtreeのエンティティ
    private String published;

    @Transient
    private String treeXml;

    @Lob
    @Column(nullable = false)
    private byte[] treeBytes;

    private String versionNumber;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public UserModel getUserModel() {
        return user;
    }

    @Override
    public void setUserModel(UserModel user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPublishType() {
        return publishType;
    }

    @Override
    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getPartyName() {
        return partyName;
    }

    @Override
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getPublishedDate() {
        return publishedDate;
    }

    @Override
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public byte[] getTreeBytes() {
        return treeBytes;
    }

    @Override
    public void setTreeBytes(byte[] treeBytes) {
        this.treeBytes = treeBytes;
    }

    @Override
    public String getTreeXml() {
        return treeXml;
    }

    @Override
    public void setTreeXml(String treeXml) {
        this.treeXml = treeXml;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String num) {
        versionNumber = num;
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
        final StampTreeModel other = (StampTreeModel) obj;
        return id == other.id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        StampTreeModel ret = new StampTreeModel();
        ret.setName("個人用");
        ret.setDescription("個人用のスタンプセットです");
        ret.setTreeXml(this.getTreeXml());
        ret.setTreeBytes(this.getTreeBytes());
        return ret;
    }
}
