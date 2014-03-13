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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * JsonConverter
 *
 * @author masuda, Masuda Naika
 * @author modified Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
public class JsonConverter {

    private static final String CAMMA = ",";
    private static final ObjectMapper objectMapper;
    private static final JsonConverter instance;
    private static final boolean debug = false;

    static {
        instance = new JsonConverter();
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        if (debug) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }

    private JsonConverter() {
    }

    public static JsonConverter getInstance() {
        return instance;
    }

    // Object to JSON
    public String toJson(Object obj) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            debug(json);
            return json;
        } catch (JsonGenerationException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        }
        return null;
    }

    public void toJson(Object obj, OutputStream os) {
        try {
            objectMapper.writeValue(os, obj);
        } catch (JsonGenerationException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        }
    }

    // JSON to Object
    public Object fromJson(String json, Class clazz) {
        try {
            debug(json);
            return objectMapper.readValue(json, clazz);
        } catch (JsonParseException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        }

        return null;
    }

    public Object fromJson(String json, TypeReference typeRef) {
        try {
            debug(json);
            return objectMapper.readValue(json, typeRef);
        } catch (JsonParseException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        }
        return null;
    }

    // JSON InputStream to Object
    public Object fromJson(InputStream is, Class clazz) {
        try {
            Object obj = objectMapper.readValue(is, clazz);
            return obj;
        } catch (JsonParseException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public Object fromJson(InputStream is, TypeReference typeRef) {
        try {
            Object obj = objectMapper.readValue(is, typeRef);
            return obj;
        } catch (JsonParseException ex) {
            processException(ex);
        } catch (JsonMappingException ex) {
            processException(ex);
        } catch (IOException ex) {
            processException(ex);
        } catch (Exception ex) {
            processException(ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    // GZipped JSON to Object
    public Object fromGzippedJson(byte[] bytes, Class clazz) {

        InputStream is = new ByteArrayInputStream(bytes);
        return fromGzippedJson(is, clazz);
    }

    public Object fromGzippedJson(byte[] bytes, TypeReference typeRef) {

        InputStream is = new ByteArrayInputStream(bytes);
        return fromGzippedJson(is, typeRef);
    }

    // GZipped JSON InputStream to Object
    public Object fromGzippedJson(InputStream is, Class clazz) {

        GZIPInputStream gis = null;
        try {
            gis = new GZIPInputStream(is);
            Object obj = fromJson(gis, clazz);
            return obj;
        } catch (IOException ex) {
            processException(ex);
        } finally {
            try {
                if (gis != null) {
                    gis.close();
                }
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public Object fromGzippedJson(InputStream is, TypeReference typeRef) {

        GZIPInputStream gis = null;
        try {
            gis = new GZIPInputStream(is);
            Object obj = fromJson(gis, typeRef);
            return obj;
        } catch (IOException ex) {
            processException(ex);
        } finally {
            try {
                if (gis != null) {
                    gis.close();
                }
            } catch (IOException ex) {
            }
        }
        return null;
    }

    private void processException(Exception ex) {
        ex.printStackTrace(System.err);
    }

    private void debug(String msg) {
        if (debug) {
            System.out.print(msg);
        }
    }

    public List<Long> toLongList(String params) {
        String[] strArray = params.split(CAMMA);
        List<Long> ret = new ArrayList<>();
        for (String s : strArray) {
            ret.add(Long.valueOf(s));
        }
        return ret;
    }

    public List<String> toStrList(String params) {
        String[] strArray = params.split(CAMMA);
        return Arrays.asList(strArray);
    }

    public String fromList(Collection list) {

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Iterator itr = list.iterator(); itr.hasNext();) {
            if (!first) {
                sb.append(CAMMA);
            } else {
                first = false;
            }
            sb.append(String.valueOf(itr.next()));
        }
        return sb.toString();
    }
}
