package com.liuniukeji.springcloud.utils;

public class StrKit {
    public StrKit() {
    }

    //定义类变量、类方法
    public final static String[] filterStr = {"\\+"};

    public static String searchWordFilter(String searchWord) {
        if (null == searchWord || searchWord.trim() == "") {
            return "";
        }
        for (String str : filterStr) {
            //包含+号字符串，对+号的特殊处理，包含两个连续的+号不处理
            if ("\\+".equals(str) && searchWord.contains("+")) {
                int index1 = searchWord.indexOf("+");
                int index2 = searchWord.indexOf("++");
                searchWord = (index1 == index2 ? searchWord : searchWord.replaceAll(str, ""));
            } else {
                searchWord = searchWord.replaceAll(str, "");
            }
        }
        return searchWord;
    }

    public static String camel2underscore(String camelName) {
        camelName = capitalize(camelName);
        String regex = "([A-Z][a-z]+)";
        String replacement = "$1_";
        String underscoreName = camelName.replaceAll(regex, replacement);
        underscoreName = underscoreName.toLowerCase().substring(0, underscoreName.length() - 1);
        return underscoreName;
    }

    public static String underscore2camel(String underscoreName) {
        String[] sections = underscoreName.split("_");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sections.length; ++i) {
            String s = sections[i];
            if (i == 0) {
                sb.append(s);
            } else {
                sb.append(capitalize(s));
            }
        }

        return sb.toString();
    }

    public static String capitalize(String str) {
        return isEmpty(str) ? str : (new StringBuilder(str.length())).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String lowerCase(String str) {
        return isEmpty(str) ? str : (new StringBuilder(str.length())).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    public static String toString(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String[] var2 = strs;
        int var3 = strs.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            String str = var2[var4];
            sb.append(str + ",");
        }

        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    /**
     * 过滤入库报错的emoji表情
     * 此方法通过正则表达式将不能入库的emoji表情替换成空串,对可以入库的emoji表情进行保留
     * 此方法针对的是数据库字符集为utf8的情况,数据库字符集是utf8mb4时可以保存emoji表情
     * 不能入库的表情是四字节字符串,可以入库的表情是三字节字符串,在utf8字符集下,数据库中的字符串类型只能保存三字节字符串
     * 可以入库的emoji表情例子:☺✊✌☝✌☕⭐✨⚡♨✈⛵☁☀☔⛄⭕❌❔❕☎♣〽⛪
     * 不能入库的emoji表情例子:😚😓😰😝😁😜💨💦🔥🏆💰💤
     *
     * @param source 过滤前的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source) {
        if (source != null && source.length() > 0) {
            return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "*");
        } else {
            return source;
        }
    }
}
