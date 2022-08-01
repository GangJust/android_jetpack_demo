# 关于本系列的说明

> 作为学习Jetpack的系列文章, 可能会更新得很慢, 本系列文或者应该称之为学习笔记...

观看本文的同学, 应该已经有具备开发简单Android App的能力了, 若是零基础, 那么阅读本文可能有些难懂, 我只能尽量简单解释。

本文所用开发环境以及SDK版本如下，读者应该使用不低于本文所使用的开发环境.

> Android Studio 4.0.1
> minSdkVersion 21
> targetSdkVersion 30

关于 `compileSdkVersion` 编译版本的说明, 并不是越高越好, 编译版本越高则表示SDK越新, 这种条件下一般会出现许多新问题, 通常是权限问题。所以这里用的是`30(Android 10)`。

关于本文中的代码片段, 统一采用伪代码形式。

关于本文使用的编程语言, 统一使用 `Kotlin`。

关于 `Jectpack` 的介绍, 这里就不再赘述了, 百度...

# 正文

> 注意：视图绑定在 Android Studio 3.6 Canary 11 及更高版本中可用。

`viewBinding` 是什么? 直接翻译成中文, 含义就是: `视图绑定`。

# 开启 viewBinding

首先找到 *项目* 的 `build.gradle` 并打开, 举两张图片。

![build.gradle](/images/build.gradle1.png)

![build.gradle](/images/build.gradle2.png)

如何开启呢？官方文档中介绍了两种开启方式, 我们分别来看。

方式一:

```gradle
    android {
        ...
        viewBinding {
            enabled true
        }
        ...
    }
```

方式二(推荐):

```gradle
    android {
        ...
        buildFeatures {
            viewBinding true
        }
        ...
    }
```

这里推荐使用`方式二`。

有的还会这么写, 也是可以的。

```gradle
    android {
        ...
        viewBinding {
            enabled = true
        }
        ...
    }
```

```gradle
    android {
        ...
        buildFeatures {
            viewBinding = true
        }
        ...
    }
```

# 使用 viewBinding

在 Android 开发中, 传统的寻找控件使用的是 `findViewById`, 例如在 `res/layout/activity_main.xml` 中的界面如下:

![activity_main](/images/activity_main.png)

```xml
    ...
    <TextView
        android:id="@+id/myTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"/>
    ...
```

对应的TextView的id则是`myTextView`, 我们来看在代码中寻找并使用 `myTextView` 的传统方式。

```kotlin
    ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myTextView: TextView = findViewById(R.id.myTextView)  //通过Id找到对应的view控件
        myTextView.text = "你好 世界！"  //设置新的文本内容
        myTextView.setOnClickListener {
            it as TextView
            it.text = "你点击了我!"
        }
    }
    ...
```

在使用了viewBinding之后, 则应该是这个样子的。
```kotlin
    ...
    lateinit var binding: ActivityMainBinding  //布局绑定类, 延迟加载
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)  //binding初始化
        setContentView(binding.root)  //将根视图作为内容视图
        binding.myTextView.text = "你好 世界!"  //设置新的文本内容
        binding.myTextView.setOnClickListener {
            it as TextView
            it.text = "你点击了我!"
        }
    }
    ...
```

乍一看, 好像代码量变多了, 而且也没有看到什么优势。

那如果, 是这样呢？

```kotlin
    ...
    lateinit var myTextView: TextView
    lateinit var myTextView2: TextView
    lateinit var myTextView3: TextView
    lateinit var myTextView4: TextView
    lateinit var myTextView5: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myTextView = findViewById(R.id.myTextView)
        myTextView2 = findViewById(R.id.myTextView2)
        myTextView3 = findViewById(R.id.myTextView3)
        myTextView4 = findViewById(R.id.myTextView4)
        myTextView5 = findViewById(R.id.myTextView5)

        myTextView.text = "你好 世界！"
        myTextView2.text = "你好 世界2！"
        myTextView3.text = "你好 世界3！"
        myTextView4.text = "你好 世界4！"
        myTextView5.text = "你好 世界5！"
    }
    ...
```

```kotlin
    ...
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myTextView.text = "你好 世界！"
        binding.myTextView2.text = "你好 世界2！"
        binding.myTextView3.text = "你好 世界3！"
        binding.myTextView4.text = "你好 世界4！"
        binding.myTextView5.text = "你好 世界5！"
    }
    ...
```

值得注意的是, 一旦开启了 `viewBinding` 那么所有的 `xml` 布局文件(layout)都将生成一个 `Binding` 类, 如果需要过滤掉某些 `xml` 即: `部分xml不生成Binding类`。

那么在`xml`的 *根节点* 中添加 `tools:viewBindingIgnore="true"` 属性即可。

```xml
    <LinearLayout
        ...
        tools:viewBindingIgnore="true">
        ...
    </LinearLayout>
```

# 与 `findViewById` 的区别

与使用 findViewById 相比，视图绑定具有一些很显著的优点：

- Null 安全：由于视图绑定会创建对视图的直接引用，因此不存在因视图 ID 无效而引发 Null 指针异常的风险。此外，如果视图仅出现在布局的某些配置中，则绑定类中包含其引用的字段会使用 @Nullable 标记。
- 类型安全：每个绑定类中的字段均具有与它们在 XML 文件中引用的视图相匹配的类型。这意味着不存在发生类转换异常的风险。

这些差异意味着布局和代码之间的不兼容将会导致构建在编译时（而非运行时）失败。

# 使用 `viewBinding` 的不足

- 视图绑定不支持布局变量或布局表达式，因此不能用于直接在 XML 布局文件中声明动态界面内容。
- 视图绑定不支持双向数据绑定。

开发过程中, 则需要根据实际情况来决定是否使用 `viewBinding` 了。