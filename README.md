# hxbt
# 前言

**注意：本文针对kotlin开发android项目的开发者，以下方法只在kotlin中有效。**

学kotlin开发Android的人，应该都有接触过anko，anko的强大就不用介绍了，想了解的，这儿有[传送门][1]；
这两周因为公司后端的开发效率太低，所以我的空闲时间比较多，花了点时间去看看anko的源码，然后就结合自己开发过的项目，参考anko源码，自己写了几个工具类，具体用法往下看。

-------------------

## 导入

项目我已经传到了jcenter上，可以直接通过gradle导入到项目中；

```
compile 'com.hebin:hxb:1.0.2'
```
说到jcenter，就顺便提一下遇到的坑；网上已经有很多关于上传安卓项目到jcenter的教程了，但是大多数都只是适用于java写的Android项目，如果项目中包含了kt的文件，那么就会报错；
![这里写图片描述](https://img-blog.csdn.net/20180409120321387?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hlYmluMzIwMzIw/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
这种错误，百度出来基本都是什么编码问题，要添加UTF-8的识别之类的，其实不然，只是因为不能识别kt文件才报的错误，解决方案就是在项目的bulid.gradle中添加：

```
//非常重要，要不它不认识你的项目.kt文件名 其中hxb是你的library名
tasks.getByPath(":hxb:releaseAndroidJavadocs").enabled = false
```

## hxb有什么用？

言归正传，下面举几个例子来讲讲这个库的用法；

1、 **SharedPreferences**
 
 在Android开发中，经常使用SharedPreferences来保存一些信息到本地，例如用户名等等，正常写法是这样的；
```
 val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
 val editor = preferences.edit()
 editor.putString(infoKey, info)
 editor.apply()
```
如果用了这个库，你只需要写下面这行代码即可

```
// 保存字符串类型
saveFile("infoKey","info")
// 保存数字类型
saveFile("infoKey",1)
// 保存布尔值类型
saveFile("infoKey",true)
```
上面这几个方法，SharedPreferences的值是固定的，都是“userdata”，如果你想自己命名，也可以这样写

```
// 保存字符串类型
saveFile("localName","infoKey","info")
// 保存数字类型
saveFile("localName","infoKey",1)
// 保存布尔值类型
saveFile("localName","infoKey",true)
```
有保存，就会有读取，读取的方法如下：

```
// 读取字符串类型
loadString("infoKey")
// 读取数字类型
loadInt("infoKey")
// 读取布尔值类型
loadBoolean("infoKey")
```
2、**选择类型控件**

常用的选择控件有CheckBox、RadioButton、Switch等等，我们经常使用到的，就是选中状态变化的监听事件，下面写几个例子，进行对比一下;

```
      // 正常写法， 选中的时候，执行Toast事件
        checkBox.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                showToast("我被选中了")
            }
        }
        
      // 用了库之后的写法， 选中的时候，执行Toast事件
        checkBox.isCheck { showToast("我被选中了") }
```

```
     // 正常写法， 不选中的时候，执行Toast事件
        checkBox.setOnCheckedChangeListener { _, isCheck ->
            if (!isCheck) {
                showToast("我没有被选中")
            }
        }
     // 用了库之后的写法， 不选中的时候，执行Toast事件
        checkBox.isNotCheck { showToast("我没有被选中") }
```

```
     // 正常写法， 选中跟不选中都执行事件
        checkBox.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                showToast("我被选中了")
            } else {
                showToast("我没有被选中")
            }
        }

     // 用了库之后的写法， 选中跟不选中都执行事件
        checkBox.checkOrNot({ showToast("我被选中了") }, { showToast("我没有被选中") })
```
3、**图片加载**

我用的图片加载库是Glide，照样写两个对比例子：
正常写法

```
       /**
        *  加载正常的图片
        * */
        fun glideNormalImage(context: Context, url: Any, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }
```
用了库之后的写法

```
// 正常的加载图片
glideNormalImage("url", imageView)
// 加载圆形图片
glideCircleImage("url", imageView)
// 加载圆角图片，roundSize是圆角半径
glideRoundImage("url", roundSize,imageView)
```
4、**Recyclerview**
Recyclerview有三种模式，线性、九宫格跟瀑布流，只要设置LayoutManager即可实现这三种效果；

```
// 正常的写法
val layoutManager = LinearLayoutManager(this)
recyclerview.layoutManager = layoutManager
```
使用了库之后

```
// 设置线性布局
recyclerView.setLinearLayoutManager(this)
// 设置九宫格布局
recyclerView.setGridLayoutManager(this,2)
// 设置垂直的瀑布流布局
recyclerView.setVerticalStaggered(2)
// 设置水平的瀑布流布局
recyclerView.setHorizontalStaggered(2)
```
5、**View的一些相关**

```
view.setVisible()
view.setGone()
view.setInvisible()
```

```
       // 写法一
        if (str1.isNotEmpty()&&str2.isNotEmpty()&&str3.isNotEmpty()&&str4.isNotEmpty()){
            showToast("全部不为空")
        }else{
            showToast("有部分为空")
        }
        // 写法二
        arrayListOf(str1,str2,str3,str4).allNotEmpty(
                {showToast("全部不为空")},
                {showToast("有部分为空")})
```

```
       // 写法一
        if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty()) {
            showToast("至少有一个为空")
        } else {
            showToast("全部都为空")
        }
        // 写法二
        arrayListOf(str1, str2, str3, str4).allEmpty(
                { showToast("全部都为空") },
                { showToast("至少有一个为空") })
```

还有就是，我在项目中，经常遇到在Recyclerview的Adapter中，列表最后一项的分割线不显示或者第一项的某个布局不显示，这时候我的写法是这样的;

```
if (position == 0) {
     view.visibility = View.VISIBLE
} else {
     view.visibility = View.GONE
}
```
如果用了库，只需要这样写

```
// 第0项执行第一个{}里面的内容。其他执行第二个{}里面的内容
position.zeroOrNot(
        { view.visibility = View.VISIBLE }, 
        { view.visibility = View.GONE })
        
// position是当前列表位置，all是列表总数，如果是最后一项，执行第一个{}执行，如果不是，执行第二个{}
lastOrNot(position, all,
         { view.visibility = View.GONE },
         { view.visibility = View.VISIBLE })
```
6、**Window相关**

```
// 设置全屏
setFullScreen()
// 获取状态栏高度
getStatusbar()
// 获取屏幕宽度
getSwidth()
// 获取屏幕高度
getShigh()
// 收藏与取消收藏的一个动画
setScalse(view)
// 点击父布局，隐藏输入法
lostByViewGroup(viewGroup)
// 点击控件，隐藏输入法
lostByView(view)
// 权限被拒绝，跳转到设置权限界面,mTAG是接收返回的键值
appSetting(mTAG)
```
7、**倒计时**

```
// 正常写法
  val time = object : CountDownTimer(milisInFuture, countDownInterval) {
            override fun onTick(l: Long) {
                showToast("倒计时中")
            }

            override fun onFinish() {
                showToast("结束倒计时")
            }
        }
  time.start()
  
// 用了库之后
setTimer(6000,1000,
        {showToast("倒计时中")},
        {showToast("结束倒计时")})
```

##后话

有一些写法，其实没有很大的必要要这样写，只是个人习惯，不喜勿喷。我也在不断学习中，这个库会不断地更新，把我学到的东西更新到这个库里面，喜欢的就看看，不喜欢的就略过，欢迎大家一起交流

---------

[1]: https://github.com/Kotlin/anko
