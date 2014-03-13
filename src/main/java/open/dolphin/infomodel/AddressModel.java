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
 * AddressModel
 * 
 * @author Minagawa,kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class AddressModel extends InfoModel {

    private String addressType;
    private String addressTypeDesc;
    private String addressTypeCodeSys;
    private String countryCode;
    private String zipCode;
    private String address;

    /**
     * 国コードを設定する。
     *
     * @param countryCode 国コード
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 国コードを返す。
     *
     * @return 国コード
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 郵便番号を設定する。
     *
     * @param zipCode 郵便番号
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 郵便番号を返す
     *
     * @return 郵便番号
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 住所を設定する。
     *
     * @param address 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 住所を返す。
     *
     * @return 住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住所区分を設定する。
     *
     * @param addressType 住所区分
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * 住所区分を返す。
     *
     * @return 住所区分
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * 住所区分説明を設定する。
     *
     * @param addressTypeDesc 住所区分説明
     */
    public void setAddressTypeDesc(String addressTypeDesc) {
        this.addressTypeDesc = addressTypeDesc;
    }

    /**
     * 住所区分説明を返す。
     *
     * @return 住所区分説明
     */
    public String getAddressTypeDesc() {
        return addressTypeDesc;
    }

    /**
     * 住所区分体系を設定する。
     *
     * @param addressTypeCodeSys 住所区分体系
     */
    public void setAddressTypeCodeSys(String addressTypeCodeSys) {
        this.addressTypeCodeSys = addressTypeCodeSys;
    }

    /**
     * 住所区分体系を返す。
     *
     * @return 住所区分体系
     */
    public String getAddressTypeCodeSys() {
        return addressTypeCodeSys;
    }
}
