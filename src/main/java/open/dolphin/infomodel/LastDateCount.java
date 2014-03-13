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
 * LastDateCount
 * 
 * @author kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class LastDateCount extends InfoModel {
    
    // システム登録日->初診日として使用
    private Date created;
    
    // 病名数
    private long diagnosisCount;
    
    // アクティブ病名数
    private long activeDiagnosisCount;
    
    // カル枚数
    private long docCount;
    
    // 最終カルテ記録日
    private Date lastDocDate;
    
    // 検査数
    private long labCount;
    
    // 最終検査結果日
    private String lastLabDate;
    
    // 画像及びシェーマ数
    private long imageCount;
    
    // 最終画像日
    private Date lastImageDate;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date registeredDate) {
        this.created = registeredDate;
    }

    public long getDocCount() {
        return docCount;
    }

    public void setDocCount(long docCount) {
        this.docCount = docCount;
    }

    public Date getLastDocDate() {
        return lastDocDate;
    }

    public void setLastDocDate(Date lastDocDate) {
        this.lastDocDate = lastDocDate;
    }

    public long getLabCount() {
        return labCount;
    }

    public void setLabCount(long labCount) {
        this.labCount = labCount;
    }

    public String getLastLabDate() {
        return lastLabDate;
    }

    public void setLastLabDate(String lastSampleDate) {
        this.lastLabDate = lastSampleDate;
    }

    public long getImageCount() {
        return imageCount;
    }

    public void setImageCount(long imageCount) {
        this.imageCount = imageCount;
    }

    public Date getLastImageDate() {
        return lastImageDate;
    }

    public void setLastImageDate(Date lastImageDate) {
        this.lastImageDate = lastImageDate;
    }

    public long getDiagnosisCount() {
        return diagnosisCount;
    }

    public void setDiagnosisCount(long diagnosisCount) {
        this.diagnosisCount = diagnosisCount;
    }

    public long getActiveDiagnosisCount() {
        return activeDiagnosisCount;
    }

    public void setActiveDiagnosisCount(long activeDiagnosisCount) {
        this.activeDiagnosisCount = activeDiagnosisCount;
    }
}
