package com.irady.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * PreferencesUtils, easy to get or put data
 * <ul>
 * <strong>Preference Name</strong>
 * <li>you can change preference name by {@link #PREFERENCE_NAME}</li>
 * </ul>
 * <ul>
 * <strong>Put Value</strong>
 * <li>put string {@link #putString(Context, String, String)}</li>
 * <li>put int {@link #putInt(Context, String, int)}</li>
 * <li>put long {@link #putLong(Context, String, long)}</li>
 * <li>put float {@link #putFloat(Context, String, float)}</li>
 * <li>put boolean {@link #putBoolean(Context, String, boolean)}</li>
 * </ul>
 * <ul>
 * <strong>Get Value</strong>
 * <li>get string {@link #getString(Context, String)}, {@link #getString(Context, String, String)}</li>
 * <li>get int {@link #getInt(Context, String)}, {@link #getInt(Context, String, int)}</li>
 * <li>get long {@link #getLong(Context, String)}, {@link #getLong(Context, String, long)}</li>
 * <li>get float {@link #getFloat(Context, String)}, {@link #getFloat(Context, String, float)}</li>
 * <li>get boolean {@link #getBoolean(Context, String)}, {@link #getBoolean(Context, String, boolean)}</li>
 * </ul>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-3-6
 */
public class PreferencesUtil {
        public static String getString(Context ct,String prefName,String key,String defValue){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        String rs = sp.getString(key, defValue);
                        return rs;
                        
                } catch (Exception e) {
                        return defValue;
                }
        }
        
        public static int getInt(Context ct,String prefName,String key,int defValue){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        int rs = sp.getInt(key, defValue);
                        return rs;
                        
                } catch (Exception e) {
                        return defValue;
                }
        }
        
        public static boolean getBoolean(Context ct,String prefName,String key,boolean defValue){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        boolean rs = sp.getBoolean(key, defValue);
                        return rs;
                        
                } catch (Exception e) {
                        return defValue;
                }
        }
        
        public static float getFloat(Context ct,String prefName,String key,float defValue){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        float rs = sp.getFloat(key, defValue);
                        return rs;                        
                } catch (Exception e) {
                        return defValue;
                }
        }
        
        public static long getLong(Context ct,String prefName,String key,long defValue){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        long rs = sp.getLong(key, defValue);
                        return rs;
                        
                } catch (Exception e) {
                        return defValue;
                }
        }
        
        public static Map<String, ?> getMap(Context ct,String prefName){
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE );
                        Map<String, ?> rsMap = sp.getAll();
                        return rsMap;
                        
                } catch (Exception e) {
                        return null;
                } 
        }
        

        
        public static boolean putString(Context ct,String prefName,String key,String value){
                boolean rs = true;
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        sp.edit().putString(key, value)
                        .commit();
                        
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
        
        
        public static boolean putBoolean(Context ct,String prefName,String key,Boolean value){
                boolean rs = true;
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        sp.edit().putBoolean(key, value)
                        .commit();
                        
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
        
        public static boolean putInt(Context ct,String prefName,String key,int value){
                boolean rs = true;
                
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        sp.edit().putInt(key, value)
                        .commit();
                        
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
        public static boolean putFloat(Context ct,String prefName,String key,float value){
                boolean rs = true;
                
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        sp.edit().putFloat(key, value)
                        .commit();
                        
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
        public static boolean putLong(Context ct,String prefName,String key,long value){
                boolean rs = true;
                
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        sp.edit().putLong(key, value)
                        .commit();
                        
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
        public static boolean putMap(Context ct,String prefName,Map<String, ?> map){
                boolean rs = true;
                try {
                        SharedPreferences sp = ct.getSharedPreferences(prefName, Context.MODE_PRIVATE);
                        Editor editor = sp.edit();
                        Set<String> keys = map.keySet();
                        Iterator<String> it = keys.iterator();
                        while(it.hasNext()){
                                String key = it.next();
                                Object value = map.get(key);
                                if(value instanceof Integer){
                                        editor.putInt(key, Integer.valueOf(String.valueOf(value)).intValue());
                                } else if(value instanceof Boolean){
                                        editor.putBoolean(key, Boolean.valueOf(String.valueOf(value)).booleanValue());
                                } else if(value instanceof Float){
                                        editor.putFloat(key, Float.valueOf(String.valueOf(value)).floatValue());
                                } else if(value instanceof Long){
                                        editor.putLong(key, Long.valueOf(String.valueOf(value)).longValue());
                                } else if(value instanceof String){
                                        editor.putString(key, String.valueOf(value));
                                }
                        }
                        editor.commit(); 
                } catch (Exception e) {
                        rs = false;
                }
                return rs;
        }
        
    	
        public static String PREFERENCE_NAME = "Android_Common_prefs";

        /**
         * put string preferences
         * 
         * @param context
         * @param key The name of the preference to modify
         * @param value The new value for the preference
         * @return True if the new values were successfully written to persistent storage.
         */
        public static boolean putString(Context context, String key, String value) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(key, value);
            return editor.commit();
        }

        /**
         * get string preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @return The preference value if it exists, or null. Throws ClassCastException if there is a preference with this
         * name that is not a string
         * @see #getString(Context, String, String)
         */
        public static String getString(Context context, String key) {
            return getString(context, key, null);
        }

        /**
         * get string preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @param defaultValue Value to return if this preference does not exist
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * this name that is not a string
         */
        public static String getString(Context context, String key, String defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            return settings.getString(key, defaultValue);
        }

        /**
         * put int preferences
         * 
         * @param context
         * @param key The name of the preference to modify
         * @param value The new value for the preference
         * @return True if the new values were successfully written to persistent storage.
         */
        public static boolean putInt(Context context, String key, int value) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(key, value);
            return editor.commit();
        }

        /**
         * get int preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
         * name that is not a int
         * @see #getInt(Context, String, int)
         */
        public static int getInt(Context context, String key) {
            return getInt(context, key, -1);
        }

        /**
         * get int preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @param defaultValue Value to return if this preference does not exist
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * this name that is not a int
         */
        public static int getInt(Context context, String key, int defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            return settings.getInt(key, defaultValue);
        }

        /**
         * put long preferences
         * 
         * @param context
         * @param key The name of the preference to modify
         * @param value The new value for the preference
         * @return True if the new values were successfully written to persistent storage.
         */
        public static boolean putLong(Context context, String key, long value) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putLong(key, value);
            return editor.commit();
        }

        /**
         * get long preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
         * name that is not a long
         * @see #getLong(Context, String, long)
         */
        public static long getLong(Context context, String key) {
            return getLong(context, key, -1);
        }

        /**
         * get long preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @param defaultValue Value to return if this preference does not exist
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * this name that is not a long
         */
        public static long getLong(Context context, String key, long defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            return settings.getLong(key, defaultValue);
        }

        /**
         * put float preferences
         * 
         * @param context
         * @param key The name of the preference to modify
         * @param value The new value for the preference
         * @return True if the new values were successfully written to persistent storage.
         */
        public static boolean putFloat(Context context, String key, float value) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putFloat(key, value);
            return editor.commit();
        }

        /**
         * get float preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
         * name that is not a float
         * @see #getFloat(Context, String, float)
         */
        public static float getFloat(Context context, String key) {
            return getFloat(context, key, -1);
        }

        /**
         * get float preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @param defaultValue Value to return if this preference does not exist
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * this name that is not a float
         */
        public static float getFloat(Context context, String key, float defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            return settings.getFloat(key, defaultValue);
        }

        /**
         * put boolean preferences
         * 
         * @param context
         * @param key The name of the preference to modify
         * @param value The new value for the preference
         * @return True if the new values were successfully written to persistent storage.
         */
        public static boolean putBoolean(Context context, String key, boolean value) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(key, value);
            return editor.commit();
        }

        /**
         * get boolean preferences, default is false
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @return The preference value if it exists, or false. Throws ClassCastException if there is a preference with this
         * name that is not a boolean
         * @see #getBoolean(Context, String, boolean)
         */
        public static boolean getBoolean(Context context, String key) {
            return getBoolean(context, key, false);
        }

        /**
         * get boolean preferences
         * 
         * @param context
         * @param key The name of the preference to retrieve
         * @param defaultValue Value to return if this preference does not exist
         * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
         * this name that is not a boolean
         */
        public static boolean getBoolean(Context context, String key, boolean defaultValue) {
            SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
            return settings.getBoolean(key, defaultValue);
        }
        
    	/*璁剧疆宸茬粡鍒嗕韩鐨勫競鍦�/
    	public static void setFeedbackMarket(Context ct,String pkgname) {
    		SharedPreferences pf = ct.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    		pf.edit().putString(pkgname, "true")
    		.commit();
    	}
    	/*鏄惁鏄凡缁忓垎浜殑甯傚満*/
    	public static boolean isFeedbackedMarket(Context ct,String pkgname) {
    		SharedPreferences pf = ct.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    		return pf.getString(pkgname, "").equals("true");
    	}
}
