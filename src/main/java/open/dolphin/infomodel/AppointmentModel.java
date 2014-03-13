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
 * AppointmentModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_appo")
public class AppointmentModel extends KarteEntryBean implements java.io.Serializable {

    public static final int TT_NONE = 0;

    public static final int TT_NEW = 1;

    public static final int TT_HAS = 2;

    public static final int TT_REPLACE = 3;

    private String patientId;

    @Transient
    private int state;

    @Column(name = "c_name", nullable = false)
    private String name;

    private String memo;

    @Column(name = "c_date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date date;

    public AppointmentModel() {
    }

    public int getState() {
        return state;
    }

    public void setState(int val) {
        state = val;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date val) {
        date = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        name = val;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String val) {
        memo = val;
    }

    /**
     * @param patientId The patientId to set.
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return Returns the patientId.
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * 予約日で比較する。
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Date s1 = this.date;
        Date s2 = ((AppointmentModel) o).getDate();
        return s1.compareTo(s2);
    }

    @Override
    public String toString() {
        return ModelUtils.getDateAsString(getDate());
    }
}
