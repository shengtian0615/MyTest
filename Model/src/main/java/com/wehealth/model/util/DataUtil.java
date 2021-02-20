package com.wehealth.model.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressLint("SimpleDateFormat")
public class DataUtil {

	private static SimpleDateFormat dateFormatterForCompare = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateFormatterForDisplay = new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat timeFormatterForDisplay = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public static int toInt(byte[] bytes){
		switch(bytes.length){
		case 1:
			return 0xff&bytes[0];
		case 2:
			return ((bytes[0]<<8)&0xff00)+(bytes[1]&0xff);
		case 3:
			return ((bytes[0]<<16)&0xff0000) + ((bytes[1]<<8)&0xff00) + (bytes[2]&0xff);
		default:
			return ((bytes[0]<<24)&0xff000000) + ((bytes[1]<<16)&0xff0000) + ((bytes[2]<<8)&0xff00) + (bytes[3]&0xff);
		}
	}
	
	public static short toShort(byte[] bytes){
		switch(bytes.length){
		case 1:
			return (short) (0xff&bytes[0]);
		default :
			return (short) (((bytes[0]<<8)&0xff00)+(bytes[1]&0xff));
		}
	}
	
	public static byte[] toByteArray(int value) {
	    return new byte[] {
	        (byte) (value >> 24),
	        (byte) (value >> 16),
	        (byte) (value >> 8),
	        (byte) value};
	}
	
	public static byte[] toByteArray(short value) {
	    return new byte[] {
	        (byte) (value >> 8),
	        (byte) value};
	}
	
	
	public static int[] toIntArray(byte[] bytes){
		int[] ret = new int[bytes.length/4];
		for(int i=0; i< bytes.length; ) {
			byte[] tmp = new byte[4];
			for(int j=0; j<4; j++) {
				tmp[j] = bytes[i+j];
			}
			ret[i/4] = toInt(tmp);
			i+=4;
		}
		return ret;
	}
	
	public static short[] toShortArray(byte[] bytes){
		short[] ret = new short[bytes.length/2];
		for(int i=0; i< bytes.length; ) {
			byte[] tmp = new byte[2];
			for(int j=0; j<2; j++) {
				tmp[j] = bytes[i+j];
			}
			ret[i/2] = toShort(tmp);
			i+=2;
		}
		return ret;
	}
	
	/**
	 * byte[] to short[], every gap number points get one point.
	 * 
	 * @param bytes byte array
	 * @param gap the gap number
	 * @return short array
	 */
	public static short[] toShortArray(byte[] bytes, int gap)
	{
		int bLen = bytes.length/2;
		int retLen = bLen/gap + (bLen%gap == 0 ? 0 : 1);
		int skip = 2 * gap;
		int retIndex = 0;
		
		short[] ret = new short[retLen];
		for(int i=0; i< bytes.length; ) 
		{
			byte[] tmp = new byte[2];
			for(int j=0; j<2; j++) 
			{
				tmp[j] = bytes[i+j];
			}
			ret[retIndex] = toShort(tmp);
			
			i += skip;
			retIndex++;
		}
		
		return ret;
	}
	
	public static byte[] toByteArray(short[] shorts){
		byte[] ret = new byte[shorts.length*2];
		for(int i=0; i< shorts.length; i++) {
			short value = shorts[i];
			byte[] tmp = toByteArray(value);
			for(int j=0; j<2; j++) {
				ret[i*2 + j] = tmp[j];
			}
		}
		return ret;
	}
	
	public static Short[] toShortObjArray(byte[] bytes){
		Short[] ret = new Short[bytes.length/2];
		for(int i=0; i< bytes.length; ) {
			byte[] tmp = new byte[2];
			for(int j=0; j<2; j++) {
				tmp[j] = bytes[i+j];
			}
			ret[i/2] = toShort(tmp);
			i+=2;
		}
		return ret;
	}
	
	
	public static byte[] toByteArray(Short[] shorts){
		byte[] ret = new byte[shorts.length*2];
		for(int i=0; i< shorts.length; i++) {
			short value = shorts[i];
			byte[] tmp = toByteArray(value);
			for(int j=0; j<2; j++) {
				ret[i*2 + j] = tmp[j];
			}
		}
		return ret;
	}
	
	public static byte[] toByteArray(int[] ints){
		byte[] ret = new byte[ints.length*4];
		for(int i=0; i< ints.length; i++) {
			int value = ints[i];
			byte[] tmp = toByteArray(value);
			for(int j=0; j<4; j++) {
				ret[i*4 + j] = tmp[j];
			}
		}
		return ret;
	}
	
	public static byte[] toByteArray(Integer[] ints){
		byte[] ret = new byte[ints.length*4];
		for(int i=0; i< ints.length; i++) {
			int value = ints[i];
			byte[] tmp = toByteArray(value);
			for(int j=0; j<4; j++) {
				ret[i*4 + j] = tmp[j];
			}
		}
		return ret;
	}
	
