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
package open.dolphin.common;

/**
 * ORCA API 基底クラス
 * @author Life Sciences Computing Corporation.
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class OrcaCommonDefImpl {

    protected static final String REQUESTMETHOD_GET = "GET";
    protected static final String REQUESTMETHOD_POST = "POST";
    protected static final String CHARSET_DEFAULT = "UTF-8";
    protected static final String CHARSET_SHIFTJIS = "Shift_JIS";

    protected static final String URL_HTTP = "http://";

    // APIの各パラメータ
    protected static final String ORCAAPI_VER_47 = "47";
    protected static final String CLASS_01 = "?class=01";
    protected static final String CLASS_02 = "?class=02";
    protected static final String CLASS_03 = "?class=03";
    protected static final String TAG_DATA_START = "<data>";
    protected static final String TAG_DATA_END = "</data>";
    protected static final String TAG_PATID_START = "<Patient_ID type=\"string\">";
    protected static final String TAG_PATID_END = "</Patient_ID>";
    protected static final String TAG_ACCEPTID_START = "<Acceptance_Id type=\"string\">";
    protected static final String TAG_ACCEPTID_END = "</Acceptance_Id>";
    protected static final String TAG_DEPTCODE_START = "<Department_Code type=\"string\">";
    protected static final String TAG_DEPTCODE_END = "</Department_Code>";
    protected static final String TAG_PHYSICODE_START = "<Physician_Code type=\"string\">";
    protected static final String TAG_PHYSICODE_END = "</Physician_Code>";
    protected static final String TAG_ACCEPTDATE_START = "<Acceptance_Date type=\"string\">";
    protected static final String TAG_ACCEPTDATE_END = "</Acceptance_Date>";
    protected static final String TAG_MEDICALINFO_START = "<Medical_Information type=\"string\">";
    protected static final String TAG_MEDICALINFO_END = "</Medical_Information>";

    protected static final String TAG_APIRESULT_START = "<Api_Result type=\"string\">";
    protected static final String TAG_APIRESULT_END = "</Api_Result>";
    protected static final String TAG_APIRESULTMSG_START = "<Api_Result_Message type=\"string\">";
    protected static final String TAG_APIRESULTMSG_END = "</Api_Result_Message>";

    // 受付一覧
    protected static final String ORCAAPI47_ACCEPTLIST = "/api01rv2/acceptlstv2";
    protected static final String TAG_ACCEPTLST_START = "<acceptlstreq type=\"record\">";
    protected static final String TAG_ACCEPTLST_END = "</acceptlstreq>";

    // 予約一覧
    protected static final String ORCAAPI47_APPOINTLIST = "/api01rv2/appointlstv2";

    // 患者病名返却
    protected static final String ORCAAPI47_GETDISEASE = "/api01rv2/diseasegetv2";

    // 患者予約情報
    protected static final String ORCAAPI47_APPOINTLIST2 = "/api01rv2/appointlst2v2";

    // 受付登録
    protected static final String ORCAAPI47_ACCEPTMOD = "/orca11/acceptmodv2";
    protected static final String TAG_ACCEPTREQ_START = "<acceptreq type=\"record\">";
    protected static final String TAG_ACCEPTREQ_END = "</acceptreq>";
}
