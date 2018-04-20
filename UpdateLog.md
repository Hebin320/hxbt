# v1.0.5



 - 获取文本

```
textView.getString()
editText.getString()
button.getString()
radioButton.getString()
checkBox.getString()
```

 - 获取颜色
 
```
getColors(R.color.white)
getColors("#FFFFFF")
```

 - 给TextView、EditView、Button、RadioButton、CheckBox设置字体颜色
 
```
textView.setTextColor(context,R.color.white)
textView.setTextColor("#FFFFFF")
```

 -  Any类型强转
```
any.asInt()
any.asString()
any.asBoolean()
any.asFloat()
```


----------

# v1.0.4



 - 单位转换

```
// dp转px
dp2px(10f)
// sp转px
sp2px(10f)
// px转dp
px2dp(10f)
// px转sp
px2sp(10f)
// dip转px
dip2px(10f)
```

 - Viewpager
 

```
// 绑定viewpager和RadioButton ,viewpager滑动到哪一页，哪一个RadioButton就选中，
// 而且，RadioButton点击了哪个，Viewpager就跳转到哪一页
viewpager.setRBCheck(arrayOf(rbOne,rbTwo,rbThree))


// viewpager 添加 PageChangeListener 的两种写法
// 方法一
viewpager.addOnPageChangeListener({position ->  },{state ->  },
{position, positionOffset, positionOffsetPixels ->  })
// 方法二 onPageSelected、onPageScrolled、onPageScrollStateChanged三个方法想实现哪个就写哪个
viewpager.addOnPageChangeListener(object :HxbrPageChangeListener{})
```

 - EditText
 

```
// EditText 添加 TextWatcher 的两种写法
// 方法一
editText.addTextChangedListener({ p0 -> }, { p0, p1, p2, p3 -> }, { p0, p1, P2, p3 -> })
// 方法二 afterTextChanged、beforeTextChanged、onTextChanged三个方法想实现哪个就写哪个
editText.addTextChangedListener(object : HxbrTextWatcher {})
```

 -  App相关

```
// 获取IMEI
getImei()
// 获取App版本名称
getVersionName()
// 获取App版本号
getVersionCode()
// 把list转换为一个用逗号分隔的字符串 结果 = 1,2,3
listToString(arrayListOf("1","2","3"))
```
