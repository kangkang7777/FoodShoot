package com.wfuhui.common.validator;

import com.wfuhui.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
