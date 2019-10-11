package com.sto.sentinel.csp;

import java.util.Arrays;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;

@Component
public class MyUrlCleaner implements UrlCleaner {

	@Override
	public String clean(String originUrl) {
		String[] split = originUrl.split("/");

        // 将数字转换为特定的占位标识符
        return Arrays.stream(split)
                .map(s -> NumberUtils.isNumber(s) ? "{number}" : s)
                .reduce((a, b) -> a + "/" + b)
                .orElse("");
	}
}
