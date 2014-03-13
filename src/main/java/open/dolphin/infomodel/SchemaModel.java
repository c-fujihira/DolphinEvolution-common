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

import javax.persistence.*;
import javax.swing.ImageIcon;

/**
 * SchemaModel
 *
 * @author Kazushi Minagawa, Digital Globe, Inc.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_image")
public class SchemaModel extends KarteEntryBean
        implements java.io.Serializable, java.lang.Cloneable {

    // ExtRef
    @Embedded
    private ExtRefModel extRef;

    // Byte data
    @Lob
    @Column(nullable = false)
    private byte[] jpegByte;

    // Document
    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private DocumentModel document;

    // Comaptible props
    @Transient
    private String fileName;

    @Transient
    private ImageIcon icon;

    @Transient
    private int imageNumber;

    @Transient
    private ModuleModel imageStamp; // ModuleInfoBean + model 

    /**
     * Creates new Schema
     */
    public SchemaModel() {
    }

    public ExtRefModel getExtRefModel() {
        return extRef;
    }

    public void setExtRefModel(ExtRefModel val) {
        extRef = val;
    }

    public DocumentModel getDocumentModel() {
        return document;
    }

    public void setDocumentModel(DocumentModel document) {
        this.document = document;
    }

    public byte[] getJpegByte() {
        return jpegByte;
    }

    public void setJpegByte(byte[] jpegByte) {
        this.jpegByte = jpegByte;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon val) {
        icon = val;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String val) {
        fileName = val;
    }

    public IInfoModel getModel() {
        return (IInfoModel) getExtRefModel();
    }

    public void setModel(IInfoModel val) {
        setExtRefModel((ExtRefModel) val);
    }

    /**
     * 確定日及びイメージ番号で比較する。
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Object other) {
        int result = super.compareTo(other);
        if (result == 0) {
            // primittive なので比較はOK
            int no1 = getImageNumber();
            int no2 = ((SchemaModel) other).getImageNumber();
            result = no1 - no2;
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SchemaModel ret = new SchemaModel();
        ret.setConfirmed(this.getConfirmed());
        ret.setEnded(this.getEnded());
        ret.setExtRefModel((ExtRefModel) this.getExtRefModel().clone());
        ret.setFileName(this.getFileName());
        ret.setFirstConfirmed(this.getConfirmed());
        ret.setImageNumber(this.getImageNumber());
        ret.setLinkId(this.getLinkId());
        ret.setLinkRelation(this.getLinkRelation());
        ret.setRecorded(this.getRecorded());
        ret.setStarted(this.getStarted());
        ret.setStatus(this.getStatus());

        if (this.getIcon() != null) {
            ret.setIcon(new ImageIcon(this.getIcon().getImage()));
        }

        if (this.getJpegByte() != null) {
            byte[] dest = new byte[this.getJpegByte().length];
            System.arraycopy(this.getJpegByte(), 0, dest, 0, this.getJpegByte().length);
            ret.setJpegByte(dest);
        }

        return ret;
    }

    public ModuleModel getImageStamp() {
        return imageStamp;
    }

    public void setImageStamp(ModuleModel imageStamp) {
        this.imageStamp = imageStamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("confirmed=").append(this.getConfirmed()).append("\n");
        sb.append("started=").append(this.getStarted()).append("\n");
        sb.append("recorded=").append(this.getRecorded()).append("\n");
        sb.append("status=").append(this.getStatus()).append("\n");
        sb.append("userModel PK=").append(this.getUserModel().getId()).append("\n");
        sb.append("karteBean PK=").append(this.getKarteBean().getId()).append("\n");
        sb.append("contentType=").append(this.getExtRefModel().getContentType()).append("\n");
        sb.append("medicalRole=").append(this.getExtRefModel().getMedicalRole()).append("\n");
        sb.append("title=").append(this.getExtRefModel().getTitle()).append("\n");
        sb.append("href=").append(this.getExtRefModel().getHref()).append("\n");
        sb.append("byte length=").append(this.getJpegByte().length).append("\n");
        return sb.toString();
    }
}
