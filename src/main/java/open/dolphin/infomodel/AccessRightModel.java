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
 * AccessRightModel
 *
 * @author  Kazushi Minagawa
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class AccessRightModel extends InfoModel {

    // 許可
    private String permission;

    // 開始日
    private String startDate;

    // 終了日
    private String endDate;

    // 医療資格コード
    private String licenseeCode;

    // 医療資格名
    private String licenseeName;

    // 医療資格コード体系
    private String licenseeCodeType;

    /**
     * Creates a new instance of AccessRight
     */
    public AccessRightModel() {
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String val) {
        permission = val;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String val) {
        startDate = val;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String val) {
        endDate = val;
    }

    public void setLicenseeCode(String licenseeCode) {
        this.licenseeCode = licenseeCode;
    }

    public String getLicenseeCode() {
        return licenseeCode;
    }

    public void setLicenseeName(String licenseeName) {
        this.licenseeName = licenseeName;
    }

    public String getLicenseeName() {
        return licenseeName;
    }

    public void setLicenseeCodeType(String licenseeCodeType) {
        this.licenseeCodeType = licenseeCodeType;
    }

    public String getLicenseeCodeType() {
        return licenseeCodeType;
    }
}
