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

import java.util.List;

/**
 * VisitPackage
 *
 * @author Kazushi Minagawa.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class VisitPackage extends InfoModel implements java.io.Serializable {

    // KarteBeanのPK
    private long kartePk;

    // 保健医療機関コードとJMARIコードの連結
    private String number;

    // 来院情報
    private PatientVisitModel patientVisitModel;

    // 患者情報
    private PatientModel patientModel;

    // 文書（カルテ）
    private DocumentModel documenModel;

    // Active病名
    private List<RegisteredDiagnosisModel> disease;

    // アレルギー
    private List<AllergyModel> allergies;

    // メモ
    private PatientMemoModel patientMemoModel;

    // 作成モード
    private int mode;

    public long getKartePk() {
        return kartePk;
    }

    public void setKartePk(long kartePk) {
        this.kartePk = kartePk;
    }

    public PatientVisitModel getPatientVisitModel() {
        return patientVisitModel;
    }

    public void setPatientVisitModel(PatientVisitModel patientVisitModel) {
        this.patientVisitModel = patientVisitModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientMode) {
        this.patientModel = patientMode;
    }

    public DocumentModel getDocumenModel() {
        return documenModel;
    }

    public void setDocumenModel(DocumentModel documenModel) {
        this.documenModel = documenModel;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<AllergyModel> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyModel> allergies) {
        this.allergies = allergies;
    }

    public PatientMemoModel getPatientMemoModel() {
        return patientMemoModel;
    }

    public void setPatientMemoModel(PatientMemoModel patientMemoModel) {
        this.patientMemoModel = patientMemoModel;
    }

    public List<RegisteredDiagnosisModel> getDisease() {
        return disease;
    }

    public void setDisease(List<RegisteredDiagnosisModel> disease) {
        this.disease = disease;
    }
}
