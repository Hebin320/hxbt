# v1.0.6



 - 动态设置控件宽高

```
// 高度全屏，设置宽度
imageView.widths = 60
// 宽度全屏，设置高度
imageView.heights = 60
// 同时设置宽高
imageView.setHeigthAndWidth(width,height)

// 以上方法，适用于控件父布局为ConstraintLayout、FrameLayout、LinearLayout、RelativeLayout，
// 在import的时候，注意看清楚
```

 - 判断不为null
 
```
Any.isNotNull{}
```

 - 给TextView、EditView、Button、RadioButton、CheckBox设置字体颜色
 
```
textView.textColor = "#FFFFFF"
```

 -  给EditText设置文本
```
editText.texts = "我是谁"
```
 -  设置背景颜色（代码）
```
view.backgroundColor = "#FFFFFF"
```

 -  长按事件
```
view.onLongClickListener {  }
```
-  双击事件
```
// 双击间隔小于1500毫秒时执行操作
view.onDoubleClickListener { }
```
- 给月份或者日期前面加0

```
// 有时候后台要求日期显示格式为“2018-04-07”，而我们得到的是“2018-4-7”，这时候需要在月份跟日期上做判断转换
val day = 4.addZero() // 输出结果04
val day = "4".addZero() // 输出结果04
val day = 17.addZero() // 输出结果17
```
- 创建View

```
val view = creatView(layoutId)
// 或者
val view = creatView(layoutId,viewGroup)
```
- 获取Recyclerview滚动过的Y轴距离

```
val y = recyclerview.getScollYDistance()
```
- 设置动画

```
view.setAnimation(context,anim)
```


----------


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
