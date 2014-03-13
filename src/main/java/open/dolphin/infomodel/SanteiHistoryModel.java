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
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 算定履歴を記録する
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "msd_santeiHistory")
public class SanteiHistoryModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String srycd;

    private int itemCount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false) // "moduleModel_id"
    private ModuleModel moduleModel;

    private int itemIndex;

    @Transient
    private Date santeiDate;

    public Date getSanteiDate() {
        return santeiDate;
    }

    public void setSanteiDate(Date date) {
        this.santeiDate = date;
    }

    @Transient
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @JsonIgnore
    @Transient
    private ETensuModel1 eTensuModel1;

    public ETensuModel1 getETensuModel1() {
        return eTensuModel1;
    }

    public void setETensuModel1(ETensuModel1 model) {
        eTensuModel1 = model;
    }

    public SanteiHistoryModel() {
    }

    public long getId() {
        return id;
    }

    public String getSrycd() {
        return srycd;
    }

    public int getItemCount() {
        return itemCount;
    }

    public ModuleModel getModuleModel() {
        return moduleModel;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSrycd(String srycd) {
        this.srycd = srycd;
    }

    public void setItemCount(int count) {
        this.itemCount = count;
    }

    public void setModuleModel(ModuleModel moduleModel) {
        this.moduleModel = moduleModel;
        if (moduleModel != null) {
            santeiDate = moduleModel.getStarted();

        }
    }

    public void setItemIndex(int index) {
        this.itemIndex = index;
    }
}
