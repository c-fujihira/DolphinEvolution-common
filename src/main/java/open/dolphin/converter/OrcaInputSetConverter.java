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
package open.dolphin.converter;

import open.dolphin.infomodel.IInfoModel;
import open.dolphin.infomodel.OrcaInputSet;

/**
 * ORCA の tbl_inputset エンティティクラス
 *
 * @author Minagawa, Kazushi
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public final class OrcaInputSetConverter implements IInfoModelConverter {

    private OrcaInputSet model;

    public String getHospId() {
        return model.getHospId();
    }

    public String getSetCd() {
        return model.getSetCd();
    }

    public String getYukostYmd() {
        return model.getYukostYmd();
    }

    public String getYukoedYmd() {
        return model.getYukoedYmd();
    }

    public int getSetSeq() {
        return model.getSetSeq();
    }

    public String getInputCd() {
        return model.getInputCd();
    }

    public float getSuryo1() {
        return model.getSuryo1();
    }

    public float getSuryo2() {
        return model.getSuryo2();
    }

    public int getKaisu() {
        return model.getKaisu();
    }

    public String getComment() {
        return model.getComment();
    }

    public String getAtai1() {
        return model.getAtai1();
    }

    public String getAtai2() {
        return model.getAtai2();
    }

    public String getAtai3() {
        return model.getAtai3();
    }

    public String getAtai4() {
        return model.getAtai4();
    }

    public String getTermId() {
        return model.getTermId();
    }

    public String getOpId() {
        return model.getOpId();
    }

    public String getCreYmd() {
        return model.getCreYmd();
    }

    public String getUpYmd() {
        return model.getUpYmd();
    }

    public String getUpHms() {
        return model.getUpHms();
    }

    @Override
    public void setModel(IInfoModel model) {
        this.model = (OrcaInputSet) model;
    }
}
