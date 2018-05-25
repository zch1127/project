package cn.csbe.web.cms.wallpager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.wallpager.bean.PubTheme;
import cn.csbe.web.cms.wallpager.mapper.IPubThemeMapper;
import cn.csbe.web.cms.wallpager.service.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private IPubThemeMapper themeMapper;
	
	@Override
	public PubTheme queryBigPreviewTotal(Integer type) {
		// TODO Auto-generated method stub
		return themeMapper.queryBigPreviewTotal(type);
	}

}
