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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 * ExamHistoryModel
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ExamHistoryModel {

    private static final String CODE_PHYSIOLOGY = "16";
    private static final String CODE_RADIOLOGY = "17";

    private long docPk;
    private Date examDate;
    private String extamTitle;

    @JsonIgnore
    private boolean ecg = false;
    @JsonIgnore
    private boolean ucg = false;
    @JsonIgnore
    private boolean us = false;
    @JsonIgnore
    private boolean holter = false;
    @JsonIgnore
    private boolean abpm = false;
    @JsonIgnore
    private boolean pwv = false;
    @JsonIgnore
    private boolean labo = false;
    @JsonIgnore
    private boolean xp = false;
    @JsonIgnore
    private boolean hyozai = false;
    @JsonIgnore
    private boolean psg = false;
    @JsonIgnore
    private boolean fiber = false;
    @JsonIgnore
    private boolean ct = false;
    @JsonIgnore
    private boolean mri = false;

    public ExamHistoryModel() {
    }

    public void setDocPk(long docPk) {
        this.docPk = docPk;
    }

    public long getDocPk() {
        return docPk;
    }

    public void setExamDate(Date d) {
        examDate = d;
    }

    public Date getExamDate() {
        return examDate;
    }

    public String getMmlExamDate() {
        return ModelUtils.getDateAsString(examDate);
    }

    public void setExamTitle(String title) {
        this.extamTitle = title;
    }

    public String getExamTitle() {
        return extamTitle;
    }

    public boolean putModuleModel(ModuleModel mm) {

        String entity = mm.getModuleInfoBean().getEntity();
        if (examDate == null) {
            examDate = mm.getStarted();
        }
        docPk = mm.getDocumentModel().getId();
        switch (entity) {
            case IInfoModel.ENTITY_PHYSIOLOGY_ORDER:
                {
                    ClaimBundle cb = (ClaimBundle) mm.getModel();
                    for (ClaimItem ci : cb.getClaimItem()) {
                        String srycd = ci.getCode();
                        if (!srycd.startsWith(CODE_PHYSIOLOGY)) {
                            continue;
                        }
                        String name = ci.getName();
                        if (!ecg
                                && name.contains("ＥＣＧ")) {
                            ecg = true;
                        } else if (!us
                                && name.contains("超音波")
                                && name.contains("胸腹部")
                                && !name.contains("以外")) {
                            us = true;
                        } else if (!ucg
                                && name.contains("超音波")
                                && (name.contains("心臓超音波検査") || name.contains("ＵＣＧ"))
                                && !name.contains("胸腹部")
                                && !name.contains("以外")) {
                            ucg = true;
                        } else if (!holter
                                && name.contains("ホルター")) {
                            holter = true;
                        } else if (!abpm
                                && name.contains("自由行動下血圧測定")) {
                            abpm = true;
                        } else if (!pwv
                                && name.contains("脈波図")) {
                            pwv = true;
                        } else if (!hyozai
                                && name.contains("超音波")
                                && name.contains("断層撮影法")
                                && name.contains("その他")) {
                            hyozai = true;
                        } else if (!psg
                                && name.contains("終夜睡眠ポリグラフィー")) {
                            psg = true;
                        } else if (!fiber
                                && name.contains("ＥＦ－")) {
                            fiber = true;
                        }
                    }       break;
                }
            case IInfoModel.ENTITY_LABO_TEST:
                {
                    ClaimBundle cb = (ClaimBundle) mm.getModel();
                    for (ClaimItem ci : cb.getClaimItem()) {
                        String name = ci.getName();
                        // 尿検査とグルコース、Ａ１ｃは除外する
                        if (!name.contains("尿")
                                && !name.contains("グルコース")
                                && !name.contains("ＨｂＡ１ｃ")) {
                            labo = true;
                            break;
                        }
                    }       break;
                }
            case IInfoModel.ENTITY_RADIOLOGY_ORDER:
                {
                    ClaimBundle cb = (ClaimBundle) mm.getModel();
                    for (ClaimItem ci : cb.getClaimItem()) {
                        String srycd = ci.getCode();
                        if (!srycd.startsWith(CODE_RADIOLOGY)) {
                            continue;
                        }
                        String name = ci.getName();
                        if (!ct && name.startsWith("ＣＴ")) {
                            ct = true;
                        } else if (!mri && name.startsWith("ＭＲＩ")) {
                            mri = true;
                        } else {
                            xp = true;
                        }
                    }       break;
                }
        }

        boolean ret = ecg || us || ucg || labo || xp || holter || abpm 
                || pwv || hyozai || psg || fiber || ct || mri;
        if (ret) {
            setTitle();
        }
        
        return ret;
    }

    private void setTitle() {
        StringBuilder sb = new StringBuilder();
        if (ucg) {
            sb.append("UCG・");
        }
        if (us) {
            sb.append("US・");
        }
        if (hyozai) {
            sb.append("表在・");
        }
        if (labo) {
            sb.append("検査・");
        }
        if (ecg) {
            sb.append("ECG・");
        }
        if (holter) {
            sb.append("Holter・");
        }
        if (abpm) {
            sb.append("ABPM・");
        }
        if (pwv) {
            sb.append("脈波・");
        }
        if (psg) {
            sb.append("PSG・");
        }
        if (xp) {
            sb.append("XP・");
        }
        if (fiber) {
            sb.append("EF・");
        }
        if (ct) {
            sb.append("CT・");
        }
        if (mri) {
            sb.append("MRI・");
        }
        String str = sb.toString();
        // 最後の「・」を削る
        if (str.endsWith("・")) {
            str = str.substring(0, str.length() - 1);
        }
        extamTitle = str;
    }
}
