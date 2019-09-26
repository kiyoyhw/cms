package com.ank.cms.util;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.regex.Matcher;/*
import java.util.regex.Patter;*/
import java.util.regex.Pattern;

public class Tools implements ITools {

    @Override
    public boolean IsInt(String InValue) {
        boolean blnResult = true;
        if (InValue != null && InValue.length() > 0) {
            Pattern pattern = Pattern.compile("^[+-]?\\d+$", Pattern.CASE_INSENSITIVE);
            blnResult = pattern.matcher(InValue).matches();
        } else {
            blnResult = false;
        }
        return blnResult;
    }

    @Override
    public boolean IsNumeric(String InValue) {
        boolean blnResult = true;
        if (InValue != null && InValue.length() > 0) {
            Pattern pattern = Pattern.compile("^[+-]?\\d+[.]?\\d*$", Pattern.CASE_INSENSITIVE);
            blnResult = pattern.matcher(InValue).matches();
        } else {
            blnResult = false;
        }
        return blnResult;
    }

    @Override
    public boolean IsNull(Object InValue) {
        if (InValue == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int NullInt(Object InValue) {
        return NullInt(InValue, 0);
    }

    @Override
    public int NullInt(Object InValue, int DefaultValue) {

        if (!IsNull(InValue)) {
            try {
                return Integer.parseInt(InValue.toString());
            } catch (Exception e) {
                e.printStackTrace();
                return DefaultValue;
            }
        } else {
            return DefaultValue;
        }
    }

    @Override
    public double NullDbl(Object InValue) {
        return NullDbl(InValue, 0);
    }

    @Override
    public double NullDbl(Object InValue, double DefaultValue) {
        if (!IsNull(InValue)) {
            try {
                return Double.parseDouble(InValue.toString());
            } catch (Exception e) {
                e.printStackTrace();
                return DefaultValue;
            }
        } else {
            return DefaultValue;
        }
    }

    @Override
    public String NullStr(Object InValue) {
        return NullStr(InValue, "");
    }

    @Override
    public String NullStr(Object InValue, String DefaultValue) {
        if (!IsNull(InValue)) {
            return InValue.toString();
        } else {
            return DefaultValue;
        }
    }

    @Override
    public Date NullDate(Object InValue) {
        return NullDate(InValue, 0);
    }

    @Override
    public Date NullDate(Object InValue, long DefaultValue) {
        if (!IsNull(InValue) && InValue.getClass().equals(java.sql.Timestamp.class)) {
            return (Date) InValue;
        } else {
            return new Date(DefaultValue);
        }
    }

    @Override
    public int CheckInt(String InValue) {
        try {
            if (IsInt(InValue)) {
                return Integer.parseInt(InValue);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public long CheckLong(String InValue) {
        try {
            if (IsInt(InValue)) {
                return Long.parseLong(InValue);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public double CheckFloat(String InValue) {
        try {
            if (IsNumeric(InValue)) {
                return Double.parseDouble(InValue);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String CheckStr(String InValue) {

        if (InValue != null && InValue.length() > 0) {
            // 先去掉跟script有关的一切输入<s
            InValue = InValue.replaceAll("(<|&lt;)script(.*?)script(>|&gt;)", "");
            InValue = InValue.replaceAll("&", "[&]");

            InValue = InValue.replaceAll(";", "[;]");

            InValue = InValue.replaceAll("[&]", "&amp;");

            InValue = InValue.replaceAll("[;]", "&#59;");

            InValue = InValue.replaceAll("%", "&#37;");

            InValue = InValue.replaceAll("'", "&#39;");

            // InValue = InValue.replaceAll("\"\"", "&quot;");

            InValue = InValue.replaceAll(">", "&gt;");

            InValue = InValue.replaceAll("<", "&lt;");

            InValue = InValue.replaceAll("	", "   ");

            InValue = InValue.replaceAll("\"", "&quot;");
        } else {
            InValue = "";
        }
        return InValue;
    }

    @Override
    public Date CheckDate(String InValue) {

        if (IsNull(InValue)) {
            return null;
        }

        if (InValue.length() < 14 || InValue.length() > 19) {
            return null;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(InValue.toString());
        } catch (java.text.ParseException e) {
            return null;
        }
    }

    @Override
    public Date CheckShortDate(String InValue) {

        if (IsNull(InValue)) {
            return null;
        }

        if (InValue.length() < 8 || InValue.length() > 10) {
            return null;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(InValue.toString());
        } catch (java.text.ParseException e) {
            return null;
        }
    }

    @Override
    public String FormatDate(Date sDataTime, String FormatTemplate) {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(FormatTemplate);
        return format.format(sDataTime);
    }

    @Override
    public String FormatDate(Date sDataTime) {
        if (sDataTime == null) {
            return "";
        }
        return FormatDate(sDataTime, "yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String FormatShortDate(Date sDataTime) {
        return FormatDate(sDataTime, "yyyy-MM-dd");
    }

    @Override
    public boolean CheckEmail(String strEmail) {
        if (strEmail != null && strEmail.length() > 0) {
            Pattern pattern = Pattern.compile(
                    "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|com|gov|mil|org|edu|int|asia)$",
                    Pattern.CASE_INSENSITIVE);
            return pattern.matcher(strEmail).matches();
        } else {
            return false;
        }
    }

    @Override
    public String CheckHTML(String strHTML) {
        if (strHTML != null && strHTML.length() > 0) {
            return strHTML.replaceAll("<script (.*?)>(.*?)</script>", "");
        } else {
            return strHTML;
        }
    }

    @Override
    public String CleanHTML(String strHTML) {
        if (strHTML != null && strHTML.length() > 0) {
            return strHTML.replaceAll("<[^>]*>", "");
        } else {
            return strHTML;
        }
    }

    @Override
    public String CutStr(String s, int len) {
        return CutStr(s, len, "…");
    }

    @Override
    public String CutStr(String s, int len, String style) {
        if (s == null) {
            return "";
        }

        String temp = s;
        if (temp.replaceAll("[^\\x00-\\xff]", "zz").length() <= len) {
            return temp;
        }
        for (int i = temp.length(); i >= 0; i--) {
            temp = temp.substring(0, i);
            if (temp.replaceAll("[^\\x00-\\xff]", "zz").length() <= len - style.length()) {
                return temp + style;
            }
        }
        return "";
    }

    @Override
    public String CreatevKey() {
        return CreatevKey(64);
    }

    @Override
    public String CreatevKey(int KeyLength) {

        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9'};

        // 61是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = str.length;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度

        StringBuffer strKey = new StringBuffer("");
        Random r = new Random();
        while (count < KeyLength) {
            // 生成随机数，取绝对值，防止生成负数
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
            if (i >= 0 && i < maxNum) {
                strKey.append(str[i]);
                count++;
            }
        }

        return strKey.toString();
    }

    @Override
    public String CreatevNum(int KeyLength) {

        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        // 61是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = str.length;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度

        StringBuffer strKey = new StringBuffer("");
        Random r = new Random();
        while (count < KeyLength) {
            // 生成随机数，取绝对值，防止生成负数
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
            if (i >= 0 && i < maxNum) {
                strKey.append(str[i]);
                count++;
            }
        }

        return strKey.toString();
    }

    @Override
    public String Left(String s, int len) {
        return (s.length() > len) ? s.substring(0, len) : s;
    }

    @Override
    public int CalculatePages(int RecordCount, int PageSize) {
        if (RecordCount > 0) {
            if ((RecordCount % PageSize) == 0) {
                return RecordCount / PageSize;
            } else {
                return RecordCount / PageSize + 1;
            }

        } else {
            return 0;
        }
    }

    @Override
    public int DeterminePage(int CurrentPage, int PageCount) {
        if (CurrentPage < 1) {
            CurrentPage = 1;
        } else if (CurrentPage > PageCount) {
            CurrentPage = PageCount;
        }
        return CurrentPage;
    }

    /**
     * 是否不包含空格的并且有字符的字符串
     *
     * @param inValue
     * @return
     */
    public boolean IsNotEmptyString(String inValue) {
        return inValue != null && inValue.trim().length() > 0;
    }

    /**
     * 检查手机号
     *
     * @param strMobile
     * @return
     */
    public boolean CheckMobile(String strMobile) {
        if (strMobile.length() != 11) {
            return false;
        }
        Pattern pattern = Pattern.compile("^1[0-9]{10}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(strMobile).matches();
    }

    public double FormatDouble(double inval, int len) {
        return new java.math.BigDecimal(String.valueOf(inval)).setScale(len, java.math.RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * 将数组拼接成用指定符号连接的字符串
     *
     * @param arr
     * @param signal
     * @return
     */
    public String ArrayToStr(String[] arr, String signal) {
        if (arr == null || arr.length <= 0 || signal == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(signal);
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * 将字符串列表拼接成用指定符号连接的字符串
     *
     * @param list
     * @param signal
     * @return
     */
    public String ListToStr(List<String> list, String signal) {
        if (list == null || list.size() <= 0 || signal == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(signal);
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * 将int列表拼接成用指定符号连接的字符串
     *
     * @param list
     * @param signal
     * @return
     */
    public String ListIntToStr(List<Integer> list, String signal) {
        if (list == null || list.size() <= 0 || signal == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(signal);
            sb.append(list.get(i));
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    @Override
    public String getMd5ByFile(String fileName) {

        try {
            java.io.File f = new java.io.File(fileName);
            java.io.InputStream ins = new java.io.FileInputStream(f);
            byte[] buffer = new byte[8192];
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");

            int len;
            while ((len = ins.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            ins.close();
            byte[] md = md5.digest();

            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            int upperBound = hexDigits.length - 1;
            StringBuilder sb = new StringBuilder(hexDigits.length * 2);
            for (int i = 0; i <= upperBound; i++) {
                sb.append(hexDigits[(md[i] & 0xf0) >>> 4]);
                sb.append(hexDigits[md[i] & 0x0f]);
            }
            return sb.toString().toLowerCase();
        } catch (Exception ex) {
            return "";
        }
    }

    // 去掉html内所有的标签
    @Override
    public String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public String CreateLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    public String sendPost(String url, String param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception ex) {
            System.out.println("发送 POST请求出现异常！" + ex);
            ex.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public String sendGet(String url) {
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");
            conn.setUseCaches(false);
            conn.connect();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception ex) {
            System.out.println("发送GET请求出现异常！" + ex);
            ex.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String replaceMdate(String date) {
        if (date == null || "".equals(date)) {
            return "";
        } else if (date.contains("T")) {
            return date.replace("T", " ") + ":00";
        } else {
            return date + ":00";
        }
    }

    @Override
    public String veCodeFun() {
        String code = "";
        Random rand = new Random();// 生成随机数
        for (int a = 0; a < 12; a++) {
            code += rand.nextInt(10);// 生成6位验证码
        }
        return code;
    }

    @Override
    public String replaceBlank(String state) {

        if (state != null && !"".equals(state)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(state);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        } else {
            return state;
        }
    }

    @Override
    public String citynumcode(String citinumcode) {
        if (citinumcode == null || citinumcode == "") {
            return "";
        } else if (citinumcode.length() <= 3) {
            return citinumcode;
        } else {
            return citinumcode.substring(citinumcode.length() - 3);
        }
    }

    @Override
    public int sixRandomNumber() {
        return (int) (Math.random() * (1000000 - 99999 + 1)) + 99999;
    }

    /*** 加密算法RSA ***/
    private final String KEY_ALGORITHM = "RSA";

    /*** 签名算法 ***/
    private final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * @param data       串
     * @param privateKey 私钥
     * @return
     * @throws Exception
     * @Title: RSASign
     * @Description: 用私钥对数字进行签名
     */
    public String RSASign(String data, String privateKey) {
        try {
            byte[] keyBytes = Base64.decodeBase64(privateKey);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateK);
            signature.update(data.getBytes());
            return Base64.encodeBase64String(signature.sign());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getCoverPhoneNumber(String phoneNumber) {
        if (null == phoneNumber || phoneNumber.length() < 11) {
            return "";
        } else {
            return phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7, phoneNumber.length());
        }
    }

    @Override
    public String getHtmlText(String htmlStr) {
        if (null == htmlStr || htmlStr.equals("")) {
            return "";
        }
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符
        String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";//定义所有w标签

        Pattern p_w = Pattern.compile(regEx_w, Pattern.CASE_INSENSITIVE);
        Matcher m_w = p_w.matcher(htmlStr);
        htmlStr = m_w.replaceAll(""); // 过滤script标签


        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签


        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签


        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签


        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签


        htmlStr = htmlStr.replaceAll(" ", ""); //过滤
        return htmlStr.trim(); // 返回文本字符串
    }

    public Integer getCurrentPage(String start, String length) {
        if (!IsInt(start) || !IsInt(length)) {
            return 1;
        } else {
            return (Integer.parseInt(length) + Integer.parseInt(start)) / Integer.parseInt(length);
        }
    }
}
