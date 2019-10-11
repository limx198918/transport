package com.sto.sentinel.csp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;

@Component
public class MyUrlBlockHandler implements UrlBlockHandler {

	@Override
	public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex)
			throws IOException {
		if(ex instanceof FlowException) {
			response.getWriter().write("{code:500,msg:'flow'}");
		} else if(ex instanceof DegradeException) {
			response.getWriter().write("{code:500,msg:'degrade'}");
		}
	}
}
