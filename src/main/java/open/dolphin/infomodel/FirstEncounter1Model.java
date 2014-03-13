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

/**
 * 瀬田クリニック版初診時情報1
 * 
 * @author Life Sciences Computing Corporation.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("SETA_1")
public class FirstEncounter1Model extends FirstEncounterModel implements java.io.Serializable {

    @Transient
    private String disease;

    @Transient
    private String metastatic1;

    @Transient
    private String metastatic2;

    @Transient
    private String metastatic3;

    @Transient
    private String metastatic4;

    @Transient
    private String tissueType;

    @Transient
    private String understandingRank;

    @Transient
    private String understanding;

    @Transient
    private String t;

    @Transient
    private String n;

    @Transient
    private String m;

    @Transient
    private String stage;

    @Transient
    private String firstState;

    @Transient
    private String firstPs;

    @Transient
    private String totsuRank;

    @Transient
    private String sleepRank;

    @Transient
    private String mindRank;

    @Transient
    private String mealRank;

    @Transient
    private String subjectiveSymptom;

    @Transient
    private String pastHistory;

    /**
     * Creates a new instance of FirstEncounter1
     */
    public FirstEncounter1Model() {
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMetastatic1() {
        return metastatic1;
    }

    public void setMetastatic1(String metastatic1) {
        this.metastatic1 = metastatic1;
    }

    public String getMetastatic2() {
        return metastatic2;
    }

    public void setMetastatic2(String metastatic2) {
        this.metastatic2 = metastatic2;
    }

    public String getMetastatic3() {
        return metastatic3;
    }

    public void setMetastatic3(String metastatic3) {
        this.metastatic3 = metastatic3;
    }

    public String getMetastatic4() {
        return metastatic4;
    }

    public void setMetastatic4(String metastatic4) {
        this.metastatic4 = metastatic4;
    }

    public String getTissueType() {
        return tissueType;
    }

    public void setTissueType(String tissueType) {
        this.tissueType = tissueType;
    }

    public String getUnderstandingRank() {
        return understandingRank;
    }

    public void setUnderstandingRank(String understandingRank) {
        this.understandingRank = understandingRank;
    }

    public String getUnderstanding() {
        return understanding;
    }

    public void setUnderstanding(String understanding) {
        this.understanding = understanding;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFirstState() {
        return firstState;
    }

    public void setFirstState(String firstState) {
        this.firstState = firstState;
    }

    public String getFirstPs() {
        return firstPs;
    }

    public void setFirstPs(String firstPs) {
        this.firstPs = firstPs;
    }

    public String getTotsuRank() {
        return totsuRank;
    }

    public void setTotsuRank(String tsuRank) {
        this.totsuRank = tsuRank;
    }

    public String getSleepRank() {
        return sleepRank;
    }

    public void setSleepRank(String sleepRank) {
        this.sleepRank = sleepRank;
    }

    public String getMindRank() {
        return mindRank;
    }

    public void setMindRank(String mindRank) {
        this.mindRank = mindRank;
    }

    public String getMealRank() {
        return mealRank;
    }

    public void setMealRank(String mealRank) {
        this.mealRank = mealRank;
    }

    public String getSubjectiveSymptom() {
        return subjectiveSymptom;
    }

    public void setSubjectiveSymptom(String subjectiveSymptom) {
        this.subjectiveSymptom = subjectiveSymptom;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }
}
