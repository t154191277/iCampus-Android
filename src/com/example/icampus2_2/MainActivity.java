package com.example.icampus2_2;

import java.util.HashMap;
import java.util.Map;

import com.viewpagerindicator.TabPageIndicator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	final static String[] NEWSCHANNEL = { "学校要闻", "人才培养", "教学科研", "文化活动",
			"媒体关注", "校园人物" };
	final Map<String, String> map = new HashMap<String, String>();
	private Button button;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		map.put("学校要闻", "/xw/zhxw");
		map.put("人才培养", "/xw/rcpy");
		map.put("教学科研", "/xw/jxky");
		map.put("文化活动", "/xw/whhd");
		map.put("媒体关注", "/xw/mtgz");
		map.put("校园人物", "/xw/xyrw");
		button = (Button) findViewById(R.id.backMain);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ICampus.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
		FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(
				getSupportFragmentManager(), map);
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}

	/*private Map<String, String> initChannelData() {
		JsonNewschannel jsonNewschannel = new JsonNewschannel();
		String channelInformation = jsonNewschannel
				.getNewsChannel("http://api.bistu.edu.cn/api/api.php?table=newschannel");
		List<NewschannelType> lists = jsonNewschannel
				.getList(channelInformation);
		Map<String, String> map = new HashMap<String, String>();
		for (NewschannelType newschannelType : lists) {
			map.put(newschannelType.getTitle(), newschannelType.getListUrl());
		}
		return map;
	}*/
}