	public static boolean isEmptyString(String s)
	{
		return s == null || s.isEmpty();
	}
	
	public static boolean notEmptyString(String s)
	{
		return !isEmptyString(s);
	}
	
	
	public static String dateToStringForCompare(Date date)
	{
		return dateFormatterForCompare.format(date);
	}
	
	public static String dateToStringForDisplay(Date date)
	{
		return dateFormatterForDisplay .format(date);
	}
	
	public static String timeToStringForDisplay(Date date)
	{
		return timeFormatterForDisplay.format(date);
	}
	
	public static String convertBirthToAge(Date birthDate)
	{
		if (birthDate == null)
		{
			return null;
		}
		String age = null;
		Date currentDate = new Date();
		Date birthDateJava = new Date(birthDate.getTime());
		Date currentDateJava = new Date(currentDate.getTime());
		@SuppressWarnings("deprecation")
		int ageInt = currentDateJava.getYear() - birthDateJava.getYear();
		age = Integer.toString(ageInt);
		return age;
	}
	
	/**
	 * 用户名以字母开头
	 * 由字母，数字，下划线组成
	 * 6到20位
	 */
	public static boolean checkUserAvailable(String username)
	{
		if(username == null)
			return false;
		
		String pattern = "^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
		return username.matches(pattern);
	}

	/**
	 * 检查登录的信息
	 * @param userInfo
	 * @return
	 */
	public static int checkUsernamePhone(String userInfo){
		int resulType = 1;
		if (TextUtils.isEmpty(userInfo)){
			return resulType;
		}
		if (checkUserAvailable(userInfo)){
			resulType = 0;
			return resulType;
		}
		if (RegexUtil.phone(userInfo)){
			resulType = 0;
			return resulType;
		}
		return resulType;
	}
	
	public static boolean isPositiveNumber(String input) {
		if(input == null)
			return false;
		String pattern = "^(\\d+)(\\.\\d+)?$";
		return input.matches(pattern);
	}
	
	public static boolean isPositiveNumber(String input, boolean exceptZero) {
		if(isPositiveNumber(input))
		{
			if(exceptZero)
			{
				int iVal = Integer.parseInt(input);
				return iVal != 0;
			}
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Is the "input" string a "count" length number?
	 */
	public static boolean isPositiveNumber(String input, int count)
	{
		if(input == null)
			return false;
		String pattern = "^\\d{"+count+"}$";
		return input.matches(pattern);
	}
	
    /**
     * 如果是合法的用户名，则返回1
     * 如果是合法的身份证，返回2
     * 
     * 如果不是合法的用户名也不是合法的身份证则返-1
     */
    public static int checkClientIdType(String clientId)
    {
    	if(DataUtil.checkUserAvailable(clientId))
    		return 1;
    	
//    	return 2;
    	
    	if(IDCardValidator.isValidateIDCard(clientId))
    		return 2;
//    	
    	else
    		return -1;
    }

	/**
	 * 如果是合法的手机号，则返回1
	 * 如果是合法的身份证，返回2
	 *
	 * 如果不是合法的手机号也不是合法的身份证则返-1
	 */
	public static int checkIdType(String id)
	{
		if(RegexUtil.phone(id))
			return 1;
		if(IDCardValidator.isValidateIDCard(id))
			return 2;
		else
			return -1;
	}

	/**
	 * json字符串转换成map
	 *
	 * @param string key1=val1&key2=val2...
	 * @param urlDecoder
	 * @return
	 */
	public static Map<String, String> jsonStrToMap(String string, boolean urlDecoder)
	{
		Map<String, String> params = new HashMap<String, String>();
		if(DataUtil.isEmptyString(string))
			return params;

		if (!urlDecoder){
			string = urlDecode(string);
		}
		String[] pairs = string.split("&");
		for(String pair : pairs)
		{
			String[] content = pair.split("=");
			String key = content[0];
			String value = content[1];
			if(urlDecoder)
				value = urlDecode(value);
			params.put(key, value);
		}
		return params;
	}

	/**
	 * json string 转换成Map
	 * @param json e.g. {"2":"10","3":"-1","4":"5"}
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String json) {
		Map<String, Object> map = new HashMap<>();
		try {
			JSONObject object = new JSONObject(json);
			Iterator<String> iterator = object.keys();
			while (iterator.hasNext()){
				String key = iterator.next();
				map.put(key, object.get(key));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 文件名中如果有小括号，保存时曾经给转义成了%28，%29，下载后转不回来；可以在下载前把%28换成左括号，%29换成右括号
	 * @param str
	 * @return
	 */
	public static String urlDecode(String str)
	{
		try
		{
			return URLDecoder.decode(str, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			return str;
		}
	}
	/**
	 * URL编码
	 *
	 * @param str
	 * @return
	 */
	public static String urlEncode(String str)
	{
		try
		{
			return URLEncoder.encode(str, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			return str;
		}
	}
}
