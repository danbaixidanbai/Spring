package com.dao.impl;

import org.springframework.stereotype.Component;

import com.dao.Cal;

@Component("cal")
public class CalImpl implements Cal {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		return result;
	}

	@Override
	public int del(int i, int j) {
		int result=i-j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result=i*j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result=i/j;
		return result;
	}

}
