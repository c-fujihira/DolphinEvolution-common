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

/*
 * BundleDolphin.java
 * Copyright (C) 2002 Dolphin Project. All rights reserved.
 * Copyright (C) 2003,2004 Digital Globe, Inc. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package open.dolphin.infomodel;

/**
 * BundleDolphin
 *
 * @author  Minagawa,Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class BundleDolphin extends ClaimBundle {

    private String orderName;

    /**
     * Creates a new instance of BundleDolphin
     */
    public BundleDolphin() {
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getItemNames() {
        if (claimItem != null && claimItem.length > 0) {
            ClaimItem item;
            StringBuilder sb = new StringBuilder();
            item = claimItem[0];
            sb.append(item.getName());
            if (item.getNumber() != null && !equal1(item.getNumber())) {
                sb.append("x").append(item.getNumber());
            }

            for (int i = 1; i < claimItem.length; i++) {
                item = claimItem[i];
                sb.append(",");
                sb.append(item.getName());
                if (item.getNumber() != null && !equal1(item.getNumber())) {
                    sb.append("x").append(item.getNumber());
                }
            }
            return sb.toString();
        }
        return null;
    }

    private boolean equal1(String test) {
        return (test != null && (test.equals("1") || (test.equals("1.0"))));
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder();

        // order name
        buf.append(orderName).append("\n");
        ClaimItem[] items = getClaimItem();
        int len = items.length;
        ClaimItem item;
        String number;

        for (int i = 0; i < len; i++) {
            item = items[i];

            // item name
            buf.append("・").append(item.getName());

            // item number
            number = item.getNumber();
            if (number != null) {
                buf.append("　").append(number);
                if (item.getUnit() != null) {
                    buf.append(item.getUnit());
                }
            }
            buf.append("\n");
        }

        // bundleNumber
        if (!bundleNumber.equals("1")) {
            buf.append("X　").append(bundleNumber).append("\n");
        }

        // admMemo
        if (adminMemo != null) {
            buf.append(adminMemo).append("\n");
        }

        // bundleMemo
        if (memo != null) {
            buf.append(memo).append("\n");
        }
        
        return buf.toString();
    }

    // 2014/01/27 スタンプのテキストコピー機能拡張
    public String toString(String patID, String title) {
       
        StringBuilder buf = new StringBuilder();
        
        buf.append(patID).append("\n");
        if(title != null) buf.append(title).append("\n");
        
        // order name
        buf.append(orderName).append("\n");
        ClaimItem[] items = getClaimItem();
        int len = items.length;
        ClaimItem item;
        String number;
        
        for (int i = 0; i < len; i++) {
            item = items[i];
            
            // item name
            buf.append("�E").append(item.getName());
            
            // item number
            number = item.getNumber();
            if (number != null) {
                buf.append("�@").append(number);
                if (item.getUnit() != null) {
                    buf.append(item.getUnit());
                }
            }
            buf.append("\n");
        }
        
        // bundleNumber
        if (! bundleNumber.equals("1")) {
            buf.append("X�@").append(bundleNumber).append("\n");
        }
        
        // admMemo
        if (adminMemo != null) {
            buf.append(adminMemo).append("\n");
        }
        
        // bundleMemo
        if (memo != null) {
            buf.append(memo).append("\n");
        }
        
        return buf.toString();
    }
//s.oh$

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        BundleDolphin ret = new BundleDolphin();
        ret.setAdmin(this.getAdmin());
        ret.setAdminCode(this.getAdminCode());
        ret.setAdminCodeSystem(this.getAdminCodeSystem());
        ret.setAdminMemo(this.getAdminMemo());
        ret.setBundleNumber(this.getBundleNumber());
        ret.setClassCode(this.getClassCode());
        ret.setClassCodeSystem(this.getClassCodeSystem());
        ret.setClassName(this.getClassName());
        ret.setInsurance(this.getInsurance());
        ret.setMemo(this.getMemo());
        ClaimItem[] items = this.getClaimItem();
        if (items != null) {
            for (ClaimItem item : items) {
                ret.addClaimItem((ClaimItem) item.clone());
            }
        }
        ret.setOrderName(this.getOrderName());
        return ret;
    }
}