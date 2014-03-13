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

/**
 * OtherIdModel
 *
 * @author Minagawa,Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class OtherIdModel extends InfoModel {

    private long id;

    private String otherId;

    private String idType;

    private String idTypeDesc;

    private String idTypeCodeSys;

    private PatientModel patient;

    /**
     * Idを返す。
     *
     * @return Id
     */
    public long getId() {
        return id;
    }

    /**
     * Idを設定する。
     *
     * @param id Id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param id The id to set.
     */
    public void setOtherId(String id) {
        this.otherId = id;
    }

    /**
     * @return Returns the id.
     */
    public String getOtherId() {
        return otherId;
    }

    /**
     * @param otherIdType The otherIdType to set.
     */
    public void setIdType(String otherIdType) {
        this.idType = otherIdType;
    }

    /**
     * @return Returns the otherIdType.
     */
    public String getIdType() {
        return idType;
    }

    /**
     * @param otherIdTypeDesc The otherIdTypeDesc to set.
     */
    public void setIdTypeDesc(String otherIdTypeDesc) {
        this.idTypeDesc = otherIdTypeDesc;
    }

    /**
     * @return Returns the otherIdTypeDesc.
     */
    public String getIdTypeDesc() {
        return idTypeDesc;
    }

    /**
     * @param otherIdCodeSys The otherIdCodeSys to set.
     */
    public void setIdTypeCodeSys(String otherIdCodeSys) {
        this.idTypeCodeSys = otherIdCodeSys;
    }

    /**
     * @return Returns the otherIdCodeSys.
     */
    public String getIdTypeCodeSys() {
        return idTypeCodeSys;
    }

    /**
     * 患者を返す。
     *
     * @return 患者
     */
    public PatientModel getPatient() {
        return patient;
    }

    /**
     * 患者を設定する。
     *
     * @param patient 患者
     */
    public void setPatient(PatientModel patient) {
        this.patient = patient;
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
        final OtherIdModel other = (OtherIdModel) obj;
        return id == other.id;
    }
}
