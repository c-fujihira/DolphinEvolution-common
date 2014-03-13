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
 * ClaimItem.java
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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClaimItem 要素クラス
 *
 * @author Kazushi Minagawa, Digital Globe,Inc. 
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class ClaimItem extends InfoModel {

    private static final String DISPOSE_UNIT = "管";

    //- 注射のみ(.3XXの診療区分対象)
    private static final String DISPOSE_INJECTION_CODE = "^3[0-9]{2}";

    //- すべての診療区分(.2XXの診療区分を除く)
    private static final String DISPOSE_REMOVE_CODE = "^2[0-9]{2}";

    //- 残量廃棄処理設定フラグ(Dolphin)
    private boolean zanryoFlag;

    //- 残量廃棄算定取得(ORCA) 1: 注射のみ 2: すべての診療区分
    private int gomicZanryoFlag;

    // 名称
    private String name;

    // コード
    private String code;

    // コード体系
    private String codeSystem;

    // 種別コード（薬剤｜手技｜材料）
    private String classCode;

    // 種別コードn体系
    private String classCodeSystem;

    // 数量
    private String number;

    // 入力された元の数量
    private String orgNumber;

    // 単位
    private String unit;

    // 数量コード
    private String numberCode;

    // 数量コード体系
    private String numberCodeSystem;

    // メモ
    private String memo;

    // 薬剤区分 2011-02-10 追加
    private String ykzKbn;

    // G-specific
    private List<String> sstKijunCdSet;//SST基準コード
    private float suryo1;
    private float suryo2;
    private String startDate;//開始日
    private String endDate;//終了日

    private String disCode;

    /**
     * Creates new ClaimItem
     */
    public ClaimItem() {
    }

    public boolean getZanryoFlag() {
        return zanryoFlag;
    }

    public void setZanryoFlag(boolean f) {
        zanryoFlag = f;
    }

    public int getGomicZanryoFlag() {
        return gomicZanryoFlag;
    }

    public void setGomicZanryoFlag(int i) {
        this.gomicZanryoFlag = i;
    }

    public void setDisCode(String t) {
        this.disCode = t;
    }

    public String getDisCode() {
        return disCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        name = val;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String val) {
        code = val;
    }

    public String getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(String val) {
        codeSystem = val;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String val) {
        classCode = val;
    }

    public String getClassCodeSystem() {
        return classCodeSystem;
    }

    public void setClassCodeSystem(String val) {
        classCodeSystem = val;
    }

    //- 残量廃棄対応用 数量
    public String getNumber() {
        return number;
    }

    public void setNumber(String val) {
        number = val;
    }

    public void setRemakeNumber(String val) {
        if (val != null && !val.isEmpty()) {
            number = val.replaceAll("[@|＠]", "").trim();
        }
    }

    //- 残量廃棄対応用 元の数量
    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String val) {
        orgNumber = val;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String val) {
        unit = val;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String val) {
        numberCode = val;
    }

    public String getNumberCodeSystem() {
        return numberCodeSystem;
    }

    public void setNumberCodeSystem(String val) {
        numberCodeSystem = val;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String val) {
        memo = val;
    }

    public String getYkzKbn() {
        return ykzKbn;
    }

    public void setYkzKbn(String ykzKbn) {
        this.ykzKbn = ykzKbn;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        ClaimItem ret = new ClaimItem();
        ret.setClassCode(this.getClassCode());
        ret.setClassCodeSystem(this.getClassCodeSystem());
        ret.setCode(this.getCode());
        ret.setCodeSystem(this.getCodeSystem());
        ret.setMemo(this.getMemo());
        ret.setName(this.getName());
        ret.setNumber(this.getNumber());
        ret.setNumberCode(this.getNumberCode());
        ret.setNumberCodeSystem(this.getNumberCodeSystem());
        ret.setUnit(this.getUnit());
        ret.setYkzKbn(this.getYkzKbn());
        return ret;
    }

    //---------------------------------
    // 残量廃棄
    //---------------------------------
    public boolean getCanDispose() {

        boolean ret = false;
        //- debug sandi
//        System.out.println("残量フラグ　　　　-> " + getZanryoFlag());
//        System.out.println("ORCA残量廃棄設定　-> " + getGomicZanryoFlag());
//        System.out.println("処置コード　　　　-> " + getDisCode());
//        System.out.println("薬剤区分　　　　　-> " + getYkzKbn());
        if (getNumber() != null && !getNumber().isEmpty()) {

            //- @ 付与判定
            String chkAbout = getOrgNumber();
            Pattern ptn = Pattern.compile("[@|＠]");
            Matcher match = ptn.matcher(chkAbout);
            boolean mc = match.find();

            //- @ 除去
            String regResult = chkAbout.replaceAll("[@|＠]", "").trim();

            //- debug sandi
//            System.out.println("debug ------> Debug");
//            System.out.println("debug ------> 元の数値 -> " + getOrgNumber());
//            System.out.println("debug ------> match   -> " + mc);
//            System.out.println("debug ------> unit    -> " + getUnit());
//            System.out.println("debug ------> @除去   -> " + regResult);
//            System.out.println("debug ------> Debug");
            //- debug sandi
            //- 数量書き戻し
            setNumber(regResult);

            //- zanryoFlag(false)の場合、評価終了(印加しない)
            if (!zanryoFlag) {
                return false;
            }

            //- 残量廃棄算定が注射のみで、処置行為がマッチしない場合、評価終了(印加しない)
            if (getGomicZanryoFlag() == 1 && !searchDisCode(getDisCode(), true)) {
//                System.out.println("debug ------> 残量廃棄算定が注射のみで、処置行為がマッチしない場合、評価終了(印加しない)");
                return false;
            }

            //- 残量廃棄算定がすべての診療区分で、処置行為がマッチしない場合、評価終了(印加しない)
            if (getGomicZanryoFlag() == 2 && searchDisCode(getDisCode(), false)) {
//                System.out.println("debug ------> 残量廃棄算定がすべての診療区分で、処置行為がマッチしない場合、評価終了(印加しない)");
                return false;
            }

            //- @ 付与の場合、残量廃棄印加しない
            if (mc && getUnit() != null
                    && getUnit().equals(DISPOSE_UNIT)) {
//                System.out.println("debug ------> SANDI Check @ Exit::::");
//                System.out.println("debug ------> 残量廃棄印加しない");
                return false;
            }

            //- 数量が1.0未満の場合、残量廃棄を印加する
            if (mc != true
                    && getUnit() != null
                    && getUnit().equals(DISPOSE_UNIT)
                    && getOrgNumber().isEmpty() == false) {
                try {
                    Float qt = Float.valueOf(regResult);
                    int iqt = Double.valueOf(regResult).intValue();
                    String siqt = String.valueOf(iqt).toString();

//                    System.out.println("debug ------> SANDI Float1 　-> " + qt);
//                    System.out.println("debug ------> SANDI Float2 　-> " + Float.valueOf(siqt));
                    //- 1未満の数値の場合
                    if (qt < 1.0) {
//                        System.out.println("debug ------> 残量廃棄印加する １未満");
                        return true;
                    }

                    //- 整数判定
                    if (!qt.equals(Float.valueOf(siqt))) {
//                        System.out.println("debug ------> 残量廃棄印加する 整数判定");
                        return true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("debug->" + e);
                }
            }
        }

//        System.out.println("debug ------> 残量廃棄印加しない 通常");
        return ret;
    }

    public List<String> getSstKijunCdSet() {
        return sstKijunCdSet;
    }

    /**
     * 残量廃棄算定ロジック
     *
     * @param t 診療行為コード
     * @param b (true: 注射のみ false:すべての診療区分)
     * @return
     */
    public boolean searchDisCode(String t, boolean b) {

        boolean mc = false;

        //- 注射のみ
        if (t != null && !t.isEmpty() && b) {
            Pattern ptn = Pattern.compile(DISPOSE_INJECTION_CODE);
            Matcher mt = ptn.matcher(t);
            mc = mt.find();
            return mc;
        }

        //- すべての診療区分
        if (t != null && !t.isEmpty() && !b) {
            Pattern ptn = Pattern.compile(DISPOSE_REMOVE_CODE);
            Matcher mt = ptn.matcher(t);
            mc = mt.find();
            return mc;
        }

        return mc;
    }

    public void setSstKijunCdSet(List<String> sstKijunCdSet) {
        this.sstKijunCdSet = sstKijunCdSet;
    }

    public float getSuryo1() {
        return suryo1;
    }

    public void setSuryo1(float suryo1) {
        this.suryo1 = suryo1;
    }

    public float getSuryo2() {
        return suryo2;
    }

    public void setSuryo2(float suryo2) {
        this.suryo2 = suryo2;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * カナのGetter
     *
     * @return　カナ
     */
    public String getKana() {
//        CombinedStringParser line = new CombinedStringParser('|', numberCodeSystem);
//
//        line.limit(4);
//        return line.get(2);
        return null;
    }

    /**
     * カナのSetter
     *
     * @param kana カナ
     */
    public final void setKana(String kana) {
//        if (kana != null) {
//            CombinedStringParser line = new CombinedStringParser('|', numberCodeSystem);
//
//            line.limit(4);
//            line.set(2, kana);
//            numberCodeSystem = line.toCombinedString();
//        }
    }

    /**
     * 使用終了日のGetter
     *
     * @return 使用終了日
     */
    public String getDisUseDate() {
//        CombinedStringParser line = new CombinedStringParser('|', numberCodeSystem);
//        line.limit(4);
//        return line.get(3);
        return null;
    }

    /**
     * 使用終了日のSetter
     *
     * @param disUseDate 使用終了日
     */
    public final void setDisUseDate(String disUseDate) {
//        if (disUseDate != null) {
//            CombinedStringParser line = new CombinedStringParser('|', numberCodeSystem);
//            line.limit(4);
//            line.set(3, disUseDate);
//            numberCodeSystem = line.toCombinedString();
//        }
    }
}
