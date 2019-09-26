package com.ank.cms.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 常用工具函数
 */
public interface ITools {

    /**
     * 判断是否位整数
     *
     * @param InValue
     * @return
     */
    boolean IsInt(String InValue);

    /**
     * 判断是否位数字
     *
     * @param InValue
     * @return
     */
    boolean IsNumeric(String InValue);

    /**
     * 判断变量是否为Null或DBNull
     *
     * @param InValue 输入字符
     * @return Boolean
     */
    boolean IsNull(Object InValue);

    /**
     * 将Null或DBNull转换为Int
     *
     * @param InValue 输入字符
     * @return
     */
    int NullInt(Object InValue);

    /**
     * 将Null或DBNull转换为Int
     *
     * @param InValue      输入字符
     * @param DefaultValue 默认de
     * @return
     */
    int NullInt(Object InValue, int DefaultValue);

    /**
     * 将Null或DBNull转换为Dbl
     *
     * @param InValue 输入字符
     * @return
     */
    double NullDbl(Object InValue);

    /**
     * 将Null或DBNull转换为Dbl
     *
     * @param InValue      输入字符
     * @param DefaultValue 默认
     * @return
     */
    double NullDbl(Object InValue, double DefaultValue);

    /**
     * 将Null或DBNull转换为Str
     *
     * @param InValue 输入字符
     * @return
     */
    String NullStr(Object InValue);

    /**
     * 将Null或DBNull转换为Str
     *
     * @param InValue      输入字符
     * @param DefaultValue 默认
     * @return
     */
    String NullStr(Object InValue, String DefaultValue);

    /**
     * 将Null或DBNull转换为Date
     *
     * @param InValue 输入字符
     * @return
     */
    Date NullDate(Object InValue);

    /**
     * 将Null或DBNull转换为Date
     *
     * @param InValue 输入字符 @param DefaultValue 默认 @return @throws
     */
    Date NullDate(Object InValue, long DefaultValue);

    /**
     * 格式化数字
     *
     * @param InValue 输入字符
     * @return
     */
    int CheckInt(String InValue);

    long CheckLong(String InValue);

    /**
     * 格式化小数
     *
     * @param InValue 输入字符
     * @return
     */
    double CheckFloat(String InValue);

    /**
     * 过滤非法字符
     *
     * @param InValue 输入字符
     * @return
     */
    String CheckStr(String InValue);

    /**
     * 转换为日期类型yyyy-MM-dd HH:mm:ss
     *
     * @param InValue 输入字符
     * @return
     */
    Date CheckDate(String InValue);

    /**
     * 转换为日期类型yyyy-MM-dd
     *
     * @param InValue 输入字符
     * @return
     */
    Date CheckShortDate(String InValue);

    /**
     * 格式化显示日期
     *
     * @param sDataTime      日期
     * @param FormatTemplate 格式
     * @return
     */
    String FormatDate(Date sDataTime, String FormatTemplate);

    /**
     * 格式化显示日期
     *
     * @param sDataTime
     * @return
     */
    String FormatDate(Date sDataTime);

    /**
     * 格式化显示日期 yyyy-MM-dd
     *
     * @param sDataTime
     * @return
     */
    String FormatShortDate(Date sDataTime);

    /**
     * 检验邮箱格式是否有效
     *
     * @param strEmail 邮箱地址
     * @return
     */
    boolean CheckEmail(String strEmail);

    /**
     * 过滤非法HTML
     *
     * @param strHTML HTMLCODE
     * @return
     */
    String CheckHTML(String strHTML);

    /**
     * 清除HTML标签
     *
     * @param strHTML HTMLCODE
     * @return
     */
    String CleanHTML(String strHTML);

    /**
     * 截取字符串
     *
     * @param s   输入字符
     * @param len 截取长度
     * @return
     */
    String CutStr(String s, int len);

    /**
     * 截取字符串
     *
     * @param s     输入字符
     * @param len   截取长度
     * @param style 省略字符样式
     * @return
     */
    String CutStr(String s, int len, String style);

    /**
     * 生成64位随机码
     *
     * @return
     */
    String CreatevKey();

    /**
     * 生成指定长度随机码
     *
     * @return
     */
    String CreatevKey(int KeyLength);

    /**
     * 截取字符串
     *
     * @param s   需要截取的字符串
     * @param len 截取长度
     * @return
     */
    String Left(String s, int len);

    /**
     * 根据RecordCount及PageSize确定页面数
     *
     * @param RecordCount 记录总数
     * @param PageSize    每页记录数
     * @return 页面总数
     */
    int CalculatePages(int RecordCount, int PageSize);

    /**
     * 确定当前页面是否正确
     *
     * @param CurrentPage 当前页面
     * @param PageCount   页面总数
     * @return 处理后的当前页面
     */
    int DeterminePage(int CurrentPage, int PageCount);

    /**
     * 是否没有空格的并且有字符的字符串
     *
     * @param inValue
     * @return
     */
    boolean IsNotEmptyString(String inValue);

    /**
     * 检查手机号
     *
     * @param strMobile
     * @return
     */
    boolean CheckMobile(String strMobile);

    /**
     * 四舍五入
     *
     * @param inval
     * @param len
     * @return
     */
    double FormatDouble(double inval, int len);

    public String CreatevNum(int KeyLength);

    /**
     * 将数组拼接成用指定符号连接的字符串
     *
     * @param arr
     * @param signal
     * @return
     */
    public String ArrayToStr(String[] arr, String signal);

    /**
     * 将字符串列表拼接成用指定符号连接的字符串
     *
     * @param list
     * @param signal
     * @return
     */
    public String ListToStr(List<String> list, String signal);

    /**
     * 读取文件MD5的
     *
     * @param fileName 文件物理物理路径
     * @return
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     */
    public String getMd5ByFile(String fileName);

    public String delHTMLTag(String htmlStr);

    /**
     * 将int列表拼接成用指定符号连接的字符串
     *
     * @param list
     * @param signal
     * @return
     */
    public String ListIntToStr(List<Integer> list, String signal);

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public String CreateLinkString(Map<String, String> params);

    public String sendPost(String url, String param);

    public String sendGet(String url);

    public String replaceMdate(String date);

    public String veCodeFun();

    /**
     * 为了 让标题对齐，新疆等两个字城市多了一个空格,去掉这个空格在其它地方的显示
     *
     * @param state
     * @return
     */
    public String replaceBlank(String state);

    /**
     * @param citinumcode 传入的城市编码。 把城市编码转化为三位数字
     * @return
     * @Title: citynumcode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public String citynumcode(String citinumcode);

    /**
     * 产生6位数的随机数
     */
    public int sixRandomNumber();

    /**
     * @param data       串
     * @param privateKey 私钥
     * @return
     * @throws Exception
     * @Title: RSASign
     * @Description: 用私钥对数字进行签名
     */
    public String RSASign(String data, String privateKey);

    public String getCoverPhoneNumber(String phoneNumber);

    public String getHtmlText(String htmlStr);

    /**
     * 获取当前页数
     *
     * @param start
     * @param length
     * @return
     */
    public Integer getCurrentPage(String start, String length);
}