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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 * UsingDrugModel 採用薬のモデル
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "msd_usingdrug")
public class UsingDrugModel implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int srycd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String administration;

    @Column(nullable = true)
    private String usualDose;

    @Column(nullable = true)
    private String maxDose;

    @Column(nullable = false)
    private boolean valid;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date created;

    @Column
    private String facilityId;

    @Column(nullable = true)
    private Boolean hasLimit;

    public UsingDrugModel() {
    }

    public long getId() {
        return id;
    }

    public int getSrycd() {
        return srycd;
    }

    public String getName() {
        return name;
    }

    public String getAdmin() {
        return administration;
    }

    public String getUsualDose() {
        return usualDose;
    }

    public String getMaxDose() {
        return maxDose;
    }

    public boolean getValid() {
        return valid;
    }

    public Date getCreated() {
        return created;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getCreatedStr() {
        final SimpleDateFormat frmt = new SimpleDateFormat(IInfoModel.DATE_WITHOUT_TIME);
        return frmt.format(created);
    }

    public boolean getHasLimit() {
        return hasLimit != null ? hasLimit : false;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSrycd(int srycd) {
        this.srycd = srycd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(String administration) {
        this.administration = administration;
    }

    public void setUsualDose(String dose) {
        usualDose = dose;
    }

    public void setMaxDose(String dose) {
        maxDose = dose;
    }

    public void setValid(boolean b) {
        valid = b;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setFacilityId(String fid) {
        facilityId = fid;
    }

    public void setHasLimit(boolean b) {
        hasLimit = b;
    }

    @Override
    public int compareTo(Object o) {
        String objName = ((UsingDrugModel) o).getName();
        return name.compareTo(objName);
    }
}
