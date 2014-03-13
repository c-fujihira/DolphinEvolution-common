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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * 定期処方薬の延滞茶
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "msd_routineMed")
public class RoutineMedModel implements Serializable, Comparable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long karteId;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registDate;

    private Boolean bookmark = false;

    private String memo;

    @JsonDeserialize(contentAs = ModuleModel.class)
    //@ElementCollection
    //@CollectionTable(name="msd_routineMed_moduleList")
    //@OneToMany(fetch=FetchType.LAZY)    // PostgresだとEAGERだめ。MySQLは大丈夫
    @Transient
    private List<ModuleModel> moduleList;

    // OneToManyだと重複を許してくれないので…　ダサいｗ
    private String moduleIds;

    @JsonIgnore
    @Transient
    private String status;

    public RoutineMedModel() {
    }

    public long getId() {
        return id;
    }

    public long getKarteId() {
        return karteId;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public boolean getBookmark() {
        return bookmark;
    }

    public String getMemo() {
        return memo;
    }

    public List<ModuleModel> getModuleList() {
        return moduleList;
    }

    public String getModuleIds() {
        return moduleIds;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKarteId(long karteId) {
        this.karteId = karteId;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public void setBookmark(boolean b) {
        bookmark = b;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setModuleList(List<ModuleModel> list) {
        moduleList = list;
    }

    public void setModuleIds(String ids) {
        moduleIds = ids;
    }

    public String getRegistDateStr() {
        final SimpleDateFormat sdf = new SimpleDateFormat(IInfoModel.DATE_WITHOUT_TIME);
        return sdf.format(registDate);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Object o) {
        RoutineMedModel target = (RoutineMedModel) o;
        return registDate.compareTo(target.getRegistDate());
    }

    @Override
    public RoutineMedModel clone() throws CloneNotSupportedException {
        try {
            return (RoutineMedModel) super.clone();
        } catch (Exception ex) {
        }
        return null;
    }
}
