# BottomDialog
# 底部弹窗
## 封装底部小弹窗

![image](https://github.com/zhangxiang0316/BottomDialog/blob/master/app/raw/2017_06_12_13_43_09_2017612134740.gif)

## 新增泛型使用

 ```java
自定义实体类继承Entity
给name赋值

public  class Entity {
    public String name;
}

public class MyEntity extends Entity{
    public String title;
    public boolean isOK;
}

for (int i = 0; i < 5; i++) {
            MyEntity entity = new MyEntity();
            entity.name = "第" + (i + 1) + "条";
            entity.isOK = Math.random() * 2 > 1;
            entity.title = "抬头";
            list.add(entity);
        }

name为列表显示的值

```


### 使用方法
 ```java
 BottomDialog<MyEntity> dialog = new BottomDialog<>(this, list, new SelectPositionCallBack() {
            @Override
            public void selectPosition(int position) {
                Toast.makeText(MainActivity.this, list.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
```

#### 跟项目添加

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
  ```	
  
  #### 项目中添加
```java
  dependencies {
	      compile 'com.github.zhangxiang0316:BottomDialog:1.0.0'
	}

        
