# IR Code

#### 提供一种字节码中间表示 [Intermediate representation](https://en.wikipedia.org/wiki/Intermediate_representation) 来方便的访问或修改 JVM/Dalvik 字节码

> **例如以下 Java 代码**

```Java
private void updateView(int index) {
  View item = listView.getChildAt(index - listView.getFirstVisiblePosition());

  if(vitem == null) {
    return;
  } else {
    TextView someText = (TextView) item.findViewById(R.id.someTextView);
    someText.setText("Hello, World!");
  }
}
```

> **在 IR Code 中的表示为：**

```kotlin
fun Class.addUpdateViewFunction() = addFunction(
  name = "updateView",
  returnType = BuiltInTypes.Void,
  param<Int>("index"),
) {
  val index = irGet(parameters[0])
  val listView = irGet(irThis.irProperty(
    name = "listView", 
    type = QualifiedType("android.widget.ListView")
  ))
  val firstVisiblePosition = listView.irCall("getFirstVisiblePosition", BuiltInTypes.Int)
  val item = irVariable(
    name = "item",
    value = listView.irCall(
      name = "getChildAt",
      returnType = BuiltInTypes.View,
      irMinus(index, firstVisiblePosition)
    )
  )

  irIf(
    condition = irEqNull(item),
    thenBlock = irReturnVoid(),
    elseBlock = {
      val androidR = irStatic(Type("android.R\$id;"))
      val foundView = item.irCall(
        name = "findViewById",
        returnType = BuiltInTypes.TextView,
        callee = androidR.irGet(
          irProperty("someTextView", BuiltInTypes.Int)
        )
      )
      val someText = irVariable(irCast(foundView, BuiltInTypes.TextView))

      someText.irCall(
        name = "setText",
        returnType = BuiltInTypes.Void,
        callee = irValue("Hello, World!")
      )
    }
  )
}
```