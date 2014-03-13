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
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 * KarteBean
 *
 * @author Minagawa,Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_karte")
public class KarteBean extends InfoModel implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // 患者外部制約
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;

    // システム生成日
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date created;

    //-------データ取得時にコンテナ機能を提供--------------------
    // key=value の属性と値のマップ
    @Transient
    private Map<String, List> entries;

    // アレルギーのリスト
    @Transient
    private List<AllergyModel> allergies;

    // 身長のリスト
    @Transient
    private List<PhysicalModel> heights;

    // 体重のリスト
    @Transient
    private List<PhysicalModel> weights;

    // 来院日のリスト
    @Transient
    private List<String> patientVisits;

    // 文書履歴
    @Transient
    private List<DocInfoModel> docInfoList;

    // メモリスト
    @Transient
    private List<PatientMemoModel> memoList;
    
//masuda^    
    @Transient
    private Date lastDocDate;

    public void setLastDocDate(Date d) {
        lastDocDate = d;
    }

    public Date getLastDocDate() {
        return lastDocDate;
    }
//masuda$
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PatientModel getPatientModel() {
        return patient;
    }

    public void setPatientModel(PatientModel patient) {
        this.patient = patient;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<AllergyModel> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<AllergyModel> allergies) {
        this.allergies = allergies;
    }

    public List<PhysicalModel> getHeights() {
        return heights;
    }

    public void setHeights(List<PhysicalModel> heights) {
        this.heights = heights;
    }

    public List<PhysicalModel> getWeights() {
        return weights;
    }

    public void setWeights(List<PhysicalModel> weights) {
        this.weights = weights;
    }

    public List<String> getPatientVisits() {
        return patientVisits;
    }

    public void setPatientVisits(List<String> patientVisits) {
        this.patientVisits = patientVisits;
    }

    public List<DocInfoModel> getDocInfoList() {
        return docInfoList;
    }

    public void setDocInfoList(List<DocInfoModel> docInfoList) {
        this.docInfoList = docInfoList;
    }

    public List<PatientMemoModel> getMemoList() {
        return memoList;
    }

    public void setMemoList(List<PatientMemoModel> memoList) {
        this.memoList = memoList;
    }
    
//    /**
//     * カルテのエントリを返す。
//     * @return カテゴリをKey、エントリのコレクションをValueにしたHashMap
//     */
//    public Map<String, List> getEntries() {
//        return entries;
//    }
//
//    /**
//     * カルテのエントリを設定する。
//     * param entries カテゴリをKey、エントリのコレクションをValueにしたHashMap
//     */
//    public void setEntries(Map<String, List> entries) {
//        this.entries = entries;
//    }
//
//    /**
//     * 指定したカテゴリのエントリコレクションを返す。
//     * @param category カテゴリ
//     * @return　エントリのコレクション
//     */
//    public List getEntryCollection(String category) {
//        return entries != null ? entries.get(category) : null;
//    }
//
//    /**
//     * カテゴリとそのエントリのコレクションを追加する。
//     * @param category カテゴリ
//     * @param entries カテゴリのエントリーのコレクション
//     */
//    public void addEntryCollection(String category, List entrs) {
//
//        if (entries == null) {
//            entries = new HashMap<String, List>();
//        }
//        entries.put(category, entrs);
//    }
    
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
        final KarteBean other = (KarteBean) obj;
        return id == other.id;
    }

    public Map<String, List> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, List> entries) {
        this.entries = entries;
    }

    public PatientModel getPatient() {
        return getPatientModel();
    }

    public void setPatient(PatientModel patient) {
        setPatientModel(patient);
    }
}
