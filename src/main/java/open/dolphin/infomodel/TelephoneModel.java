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
 * TelephoneModel
 * 
 * @author Minagawa,Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class TelephoneModel extends InfoModel {

    private String telephoneType;

    private String telephoneTypeDesc;

    private String telephoneTypeCodeSys;

    private String country;

    private String area;

    private String city;

    private String number;

    // さすがに不要では？
    private String extension;

    private String memo;

    public TelephoneModel() {
    }

    /**
     * @param telephoneClass The telephoneClass to set.
     */
    public void setTelephoneType(String telephoneClass) {
        this.telephoneType = telephoneClass;
    }

    /**
     * @return Returns the telephoneClass.
     */
    public String getTelephoneType() {
        return telephoneType;
    }

    /**
     * @param telephoneClassDesc The telephoneClassDesc to set.
     */
    public void setTelephoneTypeDesc(String telephoneClassDesc) {
        this.telephoneTypeDesc = telephoneClassDesc;
    }

    /**
     * @return Returns the telephoneClassDesc.
     */
    public String getTelephoneTypeDesc() {
        return telephoneTypeDesc;
    }

    /**
     * @param telephoneClassCodeSys The telephoneClassCodeSys to set.
     */
    public void setTelephoneTypeCodeSys(String telephoneClassCodeSys) {
        this.telephoneTypeCodeSys = telephoneClassCodeSys;
    }

    /**
     * @return Returns the telephoneClassCodeSys.
     */
    public String getTelephoneTypeCodeSys() {
        return telephoneTypeCodeSys;
    }

    /**
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param area The area to set.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return Returns the area.
     */
    public String getArea() {
        return area;
    }

    /**
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param number The number to set.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return Returns the number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param extension The extension to set.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return Returns the extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param memo The memo to set.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return Returns the memo.
     */
    public String getMemo() {
        return memo;
    }
}
