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

/**
 * RpModel
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class RpModel {

    private String drugSrycd;
    private String drugName;
    private String adminSrycd;
    private String rpNumber;
    private String rpDay;
    private Date rpDate;

    public RpModel() {
    }

    public RpModel(String drugSrycd, String drugName, String adminSrycd, String rpNumber, String rpDay, Date rpDate) {
        this.drugSrycd = drugSrycd;
        this.drugName = drugName;
        this.adminSrycd = adminSrycd;
        this.rpNumber = rpNumber;
        this.rpDay = rpDay;
        this.rpDate = rpDate;
    }

    public String getDrugSrycd() {
        return drugSrycd;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getAdminSrycd() {
        return adminSrycd;
    }

    public String getRpNumber() {
        return (rpNumber == null) ? "" : rpNumber;
    }

    public String getRpDay() {
        return (rpDay == null) ? "1" : rpDay;
    }

    public Date getRpDate() {
        return rpDate;
    }

    public void setDrugSrycd(String srycd) {
        drugSrycd = srycd;
    }

    public void setDrugName(String name) {
        drugName = name;
    }

    public void setAdminSrycd(String srycd) {
        adminSrycd = srycd;
    }

    public void setRpNumber(String rpNumber) {
        this.rpNumber = rpNumber;
    }

    public void setRpDay(String rpDay) {
        this.rpDay = rpDay;
    }

    public void setRpDate(Date date) {
        rpDate = date;
    }

    public boolean isSameWith(RpModel test) {
        return test.getDrugSrycd() != null && test.getDrugSrycd().equals(drugSrycd)
                && test.getAdminSrycd() != null && test.getAdminSrycd().equals(adminSrycd)
                && test.getRpNumber() != null && test.getRpNumber().equals(rpNumber);
    }
}
