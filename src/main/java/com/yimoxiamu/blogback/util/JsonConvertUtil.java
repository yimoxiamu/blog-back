package com.yimoxiamu.blogback.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Andy
 * @createTime 2016-08-02 
 * @desc  json与String类型转换通用方法
 * 
 */
@Service
public class JsonConvertUtil {
	private static final String CACHE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * Json转换成String
	 * @param jsonObj
	 * @return
	 */
	
	
	/**
	 * 统一JSON转换格式(FastJson)
	 * @param object
	 * @return
	 */
	public static String toFastJsonString(Object object) {
		SerializeConfig config = new SerializeConfig();
		config.put(java.util.Date.class, new FastJsonDateFormatSerializer());
		config.put(java.sql.Date.class, new FastJsonDateFormatSerializer());
		config.put(java.sql.Timestamp.class, new FastJsonDateFormatSerializer());
		return com.alibaba.fastjson.JSON.toJSONString(object, config, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
	}
	
	public static boolean IsJsonString(Object obj) {
		if(obj instanceof String) {
			String jString = (String)obj;
			try{
				com.alibaba.fastjson.JSON.parse(jString);
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 统一JSON转换格式(FastJson)
	 * @param object
	 * @return
	 */
	public static com.alibaba.fastjson.JSONObject toFastJsonObject(Object object, boolean writeNullValue) {
		SerializeConfig config = new SerializeConfig();
		config.put(java.util.Date.class, new FastJsonDateFormatSerializer());
		config.put(java.sql.Date.class, new FastJsonDateFormatSerializer());
		config.put(java.sql.Timestamp.class, new FastJsonDateFormatSerializer());

		return (com.alibaba.fastjson.JSONObject)com.alibaba.fastjson.JSON.toJSON(object, config);
	}
	
	/**
	 * JSON转对象
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T fastJsonStringToEntity(String str, Class<T> clazz) {
		
		T object = com.alibaba.fastjson.JSON.parseObject(str, clazz);
		return object;
	}
	
	/**
	 * JSON转list
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> fastJson2EntityList(String str, Class<T> clazz) {
		try{
			List<T> list = com.alibaba.fastjson.JSON.parseArray(str, clazz);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * list转JSON
	 * @param <T>
     * @return
     */
    public static <T> String fastList2Json(List<T> list) {
      //list转换为json
        try{
            String str= com.alibaba.fastjson.JSON.toJSON(list).toString();
            return str;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 转换Map
	 * @param jsonValue
	 * @return
	 */
	public static List<Map<String, Object>> fastJson2MapList(String jsonValue) {
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		try{
			com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(jsonValue);
			for(int i = 0; i < array.size(); i++) {
				Map<String, Object> map = convert2MapObject(array.get(i).toString());
				if(map != null) {
					list.add(map);
				}
			}
		}catch (Exception e) {
		}
		return list;
	}
	
	/**
	 * JSON转Map
	 * @param jsonValue
	 * @return
	 */
	public static Map<String, Object> convert2MapObject(String jsonValue) {
		try{
			Map<String, Object> map = JSON.parseObject(jsonValue, new TypeReference<HashMap<String, Object>>(){});
			return map;
		}catch (Exception e) {
			
		}
		
		return null;
	}
	
	public static String getJsonValue(String jstr, String key) {
		try{
			com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject)com.alibaba.fastjson.JSON.parse(jstr);
			return StringUtils.toString(jsonObject.get(key));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static com.alibaba.fastjson.JSONObject parseJson(String json) {
		try{
			com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject)com.alibaba.fastjson.JSON.parse(json);
			return jsonObject;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}

