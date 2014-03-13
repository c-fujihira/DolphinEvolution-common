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
 * PVTPublicInsuranceItemModel
 *
 * @author  Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class PVTPublicInsuranceItemModel extends InfoModel {

    // 複数公費の優先順位
    private String priority;

    // 公費負担名称
    private String providerName;

    // 負担者番号
    private String provider;

    // 受給者番号
    private String recipient;

    // 開始日
    private String startDate;

    // 開始日
    private String expiredDate;

    // 負担率または負担金
    private String paymentRatio;

    // 負担率または負担金
    private String paymentRatioType;

    public PVTPublicInsuranceItemModel() {
        super();
    }

    public String getPaymentRatioType() {
        return paymentRatioType;
    }

    public void setPaymentRatioType(String val) {
        paymentRatioType = val;
    }

    public String getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(String val) {
        paymentRatio = val;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String val) {
        expiredDate = val;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String val) {
        startDate = val;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String val) {
        recipient = val;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String val) {
        priority = val;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String val) {
        providerName = val;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String val) {
        provider = val;
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder();

        if (providerName != null) {
            buf.append(providerName);
        } else if (provider != null) {
            buf.append(provider);
        }

        return buf.toString();
    }

    public String toClaim() {

        StringBuilder sb = new StringBuilder();

        sb.append("<mmlHi:publicInsuranceItem ");

        // 公費の優先順位 attribute
        if (getPriority() != null) {
            sb.append("mmlHi:priority=");
            sb.append(addQuote(getPriority()));
            sb.append(">");
        }

        // 公費負担名称 ?
        if (getProviderName() != null) {
            sb.append("<mmlHi:providerName>");
            sb.append(getProviderName());
            sb.append("</mmlHi:providerName>");
        }

        // 負担者番号
        if (getProvider() != null) {
            sb.append("<mmlHi:provider>");
            sb.append(getProvider());
            sb.append("</mmlHi:provider>");
        }

        // 受給者番号
        if (getRecipient() != null) {
            sb.append("<mmlHi:recipient>");
            sb.append(getRecipient());
            sb.append("</mmlHi:recipient>");
        }

        // 開始日
        if (getStartDate() != null) {
            sb.append("<mmlHi:startDate>");
            sb.append(getStartDate());
            sb.append("</mmlHi:startDate>");
        }

        // 有効期限
        if (getExpiredDate() != null) {
            sb.append("<mmlHi:expiredDate>");
            sb.append(getExpiredDate());
            sb.append("</mmlHi:expiredDate>");
        }

        // 負担率 ?
        if (getPaymentRatio() != null && getPaymentRatioType() != null) {
            sb.append("<mmlHi:paymentRatio mmlHi:RatioType=");
            sb.append(addQuote(getPaymentRatioType()));
            sb.append(">");
            sb.append(getPaymentRatio());
            sb.append("</mmlHi:paymentRatio>");
        }

        sb.append("</mmlHi:publicInsuranceItem>");

        return sb.toString();
    }

    private String addQuote(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }
}
